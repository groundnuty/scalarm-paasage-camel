package eu.paasage.camel.agh.scalarm.model.submodels;

import org.javatuples.Triplet;

import eu.paasage.camel.UnitType;
import eu.paasage.camel.provider.Attribute;
import eu.paasage.camel.provider.AttributeConstraint;
import eu.paasage.camel.provider.Constraint;
import eu.paasage.camel.provider.FeatCardinality;
import eu.paasage.camel.provider.Feature;
import eu.paasage.camel.provider.Implies;
import eu.paasage.camel.provider.ProviderFactory;
import eu.paasage.camel.provider.ProviderModel;
import eu.paasage.camel.type.EnumerateValue;
import eu.paasage.camel.type.Enumeration;
import eu.paasage.camel.type.IntValue;
import eu.paasage.camel.type.Limit;
import eu.paasage.camel.type.Range;
import eu.paasage.camel.type.StringValue;
import eu.paasage.camel.type.TypeEnum;
import eu.paasage.camel.type.TypeFactory;

/**
 * @author nikolayn, orzech
 */
public class ScalarmFlexiantProviderModel {

    public static Triplet<ProviderModel, Feature, Constraint> createFlexiantProviderModel() {
        /////// START of definition of the Provider model

        ProviderModel flexiantProviderModel = ProviderFactory.eINSTANCE.createProviderModel();

        Feature vmFeature = ProviderFactory.eINSTANCE.createFeature();
        vmFeature.setName("VM");
        FeatCardinality vmCardinality = ProviderFactory.eINSTANCE.createFeatCardinality();
        vmCardinality.setValue(1);
        vmCardinality.setCardinalityMin(1);
        vmCardinality.setCardinalityMax(8);
        vmFeature.setFeatureCardinality(vmCardinality);

        flexiantProviderModel.setRootFeature(vmFeature);

        Attribute vmType = ProviderFactory.eINSTANCE.createAttribute();
        vmType.setName("vmType");

        Enumeration vmTypes = TypeFactory.eINSTANCE.createEnumeration();

        EnumerateValue lowestVm = TypeFactory.eINSTANCE.createEnumerateValue();
        lowestVm.setName("LOWEST");
        lowestVm.setValue(0);
        vmTypes.getValues().add(lowestVm);
        
        EnumerateValue lowerVm = TypeFactory.eINSTANCE.createEnumerateValue();
        lowerVm.setName("LOWER");
        lowerVm.setValue(1);
        vmTypes.getValues().add(lowerVm);
        
        EnumerateValue lowVm = TypeFactory.eINSTANCE.createEnumerateValue();
        lowVm.setName("LOW");
        lowVm.setValue(2);
        vmTypes.getValues().add(lowVm);
        
        EnumerateValue mediumVm = TypeFactory.eINSTANCE.createEnumerateValue();
        mediumVm.setName("MEDIUM");
        mediumVm.setValue(3);
        vmTypes.getValues().add(mediumVm);
        
        EnumerateValue highVm = TypeFactory.eINSTANCE.createEnumerateValue();
        highVm.setName("HIGH");
        highVm.setValue(4);
        vmTypes.getValues().add(highVm);
        
        EnumerateValue higherVm = TypeFactory.eINSTANCE.createEnumerateValue();
        higherVm.setName("HIGHER");
        higherVm.setValue(5);
        vmTypes.getValues().add(higherVm);
        
        EnumerateValue highestVm = TypeFactory.eINSTANCE.createEnumerateValue();
        highestVm.setName("HIGHEST");
        highestVm.setValue(6);
        vmTypes.getValues().add(highestVm);

        vmType.setValueType(vmTypes);

        vmFeature.getAttributes().add(vmType);

        Attribute vmMemory = ProviderFactory.eINSTANCE.createAttribute();
        vmMemory.setName("vmMemory");

        Range vmMemoryRange = TypeFactory.eINSTANCE.createRange();

        vmMemoryRange.setPrimitiveType(TypeEnum.INT_TYPE);

        Limit minMemory = TypeFactory.eINSTANCE.createLimit();
        minMemory.setIncluded(true);
        IntValue minMemoryValue = TypeFactory.eINSTANCE.createIntValue();
        minMemoryValue.setValue(512);
        minMemory.setValue(minMemoryValue);

        Limit maxMemory = TypeFactory.eINSTANCE.createLimit();
        maxMemory.setIncluded(true);
        IntValue maxMemoryValue = TypeFactory.eINSTANCE.createIntValue();
        maxMemoryValue.setValue(4096);
        maxMemory.setValue(maxMemoryValue);

        vmMemoryRange.setLowerLimit(minMemory);
        vmMemoryRange.setUpperLimit(maxMemory);

        vmMemory.setValueType(vmMemoryRange);
        vmMemory.setUnitType(UnitType.MEGABYTES);
        
        vmFeature.getAttributes().add(vmMemory);

        Attribute vmStorage = ProviderFactory.eINSTANCE.createAttribute();
        vmStorage.setName("vmStorage");

        Range vmStorageRange = TypeFactory.eINSTANCE.createRange();

        vmStorageRange.setPrimitiveType(TypeEnum.INT_TYPE);

        Limit minStorage = TypeFactory.eINSTANCE.createLimit();
        minStorage.setIncluded(true);
        IntValue minStorageValue = TypeFactory.eINSTANCE.createIntValue();
        minStorageValue.setValue(1);
        minStorage.setValue(minStorageValue);

        Limit maxStorage = TypeFactory.eINSTANCE.createLimit();
        maxStorage.setIncluded(true);
        IntValue maxStorageValue = TypeFactory.eINSTANCE.createIntValue();
        maxStorageValue.setValue(1000);
        maxStorage.setValue(maxStorageValue);

        vmStorageRange.setLowerLimit(minStorage);
        vmStorageRange.setUpperLimit(maxStorage);

        vmStorage.setValueType(vmStorageRange);
        vmStorage.setUnitType(UnitType.GIGABYTES);

        vmFeature.getAttributes().add(vmStorage);

        Attribute vmCores = ProviderFactory.eINSTANCE.createAttribute();
        vmCores.setName("vmCores");

        Range vmCoresRange = TypeFactory.eINSTANCE.createRange();

        vmCoresRange.setPrimitiveType(TypeEnum.INT_TYPE);

        Limit minCores = TypeFactory.eINSTANCE.createLimit();
        minCores.setIncluded(true);
        IntValue minCoresValue = TypeFactory.eINSTANCE.createIntValue();
        minCoresValue.setValue(1);
        minCores.setValue(minCoresValue);

        Limit maxCores = TypeFactory.eINSTANCE.createLimit();
        maxCores.setIncluded(true);
        IntValue maxCoresValue = TypeFactory.eINSTANCE.createIntValue();
        maxCoresValue.setValue(4);
        maxCores.setValue(maxCoresValue);

        vmCoresRange.setLowerLimit(minCores);
        vmCoresRange.setUpperLimit(maxCores);

        vmCores.setValueType(vmCoresRange);

        vmFeature.getAttributes().add(vmCores);

        Attribute vmOS = ProviderFactory.eINSTANCE.createAttribute();
        vmOS.setName("vmOS");
        Enumeration vmOSTypes = TypeFactory.eINSTANCE.createEnumeration();

        EnumerateValue centOS62 = TypeFactory.eINSTANCE.createEnumerateValue();
        centOS62.setName("CentOS 6.2");
        centOS62.setValue(0);
        vmOSTypes.getValues().add(centOS62);
        
        EnumerateValue ubuntu1204 = TypeFactory.eINSTANCE.createEnumerateValue();
        ubuntu1204.setName("Ubuntu 12.04");
        ubuntu1204.setValue(1);
        vmOSTypes.getValues().add(ubuntu1204);
        
        EnumerateValue ubuntu1404 = TypeFactory.eINSTANCE.createEnumerateValue();
        ubuntu1404.setName("Ubuntu 14.04");
        ubuntu1404.setValue(2);
        vmOSTypes.getValues().add(ubuntu1404);
        
        EnumerateValue windows2008 = TypeFactory.eINSTANCE.createEnumerateValue();
        windows2008.setName("Windows 2008 R2");
        windows2008.setValue(3);
        vmOSTypes.getValues().add(windows2008);

        vmOS.setValueType(vmOSTypes);

        vmFeature.getAttributes().add(vmOS);

        
        Implies lowestVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        lowestVmConstraint.setName("LOWEST_VM_Constraint_Mapping");
        lowestVmConstraint.setFrom(vmFeature);
        lowestVmConstraint.setTo(vmFeature);


        AttributeConstraint lowestVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        lowestVmMemoryConstraint.setFrom(vmType);
        StringValue lowestVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        lowestVmMemoryConstraintFrom.setValue("LOWEST");
        lowestVmMemoryConstraint.setFromValue(lowestVmMemoryConstraintFrom);

        lowestVmMemoryConstraint.setTo(vmMemory);
        IntValue lowestVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        lowestVMMemoryConstraintTo.setValue(512);
        lowestVmMemoryConstraint.setToValue(lowestVMMemoryConstraintTo);

        lowestVmConstraint.getAttributeConstraints().add(lowestVmMemoryConstraint);


        AttributeConstraint lowestVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        lowestVmCoresConstraint.setFrom(vmType);
        StringValue lowestVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        lowestVmCoresConstraintFrom.setValue("LOWEST");
        lowestVmCoresConstraint.setFromValue(lowestVmCoresConstraintFrom);

        lowestVmCoresConstraint.setTo(vmCores);
        IntValue lowestVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        lowestVmCoresConstraintTo.setValue(1);
        lowestVmCoresConstraint.setToValue(lowestVmCoresConstraintTo);

        lowestVmConstraint.getAttributeConstraints().add(lowestVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(lowestVmConstraint);


        Implies lowerVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        lowerVmConstraint.setName("LOWER_VM_Constraint_Mapping");
        lowerVmConstraint.setFrom(vmFeature);
        lowerVmConstraint.setTo(vmFeature);


        AttributeConstraint lowerVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        lowerVmMemoryConstraint.setFrom(vmType);
        StringValue lowerVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        lowerVmMemoryConstraintFrom.setValue("LOWER");
        lowerVmMemoryConstraint.setFromValue(lowerVmMemoryConstraintFrom);

        lowerVmMemoryConstraint.setTo(vmMemory);
        IntValue lowerVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        lowerVMMemoryConstraintTo.setValue(1024);
        lowerVmMemoryConstraint.setToValue(lowerVMMemoryConstraintTo);

        lowerVmConstraint.getAttributeConstraints().add(lowerVmMemoryConstraint);


        AttributeConstraint lowerVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        lowerVmCoresConstraint.setFrom(vmType);
        StringValue lowerVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        lowerVmCoresConstraintFrom.setValue("LOWER");
        lowerVmCoresConstraint.setFromValue(lowerVmCoresConstraintFrom);

        lowerVmCoresConstraint.setTo(vmCores);
        IntValue lowerVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        lowerVmCoresConstraintTo.setValue(1);
        lowerVmCoresConstraint.setToValue(lowerVmCoresConstraintTo);

        lowerVmConstraint.getAttributeConstraints().add(lowerVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(lowerVmConstraint);
        
        Implies lowVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        lowVmConstraint.setName("LOW_VM_Constraint_Mapping");
        lowVmConstraint.setFrom(vmFeature);
        lowVmConstraint.setTo(vmFeature);


        AttributeConstraint lowVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        lowVmMemoryConstraint.setFrom(vmType);
        StringValue lowVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        lowVmMemoryConstraintFrom.setValue("LOW");
        lowVmMemoryConstraint.setFromValue(lowVmMemoryConstraintFrom);

        lowVmMemoryConstraint.setTo(vmMemory);
        IntValue lowVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        lowVMMemoryConstraintTo.setValue(2048);
        lowVmMemoryConstraint.setToValue(lowVMMemoryConstraintTo);

        lowVmConstraint.getAttributeConstraints().add(lowVmMemoryConstraint);


        AttributeConstraint lowVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        lowVmCoresConstraint.setFrom(vmType);
        StringValue lowVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        lowVmCoresConstraintFrom.setValue("LOW");
        lowVmCoresConstraint.setFromValue(lowVmCoresConstraintFrom);

        lowVmCoresConstraint.setTo(vmCores);
        IntValue lowVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        lowVmCoresConstraintTo.setValue(1);
        lowVmCoresConstraint.setToValue(lowVmCoresConstraintTo);

        lowVmConstraint.getAttributeConstraints().add(lowVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(lowVmConstraint);
        
        
        Implies mediumVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        mediumVmConstraint.setName("MEDIUM_VM_Constraint_Mapping");
        mediumVmConstraint.setFrom(vmFeature);
        mediumVmConstraint.setTo(vmFeature);


        AttributeConstraint mediumVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        mediumVmMemoryConstraint.setFrom(vmType);
        StringValue mediumVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        mediumVmMemoryConstraintFrom.setValue("MEDIUM");
        mediumVmMemoryConstraint.setFromValue(mediumVmMemoryConstraintFrom);

        mediumVmMemoryConstraint.setTo(vmMemory);
        IntValue mediumVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        mediumVMMemoryConstraintTo.setValue(2048);
        mediumVmMemoryConstraint.setToValue(mediumVMMemoryConstraintTo);

        mediumVmConstraint.getAttributeConstraints().add(mediumVmMemoryConstraint);


        AttributeConstraint mediumVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        mediumVmCoresConstraint.setFrom(vmType);
        StringValue mediumVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        mediumVmCoresConstraintFrom.setValue("MEDIUM");
        mediumVmCoresConstraint.setFromValue(mediumVmCoresConstraintFrom);

        mediumVmCoresConstraint.setTo(vmCores);
        IntValue mediumVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        mediumVmCoresConstraintTo.setValue(2);
        mediumVmCoresConstraint.setToValue(mediumVmCoresConstraintTo);

        mediumVmConstraint.getAttributeConstraints().add(mediumVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(mediumVmConstraint);
        
        Implies highVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        highVmConstraint.setName("HIGH_VM_Constraint_Mapping");
        highVmConstraint.setFrom(vmFeature);
        highVmConstraint.setTo(vmFeature);


        AttributeConstraint highVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        highVmMemoryConstraint.setFrom(vmType);
        StringValue highVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        highVmMemoryConstraintFrom.setValue("HIGH");
        highVmMemoryConstraint.setFromValue(highVmMemoryConstraintFrom);

        highVmMemoryConstraint.setTo(vmMemory);
        IntValue highVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        highVMMemoryConstraintTo.setValue(4096);
        highVmMemoryConstraint.setToValue(highVMMemoryConstraintTo);

        highVmConstraint.getAttributeConstraints().add(highVmMemoryConstraint);


        AttributeConstraint highVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        highVmCoresConstraint.setFrom(vmType);
        StringValue highVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        highVmCoresConstraintFrom.setValue("HIGH");
        highVmCoresConstraint.setFromValue(highVmCoresConstraintFrom);

        highVmCoresConstraint.setTo(vmCores);
        IntValue highVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        highVmCoresConstraintTo.setValue(2);
        highVmCoresConstraint.setToValue(highVmCoresConstraintTo);

        highVmConstraint.getAttributeConstraints().add(highVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(highVmConstraint);
        
        
        Implies higherVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        higherVmConstraint.setName("HIGHER_VM_Constraint_Mapping");
        higherVmConstraint.setFrom(vmFeature);
        higherVmConstraint.setTo(vmFeature);


        AttributeConstraint higherVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        higherVmMemoryConstraint.setFrom(vmType);
        StringValue higherVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        higherVmMemoryConstraintFrom.setValue("HIGHER");
        higherVmMemoryConstraint.setFromValue(higherVmMemoryConstraintFrom);

        higherVmMemoryConstraint.setTo(vmMemory);
        IntValue higherVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        higherVMMemoryConstraintTo.setValue(4096);
        higherVmMemoryConstraint.setToValue(higherVMMemoryConstraintTo);

        higherVmConstraint.getAttributeConstraints().add(higherVmMemoryConstraint);


        AttributeConstraint higherVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        higherVmCoresConstraint.setFrom(vmType);
        StringValue higherVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        higherVmCoresConstraintFrom.setValue("HIGHER");
        higherVmCoresConstraint.setFromValue(higherVmCoresConstraintFrom);

        higherVmCoresConstraint.setTo(vmCores);
        IntValue higherVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        higherVmCoresConstraintTo.setValue(3);
        higherVmCoresConstraint.setToValue(higherVmCoresConstraintTo);

        higherVmConstraint.getAttributeConstraints().add(higherVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(higherVmConstraint);
        
        Implies highestVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        highestVmConstraint.setName("HIGHEST_VM_Constraint_Mapping");
        highestVmConstraint.setFrom(vmFeature);
        highestVmConstraint.setTo(vmFeature);


        AttributeConstraint highestVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        highestVmMemoryConstraint.setFrom(vmType);
        StringValue highestVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        highestVmMemoryConstraintFrom.setValue("HIGHEST");
        highestVmMemoryConstraint.setFromValue(highestVmMemoryConstraintFrom);

        highestVmMemoryConstraint.setTo(vmMemory);
        IntValue highestVMMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        highestVMMemoryConstraintTo.setValue(4096);
        highestVmMemoryConstraint.setToValue(highestVMMemoryConstraintTo);

        highestVmConstraint.getAttributeConstraints().add(highestVmMemoryConstraint);


        AttributeConstraint highestVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        highestVmCoresConstraint.setFrom(vmType);
        StringValue highestVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        highestVmCoresConstraintFrom.setValue("HIGHEST");
        highestVmCoresConstraint.setFromValue(highestVmCoresConstraintFrom);

        highestVmCoresConstraint.setTo(vmCores);
        IntValue highestVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        highestVmCoresConstraintTo.setValue(4);
        highestVmCoresConstraint.setToValue(highestVmCoresConstraintTo);

        highestVmConstraint.getAttributeConstraints().add(highestVmCoresConstraint);


        flexiantProviderModel.getConstraints().add(highestVmConstraint);
        return new Triplet<ProviderModel, Feature, Constraint>(flexiantProviderModel, vmFeature,
                mediumVmConstraint);

    }

}
