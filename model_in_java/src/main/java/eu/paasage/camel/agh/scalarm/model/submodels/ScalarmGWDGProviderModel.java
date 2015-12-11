package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.UnitType;
import eu.paasage.camel.provider.Attribute;
import eu.paasage.camel.provider.AttributeConstraint;
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
 * @author nikolayn
 */
public class ScalarmGWDGProviderModel {

    public static ProviderModel createGWDGProviderModel() {

        ProviderModel gwdgProviderModel = ProviderFactory.eINSTANCE.createProviderModel();

        Feature vmFeature = ProviderFactory.eINSTANCE.createFeature();
        vmFeature.setName("VM");
        FeatCardinality vmCardinality = ProviderFactory.eINSTANCE.createFeatCardinality();
        vmCardinality.setValue(1);
        vmCardinality.setCardinalityMin(1);
        vmCardinality.setCardinalityMax(8);
        vmFeature.setFeatureCardinality(vmCardinality);

        gwdgProviderModel.setRootFeature(vmFeature);

        Attribute vmType = ProviderFactory.eINSTANCE.createAttribute();
        vmType.setName("vmType");

        Enumeration vmTypes = TypeFactory.eINSTANCE.createEnumeration();

        EnumerateValue m1MicroVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1MicroVm.setName("M1.MICRO");
        m1MicroVm.setValue(0);
        vmTypes.getValues().add(m1MicroVm);
        
        EnumerateValue m1TinyVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1TinyVm.setName("M1.TINY");
        m1TinyVm.setValue(1);
        vmTypes.getValues().add(m1TinyVm);
        
        EnumerateValue m1SmallVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1SmallVm.setName("M1.SMALL");
        m1SmallVm.setValue(2);
        vmTypes.getValues().add(m1SmallVm);
        
        EnumerateValue m1MediumVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1MediumVm.setName("M1.MEDIUM");
        m1MediumVm.setValue(3);
        vmTypes.getValues().add(m1MediumVm);
        
        EnumerateValue m1LargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1LargeVm.setName("M1.LARGE");
        m1LargeVm.setValue(4);
        vmTypes.getValues().add(m1LargeVm);
        
        EnumerateValue m1XLargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1XLargeVm.setName("M1.XLARGE");
        m1XLargeVm.setValue(5);
        vmTypes.getValues().add(m1XLargeVm);
        
        EnumerateValue m1XXLargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m1XXLargeVm.setName("M1.XXLARGE");
        m1XXLargeVm.setValue(6);
        vmTypes.getValues().add(m1XXLargeVm);

        EnumerateValue m2SmallVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m2SmallVm.setName("M2.SMALL");
        m2SmallVm.setValue(7);
        vmTypes.getValues().add(m2SmallVm);
        
        EnumerateValue m2MediumVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m2MediumVm.setName("M2.MEDIUM");
        m2MediumVm.setValue(8);
        vmTypes.getValues().add(m2MediumVm);
        
        EnumerateValue m2LargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m2LargeVm.setName("M2.LARGE");
        m2LargeVm.setValue(9);
        vmTypes.getValues().add(m2LargeVm);
        
        EnumerateValue m2XLargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        m2XLargeVm.setName("M2.XLARGE");
        m2XLargeVm.setValue(10);
        vmTypes.getValues().add(m2XLargeVm);
        
        EnumerateValue c1SmallVm = TypeFactory.eINSTANCE.createEnumerateValue();
        c1SmallVm.setName("C1.SMALL");
        c1SmallVm.setValue(11);
        vmTypes.getValues().add(c1SmallVm);
        
        EnumerateValue c1MediumVm = TypeFactory.eINSTANCE.createEnumerateValue();
        c1MediumVm.setName("C1.MEDIUM");
        c1MediumVm.setValue(12);
        vmTypes.getValues().add(c1MediumVm);
        
        EnumerateValue c1LargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        c1LargeVm.setName("C1.LARGE");
        c1LargeVm.setValue(13);
        vmTypes.getValues().add(c1LargeVm);
        
        EnumerateValue c1XLargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        c1XLargeVm.setName("C1.XLARGE");
        c1XLargeVm.setValue(14);
        vmTypes.getValues().add(c1XLargeVm);
        
        EnumerateValue c1XXLargeVm = TypeFactory.eINSTANCE.createEnumerateValue();
        c1XXLargeVm.setName("C1.XXLARGE");
        c1XXLargeVm.setValue(15);
        vmTypes.getValues().add(c1XXLargeVm);
        
        vmType.setValueType(vmTypes);

        vmFeature.getAttributes().add(vmType);

        Attribute vmMemory = ProviderFactory.eINSTANCE.createAttribute();
        vmMemory.setName("vmMemory");

        Range vmMemoryRange = TypeFactory.eINSTANCE.createRange();

        vmMemoryRange.setPrimitiveType(TypeEnum.INT_TYPE);

        Limit minMemory = TypeFactory.eINSTANCE.createLimit();
        minMemory.setIncluded(true);
        IntValue minMemoryValue = TypeFactory.eINSTANCE.createIntValue();
        minMemoryValue.setValue(256);
        minMemory.setValue(minMemoryValue);

        Limit maxMemory = TypeFactory.eINSTANCE.createLimit();
        maxMemory.setIncluded(true);
        IntValue maxMemoryValue = TypeFactory.eINSTANCE.createIntValue();
        maxMemoryValue.setValue(32768);
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
        minStorageValue.setValue(0);
        minStorage.setValue(minStorageValue);

        Limit maxStorage = TypeFactory.eINSTANCE.createLimit();
        maxStorage.setIncluded(true);
        IntValue maxStorageValue = TypeFactory.eINSTANCE.createIntValue();
        maxStorageValue.setValue(160);
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
        maxCoresValue.setValue(16);
        maxCores.setValue(maxCoresValue);

        vmCoresRange.setLowerLimit(minCores);
        vmCoresRange.setUpperLimit(maxCores);

        vmCores.setValueType(vmCoresRange);

        vmFeature.getAttributes().add(vmCores);

        Attribute vmOS = ProviderFactory.eINSTANCE.createAttribute();
        vmOS.setName("vmOS");
        Enumeration vmOSTypes = TypeFactory.eINSTANCE.createEnumeration();

        EnumerateValue fedora20Server = TypeFactory.eINSTANCE.createEnumerateValue();
        fedora20Server.setName("Fedora 20 server x86_64");
        fedora20Server.setValue(0);
        vmOSTypes.getValues().add(fedora20Server);
        
        EnumerateValue ubuntu1404Server = TypeFactory.eINSTANCE.createEnumerateValue();
        ubuntu1404Server.setName("Ubuntu 14.04 LTS Server x86_64");
        ubuntu1404Server.setValue(1);
        vmOSTypes.getValues().add(ubuntu1404Server);
        
        EnumerateValue debian760Server = TypeFactory.eINSTANCE.createEnumerateValue();
        debian760Server.setName("Debian 7.6.0 Server x86_64");
        debian760Server.setValue(2);
        vmOSTypes.getValues().add(debian760Server);
        
        EnumerateValue scientificLinux65Server = TypeFactory.eINSTANCE.createEnumerateValue();
        scientificLinux65Server.setName("Scientific Linux 6.5 Server x86_64");
        scientificLinux65Server.setValue(3);
        vmOSTypes.getValues().add(scientificLinux65Server);
        
        EnumerateValue openSUSE131Server = TypeFactory.eINSTANCE.createEnumerateValue();
        openSUSE131Server.setName("openSUSE 13.1 Server x86_64");
        openSUSE131Server.setValue(4);
        vmOSTypes.getValues().add(openSUSE131Server);
        
        EnumerateValue centOS65Server = TypeFactory.eINSTANCE.createEnumerateValue();
        centOS65Server.setName("CentOS 6.5 Server x86_64");
        centOS65Server.setValue(5);
        vmOSTypes.getValues().add(centOS65Server);
        
        EnumerateValue ubuntu1310Desktop = TypeFactory.eINSTANCE.createEnumerateValue();
        ubuntu1310Desktop.setName("Ubuntu 13.10 Desktop Unity x86_64");
        ubuntu1310Desktop.setValue(6);
        vmOSTypes.getValues().add(ubuntu1310Desktop);
        
        EnumerateValue fedora20DesktopGnome = TypeFactory.eINSTANCE.createEnumerateValue();
        fedora20DesktopGnome.setName("Fedora 20 Desktop Gnome x86_64");
        fedora20DesktopGnome.setValue(7);
        vmOSTypes.getValues().add(fedora20DesktopGnome);
        
        EnumerateValue openSUSE131DesktopGnome = TypeFactory.eINSTANCE.createEnumerateValue();
        openSUSE131DesktopGnome.setName("openSUSE 13.1 Desktop Gnome x86_64");
        openSUSE131DesktopGnome.setValue(8);
        vmOSTypes.getValues().add(openSUSE131DesktopGnome);
        
        EnumerateValue fedora20DesktopKDE = TypeFactory.eINSTANCE.createEnumerateValue();
        fedora20DesktopKDE.setName("Fedora 20 Desktop KDE x86_64");
        fedora20DesktopKDE.setValue(9);
        vmOSTypes.getValues().add(fedora20DesktopKDE);
        
        EnumerateValue openSUSE131DesktopKDE = TypeFactory.eINSTANCE.createEnumerateValue();
        openSUSE131DesktopKDE.setName("openSUSE 13.1 Desktop KDE x86_64");
        openSUSE131DesktopKDE.setValue(10);
        vmOSTypes.getValues().add(openSUSE131DesktopKDE);

        vmOS.setValueType(vmOSTypes);

        vmFeature.getAttributes().add(vmOS);

        
        Implies m1MicroVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1MicroVmConstraint.setName("M1.MICRO_VM_Constraint_Mapping");
        m1MicroVmConstraint.setFrom(vmFeature);
        m1MicroVmConstraint.setTo(vmFeature);


        AttributeConstraint m1MicroVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1MicroVmMemoryConstraint.setFrom(vmType);
        StringValue m1MicroVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1MicroVmMemoryConstraintFrom.setValue("M1.MICRO");
        m1MicroVmMemoryConstraint.setFromValue(m1MicroVmMemoryConstraintFrom);

        m1MicroVmMemoryConstraint.setTo(vmMemory);
        IntValue m1MicroVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1MicroVmMemoryConstraintTo.setValue(256);
        m1MicroVmMemoryConstraint.setToValue(m1MicroVmMemoryConstraintTo);

        m1MicroVmConstraint.getAttributeConstraints().add(m1MicroVmMemoryConstraint);


        AttributeConstraint m1MicroVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1MicroVmCoresConstraint.setFrom(vmType);
        StringValue m1MicroVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1MicroVmCoresConstraintFrom.setValue("M1.MICRO");
        m1MicroVmCoresConstraint.setFromValue(m1MicroVmCoresConstraintFrom);

        m1MicroVmCoresConstraint.setTo(vmCores);
        IntValue m1MicroVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1MicroVmCoresConstraintTo.setValue(1);
        m1MicroVmCoresConstraint.setToValue(m1MicroVmCoresConstraintTo);

        m1MicroVmConstraint.getAttributeConstraints().add(m1MicroVmCoresConstraint);
        
        AttributeConstraint m1MicroVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1MicroVmStorageConstraint.setFrom(vmType);
        StringValue m1MicroVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1MicroVmStorageConstraintFrom.setValue("M1.MICRO");
        m1MicroVmStorageConstraint.setFromValue(m1MicroVmStorageConstraintFrom);

        m1MicroVmStorageConstraint.setTo(vmStorage);
        IntValue m1MicroVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1MicroVmStorageConstraintTo.setValue(0);
        m1MicroVmStorageConstraint.setToValue(m1MicroVmStorageConstraintTo);

        m1MicroVmConstraint.getAttributeConstraints().add(m1MicroVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1MicroVmConstraint);


        Implies m1TinyVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1TinyVmConstraint.setName("M1.TINY_VM_Constraint_Mapping");
        m1TinyVmConstraint.setFrom(vmFeature);
        m1TinyVmConstraint.setTo(vmFeature);


        AttributeConstraint m1TinyVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1TinyVmMemoryConstraint.setFrom(vmType);
        StringValue m1TinyVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1TinyVmMemoryConstraintFrom.setValue("M1.TINY");
        m1TinyVmMemoryConstraint.setFromValue(m1TinyVmMemoryConstraintFrom);

        m1TinyVmMemoryConstraint.setTo(vmMemory);
        IntValue m1TinyVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1TinyVmMemoryConstraintTo.setValue(512);
        m1TinyVmMemoryConstraint.setToValue(m1TinyVmMemoryConstraintTo);

        m1TinyVmConstraint.getAttributeConstraints().add(m1TinyVmMemoryConstraint);


        AttributeConstraint m1TinyVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1TinyVmCoresConstraint.setFrom(vmType);
        StringValue m1TinyVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1TinyVmCoresConstraintFrom.setValue("M1.TINY");
        m1TinyVmCoresConstraint.setFromValue(m1TinyVmCoresConstraintFrom);

        m1TinyVmCoresConstraint.setTo(vmCores);
        IntValue m1TinyVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1TinyVmCoresConstraintTo.setValue(1);
        m1TinyVmCoresConstraint.setToValue(m1TinyVmCoresConstraintTo);

        m1TinyVmConstraint.getAttributeConstraints().add(m1TinyVmCoresConstraint);
        
        AttributeConstraint m1TinyVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1TinyVmStorageConstraint.setFrom(vmType);
        StringValue m1TinyVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1TinyVmStorageConstraintFrom.setValue("M1.TINY");
        m1TinyVmStorageConstraint.setFromValue(m1TinyVmStorageConstraintFrom);

        m1TinyVmStorageConstraint.setTo(vmStorage);
        IntValue m1TinyVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1TinyVmStorageConstraintTo.setValue(0);
        m1TinyVmStorageConstraint.setToValue(m1TinyVmStorageConstraintTo);

        m1TinyVmConstraint.getAttributeConstraints().add(m1TinyVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1TinyVmConstraint);
        
        
        Implies m1SmallVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1SmallVmConstraint.setName("M1.SMALL_VM_Constraint_Mapping");
        m1SmallVmConstraint.setFrom(vmFeature);
        m1SmallVmConstraint.setTo(vmFeature);


        AttributeConstraint m1SmallVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1SmallVmMemoryConstraint.setFrom(vmType);
        StringValue m1SmallVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1SmallVmMemoryConstraintFrom.setValue("M1.SMALL");
        m1SmallVmMemoryConstraint.setFromValue(m1SmallVmMemoryConstraintFrom);

        m1SmallVmMemoryConstraint.setTo(vmMemory);
        IntValue m1SmallVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1SmallVmMemoryConstraintTo.setValue(2048);
        m1SmallVmMemoryConstraint.setToValue(m1SmallVmMemoryConstraintTo);

        m1SmallVmConstraint.getAttributeConstraints().add(m1SmallVmMemoryConstraint);


        AttributeConstraint m1SmallVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1SmallVmCoresConstraint.setFrom(vmType);
        StringValue m1SmallVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1SmallVmCoresConstraintFrom.setValue("M1.SMALL");
        m1SmallVmCoresConstraint.setFromValue(m1SmallVmCoresConstraintFrom);

        m1SmallVmCoresConstraint.setTo(vmCores);
        IntValue m1SmallVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1SmallVmCoresConstraintTo.setValue(1);
        m1SmallVmCoresConstraint.setToValue(m1SmallVmCoresConstraintTo);

        m1SmallVmConstraint.getAttributeConstraints().add(m1SmallVmCoresConstraint);
        
        AttributeConstraint m1SmallVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1SmallVmStorageConstraint.setFrom(vmType);
        StringValue m1SmallVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1SmallVmStorageConstraintFrom.setValue("M1.SMALL");
        m1SmallVmStorageConstraint.setFromValue(m1SmallVmStorageConstraintFrom);

        m1SmallVmStorageConstraint.setTo(vmStorage);
        IntValue m1SmallVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1SmallVmStorageConstraintTo.setValue(20);
        m1SmallVmStorageConstraint.setToValue(m1SmallVmStorageConstraintTo);

        m1SmallVmConstraint.getAttributeConstraints().add(m1SmallVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1SmallVmConstraint);
        
        
        Implies m1MediumVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1MediumVmConstraint.setName("M1.MEDIUM_VM_Constraint_Mapping");
        m1MediumVmConstraint.setFrom(vmFeature);
        m1MediumVmConstraint.setTo(vmFeature);


        AttributeConstraint m1MediumVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1MediumVmMemoryConstraint.setFrom(vmType);
        StringValue m1MediumVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1MediumVmMemoryConstraintFrom.setValue("M1.MEDIUM");
        m1MediumVmMemoryConstraint.setFromValue(m1MediumVmMemoryConstraintFrom);

        m1MediumVmMemoryConstraint.setTo(vmMemory);
        IntValue m1MediumVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1MediumVmMemoryConstraintTo.setValue(4096);
        m1MediumVmMemoryConstraint.setToValue(m1MediumVmMemoryConstraintTo);

        m1MediumVmConstraint.getAttributeConstraints().add(m1MediumVmMemoryConstraint);


        AttributeConstraint m1MediumVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1MediumVmCoresConstraint.setFrom(vmType);
        StringValue m1MediumVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1MediumVmCoresConstraintFrom.setValue("M1.MEDIUM");
        m1MediumVmCoresConstraint.setFromValue(m1MediumVmCoresConstraintFrom);

        m1MediumVmCoresConstraint.setTo(vmCores);
        IntValue m1MediumVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1MediumVmCoresConstraintTo.setValue(2);
        m1MediumVmCoresConstraint.setToValue(m1MediumVmCoresConstraintTo);

        m1MediumVmConstraint.getAttributeConstraints().add(m1MediumVmCoresConstraint);
        
        AttributeConstraint m1MediumVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1MediumVmStorageConstraint.setFrom(vmType);
        StringValue m1MediumVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1MediumVmStorageConstraintFrom.setValue("M1.MEDIUM");
        m1MediumVmStorageConstraint.setFromValue(m1MediumVmStorageConstraintFrom);

        m1MediumVmStorageConstraint.setTo(vmStorage);
        IntValue m1MediumVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1MediumVmStorageConstraintTo.setValue(40);
        m1MediumVmStorageConstraint.setToValue(m1MediumVmStorageConstraintTo);

        m1MediumVmConstraint.getAttributeConstraints().add(m1MediumVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1MediumVmConstraint);
        
        
        Implies m1LargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1LargeVmConstraint.setName("M1.LARGE_VM_Constraint_Mapping");
        m1LargeVmConstraint.setFrom(vmFeature);
        m1LargeVmConstraint.setTo(vmFeature);


        AttributeConstraint m1LargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1LargeVmMemoryConstraint.setFrom(vmType);
        StringValue m1LargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1LargeVmMemoryConstraintFrom.setValue("M1.LARGE");
        m1LargeVmMemoryConstraint.setFromValue(m1LargeVmMemoryConstraintFrom);

        m1LargeVmMemoryConstraint.setTo(vmMemory);
        IntValue m1LargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1LargeVmMemoryConstraintTo.setValue(8192);
        m1LargeVmMemoryConstraint.setToValue(m1LargeVmMemoryConstraintTo);

        m1LargeVmConstraint.getAttributeConstraints().add(m1LargeVmMemoryConstraint);


        AttributeConstraint m1LargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1LargeVmCoresConstraint.setFrom(vmType);
        StringValue m1LargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1LargeVmCoresConstraintFrom.setValue("M1.LARGE");
        m1LargeVmCoresConstraint.setFromValue(m1LargeVmCoresConstraintFrom);

        m1LargeVmCoresConstraint.setTo(vmCores);
        IntValue m1LargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1LargeVmCoresConstraintTo.setValue(4);
        m1LargeVmCoresConstraint.setToValue(m1LargeVmCoresConstraintTo);

        m1LargeVmConstraint.getAttributeConstraints().add(m1LargeVmCoresConstraint);
        
        AttributeConstraint m1LargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1LargeVmStorageConstraint.setFrom(vmType);
        StringValue m1LargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1LargeVmStorageConstraintFrom.setValue("M1.LARGE");
        m1LargeVmStorageConstraint.setFromValue(m1LargeVmStorageConstraintFrom);

        m1LargeVmStorageConstraint.setTo(vmStorage);
        IntValue m1LargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1LargeVmStorageConstraintTo.setValue(80);
        m1LargeVmStorageConstraint.setToValue(m1LargeVmStorageConstraintTo);

        m1LargeVmConstraint.getAttributeConstraints().add(m1LargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1LargeVmConstraint);
        
        
        Implies m1XLargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1XLargeVmConstraint.setName("M1.XLARGE_VM_Constraint_Mapping");
        m1XLargeVmConstraint.setFrom(vmFeature);
        m1XLargeVmConstraint.setTo(vmFeature);


        AttributeConstraint m1XLargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1XLargeVmMemoryConstraint.setFrom(vmType);
        StringValue m1XLargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1XLargeVmMemoryConstraintFrom.setValue("M1.XLARGE");
        m1XLargeVmMemoryConstraint.setFromValue(m1XLargeVmMemoryConstraintFrom);

        m1XLargeVmMemoryConstraint.setTo(vmMemory);
        IntValue m1XLargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1XLargeVmMemoryConstraintTo.setValue(16384);
        m1XLargeVmMemoryConstraint.setToValue(m1XLargeVmMemoryConstraintTo);

        m1XLargeVmConstraint.getAttributeConstraints().add(m1XLargeVmMemoryConstraint);


        AttributeConstraint m1XLargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1XLargeVmCoresConstraint.setFrom(vmType);
        StringValue m1XLargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1XLargeVmCoresConstraintFrom.setValue("M1.XLARGE");
        m1XLargeVmCoresConstraint.setFromValue(m1XLargeVmCoresConstraintFrom);

        m1XLargeVmCoresConstraint.setTo(vmCores);
        IntValue m1XLargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1XLargeVmCoresConstraintTo.setValue(8);
        m1XLargeVmCoresConstraint.setToValue(m1XLargeVmCoresConstraintTo);

        m1XLargeVmConstraint.getAttributeConstraints().add(m1XLargeVmCoresConstraint);
        
        AttributeConstraint m1XLargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1XLargeVmStorageConstraint.setFrom(vmType);
        StringValue m1XLargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1XLargeVmStorageConstraintFrom.setValue("M1.XLARGE");
        m1XLargeVmStorageConstraint.setFromValue(m1XLargeVmStorageConstraintFrom);

        m1XLargeVmStorageConstraint.setTo(vmStorage);
        IntValue m1XLargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1XLargeVmStorageConstraintTo.setValue(160);
        m1XLargeVmStorageConstraint.setToValue(m1XLargeVmStorageConstraintTo);

        m1XLargeVmConstraint.getAttributeConstraints().add(m1XLargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1XLargeVmConstraint);
        
        
        Implies m1XXLargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m1XXLargeVmConstraint.setName("M1.XXLARGE_VM_Constraint_Mapping");
        m1XXLargeVmConstraint.setFrom(vmFeature);
        m1XXLargeVmConstraint.setTo(vmFeature);


        AttributeConstraint m1XXLargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1XXLargeVmMemoryConstraint.setFrom(vmType);
        StringValue m1XXLargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1XXLargeVmMemoryConstraintFrom.setValue("M1.XXLARGE");
        m1XXLargeVmMemoryConstraint.setFromValue(m1XXLargeVmMemoryConstraintFrom);

        m1XXLargeVmMemoryConstraint.setTo(vmMemory);
        IntValue m1XXLargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1XXLargeVmMemoryConstraintTo.setValue(32768);
        m1XXLargeVmMemoryConstraint.setToValue(m1XXLargeVmMemoryConstraintTo);

        m1XXLargeVmConstraint.getAttributeConstraints().add(m1XXLargeVmMemoryConstraint);


        AttributeConstraint m1XXLargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1XXLargeVmCoresConstraint.setFrom(vmType);
        StringValue m1XXLargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1XXLargeVmCoresConstraintFrom.setValue("M1.XXLARGE");
        m1XXLargeVmCoresConstraint.setFromValue(m1XXLargeVmCoresConstraintFrom);

        m1XXLargeVmCoresConstraint.setTo(vmCores);
        IntValue m1XXLargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1XXLargeVmCoresConstraintTo.setValue(8);
        m1XXLargeVmCoresConstraint.setToValue(m1XXLargeVmCoresConstraintTo);

        m1XXLargeVmConstraint.getAttributeConstraints().add(m1XXLargeVmCoresConstraint);
        
        AttributeConstraint m1XXLargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m1XXLargeVmStorageConstraint.setFrom(vmType);
        StringValue m1XXLargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m1XXLargeVmStorageConstraintFrom.setValue("M1.XLARGE");
        m1XXLargeVmStorageConstraint.setFromValue(m1XXLargeVmStorageConstraintFrom);

        m1XXLargeVmStorageConstraint.setTo(vmStorage);
        IntValue m1XXLargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m1XXLargeVmStorageConstraintTo.setValue(160);
        m1XXLargeVmStorageConstraint.setToValue(m1XXLargeVmStorageConstraintTo);

        m1XXLargeVmConstraint.getAttributeConstraints().add(m1XXLargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m1XXLargeVmConstraint);
        
        
        Implies m2SmallVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m2SmallVmConstraint.setName("M2.SMALL_VM_Constraint_Mapping");
        m2SmallVmConstraint.setFrom(vmFeature);
        m2SmallVmConstraint.setTo(vmFeature);


        AttributeConstraint m2SmallVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2SmallVmMemoryConstraint.setFrom(vmType);
        StringValue m2SmallVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2SmallVmMemoryConstraintFrom.setValue("M2.SMALL");
        m2SmallVmMemoryConstraint.setFromValue(m2SmallVmMemoryConstraintFrom);

        m2SmallVmMemoryConstraint.setTo(vmMemory);
        IntValue m2SmallVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2SmallVmMemoryConstraintTo.setValue(4096);
        m2SmallVmMemoryConstraint.setToValue(m2SmallVmMemoryConstraintTo);

        m2SmallVmConstraint.getAttributeConstraints().add(m2SmallVmMemoryConstraint);


        AttributeConstraint m2SmallVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2SmallVmCoresConstraint.setFrom(vmType);
        StringValue m2SmallVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2SmallVmCoresConstraintFrom.setValue("M2.SMALL");
        m2SmallVmCoresConstraint.setFromValue(m2SmallVmCoresConstraintFrom);

        m2SmallVmCoresConstraint.setTo(vmCores);
        IntValue m2SmallVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2SmallVmCoresConstraintTo.setValue(1);
        m2SmallVmCoresConstraint.setToValue(m2SmallVmCoresConstraintTo);

        m2SmallVmConstraint.getAttributeConstraints().add(m2SmallVmCoresConstraint);
        
        AttributeConstraint m2SmallVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2SmallVmStorageConstraint.setFrom(vmType);
        StringValue m2SmallVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2SmallVmStorageConstraintFrom.setValue("M2.SMALL");
        m2SmallVmStorageConstraint.setFromValue(m2SmallVmStorageConstraintFrom);

        m2SmallVmStorageConstraint.setTo(vmStorage);
        IntValue m2SmallVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2SmallVmStorageConstraintTo.setValue(20);
        m2SmallVmStorageConstraint.setToValue(m2SmallVmStorageConstraintTo);

        m2SmallVmConstraint.getAttributeConstraints().add(m2SmallVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m2SmallVmConstraint);
        
        
        Implies m2MediumVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m2MediumVmConstraint.setName("M2.MEDIUM_VM_Constraint_Mapping");
        m2MediumVmConstraint.setFrom(vmFeature);
        m2MediumVmConstraint.setTo(vmFeature);


        AttributeConstraint m2MediumVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2MediumVmMemoryConstraint.setFrom(vmType);
        StringValue m2MediumVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2MediumVmMemoryConstraintFrom.setValue("M2.MEDIUM");
        m2MediumVmMemoryConstraint.setFromValue(m2MediumVmMemoryConstraintFrom);

        m2MediumVmMemoryConstraint.setTo(vmMemory);
        IntValue m2MediumVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2MediumVmMemoryConstraintTo.setValue(8192);
        m2MediumVmMemoryConstraint.setToValue(m2MediumVmMemoryConstraintTo);

        m2MediumVmConstraint.getAttributeConstraints().add(m2MediumVmMemoryConstraint);


        AttributeConstraint m2MediumVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2MediumVmCoresConstraint.setFrom(vmType);
        StringValue m2MediumVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2MediumVmCoresConstraintFrom.setValue("M2.MEDIUM");
        m2MediumVmCoresConstraint.setFromValue(m2MediumVmCoresConstraintFrom);

        m2MediumVmCoresConstraint.setTo(vmCores);
        IntValue m2MediumVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2MediumVmCoresConstraintTo.setValue(2);
        m2MediumVmCoresConstraint.setToValue(m2MediumVmCoresConstraintTo);

        m2MediumVmConstraint.getAttributeConstraints().add(m2MediumVmCoresConstraint);
        
        AttributeConstraint m2MediumVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2MediumVmStorageConstraint.setFrom(vmType);
        StringValue m2MediumVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2MediumVmStorageConstraintFrom.setValue("M2.MEDIUM");
        m2MediumVmStorageConstraint.setFromValue(m2MediumVmStorageConstraintFrom);

        m2MediumVmStorageConstraint.setTo(vmStorage);
        IntValue m2MediumVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2MediumVmStorageConstraintTo.setValue(40);
        m2MediumVmStorageConstraint.setToValue(m2MediumVmStorageConstraintTo);

        m2MediumVmConstraint.getAttributeConstraints().add(m2MediumVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m2MediumVmConstraint);

        
        Implies m2LargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m2LargeVmConstraint.setName("M2.LARGE_VM_Constraint_Mapping");
        m2LargeVmConstraint.setFrom(vmFeature);
        m2LargeVmConstraint.setTo(vmFeature);


        AttributeConstraint m2LargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2LargeVmMemoryConstraint.setFrom(vmType);
        StringValue m2LargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2LargeVmMemoryConstraintFrom.setValue("M2.LARGE");
        m2LargeVmMemoryConstraint.setFromValue(m2LargeVmMemoryConstraintFrom);

        m2LargeVmMemoryConstraint.setTo(vmMemory);
        IntValue m2LargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2LargeVmMemoryConstraintTo.setValue(16384);
        m2LargeVmMemoryConstraint.setToValue(m2LargeVmMemoryConstraintTo);

        m2LargeVmConstraint.getAttributeConstraints().add(m2LargeVmMemoryConstraint);


        AttributeConstraint m2LargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2LargeVmCoresConstraint.setFrom(vmType);
        StringValue m2LargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2LargeVmCoresConstraintFrom.setValue("M2.LARGE");
        m2LargeVmCoresConstraint.setFromValue(m2LargeVmCoresConstraintFrom);

        m2LargeVmCoresConstraint.setTo(vmCores);
        IntValue m2LargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2LargeVmCoresConstraintTo.setValue(4);
        m2LargeVmCoresConstraint.setToValue(m2LargeVmCoresConstraintTo);

        m2LargeVmConstraint.getAttributeConstraints().add(m2LargeVmCoresConstraint);
        
        AttributeConstraint m2LargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2LargeVmStorageConstraint.setFrom(vmType);
        StringValue m2LargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2LargeVmStorageConstraintFrom.setValue("M2.LARGE");
        m2LargeVmStorageConstraint.setFromValue(m2LargeVmStorageConstraintFrom);

        m2LargeVmStorageConstraint.setTo(vmStorage);
        IntValue m2LargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2LargeVmStorageConstraintTo.setValue(80);
        m2LargeVmStorageConstraint.setToValue(m2LargeVmStorageConstraintTo);

        m2LargeVmConstraint.getAttributeConstraints().add(m2LargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m2LargeVmConstraint);
        
        
        Implies m2XLargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        m2XLargeVmConstraint.setName("M2.XLARGE_VM_Constraint_Mapping");
        m2XLargeVmConstraint.setFrom(vmFeature);
        m2XLargeVmConstraint.setTo(vmFeature);


        AttributeConstraint m2XLargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2XLargeVmMemoryConstraint.setFrom(vmType);
        StringValue m2XLargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2XLargeVmMemoryConstraintFrom.setValue("M2.XLARGE");
        m2XLargeVmMemoryConstraint.setFromValue(m2XLargeVmMemoryConstraintFrom);

        m2XLargeVmMemoryConstraint.setTo(vmMemory);
        IntValue m2XLargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2XLargeVmMemoryConstraintTo.setValue(32768);
        m2XLargeVmMemoryConstraint.setToValue(m2XLargeVmMemoryConstraintTo);

        m2XLargeVmConstraint.getAttributeConstraints().add(m2XLargeVmMemoryConstraint);


        AttributeConstraint m2XLargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2XLargeVmCoresConstraint.setFrom(vmType);
        StringValue m2XLargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2XLargeVmCoresConstraintFrom.setValue("M2.XLARGE");
        m2XLargeVmCoresConstraint.setFromValue(m2XLargeVmCoresConstraintFrom);

        m2XLargeVmCoresConstraint.setTo(vmCores);
        IntValue m2XLargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2XLargeVmCoresConstraintTo.setValue(4);
        m2XLargeVmCoresConstraint.setToValue(m2XLargeVmCoresConstraintTo);

        m2XLargeVmConstraint.getAttributeConstraints().add(m2XLargeVmCoresConstraint);
        
        AttributeConstraint m2XLargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        m2XLargeVmStorageConstraint.setFrom(vmType);
        StringValue m2XLargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        m2XLargeVmStorageConstraintFrom.setValue("M2.XLARGE");
        m2XLargeVmStorageConstraint.setFromValue(m2XLargeVmStorageConstraintFrom);

        m2XLargeVmStorageConstraint.setTo(vmStorage);
        IntValue m2XLargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        m2XLargeVmStorageConstraintTo.setValue(160);
        m2XLargeVmStorageConstraint.setToValue(m2XLargeVmStorageConstraintTo);

        m2XLargeVmConstraint.getAttributeConstraints().add(m2XLargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(m2XLargeVmConstraint);
        
        
        Implies c1SmallVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        c1SmallVmConstraint.setName("C1.SMALL_VM_Constraint_Mapping");
        c1SmallVmConstraint.setFrom(vmFeature);
        c1SmallVmConstraint.setTo(vmFeature);


        AttributeConstraint c1SmallVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1SmallVmMemoryConstraint.setFrom(vmType);
        StringValue c1SmallVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1SmallVmMemoryConstraintFrom.setValue("C1.SMALL");
        c1SmallVmMemoryConstraint.setFromValue(c1SmallVmMemoryConstraintFrom);

        c1SmallVmMemoryConstraint.setTo(vmMemory);
        IntValue c1SmallVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1SmallVmMemoryConstraintTo.setValue(2048);
        c1SmallVmMemoryConstraint.setToValue(c1SmallVmMemoryConstraintTo);

        c1SmallVmConstraint.getAttributeConstraints().add(c1SmallVmMemoryConstraint);


        AttributeConstraint c1SmallVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1SmallVmCoresConstraint.setFrom(vmType);
        StringValue c1SmallVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1SmallVmCoresConstraintFrom.setValue("C1.SMALL");
        c1SmallVmCoresConstraint.setFromValue(c1SmallVmCoresConstraintFrom);

        c1SmallVmCoresConstraint.setTo(vmCores);
        IntValue c1SmallVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1SmallVmCoresConstraintTo.setValue(2);
        c1SmallVmCoresConstraint.setToValue(c1SmallVmCoresConstraintTo);

        c1SmallVmConstraint.getAttributeConstraints().add(c1SmallVmCoresConstraint);
        
        AttributeConstraint c1SmallVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1SmallVmStorageConstraint.setFrom(vmType);
        StringValue c1SmallVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1SmallVmStorageConstraintFrom.setValue("C1.SMALL");
        c1SmallVmStorageConstraint.setFromValue(c1SmallVmStorageConstraintFrom);

        c1SmallVmStorageConstraint.setTo(vmStorage);
        IntValue c1SmallVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1SmallVmStorageConstraintTo.setValue(20);
        c1SmallVmStorageConstraint.setToValue(c1SmallVmStorageConstraintTo);

        c1SmallVmConstraint.getAttributeConstraints().add(c1SmallVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(c1SmallVmConstraint);
        
        
        Implies c1MediumVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        c1MediumVmConstraint.setName("C1.MEDIUM_VM_Constraint_Mapping");
        c1MediumVmConstraint.setFrom(vmFeature);
        c1MediumVmConstraint.setTo(vmFeature);


        AttributeConstraint c1MediumVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1MediumVmMemoryConstraint.setFrom(vmType);
        StringValue c1MediumVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1MediumVmMemoryConstraintFrom.setValue("C1.MEDIUM");
        c1MediumVmMemoryConstraint.setFromValue(c1MediumVmMemoryConstraintFrom);

        c1MediumVmMemoryConstraint.setTo(vmMemory);
        IntValue c1MediumVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1MediumVmMemoryConstraintTo.setValue(4096);
        c1MediumVmMemoryConstraint.setToValue(c1MediumVmMemoryConstraintTo);

        c1MediumVmConstraint.getAttributeConstraints().add(c1MediumVmMemoryConstraint);


        AttributeConstraint c1MediumVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1MediumVmCoresConstraint.setFrom(vmType);
        StringValue c1MediumVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1MediumVmCoresConstraintFrom.setValue("C1.MEDIUM");
        c1MediumVmCoresConstraint.setFromValue(c1MediumVmCoresConstraintFrom);

        c1MediumVmCoresConstraint.setTo(vmCores);
        IntValue c1MediumVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1MediumVmCoresConstraintTo.setValue(4);
        c1MediumVmCoresConstraint.setToValue(c1MediumVmCoresConstraintTo);

        c1MediumVmConstraint.getAttributeConstraints().add(c1MediumVmCoresConstraint);
        
        AttributeConstraint c1MediumVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1MediumVmStorageConstraint.setFrom(vmType);
        StringValue c1MediumVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1MediumVmStorageConstraintFrom.setValue("C1.MEDIUM");
        c1MediumVmStorageConstraint.setFromValue(c1MediumVmStorageConstraintFrom);

        c1MediumVmStorageConstraint.setTo(vmStorage);
        IntValue c1MediumVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1MediumVmStorageConstraintTo.setValue(40);
        c1MediumVmStorageConstraint.setToValue(c1MediumVmStorageConstraintTo);

        c1MediumVmConstraint.getAttributeConstraints().add(c1MediumVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(c1MediumVmConstraint);
        
        
        Implies c1LargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        c1LargeVmConstraint.setName("C1.LARGE_VM_Constraint_Mapping");
        c1LargeVmConstraint.setFrom(vmFeature);
        c1LargeVmConstraint.setTo(vmFeature);


        AttributeConstraint c1LargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1LargeVmMemoryConstraint.setFrom(vmType);
        StringValue c1LargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1LargeVmMemoryConstraintFrom.setValue("C1.LARGE");
        c1LargeVmMemoryConstraint.setFromValue(c1LargeVmMemoryConstraintFrom);

        c1LargeVmMemoryConstraint.setTo(vmMemory);
        IntValue c1LargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1LargeVmMemoryConstraintTo.setValue(8192);
        c1LargeVmMemoryConstraint.setToValue(c1LargeVmMemoryConstraintTo);

        c1LargeVmConstraint.getAttributeConstraints().add(c1LargeVmMemoryConstraint);


        AttributeConstraint c1LargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1LargeVmCoresConstraint.setFrom(vmType);
        StringValue c1LargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1LargeVmCoresConstraintFrom.setValue("C1.LARGE");
        c1LargeVmCoresConstraint.setFromValue(c1LargeVmCoresConstraintFrom);

        c1LargeVmCoresConstraint.setTo(vmCores);
        IntValue c1LargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1LargeVmCoresConstraintTo.setValue(8);
        c1LargeVmCoresConstraint.setToValue(c1LargeVmCoresConstraintTo);

        c1LargeVmConstraint.getAttributeConstraints().add(c1LargeVmCoresConstraint);
        
        AttributeConstraint c1LargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1LargeVmStorageConstraint.setFrom(vmType);
        StringValue c1LargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1LargeVmStorageConstraintFrom.setValue("C1.LARGE");
        c1LargeVmStorageConstraint.setFromValue(c1LargeVmStorageConstraintFrom);

        c1LargeVmStorageConstraint.setTo(vmStorage);
        IntValue c1LargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1LargeVmStorageConstraintTo.setValue(80);
        c1LargeVmStorageConstraint.setToValue(c1LargeVmStorageConstraintTo);

        c1LargeVmConstraint.getAttributeConstraints().add(c1LargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(c1LargeVmConstraint);
        
        
        Implies c1XLargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        c1XLargeVmConstraint.setName("C1.XLARGE_VM_Constraint_Mapping");
        c1XLargeVmConstraint.setFrom(vmFeature);
        c1XLargeVmConstraint.setTo(vmFeature);


        AttributeConstraint c1XLargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1XLargeVmMemoryConstraint.setFrom(vmType);
        StringValue c1XLargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1XLargeVmMemoryConstraintFrom.setValue("C1.XLARGE");
        c1XLargeVmMemoryConstraint.setFromValue(c1XLargeVmMemoryConstraintFrom);

        c1XLargeVmMemoryConstraint.setTo(vmMemory);
        IntValue c1XLargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1XLargeVmMemoryConstraintTo.setValue(16384);
        c1XLargeVmMemoryConstraint.setToValue(c1XLargeVmMemoryConstraintTo);

        c1XLargeVmConstraint.getAttributeConstraints().add(c1XLargeVmMemoryConstraint);


        AttributeConstraint c1XLargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1XLargeVmCoresConstraint.setFrom(vmType);
        StringValue c1XLargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1XLargeVmCoresConstraintFrom.setValue("C1.XLARGE");
        c1XLargeVmCoresConstraint.setFromValue(c1XLargeVmCoresConstraintFrom);

        c1XLargeVmCoresConstraint.setTo(vmCores);
        IntValue c1XLargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1XLargeVmCoresConstraintTo.setValue(16);
        c1XLargeVmCoresConstraint.setToValue(c1XLargeVmCoresConstraintTo);

        c1XLargeVmConstraint.getAttributeConstraints().add(c1XLargeVmCoresConstraint);
        
        AttributeConstraint c1XLargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1XLargeVmStorageConstraint.setFrom(vmType);
        StringValue c1XLargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1XLargeVmStorageConstraintFrom.setValue("C1.XLARGE");
        c1XLargeVmStorageConstraint.setFromValue(c1XLargeVmStorageConstraintFrom);

        c1XLargeVmStorageConstraint.setTo(vmStorage);
        IntValue c1XLargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1XLargeVmStorageConstraintTo.setValue(160);
        c1XLargeVmStorageConstraint.setToValue(c1XLargeVmStorageConstraintTo);

        c1XLargeVmConstraint.getAttributeConstraints().add(c1XLargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(c1XLargeVmConstraint);
        
        
        Implies c1XXLargeVmConstraint = ProviderFactory.eINSTANCE.createImplies();
        c1XXLargeVmConstraint.setName("C1.XXLARGE_VM_Constraint_Mapping");
        c1XXLargeVmConstraint.setFrom(vmFeature);
        c1XXLargeVmConstraint.setTo(vmFeature);


        AttributeConstraint c1XXLargeVmMemoryConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1XXLargeVmMemoryConstraint.setFrom(vmType);
        StringValue c1XXLargeVmMemoryConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1XXLargeVmMemoryConstraintFrom.setValue("C1.XXLARGE");
        c1XXLargeVmMemoryConstraint.setFromValue(c1XXLargeVmMemoryConstraintFrom);

        c1XXLargeVmMemoryConstraint.setTo(vmMemory);
        IntValue c1XXLargeVmMemoryConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1XXLargeVmMemoryConstraintTo.setValue(32768);
        c1XXLargeVmMemoryConstraint.setToValue(c1XXLargeVmMemoryConstraintTo);

        c1XXLargeVmConstraint.getAttributeConstraints().add(c1XXLargeVmMemoryConstraint);


        AttributeConstraint c1XXLargeVmCoresConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1XXLargeVmCoresConstraint.setFrom(vmType);
        StringValue c1XXLargeVmCoresConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1XXLargeVmCoresConstraintFrom.setValue("C1.XXLARGE");
        c1XXLargeVmCoresConstraint.setFromValue(c1XXLargeVmCoresConstraintFrom);

        c1XXLargeVmCoresConstraint.setTo(vmCores);
        IntValue c1XXLargeVmCoresConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1XXLargeVmCoresConstraintTo.setValue(16);
        c1XXLargeVmCoresConstraint.setToValue(c1XXLargeVmCoresConstraintTo);

        c1XXLargeVmConstraint.getAttributeConstraints().add(c1XXLargeVmCoresConstraint);
        
        AttributeConstraint c1XXLargeVmStorageConstraint = ProviderFactory.eINSTANCE.createAttributeConstraint();
        c1XXLargeVmStorageConstraint.setFrom(vmType);
        StringValue c1XXLargeVmStorageConstraintFrom = TypeFactory.eINSTANCE.createStringValue();
        c1XXLargeVmStorageConstraintFrom.setValue("C1.XXLARGE");
        c1XXLargeVmStorageConstraint.setFromValue(c1XXLargeVmStorageConstraintFrom);

        c1XXLargeVmStorageConstraint.setTo(vmStorage);
        IntValue c1XXLargeVmStorageConstraintTo = TypeFactory.eINSTANCE.createIntValue();
        c1XXLargeVmStorageConstraintTo.setValue(160);
        c1XXLargeVmStorageConstraint.setToValue(c1XXLargeVmStorageConstraintTo);

        c1XXLargeVmConstraint.getAttributeConstraints().add(c1XXLargeVmStorageConstraint);


        gwdgProviderModel.getConstraints().add(c1XXLargeVmConstraint);
        
        // TODO change this
        return gwdgProviderModel;

    }

}
