package eu.paasage.camel.agh.scalarm.model.submodels;

import org.javatuples.Triplet;

import eu.paasage.camel.ActionType;
import eu.paasage.camel.CamelFactory;
import eu.paasage.camel.UnitDimensionType;
import eu.paasage.camel.UnitType;
import eu.paasage.camel.Unitless;
import eu.paasage.camel.deployment.InternalComponent;
import eu.paasage.camel.deployment.InternalComponentInstance;
import eu.paasage.camel.deployment.VMInstance;
import eu.paasage.camel.execution.ExecutionContext;
import eu.paasage.camel.execution.ExecutionFactory;
import eu.paasage.camel.scalability.*;
import eu.paasage.camel.type.FloatValue;
import eu.paasage.camel.type.Limit;
import eu.paasage.camel.type.Range;
import eu.paasage.camel.type.TypeEnum;
import eu.paasage.camel.type.TypeFactory;

/**
 * @author orzech
 */
public class ScalarmScalabilityModel {

	/*
	 * The idea here is to create a simple metric based on RAW CPU readings.
	 * When CPU load is more than 80% then it triggers the creation of new
	 * SimulationManager instance
	 */
	public static Triplet<ScalabilityModel, ExecutionContext, HorizontalScalabilityPolicy> createMyScalabilityModel(
			InternalComponent simulationManagerIc,
			InternalComponentInstance simulationManagerInstance,
			VMInstance simulationManagerVMInstance) {

		ScalabilityModel scalabilityModel = ScalabilityFactory.eINSTANCE
				.createScalabilityModel();

		/*
		 * Creating a raw CPU metric
		 */
		MetricTemplate rawCPU = ScalabilityFactory.eINSTANCE
				.createMetricTemplate();
		rawCPU.setLayer(LayerType.IAA_S);
		rawCPU.setName("CPU_RAW");

		Property cpu = ScalabilityFactory.eINSTANCE.createProperty();
		cpu.setName("CPU");
		cpu.setType(PropertyType.MEASURABLE);
		scalabilityModel.getProperties().add(cpu);

		rawCPU.setProperty(cpu);
		rawCPU.setType(MetricType.RAW);

		// Unit for CPU
		Unitless perc = CamelFactory.eINSTANCE.createUnitless();
		perc.setName("CPUUnit");
		perc.setDimensionType(UnitDimensionType.UNITLESS);
		perc.setUnit(UnitType.PERCENTAGE);
		scalabilityModel.getUnits().add(perc);

		rawCPU.setUnit(perc);
		rawCPU.setValueDirection((short) 0);

		scalabilityModel.getMetricTemplates().add(rawCPU);

		/*
		 * Defining 1 raw cpu sensor with metric instance and bindings to VM
		 * instance
		 */
		Metric rawCPUMetric = ScalabilityFactory.eINSTANCE.createMetric();
		rawCPUMetric.setId("rawCPUMetric1");

		MetricVMBinding rawCPUMetricInstanceBinding = ScalabilityFactory.eINSTANCE
				.createMetricVMBinding();
		rawCPUMetricInstanceBinding.setName("storageManagerVMScalarmEC1");
		ExecutionContext scalarmExecutionContext = ExecutionFactory.eINSTANCE
				.createExecutionContext();
		rawCPUMetricInstanceBinding
				.setExecutionContext(scalarmExecutionContext);
		rawCPUMetricInstanceBinding.setVmInstance(simulationManagerVMInstance);
		scalabilityModel.getBindings().add(rawCPUMetricInstanceBinding);

		rawCPUMetric.setObjectBinding(rawCPUMetricInstanceBinding);

		Sensor sensor1 = ScalabilityFactory.eINSTANCE.createSensor();
		sensor1.setId("cpuSensor1");
		sensor1.setIsPush(false);

		scalabilityModel.getSensors().add(sensor1);

		rawCPUMetric.setSensor(sensor1);
		rawCPUMetric.setTemplate(rawCPU);

		/*
		 * Defining CPU metric range
		 */
		Range rawCPUMetricRange = TypeFactory.eINSTANCE.createRange();
		rawCPUMetricRange.setPrimitiveType(TypeEnum.FLOAT_TYPE);

		Limit rawCPUMetricMin = TypeFactory.eINSTANCE.createLimit();
		rawCPUMetricMin.setIncluded(false);
		Limit rawCPUMetricMax = TypeFactory.eINSTANCE.createLimit();
		rawCPUMetricMax.setIncluded(false);

		FloatValue rawCPUMetricMinValue = TypeFactory.eINSTANCE
				.createFloatValue();
		rawCPUMetricMinValue.setValue(0);
		rawCPUMetricMin.setValue(rawCPUMetricMinValue);

		FloatValue rawCPUMetricMaxValue = TypeFactory.eINSTANCE
				.createFloatValue();
		rawCPUMetricMaxValue.setValue(100);
		rawCPUMetricMax.setValue(rawCPUMetricMaxValue);

		rawCPUMetricRange.setLowerLimit(rawCPUMetricMin);
		rawCPUMetricRange.setUpperLimit(rawCPUMetricMax);

		rawCPUMetric.setValueType(rawCPUMetricRange);
		scalabilityModel.getMetrics().add(rawCPUMetric);

		/*
		 * Simple horizontal scaling
		 */
		ScalabilityRule rawCPUScalabilityRule = ScalabilityFactory.eINSTANCE
				.createScalabilityRule();

		ScalingAction horizontalScalingSimulationManager = ScalabilityFactory.eINSTANCE
				.createScalingAction();
		horizontalScalingSimulationManager
				.setComponentInstance(simulationManagerInstance);
		horizontalScalingSimulationManager.setCoreUpdate(0);
		horizontalScalingSimulationManager.setCount(1);
		horizontalScalingSimulationManager.setCPUUpdate(0);
		horizontalScalingSimulationManager.setIoUpdate(0);
		horizontalScalingSimulationManager.setMemoryUpdate(0);
		horizontalScalingSimulationManager
				.setName("horizontalScalingSimulationManager");
		horizontalScalingSimulationManager.setNetworkUpdate(0);
		horizontalScalingSimulationManager.setStorageUpdate(0);
		horizontalScalingSimulationManager.setType(ActionType.SCALE_OUT);
		horizontalScalingSimulationManager
				.setVmInstance(simulationManagerVMInstance);

		scalabilityModel.getActions().add(horizontalScalingSimulationManager);
		rawCPUScalabilityRule.getActions().add(
				horizontalScalingSimulationManager);

		/*
		 * Create and event that will trigger the scaling
		 */
		NonFunctionalEvent CPULoadToHigh = ScalabilityFactory.eINSTANCE
				.createNonFunctionalEvent();
		CPULoadToHigh.setIsViolation(true);

		MetricCondition rawCPUMetricCondition = ScalabilityFactory.eINSTANCE
				.createMetricCondition();
		rawCPUMetricCondition
				.setComparisonOperator(ComparisonOperatorType.GREATER_THAN);
		rawCPUMetricCondition.setMetric(rawCPUMetric);
		rawCPUMetricCondition.setThreshold(80);
		rawCPUMetricCondition.setName("CPUMetricCondition");

		scalabilityModel.getConditions().add(rawCPUMetricCondition);

		CPULoadToHigh.setMetricCondition(rawCPUMetricCondition);
		CPULoadToHigh.setName("CPULoadToHigh");

		scalabilityModel.getEvents().add(CPULoadToHigh);

		rawCPUScalabilityRule.setEvent(CPULoadToHigh);
		rawCPUScalabilityRule.setName("rawCPUScalabilityRule");

		scalabilityModel.getRules().add(rawCPUScalabilityRule);

		/*
		 * Wrap it all up into a policy
		 */

		HorizontalScalabilityPolicy horizontalPolicySimulationManager = ScalabilityFactory.eINSTANCE
				.createHorizontalScalabilityPolicy();
		horizontalPolicySimulationManager.setComponent(simulationManagerIc);
		horizontalPolicySimulationManager.setId("horizPolicySimulationManager");
		horizontalPolicySimulationManager.setMaxInstances(4);
		horizontalPolicySimulationManager.setMinInstances(1);
		horizontalPolicySimulationManager.setPriority(0);

		scalabilityModel.getPolicies().add(horizontalPolicySimulationManager);

		// //// END definition of Scalability model
		return new Triplet<ScalabilityModel, ExecutionContext, HorizontalScalabilityPolicy>(
				scalabilityModel, scalarmExecutionContext,
				horizontalPolicySimulationManager);
	}
}
