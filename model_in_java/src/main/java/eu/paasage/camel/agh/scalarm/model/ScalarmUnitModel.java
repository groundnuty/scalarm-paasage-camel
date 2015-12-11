package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.provider.Constraint;
import eu.paasage.camel.provider.Feature;
import eu.paasage.camel.provider.ProviderModel;
import eu.paasage.camel.unit.*;
import org.javatuples.Triplet;

/**
 * Created by orzech on 10/12/15.
 */
public class ScalarmUnitModel {


    public static TimeIntervalUnit minutes ;
    public static TimeIntervalUnit seconds ;
    public static Dimensionless availabilityUnit ;
    public static Dimensionless cpuUnit ;
    public static MonetaryUnit costEuroMonetaryUnit ;
    public static TimeIntervalUnit responseTimeUnitTimeIntervalUnit ;
    public static  TransactionUnit numberOfSimulationsLeftInExperimentUnit;
    public static  ThroughputUnit simulationsPerSecondUnit;
    public static  TimeIntervalUnit experimentMakespanInSecondsUnit;

    public static UnitModel createUnitModel() {

        UnitModel unitModel = UnitFactory.eINSTANCE.createUnitModel();
        unitModel.setName("Scalarm Unit Model");


        /*
            dimensionless {AvailabilityUnit: PERCENTAGE}
         */
        TransactionUnit numberOfSimulationsLeftInExperimentUnit = UnitFactory.eINSTANCE.createTransactionUnit();
        numberOfSimulationsLeftInExperimentUnit.setUnit(UnitType.TRANSACTIONS_PER_SECOND);
        numberOfSimulationsLeftInExperimentUnit.setName("NumberOfSimulationsLeftInExperimentUnit");
        unitModel.getUnits().add(numberOfSimulationsLeftInExperimentUnit);

        /*
            throughput unit {SimulationsPerSecondUnit: TRANSACTIONS_PER_SECOND}

         */
        ThroughputUnit simulationsPerSecondUnit = UnitFactory.eINSTANCE.createThroughputUnit();
        simulationsPerSecondUnit.setUnit(UnitType.TRANSACTIONS_PER_SECOND);
        simulationsPerSecondUnit.setName("SimulationsPerSecondUnit");
        unitModel.getUnits().add(simulationsPerSecondUnit);

        /*
            dimensionless {AvailabilityUnit: PERCENTAGE}
         */
        Dimensionless availabilityUnit = UnitFactory.eINSTANCE.createDimensionless();
        availabilityUnit.setUnit(UnitType.PERCENTAGE);
        availabilityUnit.setName("AvailabilityUnit");
        unitModel.getUnits().add(availabilityUnit);

        /*
            dimensionless {CPUUnit: PERCENTAGE}
         */
        Dimensionless cpuUnit = UnitFactory.eINSTANCE.createDimensionless();
        cpuUnit.setUnit(UnitType.PERCENTAGE);
        cpuUnit.setName("CPUUnit");
        unitModel.getUnits().add(cpuUnit);

        /*
            monetary unit {Euro: EUROS}
         */
        MonetaryUnit costEuroMonetaryUnit = UnitFactory.eINSTANCE.createMonetaryUnit();
        costEuroMonetaryUnit.setUnit(UnitType.EUROS);
        costEuroMonetaryUnit.setName("Euro");
        unitModel.getUnits().add(costEuroMonetaryUnit);

        /*
            monetary unit {Euro: EUROS}
         */
        MonetaryUnit euroMonetaryUnit = UnitFactory.eINSTANCE.createMonetaryUnit();
        euroMonetaryUnit.setUnit(UnitType.EUROS);
        euroMonetaryUnit.setName("CPUUnit");
        unitModel.getUnits().add(euroMonetaryUnit);

        /*
            time interval unit {ResponseTimeUnit: MILLISECONDS}
         */
        TimeIntervalUnit responseTimeUnitTimeIntervalUnit = UnitFactory.eINSTANCE
                .createTimeIntervalUnit();
        responseTimeUnitTimeIntervalUnit.setUnit(UnitType.MILLISECONDS);
        responseTimeUnitTimeIntervalUnit.setName("ResponseTimeUnit");
        unitModel.getUnits().add(responseTimeUnitTimeIntervalUnit);

        /*
            time interval unit {ResponseTimeUnit: MILLISECONDS}
         */
        TimeIntervalUnit experimentMakespanInSecondsUnit = UnitFactory.eINSTANCE
                .createTimeIntervalUnit();
        experimentMakespanInSecondsUnit.setUnit(UnitType.SECONDS);
        experimentMakespanInSecondsUnit.setName("ExperimentMakespanInSecondsUnit");
        unitModel.getUnits().add(experimentMakespanInSecondsUnit);

        /*
            time interval unit {ResponseTimeUnit: MILLISECONDS}
         */
        TimeIntervalUnit timeIntervalInSecondsUnit = UnitFactory.eINSTANCE
                .createTimeIntervalUnit();
        timeIntervalInSecondsUnit.setUnit(UnitType.SECONDS);
        timeIntervalInSecondsUnit.setName("seconds");
        unitModel.getUnits().add(timeIntervalInSecondsUnit);


        /*
            time interval unit {ResponseTimeUnit: MILLISECONDS}
         */
        TimeIntervalUnit timeIntervalInMinutesUnit = UnitFactory.eINSTANCE
                .createTimeIntervalUnit();
        timeIntervalInMinutesUnit.setUnit(UnitType.MINUTES);
        timeIntervalInMinutesUnit.setName("minutes");
        unitModel.getUnits().add(timeIntervalInMinutesUnit);




        ScalarmUnitModel.minutes  = timeIntervalInMinutesUnit;
        ScalarmUnitModel.seconds = timeIntervalInSecondsUnit;
        ScalarmUnitModel.availabilityUnit = availabilityUnit;
        ScalarmUnitModel.cpuUnit = cpuUnit;
        ScalarmUnitModel.costEuroMonetaryUnit = costEuroMonetaryUnit;
        ScalarmUnitModel.responseTimeUnitTimeIntervalUnit = responseTimeUnitTimeIntervalUnit;
        ScalarmUnitModel.numberOfSimulationsLeftInExperimentUnit = numberOfSimulationsLeftInExperimentUnit;
        ScalarmUnitModel.simulationsPerSecondUnit = simulationsPerSecondUnit;
        ScalarmUnitModel.experimentMakespanInSecondsUnit = experimentMakespanInSecondsUnit;

        return unitModel;
    }

}
