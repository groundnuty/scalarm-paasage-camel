package eu.paasage.camel.agh.scalarm.model.submodels;

import org.javatuples.Triplet;

import eu.paasage.camel.ActionType;

import eu.paasage.camel.deployment.InternalComponent;
import eu.paasage.camel.deployment.InternalComponentInstance;
import eu.paasage.camel.deployment.VMInstance;
import eu.paasage.camel.execution.ExecutionContext;
import eu.paasage.camel.scalability.*;

/**
 * @author orzech
 */
public class ScalarmScalabilityModel {

    /*
     * The idea here is to create a simple metric based on RAW CPU readings.
     * When CPU load is more than 80% then it triggers the creation of new
     * SimulationManager instance
     */
    public static ScalabilityModel createMyScalabilityModel() {

        ScalabilityModel scalabilityModel = ScalabilityFactory.eINSTANCE.createScalabilityModel();

		/*
         * Simple horizontal scaling
		 */

        HorizontalScalingAction horizontalScalingSimulationManager = ScalabilityFactory.eINSTANCE.createHorizontalScalingAction();
        horizontalScalingSimulationManager.setName("HorizontalScalingSimulationManager");
        horizontalScalingSimulationManager.setType(ActionType.SCALE_OUT);
        horizontalScalingSimulationManager.setVm(ScalarmDepolymentModel.cpuIntensiveUbuntuGermany);
        horizontalScalingSimulationManager.setInternalComponent(ScalarmDepolymentModel.simulationManager);
        scalabilityModel.getActions().add(horizontalScalingSimulationManager);


		/*
		 * Create and event that will trigger the scaling
		 */
        NonFunctionalEvent cpuAvgMetricNFEAll = ScalabilityFactory.eINSTANCE.createNonFunctionalEvent();
        cpuAvgMetricNFEAll.setName("CPUAvgMetricNFEAll");
        cpuAvgMetricNFEAll.setIsViolation(true);
        cpuAvgMetricNFEAll.setMetricCondition(ScalarmMetricsModel.cpuAvgMetricConditionAll);
        scalabilityModel.getEvents().add(cpuAvgMetricNFEAll);


        NonFunctionalEvent cpuAvgMetricNFEAny = ScalabilityFactory.eINSTANCE.createNonFunctionalEvent();
        cpuAvgMetricNFEAny.setName("CPUAvgMetricNFEAny");
        cpuAvgMetricNFEAny.setIsViolation(true);
        cpuAvgMetricNFEAny.setMetricCondition(ScalarmMetricsModel.cpuAvgMetricConditionAny);
        scalabilityModel.getEvents().add(cpuAvgMetricNFEAny);

        BinaryEventPattern cpuAvgMetricBEPAnd = ScalabilityFactory.eINSTANCE.createBinaryEventPattern();
        cpuAvgMetricBEPAnd.setName("CPUAvgMetricBEPAnd");
        cpuAvgMetricBEPAnd.setLeftEvent(cpuAvgMetricNFEAll);
        cpuAvgMetricBEPAnd.setRightEvent(cpuAvgMetricNFEAny);
        cpuAvgMetricBEPAnd.setOperator(BinaryPatternOperatorType.AND);
        scalabilityModel.getEvents().add(cpuAvgMetricBEPAnd);


        ScalabilityRule rawCPUScalabilityRule = ScalabilityFactory.eINSTANCE.createScalabilityRule();
        rawCPUScalabilityRule.setName("RawCPUScalabilityRule");
        rawCPUScalabilityRule.setEvent(cpuAvgMetricBEPAnd);
        rawCPUScalabilityRule.getActions().add(horizontalScalingSimulationManager);
        rawCPUScalabilityRule.getScaleRequirements().add(ScalarmRequirmentModel.horizontalScaleSimulationManager);
        scalabilityModel.getRules().add(rawCPUScalabilityRule);


        // //// END definition of Scalability model
        return scalabilityModel ;
    }
}
