package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmDepolymentModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmLocationModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmMetricsModel;
import eu.paasage.camel.requirement.*;

/**
 * Created by orzech on 10/12/15.
 */
public class ScalarmRequirmentModel {

    public static OSRequirement ubuntuRequirement ;
    public static QuantitativeHardwareRequirement coreIntensiveRequirment ;
    public static QuantitativeHardwareRequirement cpuIntensiveRequirment ;
    public static QuantitativeHardwareRequirement storageIntensiveRequirment ;
    public static LocationRequirement germanyRequirement ;
    public static HorizontalScaleRequirement horizontalScaleSimulationManager ;



    public static RequirementModel createScalarmRequirmentModel() {


        RequirementModel rm = RequirementFactory.eINSTANCE.createRequirementModel();
        rm.setName("SensAPP-Requirement Model");


        QuantitativeHardwareRequirement coreIntensiveRequirment = RequirementFactory.eINSTANCE.createQuantitativeHardwareRequirement();
        coreIntensiveRequirment.setName("CoreIntensive");
        coreIntensiveRequirment.setMaxCores(32);
        coreIntensiveRequirment.setMinCores(8);
        coreIntensiveRequirment.setMaxRAM(8192);
        coreIntensiveRequirment.setMinRAM(4096);
        rm.getRequirements().add(coreIntensiveRequirment);


        QuantitativeHardwareRequirement cpuIntensiveRequirment = RequirementFactory.eINSTANCE.createQuantitativeHardwareRequirement();
        cpuIntensiveRequirment.setName("CPUIntensive");
        cpuIntensiveRequirment.setMinCores(1);
        cpuIntensiveRequirment.setMaxRAM(8192);
        cpuIntensiveRequirment.setMinRAM(4096);
        cpuIntensiveRequirment.setMinCores(1);
        rm.getRequirements().add(cpuIntensiveRequirment);

        QuantitativeHardwareRequirement storageIntensiveRequirment = RequirementFactory.eINSTANCE.createQuantitativeHardwareRequirement();
        storageIntensiveRequirment.setName("StorageIntensive");
        storageIntensiveRequirment.setMinStorage(1000);
        rm.getRequirements().add(storageIntensiveRequirment);

        OSRequirement ubuntuRequirement = RequirementFactory.eINSTANCE.createOSRequirement();
        ubuntuRequirement.setOs("Ubuntu");
        ubuntuRequirement.setIs64os(true);
        ubuntuRequirement.setName("Ubuntu");
        rm.getRequirements().add(ubuntuRequirement);

        LocationRequirement germanyRequirement = RequirementFactory.eINSTANCE.createLocationRequirement();
        germanyRequirement.setName("GermanyReq");
        germanyRequirement.getLocations().add(ScalarmLocationModel.germany);
        rm.getRequirements().add(germanyRequirement);


        LocationRequirement ukRequirement = RequirementFactory.eINSTANCE.createLocationRequirement();
        ukRequirement.setName("UKReq");
        ukRequirement.getLocations().add(ScalarmLocationModel.uk);
        rm.getRequirements().add(ukRequirement);

        HorizontalScaleRequirement horizontalScaleSimulationManager = RequirementFactory.eINSTANCE.createHorizontalScaleRequirement();
        horizontalScaleSimulationManager.setName("HorizontalScaleSimulationManager");
        horizontalScaleSimulationManager.setComponent(ScalarmDepolymentModel.simulationManager);
        horizontalScaleSimulationManager.setMinInstances(1);
        horizontalScaleSimulationManager.setMaxInstances(5);
        rm.getRequirements().add(horizontalScaleSimulationManager);


        ServiceLevelObjective CPUMetricSLO = RequirementFactory.eINSTANCE.createServiceLevelObjective();
        CPUMetricSLO.setName("CPUMetricSLO");
        CPUMetricSLO.setCustomServiceLevel(ScalarmMetricsModel.cpuMetricCondition);
        rm.getRequirements().add(CPUMetricSLO);


        OptimisationRequirement minimiseResponseTimeInformationService = RequirementFactory.eINSTANCE.createOptimisationRequirement();
        minimiseResponseTimeInformationService.setName("MinimiseResponseTimeInformationService");
        minimiseResponseTimeInformationService.setOptimisationFunction(OptimisationFunctionType.MINIMISE);
        minimiseResponseTimeInformationService.setMetric(ScalarmMetricsModel.responseTimeMetric);
        minimiseResponseTimeInformationService.setComponent(ScalarmDepolymentModel.informationService);
        minimiseResponseTimeInformationService.setPriority(3.0D);
        rm.getRequirements().add(minimiseResponseTimeInformationService);

        OptimisationRequirement maximiseAvailabilityStorageManager = RequirementFactory.eINSTANCE.createOptimisationRequirement();
        maximiseAvailabilityStorageManager.setName("MaximiseAvailabilityStorageManager");
        maximiseAvailabilityStorageManager.setOptimisationFunction(OptimisationFunctionType.MAXIMISE);
        maximiseAvailabilityStorageManager.setMetric(ScalarmMetricsModel.availabilityMetric);
        maximiseAvailabilityStorageManager.setComponent(ScalarmDepolymentModel.storageManager);
        maximiseAvailabilityStorageManager.setPriority(5.0D);
        rm.getRequirements().add(maximiseAvailabilityStorageManager);


        OptimisationRequirement minimisePerformanceDegradationOfExperimentManager = RequirementFactory.eINSTANCE.createOptimisationRequirement();
        minimisePerformanceDegradationOfExperimentManager.setName("MinimisePerformanceDegradationOfExperimentManager");
        minimisePerformanceDegradationOfExperimentManager.setOptimisationFunction(OptimisationFunctionType.MINIMISE);
        minimisePerformanceDegradationOfExperimentManager.setMetric(ScalarmMetricsModel.meanValueOfResponseTimeOfAllExprimentManagersMetric);
        minimisePerformanceDegradationOfExperimentManager.setComponent(ScalarmDepolymentModel.experimentManager);
        minimisePerformanceDegradationOfExperimentManager.setPriority(1.0D);
        rm.getRequirements().add(minimisePerformanceDegradationOfExperimentManager);


        OptimisationRequirement minimiseDataFarmingExperimentMakespan = RequirementFactory.eINSTANCE.createOptimisationRequirement();
        minimiseDataFarmingExperimentMakespan.setName("MinimiseDataFarmingExperimentMakespan");
        minimiseDataFarmingExperimentMakespan.setOptimisationFunction(OptimisationFunctionType.MINIMISE);
        minimiseDataFarmingExperimentMakespan.setMetric(ScalarmMetricsModel.makespanMetric);
        minimiseDataFarmingExperimentMakespan.setComponent(ScalarmDepolymentModel.experimentManager);
        minimiseDataFarmingExperimentMakespan.setPriority(1.0D);
        rm.getRequirements().add(minimiseDataFarmingExperimentMakespan);


        RequirementGroup scalarmRequirementGroup = RequirementFactory.eINSTANCE.createRequirementGroup();
        scalarmRequirementGroup.setName("ScalarmRequirementGroup");
        scalarmRequirementGroup.setRequirementOperator(RequirementOperatorType.AND);
        scalarmRequirementGroup.getRequirements().add(minimiseResponseTimeInformationService);
        scalarmRequirementGroup.getRequirements().add(maximiseAvailabilityStorageManager);
        scalarmRequirementGroup.getRequirements().add(minimisePerformanceDegradationOfExperimentManager);
        scalarmRequirementGroup.getRequirements().add(minimiseDataFarmingExperimentMakespan);
        rm.getRequirements().add(scalarmRequirementGroup);


        ScalarmRequirmentModel.ubuntuRequirement = ubuntuRequirement;
        ScalarmRequirmentModel.coreIntensiveRequirment = coreIntensiveRequirment;
        ScalarmRequirmentModel.cpuIntensiveRequirment = cpuIntensiveRequirment;
        ScalarmRequirmentModel.storageIntensiveRequirment = storageIntensiveRequirment;
        ScalarmRequirmentModel.germanyRequirement = germanyRequirement ;
        ScalarmRequirmentModel.horizontalScaleSimulationManager = horizontalScaleSimulationManager;

        return rm;
    }

}
