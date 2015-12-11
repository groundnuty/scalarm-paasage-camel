package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.LayerType;
import eu.paasage.camel.metric.*;
import eu.paasage.camel.provider.Functional;

/**
 * Created by orzech on 10/12/15.
 */
public class ScalarmMetricsModel {


    public static MetricCondition cpuMetricCondition ;
    public static RawMetric availabilityMetric ;
    public static RawMetric responseTimeMetric ;
    public static CompositeMetric meanValueOfResponseTimeOfAllExprimentManagersMetric;
    public static CompositeMetric makespanMetric;
    public static MetricCondition cpuAvgMetricConditionAll ;
    public static MetricCondition cpuAvgMetricConditionAny ;

    public static MetricModel createScalarmMetricsModel() {

        MetricModel metricModel = MetricFactory.eINSTANCE
                .createMetricModel();
        metricModel.setName("Scalarm Metric Model");

        Window win5Min = MetricFactory.eINSTANCE.createWindow();
        win5Min.setName("Win5Min");
        win5Min.setWindowType(WindowType.SLIDING);
        win5Min.setTimeSize(5L);
        win5Min.setUnit(ScalarmUnitModel.minutes);

        Window win1Min = MetricFactory.eINSTANCE.createWindow();
        win1Min.setName("Win1Min");
        win1Min.setWindowType(WindowType.SLIDING);
        win1Min.setTimeSize(1L);
        win1Min.setUnit(ScalarmUnitModel.minutes);

        Schedule schedule1Min = MetricFactory.eINSTANCE.createSchedule();
        schedule1Min.setName("Schedule1Min");
        schedule1Min.setType(ScheduleType.FIXED_RATE);
        schedule1Min.setInterval(1L);
        schedule1Min.setUnit(ScalarmUnitModel.minutes);

        Schedule schedule1Sec = MetricFactory.eINSTANCE.createSchedule();
        schedule1Sec.setName("Schedule1Sec");
        schedule1Sec.setType(ScheduleType.FIXED_RATE);
        schedule1Sec.setInterval(1L);
        schedule1Sec.setUnit(ScalarmUnitModel.seconds);




        Sensor availabilitySensor = MetricFactory.eINSTANCE.createSensor();
        availabilitySensor.setName("AvailabilitySensor");
        availabilitySensor.setIsPush(true);

        Property availabilityProperty = MetricFactory.eINSTANCE.createProperty();
        availabilityProperty.setName("AvailabilityProperty");
        availabilityProperty.setType(PropertyType.MEASURABLE);
        availabilityProperty.getSensors().add(availabilitySensor);



        Sensor cpuSensor = MetricFactory.eINSTANCE.createSensor();
        cpuSensor.setName("CPUSensor");
        cpuSensor.setConfiguration("de.uniulm.packagename.classname");
        cpuSensor.setIsPush(true);

        Property cpuProperty = MetricFactory.eINSTANCE.createProperty();
        cpuProperty.setName("CPUProperty");
        cpuProperty.setType(PropertyType.MEASURABLE);
        cpuProperty.getSensors().add(cpuSensor);




        Sensor responseTimeSensor = MetricFactory.eINSTANCE.createSensor();
        responseTimeSensor.setName("ResponseTimeSensor");
        responseTimeSensor.setIsPush(true);

        Property responseTimeProperty = MetricFactory.eINSTANCE.createProperty();
        responseTimeProperty.setName("ResponseTimeProperty");
        responseTimeProperty.setType(PropertyType.MEASURABLE);
        responseTimeProperty.getSensors().add(responseTimeSensor);



        Sensor throughputOfSimulationsExecutedByWorkerSensor = MetricFactory.eINSTANCE.createSensor();
        throughputOfSimulationsExecutedByWorkerSensor.setName("ThroughputInSimulationsPerSecondProperty");
        throughputOfSimulationsExecutedByWorkerSensor.setIsPush(true);

        Property throughputInSimulationsPerSecondProperty = MetricFactory.eINSTANCE.createProperty();
        throughputInSimulationsPerSecondProperty.setName("ThroughputInSimulationsPerSecondProperty");
        throughputInSimulationsPerSecondProperty.setType(PropertyType.MEASURABLE);
        throughputInSimulationsPerSecondProperty.getSensors().add(throughputOfSimulationsExecutedByWorkerSensor);




        Sensor numberOfSimulationsLeftInTheExperimentSensor = MetricFactory.eINSTANCE.createSensor();
        numberOfSimulationsLeftInTheExperimentSensor.setName("NumberOfSimulationsLeftInTheExperimentSensor");
        numberOfSimulationsLeftInTheExperimentSensor.setIsPush(true);

        Property numberOfSimulationsPerSecondProperty = MetricFactory.eINSTANCE.createProperty();
        numberOfSimulationsPerSecondProperty.setName("NumberOfSimulationsPerSecondProperty");
        numberOfSimulationsPerSecondProperty.setType(PropertyType.MEASURABLE);
        numberOfSimulationsPerSecondProperty.getSensors().add(throughputOfSimulationsExecutedByWorkerSensor);


        Property makespanProperty = MetricFactory.eINSTANCE.createProperty();
        makespanProperty.setName("MakespanProperty");
        makespanProperty.setType(PropertyType.MEASURABLE);



        RawMetric availabilityMetric = MetricFactory.eINSTANCE.createRawMetric();
        availabilityMetric.setLayer(LayerType.SAA_S);
        availabilityMetric.setName("AvailabilityMetric");
        availabilityMetric.setProperty(availabilityProperty);
        availabilityMetric.setUnit(ScalarmUnitModel.availabilityUnit);
        availabilityMetric.setValueType(ScalarmTypeModel.rangeFrom0To100Double);
        availabilityMetric.setValueDirection((short) 0);
        metricModel.getMetrics().add(availabilityMetric);


        RawMetric cpuMetric = MetricFactory.eINSTANCE.createRawMetric();
        cpuMetric.setLayer(LayerType.IAA_S);
        cpuMetric.setName("CPUMetric");
        cpuMetric.setProperty(cpuProperty);
        cpuMetric.setUnit(ScalarmUnitModel.cpuUnit);
        cpuMetric.setValueType(ScalarmTypeModel.rangeFrom0To100Int);
        cpuMetric.setValueDirection((short) 0);
        metricModel.getMetrics().add(cpuMetric);


        RawMetric responseTimeMetric = MetricFactory.eINSTANCE.createRawMetric();
        responseTimeMetric.setLayer(LayerType.SAA_S);
        responseTimeMetric.setName("ResponseTimeMetric");
        responseTimeMetric.setProperty(cpuProperty);
        responseTimeMetric.setUnit(ScalarmUnitModel.responseTimeUnitTimeIntervalUnit) ;
        responseTimeMetric.setValueType(ScalarmTypeModel.rangeFrom0To10000Int);
        responseTimeMetric.setValueDirection((short) 0);
        metricModel.getMetrics().add(responseTimeMetric);


        RawMetric throughputOfAWrokerMetric = MetricFactory.eINSTANCE.createRawMetric();
        throughputOfAWrokerMetric.setLayer(LayerType.SAA_S);
        throughputOfAWrokerMetric.setName("ThroughputOfAWrokerMetric");
        throughputOfAWrokerMetric.setProperty(numberOfSimulationsPerSecondProperty);
        throughputOfAWrokerMetric.setUnit(ScalarmUnitModel.simulationsPerSecondUnit) ;
        throughputOfAWrokerMetric.setValueDirection((short) 1);
        metricModel.getMetrics().add(throughputOfAWrokerMetric);

        RawMetric numberOfSimulationsLeftInExperimentsMetric = MetricFactory.eINSTANCE.createRawMetric();
        numberOfSimulationsLeftInExperimentsMetric.setLayer(LayerType.SAA_S);
        numberOfSimulationsLeftInExperimentsMetric.setName("NumberOfSimulationsLeftInExperimentsMetric");
        numberOfSimulationsLeftInExperimentsMetric.setProperty(numberOfSimulationsPerSecondProperty);
        numberOfSimulationsLeftInExperimentsMetric.setUnit(ScalarmUnitModel.numberOfSimulationsLeftInExperimentUnit) ;
        numberOfSimulationsLeftInExperimentsMetric.setValueDirection((short) 0);
        metricModel.getMetrics().add(numberOfSimulationsLeftInExperimentsMetric);



        CompositeMetric meanValueOfResponseTimeOfAllExprimentManagersMetric =  MetricFactory.eINSTANCE.createCompositeMetric();
        meanValueOfResponseTimeOfAllExprimentManagersMetric.setName("MeanValueOfResponseTimeOfAllExprimentManagersMetric");
        meanValueOfResponseTimeOfAllExprimentManagersMetric.setValueDirection((short) 0);
        meanValueOfResponseTimeOfAllExprimentManagersMetric.setLayer(LayerType.SAA_S);
        meanValueOfResponseTimeOfAllExprimentManagersMetric.setProperty(responseTimeProperty);
        meanValueOfResponseTimeOfAllExprimentManagersMetric.setUnit(ScalarmUnitModel.responseTimeUnitTimeIntervalUnit);
        metricModel.getMetrics().add(meanValueOfResponseTimeOfAllExprimentManagersMetric);

        MetricFormula meanValueOfResponseTimeOfAllExprimentManagersFormula =  MetricFactory.eINSTANCE.createMetricFormula();
        meanValueOfResponseTimeOfAllExprimentManagersFormula.setName("MeanValueOfResponseTimeOfAllExprimentManagersFormula");
        meanValueOfResponseTimeOfAllExprimentManagersFormula.setFunctionArity(MetricFunctionArityType.UNARY);
        meanValueOfResponseTimeOfAllExprimentManagersFormula.setFunctionPattern(FunctionPatternType.MAP);
        meanValueOfResponseTimeOfAllExprimentManagersFormula.setFunction(MetricFunctionType.MEAN);
        meanValueOfResponseTimeOfAllExprimentManagersFormula.getParameters().add(responseTimeMetric);

        meanValueOfResponseTimeOfAllExprimentManagersMetric.setFormula(meanValueOfResponseTimeOfAllExprimentManagersFormula);



        CompositeMetric sumOfThroughputsOfAllWorkersMetric =  MetricFactory.eINSTANCE.createCompositeMetric();
        sumOfThroughputsOfAllWorkersMetric.setName("SumOfThroughputsOfAllWorkersMetric");
        sumOfThroughputsOfAllWorkersMetric.setValueDirection((short) 1);
        sumOfThroughputsOfAllWorkersMetric.setLayer(LayerType.SAA_S);
        sumOfThroughputsOfAllWorkersMetric.setProperty(throughputInSimulationsPerSecondProperty);
        sumOfThroughputsOfAllWorkersMetric.setUnit(ScalarmUnitModel.responseTimeUnitTimeIntervalUnit);
        metricModel.getMetrics().add(sumOfThroughputsOfAllWorkersMetric);

        MetricFormula sumOfThroughputsOfAllWorkersFormula =  MetricFactory.eINSTANCE.createMetricFormula();
        sumOfThroughputsOfAllWorkersFormula.setName("SumOfThroughputsOfAllWorkersFormula");
        sumOfThroughputsOfAllWorkersFormula.setFunctionArity(MetricFunctionArityType.UNARY);
        sumOfThroughputsOfAllWorkersFormula.setFunctionPattern(FunctionPatternType.MAP);
        sumOfThroughputsOfAllWorkersFormula.setFunction(MetricFunctionType.PLUS);
        sumOfThroughputsOfAllWorkersFormula.getParameters().add(throughputOfAWrokerMetric);

        sumOfThroughputsOfAllWorkersMetric.setFormula(sumOfThroughputsOfAllWorkersFormula);



        CompositeMetric makespanMetric =  MetricFactory.eINSTANCE.createCompositeMetric();
        makespanMetric.setName("MakespanMetric");
        makespanMetric.setValueDirection((short) 1);
        makespanMetric.setLayer(LayerType.SAA_S);
        makespanMetric.setProperty(makespanProperty);
        makespanMetric.setUnit(ScalarmUnitModel.experimentMakespanInSecondsUnit);
        metricModel.getMetrics().add(makespanMetric);

        MetricFormula makespanFormula =  MetricFactory.eINSTANCE.createMetricFormula();
        makespanFormula.setName("MakespanFormula");
        makespanFormula.setFunctionArity(MetricFunctionArityType.BINARY);
        makespanFormula.setFunctionPattern(FunctionPatternType.MAP);
        makespanFormula.setFunction(MetricFunctionType.DIV);
        makespanFormula.getParameters().add(numberOfSimulationsLeftInExperimentsMetric);
        makespanFormula.getParameters().add(sumOfThroughputsOfAllWorkersMetric);

        makespanMetric.setFormula(makespanFormula);




        CompositeMetric cpuAverageMetric =  MetricFactory.eINSTANCE.createCompositeMetric();
        cpuAverageMetric.setDescription("Average of the CPU");
        cpuAverageMetric.setName("CPUAverageMetric");
        cpuAverageMetric.setValueDirection((short) 1);
        cpuAverageMetric.setLayer(LayerType.PAA_S);
        cpuAverageMetric.setProperty(cpuProperty);
        cpuAverageMetric.setUnit(ScalarmUnitModel.cpuUnit);
        metricModel.getMetrics().add(cpuAverageMetric);

        MetricFormula cpuAverageFormula =  MetricFactory.eINSTANCE.createMetricFormula();
        cpuAverageFormula.setName("CPUAverageFormula");
        cpuAverageFormula.setFunctionArity(MetricFunctionArityType.UNARY);
        cpuAverageFormula.setFunctionPattern(FunctionPatternType.REDUCE);
        cpuAverageFormula.setFunction(MetricFunctionType.MEAN);
        cpuAverageFormula.getParameters().add(cpuMetric);

        cpuAverageMetric.setFormula(cpuAverageFormula);


        RawMetricContext storageManagerAvailabilityContext = MetricFactory.eINSTANCE.createRawMetricContext();
        storageManagerAvailabilityContext.setName("StorageManagerAvailabilityContext");
        storageManagerAvailabilityContext.setMetric(availabilityMetric);
        storageManagerAvailabilityContext.setSensor(availabilitySensor);
        storageManagerAvailabilityContext.setComponent(ScalarmDepolymentModel.storageManager);
        storageManagerAvailabilityContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(storageManagerAvailabilityContext);

        RawMetricContext cpuMetricConditionContext = MetricFactory.eINSTANCE.createRawMetricContext();
        cpuMetricConditionContext.setName("CPUMetricConditionContext");
        cpuMetricConditionContext.setMetric(cpuMetric);
        cpuMetricConditionContext.setSensor(cpuSensor);
        cpuMetricConditionContext.setComponent(ScalarmDepolymentModel.simulationManager);
        cpuMetricConditionContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(cpuMetricConditionContext);


        RawMetricContext experimentManagerResponseTimeContext = MetricFactory.eINSTANCE.createRawMetricContext();
        experimentManagerResponseTimeContext.setName("ExperimentManagerResponseTimeContext");
        experimentManagerResponseTimeContext.setMetric(responseTimeMetric);
        experimentManagerResponseTimeContext.setSensor(responseTimeSensor);
        experimentManagerResponseTimeContext.setComponent(ScalarmDepolymentModel.experimentManager);
        experimentManagerResponseTimeContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(experimentManagerResponseTimeContext);

        RawMetricContext informationServiceResponseTimeContext = MetricFactory.eINSTANCE.createRawMetricContext();
        informationServiceResponseTimeContext.setName("InformationServiceResponseTimeContext");
        informationServiceResponseTimeContext.setMetric(responseTimeMetric);
        informationServiceResponseTimeContext.setSensor(responseTimeSensor);
        informationServiceResponseTimeContext.setComponent(ScalarmDepolymentModel.experimentManager);
        informationServiceResponseTimeContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(informationServiceResponseTimeContext);


        RawMetricContext throughputOfAWrokerContext = MetricFactory.eINSTANCE.createRawMetricContext();
        throughputOfAWrokerContext.setName("ThroughputOfAWrokerContext");
        throughputOfAWrokerContext.setMetric(throughputOfAWrokerMetric);
        throughputOfAWrokerContext.setSensor(throughputOfSimulationsExecutedByWorkerSensor);
        throughputOfAWrokerContext.setComponent(ScalarmDepolymentModel.simulationManager);
        throughputOfAWrokerContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(throughputOfAWrokerContext);

        RawMetricContext numberOfSimulationsLeftInExperimentsContext = MetricFactory.eINSTANCE.createRawMetricContext();
        numberOfSimulationsLeftInExperimentsContext.setName("NumberOfSimulationsLeftInExperimentsContext");
        numberOfSimulationsLeftInExperimentsContext.setMetric(numberOfSimulationsLeftInExperimentsMetric);
        numberOfSimulationsLeftInExperimentsContext.setSensor(numberOfSimulationsLeftInTheExperimentSensor);
        numberOfSimulationsLeftInExperimentsContext.setComponent(ScalarmDepolymentModel.experimentManager);
        numberOfSimulationsLeftInExperimentsContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(numberOfSimulationsLeftInExperimentsContext);

        RawMetricContext cpuRawMetricContext = MetricFactory.eINSTANCE.createRawMetricContext();
        cpuRawMetricContext.setName("CPURawMetricContext");
        cpuRawMetricContext.setMetric(cpuMetric);
        cpuRawMetricContext.setSensor(cpuSensor);
        cpuRawMetricContext.setComponent(ScalarmDepolymentModel.simulationManager);
        cpuRawMetricContext.setSchedule(schedule1Sec);
        cpuRawMetricContext.setQuantifier(QuantifierType.ALL);
        metricModel.getContexts().add(cpuRawMetricContext);

        CompositeMetricContext allExperimentManagersResponseTimeContext = MetricFactory.eINSTANCE.createCompositeMetricContext();
        allExperimentManagersResponseTimeContext.setName("AllExperimentManagersResponseTimeContext");
        allExperimentManagersResponseTimeContext.setMetric(meanValueOfResponseTimeOfAllExprimentManagersMetric);
        allExperimentManagersResponseTimeContext.setComponent(ScalarmDepolymentModel.experimentManager);
        allExperimentManagersResponseTimeContext.getComposingMetricContexts().add(experimentManagerResponseTimeContext);
        allExperimentManagersResponseTimeContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(allExperimentManagersResponseTimeContext);


        CompositeMetricContext sumOfThroughputsOfAllWorkersContext = MetricFactory.eINSTANCE.createCompositeMetricContext();
        sumOfThroughputsOfAllWorkersContext.setName("SumOfThroughputsOfAllWorkersContext");
        sumOfThroughputsOfAllWorkersContext.setMetric(sumOfThroughputsOfAllWorkersMetric);
        sumOfThroughputsOfAllWorkersContext.setComponent(ScalarmDepolymentModel.simulationManager);
        sumOfThroughputsOfAllWorkersContext.getComposingMetricContexts().add(throughputOfAWrokerContext);
        sumOfThroughputsOfAllWorkersContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(sumOfThroughputsOfAllWorkersContext);

        CompositeMetricContext makespanContext = MetricFactory.eINSTANCE.createCompositeMetricContext();
        makespanContext.setName("MakespanContext");
        makespanContext.setMetric(makespanMetric);
        makespanContext.setComponent(ScalarmDepolymentModel.experimentManager);
        makespanContext.getComposingMetricContexts().add(numberOfSimulationsLeftInExperimentsContext);
        makespanContext.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(makespanContext);

        CompositeMetricContext cpuAvgMetricContextAll = MetricFactory.eINSTANCE.createCompositeMetricContext();
        cpuAvgMetricContextAll.setName("CPUAvgMetricContextAll");
        cpuAvgMetricContextAll.setMetric(cpuAverageMetric);
        cpuAvgMetricContextAll.setComponent(ScalarmDepolymentModel.simulationManager);
        cpuAvgMetricContextAll.setWindow(win5Min);
        cpuAvgMetricContextAll.setSchedule(schedule1Min);
        cpuAvgMetricContextAll.getComposingMetricContexts().add(cpuRawMetricContext);
        cpuAvgMetricContextAll.setQuantifier(QuantifierType.ALL);
        metricModel.getContexts().add(cpuAvgMetricContextAll);

        CompositeMetricContext cpuAvgMetricContextAny = MetricFactory.eINSTANCE.createCompositeMetricContext();
        cpuAvgMetricContextAny.setName("CPUAvgMetricContextAll");
        cpuAvgMetricContextAny.setMetric(cpuAverageMetric);
        cpuAvgMetricContextAny.setComponent(ScalarmDepolymentModel.simulationManager);
        cpuAvgMetricContextAny.setWindow(win1Min);
        cpuAvgMetricContextAny.setSchedule(schedule1Min);
        cpuAvgMetricContextAny.getComposingMetricContexts().add(cpuRawMetricContext);
        cpuAvgMetricContextAny.setQuantifier(QuantifierType.ANY);
        metricModel.getContexts().add(cpuAvgMetricContextAny);



        MetricCondition storageManagerAvailabilityCondition = MetricFactory.eINSTANCE.createMetricCondition();
        storageManagerAvailabilityCondition.setName("StorageManagerAvailabilityCondition");
        storageManagerAvailabilityCondition.setMetricContext(storageManagerAvailabilityContext);
        storageManagerAvailabilityCondition.setThreshold(99.0D);
        storageManagerAvailabilityCondition.setComparisonOperator(ComparisonOperatorType.GREATER_THAN);
        metricModel.getConditions().add(storageManagerAvailabilityCondition);

        MetricCondition cpuMetricCondition = MetricFactory.eINSTANCE.createMetricCondition();
        cpuMetricCondition.setName("CPUMetricCondition");
        cpuMetricCondition.setMetricContext(cpuMetricConditionContext);
        cpuMetricCondition.setThreshold(80.0D);
        cpuMetricCondition.setComparisonOperator(ComparisonOperatorType.GREATER_THAN);
        metricModel.getConditions().add(cpuMetricCondition);

        MetricCondition informationServiceResponseCondition = MetricFactory.eINSTANCE.createMetricCondition();
        informationServiceResponseCondition.setName("InformationServiceResponseCondition");
        informationServiceResponseCondition.setMetricContext(informationServiceResponseTimeContext);
        informationServiceResponseCondition.setThreshold(700.0D);
        informationServiceResponseCondition.setComparisonOperator(ComparisonOperatorType.LESS_THAN);
        metricModel.getConditions().add(informationServiceResponseCondition);

        MetricCondition experimentManagerResponseTimeCondition = MetricFactory.eINSTANCE.createMetricCondition();
        experimentManagerResponseTimeCondition.setName("ExperimentManagerResponseTimeCondition");
        experimentManagerResponseTimeCondition.setMetricContext(experimentManagerResponseTimeContext);
        experimentManagerResponseTimeCondition.setThreshold(0.3D);
        experimentManagerResponseTimeCondition.setComparisonOperator(ComparisonOperatorType.GREATER_THAN);
        metricModel.getConditions().add(experimentManagerResponseTimeCondition);


        MetricCondition cpuAvgMetricConditionAll = MetricFactory.eINSTANCE.createMetricCondition();
        cpuAvgMetricConditionAll.setName("CPUAvgMetricConditionAll");
        cpuAvgMetricConditionAll.setMetricContext(cpuAvgMetricContextAll);
        cpuAvgMetricConditionAll.setThreshold(50.0D);
        cpuAvgMetricConditionAll.setComparisonOperator(ComparisonOperatorType.GREATER_THAN);
        metricModel.getConditions().add(cpuAvgMetricConditionAll);


        MetricCondition cpuAvgMetricConditionAny = MetricFactory.eINSTANCE.createMetricCondition();
        cpuAvgMetricConditionAny.setName("CPUAvgMetricConditionAny");
        cpuAvgMetricConditionAny.setMetricContext(cpuAvgMetricContextAny);
        cpuAvgMetricConditionAny.setThreshold(50.0D);
        cpuAvgMetricConditionAny.setComparisonOperator(ComparisonOperatorType.GREATER_THAN);
        metricModel.getConditions().add(cpuAvgMetricConditionAny);



        return metricModel ;
    }

}
