package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.*;
import eu.paasage.camel.deployment.*;
import eu.paasage.camel.organisation.CloudProvider;
import eu.paasage.camel.organisation.Location;
import eu.paasage.camel.provider.Attribute;
import eu.paasage.camel.provider.Constraint;
import eu.paasage.camel.provider.Feature;
import eu.paasage.camel.provider.ProviderFactory;
import eu.paasage.camel.type.StringValue;
import eu.paasage.camel.type.TypeFactory;
import org.javatuples.*;
import java.util.Date;

/** @author orzech
 * 	This class creates deployment model there is one function at the bottom that
 * 	actually returns the model, and a number of helper functions
 */

public class ScalarmDepolymentModel {

	/*
	 * this function creates and returns all objects that are required for
	 * deployment of ExperimentManager
	 */
	static Decade<InternalComponent, ProvidedCommunication, RequiredCommunication, RequiredCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance> defineExperimentManagerType() {

		/*
		 * First we define types we start with Component definition
		 */
		InternalComponent experimentManagerIc = DeploymentFactory.eINSTANCE
				.createInternalComponent();
		experimentManagerIc.setName("ExperimentManager");

		ComputationalResource experimentManagerCompResource = DeploymentFactory.eINSTANCE
				.createComputationalResource();
		experimentManagerCompResource
				.setDownloadCommand("wget <things that will download ExperimentManager>");
		// Alesandor suggested to comment this line
		// experimentManagerCompResource.setExecuteLocally(false);
		experimentManagerCompResource
				.setInstallCommand("<the command that will install ExperimentManager>");
		experimentManagerCompResource.setName("ExperimentManager");
		// Alesandor suggested to comment this line
		// experimentManagerCompResource.setRequireCredentials(false);
		experimentManagerIc.getResources().add(experimentManagerCompResource);

		/*
		 * Communications definitions
		 */
		ProvidedCommunication experimentManagerProvidedCommunication = DeploymentFactory.eINSTANCE
				.createProvidedCommunication();
		experimentManagerProvidedCommunication.setOwner(experimentManagerIc);
		// isLocal true will force to deploy in sigle VM
		experimentManagerProvidedCommunication.setIsLocal(false);
		experimentManagerProvidedCommunication.setName("ExperimentManager");
		experimentManagerProvidedCommunication.setPortNumber(443);
		experimentManagerIc.getProvidedCommunications().add(
				experimentManagerProvidedCommunication);

		RequiredCommunication experimentManagerReqStorageCommunication = DeploymentFactory.eINSTANCE
				.createRequiredCommunication();
		experimentManagerReqStorageCommunication.setOwner(experimentManagerIc);
		experimentManagerReqStorageCommunication.setIsLocal(false);
		experimentManagerReqStorageCommunication.setIsMandatory(true);
		experimentManagerReqStorageCommunication
				.setName("ExperimentManager_consumes_SotrageManager");
		experimentManagerReqStorageCommunication.setPortNumber(20001);
		experimentManagerIc.getRequiredCommunications().add(
				experimentManagerReqStorageCommunication);

		RequiredCommunication experimentManagerReqInfoCommunication = DeploymentFactory.eINSTANCE
				.createRequiredCommunication();
		experimentManagerReqInfoCommunication.setOwner(experimentManagerIc);
		experimentManagerReqInfoCommunication.setIsLocal(false);
		experimentManagerReqInfoCommunication.setIsMandatory(true);
		experimentManagerReqInfoCommunication
				.setName("ExperimentManager_consumes_Information Service");
		experimentManagerReqInfoCommunication.setPortNumber(11300);
		experimentManagerIc.getRequiredCommunications().add(
				experimentManagerReqInfoCommunication);

		/*
		 * Now we can define instances we start with component instance
		 */
		InternalComponentInstance experimentManagerInstance = DeploymentFactory.eINSTANCE
				.createInternalComponentInstance();
		experimentManagerInstance.setName("experimentManagerInstance");
		experimentManagerInstance.setType(experimentManagerIc);

		/*
		 * and proceed with communication instances
		 */
		ProvidedCommunicationInstance experimentManagerProvidedCommunicationInstance = DeploymentFactory.eINSTANCE
				.createProvidedCommunicationInstance();
		experimentManagerProvidedCommunicationInstance
				.setOwner(experimentManagerInstance);
		experimentManagerProvidedCommunicationInstance
				.setName("experimentManagerProvidedCommunicationInstance");
		experimentManagerProvidedCommunicationInstance
				.setType(experimentManagerProvidedCommunication);
		experimentManagerInstance.getProvidedCommunicationInstances().add(
				experimentManagerProvidedCommunicationInstance);

		RequiredCommunicationInstance experimentManagerReqStorageCommunicationInstance = DeploymentFactory.eINSTANCE
				.createRequiredCommunicationInstance();
		experimentManagerReqStorageCommunicationInstance
				.setOwner(experimentManagerInstance);
		experimentManagerReqStorageCommunicationInstance
				.setName("experimentManagerReqStorageCommunicationInstance");
		experimentManagerReqStorageCommunicationInstance
				.setType(experimentManagerReqStorageCommunication);
		experimentManagerInstance.getRequiredCommunicationInstances().add(
				experimentManagerReqStorageCommunicationInstance);

		RequiredCommunicationInstance experimentManagerReqInfoCommunicationInstance = DeploymentFactory.eINSTANCE
				.createRequiredCommunicationInstance();
		experimentManagerReqInfoCommunicationInstance
				.setOwner(experimentManagerInstance);
		experimentManagerReqInfoCommunicationInstance
				.setName("experimentManagerReqInfoCommunicationInstance");
		experimentManagerReqInfoCommunicationInstance
				.setType(experimentManagerReqInfoCommunication);
		experimentManagerInstance.getRequiredCommunicationInstances().add(
				experimentManagerReqInfoCommunicationInstance);

		/*
		 * Lastly we define hosts
		 */
		RequiredHost experimentManagerRequiredHost = DeploymentFactory.eINSTANCE
				.createRequiredHost();
		experimentManagerRequiredHost.setOwner(experimentManagerIc);
		experimentManagerRequiredHost.setName("experimentManagerRequiredHost");
		experimentManagerIc.setRequiredHost(experimentManagerRequiredHost);

		RequiredHostInstance experimentManagerRequiredHostInstance = DeploymentFactory.eINSTANCE
				.createRequiredHostInstance();
		experimentManagerRequiredHostInstance
				.setOwner(experimentManagerInstance);
		experimentManagerRequiredHostInstance
				.setName("experimentManagerRequiredHostInstance");
		experimentManagerRequiredHostInstance
				.setType(experimentManagerRequiredHost);
		experimentManagerInstance
				.setRequiredHostInstance(experimentManagerRequiredHostInstance);

		return new Decade<InternalComponent, ProvidedCommunication, RequiredCommunication, RequiredCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance>(
				experimentManagerIc, experimentManagerProvidedCommunication,
				experimentManagerReqStorageCommunication,
				experimentManagerReqInfoCommunication,
				experimentManagerInstance,
				experimentManagerProvidedCommunicationInstance,
				experimentManagerReqInfoCommunicationInstance,
				experimentManagerReqStorageCommunicationInstance,
				experimentManagerRequiredHost,
				experimentManagerRequiredHostInstance);
	}

	/*
	 * this function creates and returns all objects that are required for
	 * deployment of StorageManager
	 */
	static Octet<InternalComponent, ProvidedCommunication, RequiredCommunication, 
	InternalComponentInstance, ProvidedCommunicationInstance, RequiredCommunicationInstance, 
	RequiredHost, RequiredHostInstance> defineStorageManagerType() {

		/*
		 * First we define types we start with Component definition
		 */
		InternalComponent storageManagerIc = DeploymentFactory.eINSTANCE
				.createInternalComponent();
		storageManagerIc.setName("StorageManager");

		ComputationalResource storageManagerResource = DeploymentFactory.eINSTANCE
				.createComputationalResource();
		storageManagerResource
				.setDownloadCommand("wget <things that will download StorageManager>");
		storageManagerResource.setExecuteLocally(false);
		storageManagerResource
				.setInstallCommand("<the command that will install StorageManager>");
		storageManagerResource.setName("StorageManager");
		storageManagerResource.setRequireCredentials(false);
		storageManagerIc.getResources().add(storageManagerResource);

		/*
		 * Not sure yet we need those ports
		 * 
		 * ProvidedCommunication storageManagerProvidedCommunicationMongos =
		 * DeploymentFactory.eINSTANCE.createProvidedCommunication();
		 * storageManagerProvidedCommunicationMongos.setOwner(storageManagerIc);
		 * storageManagerProvidedCommunicationMongos.setIsLocal(false);
		 * storageManagerProvidedCommunicationMongos
		 * .setName("StorageManager_mongos");
		 * storageManagerProvidedCommunicationMongos.setPortNumber(27017);
		 * 
		 * storageManagerIc.getProvidedCommunications().add(
		 * storageManagerProvidedCommunicationMongos);
		 * 
		 * ProvidedCommunication storageManagerProvidedCommunicationMongodShard
		 * = DeploymentFactory.eINSTANCE.createProvidedCommunication();
		 * storageManagerProvidedCommunicationMongodShard
		 * .setOwner(storageManagerIc);
		 * storageManagerProvidedCommunicationMongodShard.setIsLocal(false);
		 * storageManagerProvidedCommunicationMongodShard
		 * .setName("StorageManager_mongod_shard");
		 * storageManagerProvidedCommunicationMongodShard.setPortNumber(30000);
		 * 
		 * storageManagerIc.getProvidedCommunications().add(
		 * storageManagerProvidedCommunicationMongodShard);
		 * 
		 * ProvidedCommunication storageManagerProvidedCommunicationMongodConfig
		 * = DeploymentFactory.eINSTANCE.createProvidedCommunication();
		 * storageManagerProvidedCommunicationMongodConfig
		 * .setOwner(storageManagerIc);
		 * storageManagerProvidedCommunicationMongodConfig.setIsLocal(false);
		 * storageManagerProvidedCommunicationMongodConfig
		 * .setName("StorageManager_mongod_shard");
		 * storageManagerProvidedCommunicationMongodConfig.setPortNumber(28000);
		 * 
		 * storageManagerIc.getProvidedCommunications().add(
		 * storageManagerProvidedCommunicationMongodConfig);
		 */

		/*
		 * Communications definitions
		 */
		ProvidedCommunication storageManagerProvidedCommunicationMongodNnginx = DeploymentFactory.eINSTANCE
				.createProvidedCommunication();
		storageManagerProvidedCommunicationMongodNnginx
				.setOwner(storageManagerIc);
		storageManagerProvidedCommunicationMongodNnginx.setIsLocal(false);
		storageManagerProvidedCommunicationMongodNnginx
				.setName("StorageManager_nginx");
		storageManagerProvidedCommunicationMongodNnginx.setPortNumber(20001);
		storageManagerIc.getProvidedCommunications().add(
				storageManagerProvidedCommunicationMongodNnginx);

		RequiredCommunication storgeManagerReqInfoCommunication = DeploymentFactory.eINSTANCE
				.createRequiredCommunication();
		storgeManagerReqInfoCommunication.setOwner(storageManagerIc);
		storgeManagerReqInfoCommunication.setIsLocal(false);
		storgeManagerReqInfoCommunication.setIsMandatory(true);
		storgeManagerReqInfoCommunication
				.setName("SotrageManager_consumes_Information Service");
		storgeManagerReqInfoCommunication.setPortNumber(11300);
		storageManagerIc.getRequiredCommunications().add(
				storgeManagerReqInfoCommunication);

		/*
		 * Now we can define instances we start with component instance
		 */
		InternalComponentInstance storageManagerInstance = DeploymentFactory.eINSTANCE
				.createInternalComponentInstance();
		storageManagerInstance.setName("storageManagerInstance");
		storageManagerInstance.setType(storageManagerIc);

		/*
		 * and proceed with communication instances
		 */
		ProvidedCommunicationInstance storageManagerProvidedCommunicationMongodNnginxInstance = DeploymentFactory.eINSTANCE
				.createProvidedCommunicationInstance();
		storageManagerProvidedCommunicationMongodNnginxInstance
				.setOwner(storageManagerInstance);
		storageManagerProvidedCommunicationMongodNnginxInstance
				.setName("storageManagerProvidedCommunicationMongodNnginxInstance");
		storageManagerProvidedCommunicationMongodNnginxInstance
				.setType(storageManagerProvidedCommunicationMongodNnginx);
		storageManagerInstance.getProvidedCommunicationInstances().add(
				storageManagerProvidedCommunicationMongodNnginxInstance);

		RequiredCommunicationInstance storgeManagerReqInfoCommunicationInstance = DeploymentFactory.eINSTANCE
				.createRequiredCommunicationInstance();
		storgeManagerReqInfoCommunicationInstance
				.setOwner(storageManagerInstance);
		storgeManagerReqInfoCommunicationInstance
				.setName("storgeManagerReqInfoCommunicationInstance");
		storgeManagerReqInfoCommunicationInstance
				.setType(storgeManagerReqInfoCommunication);
		storageManagerInstance.getRequiredCommunicationInstances().add(
				storgeManagerReqInfoCommunicationInstance);

		/*
		 * Lastly we define hosts
		 */
		RequiredHost storgeManagerRequiredHost = DeploymentFactory.eINSTANCE
				.createRequiredHost();
		storgeManagerRequiredHost.setOwner(storageManagerIc);
		storgeManagerRequiredHost.setName("storgeManagerRequiredHost");
		storageManagerIc.setRequiredHost(storgeManagerRequiredHost);

		RequiredHostInstance storgeManagerRequiredHostInstance = DeploymentFactory.eINSTANCE
				.createRequiredHostInstance();
		storgeManagerRequiredHostInstance.setOwner(storageManagerInstance);
		storgeManagerRequiredHostInstance
				.setName("storgeManagerRequiredHostInstance");
		storgeManagerRequiredHostInstance.setType(storgeManagerRequiredHost);
		storageManagerInstance
				.setRequiredHostInstance(storgeManagerRequiredHostInstance);

		return new Octet<InternalComponent, ProvidedCommunication, RequiredCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance>(
				storageManagerIc,
				storageManagerProvidedCommunicationMongodNnginx,
				storgeManagerReqInfoCommunication, storageManagerInstance,
				storageManagerProvidedCommunicationMongodNnginxInstance,
				storgeManagerReqInfoCommunicationInstance,
				storgeManagerRequiredHost, storgeManagerRequiredHostInstance);
	}

	/*
	 * this function creates and returns all objects that are required for
	 * deployment of InfomrationService
	 */
	static Sextet<InternalComponent, ProvidedCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredHost, RequiredHostInstance> defineInformationServiceType() {

		/*
		 * First we define types we start with Component definition
		 */
		InternalComponent informationManagerIc = DeploymentFactory.eINSTANCE
				.createInternalComponent();
		informationManagerIc.setName("InfomrationService");

		ComputationalResource informationManagerResource = DeploymentFactory.eINSTANCE
				.createComputationalResource();
		informationManagerResource
				.setDownloadCommand("wget <things that will download InfomrationManager>");
		informationManagerResource.setExecuteLocally(false);
		informationManagerResource
				.setInstallCommand("<the command that will install InfomrationManager>");
		informationManagerResource.setName("InfomrationService");
		informationManagerResource.setRequireCredentials(false);
		informationManagerIc.getResources().add(informationManagerResource);

		/*
		 * Communications definitions
		 */
		ProvidedCommunication informationManagerProvidedCommunication = DeploymentFactory.eINSTANCE
				.createProvidedCommunication();
		informationManagerProvidedCommunication.setOwner(informationManagerIc);
		informationManagerProvidedCommunication.setIsLocal(false);
		informationManagerProvidedCommunication.setName("InfomrationService");
		informationManagerProvidedCommunication.setPortNumber(11300);
		informationManagerIc.getProvidedCommunications().add(
				informationManagerProvidedCommunication);

		/*
		 * Now we can define instances we start with component instance
		 */
		InternalComponentInstance informationManagerInstance = DeploymentFactory.eINSTANCE
				.createInternalComponentInstance();
		informationManagerInstance.setName("informationManagerInstance");
		informationManagerInstance.setType(informationManagerIc);

		/*
		 * and proceed with communication instances
		 */
		ProvidedCommunicationInstance informationManagerProvidedCommunicationInstance = DeploymentFactory.eINSTANCE
				.createProvidedCommunicationInstance();
		informationManagerProvidedCommunicationInstance
				.setOwner(informationManagerInstance);
		informationManagerProvidedCommunicationInstance
				.setName("informationManagerProvidedCommunicationInstance");
		informationManagerProvidedCommunicationInstance
				.setType(informationManagerProvidedCommunication);
		informationManagerInstance.getProvidedCommunicationInstances().add(
				informationManagerProvidedCommunicationInstance);

		/*
		 * Lastly we define hosts
		 */
		RequiredHost informationManagerRequiredHost = DeploymentFactory.eINSTANCE
				.createRequiredHost();
		informationManagerRequiredHost.setOwner(informationManagerIc);
		informationManagerRequiredHost
				.setName("informationManagerRequiredHost");
		informationManagerIc.setRequiredHost(informationManagerRequiredHost);

		RequiredHostInstance informationManagerRequiredHostInstance = DeploymentFactory.eINSTANCE
				.createRequiredHostInstance();
		informationManagerRequiredHostInstance
				.setOwner(informationManagerInstance);
		informationManagerRequiredHostInstance
				.setName("informationManagerRequiredHostInstance");
		informationManagerRequiredHostInstance
				.setType(informationManagerRequiredHost);
		informationManagerInstance
				.setRequiredHostInstance(informationManagerRequiredHostInstance);

		return new Sextet<InternalComponent, ProvidedCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredHost, RequiredHostInstance>(
				informationManagerIc, informationManagerProvidedCommunication,
				informationManagerInstance,
				informationManagerProvidedCommunicationInstance,
				informationManagerRequiredHost,
				informationManagerRequiredHostInstance);
	}

	/*
	 * this function creates and returns all objects that are required for
	 * deployment of SimulationManager
	 */
	static Decade<InternalComponent, RequiredCommunication, RequiredCommunication, RequiredCommunication, InternalComponentInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance> defineSimulationManagerType() {

		/*
		 * First we define types we start with Component definition
		 */
		InternalComponent simulationManagerIc = DeploymentFactory.eINSTANCE
				.createInternalComponent();
		simulationManagerIc.setName("SimulationManager");

		ComputationalResource simulationManagerResource = DeploymentFactory.eINSTANCE
				.createComputationalResource();
		simulationManagerResource
				.setDownloadCommand("wget -P <things that will download SimulationManager>");
		simulationManagerResource.setExecuteLocally(false);
		simulationManagerResource
				.setInstallCommand("<the command that will install SimulationManager>");
		simulationManagerResource.setName("SimulationManager");
		simulationManagerResource.setRequireCredentials(false);
		simulationManagerResource.setStopCommand("<command to stop service>");
		simulationManagerIc.getResources().add(simulationManagerResource);

		/*
		 * Communications definitions
		 */
		RequiredCommunication similationManagerReqInfoCommunication = DeploymentFactory.eINSTANCE
				.createRequiredCommunication();
		similationManagerReqInfoCommunication.setOwner(simulationManagerIc);
		similationManagerReqInfoCommunication.setIsLocal(false);
		similationManagerReqInfoCommunication.setIsMandatory(true);
		similationManagerReqInfoCommunication
				.setName("SimulationManagerr_consumes_Information Service");
		similationManagerReqInfoCommunication.setPortNumber(11300);
		simulationManagerIc.getRequiredCommunications().add(
				similationManagerReqInfoCommunication);

		RequiredCommunication simulationManagerReqStorCommunication = DeploymentFactory.eINSTANCE
				.createRequiredCommunication();
		simulationManagerReqStorCommunication.setOwner(simulationManagerIc);
		simulationManagerReqStorCommunication.setIsLocal(false);
		simulationManagerReqStorCommunication.setIsMandatory(true);
		simulationManagerReqStorCommunication
				.setName("SimulationManagerr_consumes_StorageManager");
		simulationManagerReqStorCommunication.setPortNumber(20001);
		simulationManagerIc.getRequiredCommunications().add(
				simulationManagerReqStorCommunication);

		RequiredCommunication similationManagerReqExpCommunication = DeploymentFactory.eINSTANCE
				.createRequiredCommunication();
		similationManagerReqExpCommunication.setOwner(simulationManagerIc);
		similationManagerReqExpCommunication.setIsLocal(false);
		similationManagerReqExpCommunication.setIsMandatory(true);
		similationManagerReqExpCommunication
				.setName("SimulationManagerr_consumes_Experiment Manager");
		similationManagerReqExpCommunication.setPortNumber(443);
		simulationManagerIc.getRequiredCommunications().add(
				similationManagerReqExpCommunication);

		/*
		 * Now we can define instances we start with component instance
		 */
		InternalComponentInstance simulationManagerInstance = DeploymentFactory.eINSTANCE
				.createInternalComponentInstance();
		simulationManagerInstance.setName("simulationManagerInstance");
		simulationManagerInstance.setType(simulationManagerIc);

		/*
		 * and proceed with communication instances
		 */
		RequiredCommunicationInstance similationManagerReqInfoCommunicationInstance = DeploymentFactory.eINSTANCE
				.createRequiredCommunicationInstance();
		similationManagerReqInfoCommunicationInstance
				.setOwner(simulationManagerInstance);
		similationManagerReqInfoCommunicationInstance
				.setName("similationManagerReqInfoCommunicationInstance");
		similationManagerReqInfoCommunicationInstance
				.setType(similationManagerReqInfoCommunication);
		simulationManagerInstance.getRequiredCommunicationInstances().add(
				similationManagerReqInfoCommunicationInstance);

		RequiredCommunicationInstance simulationManagerReqStorCommunicationInstance = DeploymentFactory.eINSTANCE
				.createRequiredCommunicationInstance();
		simulationManagerReqStorCommunicationInstance
				.setOwner(simulationManagerInstance);
		simulationManagerReqStorCommunicationInstance
				.setName("simulationManagerReqStorCommunicationInstance");
		simulationManagerReqStorCommunicationInstance
				.setType(simulationManagerReqStorCommunication);
		simulationManagerInstance.getRequiredCommunicationInstances().add(
				simulationManagerReqStorCommunicationInstance);

		RequiredCommunicationInstance similationManagerReqExpCommunicationInstance = DeploymentFactory.eINSTANCE
				.createRequiredCommunicationInstance();
		similationManagerReqExpCommunicationInstance
				.setOwner(simulationManagerInstance);
		similationManagerReqExpCommunicationInstance
				.setName("similationManagerReqExpCommunicationInstance");
		similationManagerReqExpCommunicationInstance
				.setType(similationManagerReqExpCommunication);
		simulationManagerInstance.getRequiredCommunicationInstances().add(
				similationManagerReqExpCommunicationInstance);

		RequiredHost similationManagerRequiredHost = DeploymentFactory.eINSTANCE
				.createRequiredHost();
		similationManagerRequiredHost.setOwner(simulationManagerIc);
		similationManagerRequiredHost.setName("informationManagerRequiredHost");
		simulationManagerIc.setRequiredHost(similationManagerRequiredHost);

		RequiredHostInstance similationManagerRequiredHostInstance = DeploymentFactory.eINSTANCE
				.createRequiredHostInstance();
		similationManagerRequiredHostInstance
				.setOwner(simulationManagerInstance);
		similationManagerRequiredHostInstance
				.setName("informationManagerRequiredHostInstance");
		similationManagerRequiredHostInstance
				.setType(similationManagerRequiredHost);
		simulationManagerInstance
				.setRequiredHostInstance(similationManagerRequiredHostInstance);

		return new Decade<InternalComponent, RequiredCommunication, RequiredCommunication, RequiredCommunication, InternalComponentInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance>(
				simulationManagerIc, similationManagerReqInfoCommunication,
				simulationManagerReqStorCommunication,
				similationManagerReqExpCommunication,
				simulationManagerInstance,
				similationManagerReqInfoCommunicationInstance,
				simulationManagerReqStorCommunicationInstance,
				similationManagerReqExpCommunicationInstance,
				similationManagerRequiredHost,
				similationManagerRequiredHostInstance);
	}

	/*
	 * this function creates vm type (GWDG specyfic) and vm instances it also
	 * deals with some monetary/const stuff that I don't understand :)
	 */
	static Quintet<VM, VMInstance, VMInstance, VMInstance, VMInstance> createVirtualMachinesInGWDG(
			CloudProvider GWDGProvider, Location GWDGLocation,
			CamelModel camelModel, Constraint mediumVmConstraint,
			Feature vmFeature) {

		// Lets create virtual machine tamplete - Images IDs have to be
		// organization specyfic
		VM firstVMTemplate = DeploymentFactory.eINSTANCE.createVM();
		firstVMTemplate.setImageId("RegionOne/<ID NEEDED>");
		firstVMTemplate.setIs64os(true);
		firstVMTemplate.setLocation(GWDGLocation);
		firstVMTemplate.setMaxCores(0);
		firstVMTemplate.setMaxRam(0);
		firstVMTemplate.setMaxStorage(0);
		firstVMTemplate.setMinCores(2);
		firstVMTemplate.setMinRam(1024);
		firstVMTemplate.setMinStorage(512);
		firstVMTemplate.setName("firstVMType");
		firstVMTemplate.setOs("ubuntu");
		firstVMTemplate.setProvider(GWDGProvider);

		// what this Key does?
		Attribute mlKeyPath = ProviderFactory.eINSTANCE.createAttribute();
		mlKeyPath.setName("needed for amazon or GWDG");
		StringValue mlKeyPathValue = TypeFactory.eINSTANCE.createStringValue();
		mlKeyPathValue.setValue(".");
		mlKeyPath.setValue(mlKeyPathValue);

		firstVMTemplate.getProperties().add(mlKeyPath);

		// I dont understand that monetary stuff
		MonetaryUnit costMonetaryUnit = CamelFactory.eINSTANCE
				.createMonetaryUnit();
		costMonetaryUnit.setName("euros");
		costMonetaryUnit.setDimensionType(UnitDimensionType.COST);
		costMonetaryUnit.setUnit(UnitType.EUROS);
		camelModel.getUnits().add(costMonetaryUnit);

		// VM info, I assume it can be shared acorss all vm instances. VM info
		// needs monetary stuff created above
		VMInfo firstVMInfo = CamelFactory.eINSTANCE.createVMInfo();
		firstVMInfo.setBenchmarkRate(0);
		firstVMInfo.setClassifiedOn(new Date());
		firstVMInfo.setCostPerHour(1);
		firstVMInfo.setCostUnit(costMonetaryUnit);
		firstVMInfo.setEvaluatedOn(new Date());
		firstVMInfo.setName("firstVMInfo");
		camelModel.getVmInfos().add(firstVMInfo);

		// VM Type, I assume it can be shared across all vm instances
		VMType firstVmType = CamelFactory.eINSTANCE.createVMType();
		firstVmType.setFeature(vmFeature);
		firstVmType.setName("firstVMType");
		firstVmType.getConstraints().add(mediumVmConstraint);
		firstVMInfo.setType(firstVmType);
		camelModel.getVmTypes().add(firstVmType);

		// Finally we create 4 VMInstances one for each component type
		VMInstance storageManagerVMInstance = createVMInstance(
				"storageManagerVMInstance", firstVMTemplate, firstVMInfo);
		VMInstance informationManagerVMInstance = createVMInstance(
				"informationManagerVMInstance", firstVMTemplate, firstVMInfo);
		VMInstance experimentManagerVMInstance = createVMInstance(
				"experimentManagerVMInstance", firstVMTemplate, firstVMInfo);
		VMInstance simulationManagerVMInstance = createVMInstance(
				"simulationManagerVMInstance", firstVMTemplate, firstVMInfo);

		return new Quintet<VM, VMInstance, VMInstance, VMInstance, VMInstance>(
				firstVMTemplate, storageManagerVMInstance,
				informationManagerVMInstance, experimentManagerVMInstance,
				simulationManagerVMInstance);
	}

	/*
	 * Simple helper function for vmInstances creation
	 */
	static VMInstance createVMInstance(String aVmName, VM aVmTemplate,
			VMInfo aVmInfo) {
		VMInstance aVMInstance = DeploymentFactory.eINSTANCE.createVMInstance();
		aVMInstance.setHasInfo(aVmInfo);
		aVMInstance.setName(aVmName);
		aVMInstance.setType(aVmTemplate);
		return aVMInstance;
	}

	/*
	 * Here we create hosts for each of the services
	 */
	static Quintet<ProvidedHost, ProvidedHostInstance, ProvidedHostInstance, ProvidedHostInstance, ProvidedHostInstance> createHosts(
			VM masterVM, VMInstance storageManagerVMInstance,
			VMInstance informationManagerVMInstance,
			VMInstance experimentManagerVMInstance,
			VMInstance simulationManagerVMInstance) {
		// We create only one provided host type that will be related to one
		// type of virtual machine
		ProvidedHost firstProvidedHostType = DeploymentFactory.eINSTANCE
				.createProvidedHost();
		firstProvidedHostType.setOwner(masterVM);
		firstProvidedHostType.setName("firstProvidedHostType");
		masterVM.getProvidedHosts().add(firstProvidedHostType);

		// We create 4 ProvidedHostInstance one for each component type
		ProvidedHostInstance storageManagerProvidedHostInstance = createProvidedHostInstance(
				"storageManagerProvidedHostInstance", firstProvidedHostType,
				storageManagerVMInstance);
		ProvidedHostInstance informationManagerProvidedHostInstance = createProvidedHostInstance(
				"informationManagerProvidedHostInstance",
				firstProvidedHostType, informationManagerVMInstance);
		ProvidedHostInstance experimentManagerProvidedHostInstance = createProvidedHostInstance(
				"experimentManagerProvidedHostInstance", firstProvidedHostType,
				experimentManagerVMInstance);
		ProvidedHostInstance simulationManagerProvidedHostInstance = createProvidedHostInstance(
				"simulationManagerProvidedHostInstance", firstProvidedHostType,
				simulationManagerVMInstance);

		return new Quintet<ProvidedHost, ProvidedHostInstance, ProvidedHostInstance, ProvidedHostInstance, ProvidedHostInstance>(
				firstProvidedHostType, storageManagerProvidedHostInstance,
				informationManagerProvidedHostInstance,
				experimentManagerProvidedHostInstance,
				simulationManagerProvidedHostInstance);
	}

	/*
	 * Simple helper function for ProvidedHostInstance creation
	 */
	static ProvidedHostInstance createProvidedHostInstance(String aName,
			ProvidedHost aProvidedHost, VMInstance aVmInstance) {

		ProvidedHostInstance aPartHostInstance = DeploymentFactory.eINSTANCE
				.createProvidedHostInstance();
		aPartHostInstance.setOwner(aVmInstance);
		aPartHostInstance.setName(aName);
		aPartHostInstance.setType(aProvidedHost);
		aVmInstance.getProvidedHostInstances().add(aPartHostInstance);
		return aPartHostInstance;
	}

	/*
	 * Master function that create deployment model
	 */
	public static Quintet<DeploymentModel, Quartet<InternalComponent, InternalComponent, InternalComponent, InternalComponent>, Quartet<InternalComponentInstance, InternalComponentInstance, InternalComponentInstance, InternalComponentInstance>, Quartet<VMInstance, VMInstance, VMInstance, VMInstance>, VM> createScalarmDepolymentModel(
			CloudProvider GWDGProvider, Location GWDGLocation,
			CamelModel camelModel, Feature vmFeature,
			Constraint mediumVmConstraint) {

		DeploymentModel scalarmDeploymentModel = DeploymentFactory.eINSTANCE
				.createDeploymentModel();

		scalarmDeploymentModel.setName("Scalarm");
		// One provided GWDG
		scalarmDeploymentModel.getProviders().add(GWDGProvider);

		// 1. Experiment Manager
		Decade<InternalComponent, ProvidedCommunication, RequiredCommunication, RequiredCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance> experimentManagerTypeReturns = defineExperimentManagerType();
		InternalComponent experimentManagerIc = experimentManagerTypeReturns
				.getValue0();
		ProvidedCommunication experimentManagerProvidedCommunication = experimentManagerTypeReturns
				.getValue1();
		RequiredCommunication experimentManagerReqStorageCommunication = experimentManagerTypeReturns
				.getValue2();
		RequiredCommunication experimentManagerReqInfoCommunication = experimentManagerTypeReturns
				.getValue3();
		InternalComponentInstance experimentManagerInstance = experimentManagerTypeReturns
				.getValue4();
		ProvidedCommunicationInstance experimentManagerProvidedCommunicationInstance = experimentManagerTypeReturns
				.getValue5();
		RequiredCommunicationInstance experimentManagerReqInfoCommunicationInstance = experimentManagerTypeReturns
				.getValue6();
		RequiredCommunicationInstance experimentManagerReqStorageCommunicationInstance = experimentManagerTypeReturns
				.getValue7();
		RequiredHost experimentManagerRequiredHost = experimentManagerTypeReturns
				.getValue8();
		RequiredHostInstance experimentManagerRequiredHostInstance = experimentManagerTypeReturns
				.getValue9();

		scalarmDeploymentModel.getInternalComponents().add(experimentManagerIc);
		scalarmDeploymentModel.getInternalComponentInstances().add(
				experimentManagerInstance);

		// 2. StorageManager
		Octet<InternalComponent, ProvidedCommunication, RequiredCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance> storageManagerTypeReturns = defineStorageManagerType();
		InternalComponent storageManagerIc = storageManagerTypeReturns
				.getValue0();
		ProvidedCommunication storageManagerProvidedCommunicationMongodNnginx = storageManagerTypeReturns
				.getValue1();
		RequiredCommunication storgeManagerReqInfoCommunication = storageManagerTypeReturns
				.getValue2();
		InternalComponentInstance storageManagerInstance = storageManagerTypeReturns
				.getValue3();
		ProvidedCommunicationInstance storageManagerProvidedCommunicationMongodNnginxInstance = storageManagerTypeReturns
				.getValue4();
		RequiredCommunicationInstance storgeManagerReqInfoCommunicationInstance = storageManagerTypeReturns
				.getValue5();
		RequiredHost storgeManagerRequiredHost = storageManagerTypeReturns
				.getValue6();
		RequiredHostInstance storgeManagerRequiredHostInstance = storageManagerTypeReturns
				.getValue7();

		scalarmDeploymentModel.getInternalComponents().add(storageManagerIc);
		scalarmDeploymentModel.getInternalComponentInstances().add(
				storageManagerInstance);

		// 3. Information Service
		Sextet<InternalComponent, ProvidedCommunication, InternalComponentInstance, ProvidedCommunicationInstance, RequiredHost, RequiredHostInstance> informationManagerTypeReturns = defineInformationServiceType();
		InternalComponent informationManagerIc = informationManagerTypeReturns
				.getValue0();
		ProvidedCommunication informationManagerProvidedCommunication = informationManagerTypeReturns
				.getValue1();
		InternalComponentInstance informationManagerInstance = informationManagerTypeReturns
				.getValue2();
		ProvidedCommunicationInstance informationManagerProvidedCommunicationInstance = informationManagerTypeReturns
				.getValue3();
		RequiredHost informationManagerRequiredHost = informationManagerTypeReturns
				.getValue4();
		RequiredHostInstance informationManagerRequiredHostInstance = informationManagerTypeReturns
				.getValue5();

		scalarmDeploymentModel.getInternalComponents()
				.add(informationManagerIc);
		scalarmDeploymentModel.getInternalComponentInstances().add(
				informationManagerInstance);

		// Scalarm Worker Part
		// 1. Simulation Manager
		Decade<InternalComponent, RequiredCommunication, RequiredCommunication, RequiredCommunication, InternalComponentInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredCommunicationInstance, RequiredHost, RequiredHostInstance> simulationManagerTypeReturns = defineSimulationManagerType();
		InternalComponent simulationManagerIc = simulationManagerTypeReturns
				.getValue0();
		RequiredCommunication similationManagerReqInfoCommunication = simulationManagerTypeReturns
				.getValue1();
		RequiredCommunication simulationManagerReqStorCommunication = simulationManagerTypeReturns
				.getValue2();
		RequiredCommunication similationManagerReqExpCommunication = simulationManagerTypeReturns
				.getValue3();
		InternalComponentInstance simulationManagerInstance = simulationManagerTypeReturns
				.getValue4();
		RequiredCommunicationInstance similationManagerReqInfoCommunicationInstance = simulationManagerTypeReturns
				.getValue5();
		RequiredCommunicationInstance simulationManagerReqStorCommunicationInstance = simulationManagerTypeReturns
				.getValue6();
		RequiredCommunicationInstance similationManagerReqExpCommunicationInstance = simulationManagerTypeReturns
				.getValue7();
		RequiredHost similationManagerRequiredHost = simulationManagerTypeReturns
				.getValue8();
		RequiredHostInstance similationManagerRequiredHostInstance = simulationManagerTypeReturns
				.getValue9();

		scalarmDeploymentModel.getInternalComponents().add(simulationManagerIc);
		scalarmDeploymentModel.getInternalComponentInstances().add(
				simulationManagerInstance);

		// Connecting services/Making the able to talk to each other
		// Defining required ports. Who consumes who.

		// Experiment manager only consumes Storage Manager
		// experimentManagerToStorageManager
		Communication experimentManagerToStorageManager = DeploymentFactory.eINSTANCE
				.createCommunication();
		experimentManagerToStorageManager
				.setName("experimentManagerToStorageManager");
		experimentManagerToStorageManager
				.setProvidedCommunication(storageManagerProvidedCommunicationMongodNnginx);
		experimentManagerToStorageManager
				.setRequiredCommunication(experimentManagerReqStorageCommunication);
		scalarmDeploymentModel.getCommunications().add(
				experimentManagerToStorageManager);

		CommunicationInstance experimentManagerToStorageManagerInstance = DeploymentFactory.eINSTANCE
				.createCommunicationInstance();
		experimentManagerToStorageManagerInstance
				.setName("experimentManagerToStorageManagerInstance");
		experimentManagerToStorageManagerInstance
				.setProvidedCommunicationInstance(storageManagerProvidedCommunicationMongodNnginxInstance);
		experimentManagerToStorageManagerInstance
				.setRequiredCommunicationInstance(experimentManagerReqStorageCommunicationInstance);
		experimentManagerToStorageManagerInstance
				.setType(experimentManagerToStorageManager);
		scalarmDeploymentModel.getCommunicationInstances().add(
				experimentManagerToStorageManagerInstance);

		// All consumes InfomrationService port
		// //experimentManagerToInformationService
		Communication experimentManagerToInformationService = DeploymentFactory.eINSTANCE
				.createCommunication();
		experimentManagerToInformationService
				.setName("experimentManagerToInformationService");
		experimentManagerToInformationService
				.setProvidedCommunication(informationManagerProvidedCommunication);
		experimentManagerToInformationService
				.setRequiredCommunication(experimentManagerReqInfoCommunication);
		scalarmDeploymentModel.getCommunications().add(
				experimentManagerToInformationService);

		CommunicationInstance experimentManagerToInformationServiceInstance = DeploymentFactory.eINSTANCE
				.createCommunicationInstance();
		experimentManagerToInformationServiceInstance
				.setName("experimentManagerToInformationServiceInstance");
		experimentManagerToInformationServiceInstance
				.setProvidedCommunicationInstance(informationManagerProvidedCommunicationInstance);
		experimentManagerToInformationServiceInstance
				.setRequiredCommunicationInstance(experimentManagerReqInfoCommunicationInstance);
		experimentManagerToInformationServiceInstance
				.setType(experimentManagerToInformationService);
		scalarmDeploymentModel.getCommunicationInstances().add(
				experimentManagerToInformationServiceInstance);

		// storageManagerToInformationService
		Communication storageManagerToInformationService = DeploymentFactory.eINSTANCE
				.createCommunication();
		storageManagerToInformationService
				.setName("storageManagerToInformationService");
		storageManagerToInformationService
				.setProvidedCommunication(storageManagerProvidedCommunicationMongodNnginx);
		storageManagerToInformationService
				.setRequiredCommunication(storgeManagerReqInfoCommunication);
		scalarmDeploymentModel.getCommunications().add(
				storageManagerToInformationService);

		CommunicationInstance storageManagerToInformationServiceInstance = DeploymentFactory.eINSTANCE
				.createCommunicationInstance();
		storageManagerToInformationServiceInstance
				.setName("storageManagerToInformationServiceInstance");
		storageManagerToInformationServiceInstance
				.setProvidedCommunicationInstance(storageManagerProvidedCommunicationMongodNnginxInstance);
		storageManagerToInformationServiceInstance
				.setRequiredCommunicationInstance(storgeManagerReqInfoCommunicationInstance);
		storageManagerToInformationServiceInstance
				.setType(storageManagerToInformationService);
		scalarmDeploymentModel.getCommunicationInstances().add(
				storageManagerToInformationServiceInstance);

		// simulationManagerToInformationService
		Communication simulationManagerToInformationService = DeploymentFactory.eINSTANCE
				.createCommunication();
		simulationManagerToInformationService
				.setName("simulationManagerToInformationService");
		simulationManagerToInformationService
				.setProvidedCommunication(informationManagerProvidedCommunication);
		simulationManagerToInformationService
				.setRequiredCommunication(similationManagerReqInfoCommunication);
		scalarmDeploymentModel.getCommunications().add(
				simulationManagerToInformationService);

		CommunicationInstance simulationManagerToInformationServiceInstance = DeploymentFactory.eINSTANCE
				.createCommunicationInstance();
		simulationManagerToInformationServiceInstance
				.setName("simulationManagerToInformationServiceInstance");
		simulationManagerToInformationServiceInstance
				.setProvidedCommunicationInstance(informationManagerProvidedCommunicationInstance);
		simulationManagerToInformationServiceInstance
				.setRequiredCommunicationInstance(similationManagerReqInfoCommunicationInstance);
		simulationManagerToInformationServiceInstance
				.setType(simulationManagerToInformationService);
		scalarmDeploymentModel.getCommunicationInstances().add(
				simulationManagerToInformationServiceInstance);

		// Simulation Manager consumes all
		// simulationManagerToStorageManager
		Communication simulationManagerToStorageManager = DeploymentFactory.eINSTANCE
				.createCommunication();
		simulationManagerToStorageManager
				.setName("simulationManagerToStorageManager");
		simulationManagerToStorageManager
				.setProvidedCommunication(storageManagerProvidedCommunicationMongodNnginx);
		simulationManagerToStorageManager
				.setRequiredCommunication(simulationManagerReqStorCommunication);
		scalarmDeploymentModel.getCommunications().add(
				simulationManagerToStorageManager);

		CommunicationInstance simulationManagerToStorageManagerInstance = DeploymentFactory.eINSTANCE
				.createCommunicationInstance();
		simulationManagerToStorageManagerInstance
				.setName("simulationManagerToStorageManagerInstance");
		simulationManagerToStorageManagerInstance
				.setProvidedCommunicationInstance(storageManagerProvidedCommunicationMongodNnginxInstance);
		simulationManagerToStorageManagerInstance
				.setRequiredCommunicationInstance(simulationManagerReqStorCommunicationInstance);
		simulationManagerToStorageManagerInstance
				.setType(simulationManagerToStorageManager);
		scalarmDeploymentModel.getCommunicationInstances().add(
				simulationManagerToStorageManagerInstance);

		// Simulation Manager consumes Experiment Manager
		Communication simulationManagerToExperimentManager = DeploymentFactory.eINSTANCE
				.createCommunication();
		simulationManagerToExperimentManager
				.setName("simulationManagerToExperimentManager");
		simulationManagerToExperimentManager
				.setProvidedCommunication(experimentManagerProvidedCommunication);
		simulationManagerToExperimentManager
				.setRequiredCommunication(similationManagerReqExpCommunication);
		scalarmDeploymentModel.getCommunications().add(
				simulationManagerToExperimentManager);

		CommunicationInstance simulationManagerToExperimentManagerInstance = DeploymentFactory.eINSTANCE
				.createCommunicationInstance();
		simulationManagerToExperimentManagerInstance
				.setName("simulationManagerToExperimentManagerInstance");
		simulationManagerToExperimentManagerInstance
				.setProvidedCommunicationInstance(experimentManagerProvidedCommunicationInstance);
		simulationManagerToExperimentManagerInstance
				.setRequiredCommunicationInstance(similationManagerReqExpCommunicationInstance);
		simulationManagerToExperimentManagerInstance
				.setType(simulationManagerToExperimentManager);
		scalarmDeploymentModel.getCommunicationInstances().add(
				simulationManagerToExperimentManagerInstance);

		// Creation of VMs
		Quintet<VM, VMInstance, VMInstance, VMInstance, VMInstance> virtualMachinesInGWDGReturns = createVirtualMachinesInGWDG(
				GWDGProvider, GWDGLocation, camelModel, mediumVmConstraint,
				vmFeature);
		VM firstVMTemplate = virtualMachinesInGWDGReturns.getValue0();
		VMInstance storageManagerVMInstance = virtualMachinesInGWDGReturns
				.getValue1();
		VMInstance informationManagerVMInstance = virtualMachinesInGWDGReturns
				.getValue2();
		VMInstance experimentManagerVMInstance = virtualMachinesInGWDGReturns
				.getValue3();
		VMInstance simulationManagerVMInstance = virtualMachinesInGWDGReturns
				.getValue4();

		scalarmDeploymentModel.getVms().add(firstVMTemplate);
		scalarmDeploymentModel.getVmInstances().add(storageManagerVMInstance);
		scalarmDeploymentModel.getVmInstances().add(
				informationManagerVMInstance);
		scalarmDeploymentModel.getVmInstances()
				.add(experimentManagerVMInstance);
		scalarmDeploymentModel.getVmInstances()
				.add(simulationManagerVMInstance);

		// Creation of ProvidedHosts
		Quintet<ProvidedHost, ProvidedHostInstance, ProvidedHostInstance, ProvidedHostInstance, ProvidedHostInstance> createHostsResults = createHosts(
				firstVMTemplate, storageManagerVMInstance,
				informationManagerVMInstance, experimentManagerVMInstance,
				simulationManagerVMInstance);
		ProvidedHost firstProvidedHostType = createHostsResults.getValue0();
		ProvidedHostInstance storageManagerProvidedHostInstance = createHostsResults
				.getValue1();
		ProvidedHostInstance informationManagerProvidedHostInstance = createHostsResults
				.getValue2();
		ProvidedHostInstance experimentManagerProvidedHostInstance = createHostsResults
				.getValue3();
		ProvidedHostInstance simulationManagerProvidedHostInstance = createHostsResults
				.getValue4();

		// Paring of ProvidedHostInstance with firstProvidedHostType
		// ExperimentManager
		Hosting masterVMtoExperimentManager = DeploymentFactory.eINSTANCE
				.createHosting();
		masterVMtoExperimentManager.setName("masterVMtoExperimentManager");
		masterVMtoExperimentManager.setProvidedHost(firstProvidedHostType);
		masterVMtoExperimentManager
				.setRequiredHost(experimentManagerRequiredHost);
		scalarmDeploymentModel.getHostings().add(masterVMtoExperimentManager);

		HostingInstance masterVMtoExperimentManagerInstance = DeploymentFactory.eINSTANCE
				.createHostingInstance();
		masterVMtoExperimentManagerInstance
				.setName("masterVMtoExperimentManagerInstance");
		masterVMtoExperimentManagerInstance
				.setProvidedHostInstance(experimentManagerProvidedHostInstance);
		masterVMtoExperimentManagerInstance
				.setRequiredHostInstance(experimentManagerRequiredHostInstance);
		masterVMtoExperimentManagerInstance
				.setType(masterVMtoExperimentManager);
		scalarmDeploymentModel.getHostingInstances().add(
				masterVMtoExperimentManagerInstance);

		// StorageManager
		Hosting masterVMtoStorageManager = DeploymentFactory.eINSTANCE
				.createHosting();
		masterVMtoStorageManager.setName("masterVMtoStorageManager");
		masterVMtoStorageManager.setProvidedHost(firstProvidedHostType);
		masterVMtoStorageManager.setRequiredHost(storgeManagerRequiredHost);
		scalarmDeploymentModel.getHostings().add(masterVMtoStorageManager);

		HostingInstance masterVMtoStorageManagerInstance = DeploymentFactory.eINSTANCE
				.createHostingInstance();
		masterVMtoStorageManagerInstance
				.setName("masterVMtoStorageManagerInstance");
		masterVMtoStorageManagerInstance
				.setProvidedHostInstance(storageManagerProvidedHostInstance);
		masterVMtoStorageManagerInstance
				.setRequiredHostInstance(storgeManagerRequiredHostInstance);
		masterVMtoStorageManagerInstance.setType(masterVMtoStorageManager);
		scalarmDeploymentModel.getHostingInstances().add(
				masterVMtoStorageManagerInstance);

		// InformationManager
		Hosting masterVMtoInformationManager = DeploymentFactory.eINSTANCE
				.createHosting();
		masterVMtoInformationManager.setName("masterVMtoInformationManager");
		masterVMtoInformationManager.setProvidedHost(firstProvidedHostType);
		masterVMtoInformationManager
				.setRequiredHost(informationManagerRequiredHost);
		scalarmDeploymentModel.getHostings().add(masterVMtoInformationManager);

		HostingInstance masterVMtoInformationManagerInstance = DeploymentFactory.eINSTANCE
				.createHostingInstance();
		masterVMtoInformationManagerInstance
				.setName("masterVMtoInformationManagerInstance");
		masterVMtoInformationManagerInstance
				.setProvidedHostInstance(informationManagerProvidedHostInstance);
		masterVMtoInformationManagerInstance
				.setRequiredHostInstance(informationManagerRequiredHostInstance);
		masterVMtoInformationManagerInstance
				.setType(masterVMtoInformationManager);
		scalarmDeploymentModel.getHostingInstances().add(
				masterVMtoInformationManagerInstance);

		// SimulationManager
		Hosting masterVMtoSimulationManager = DeploymentFactory.eINSTANCE
				.createHosting();
		masterVMtoSimulationManager.setName("masterVMtoSimulationManager");
		masterVMtoSimulationManager.setProvidedHost(firstProvidedHostType);
		masterVMtoSimulationManager
				.setRequiredHost(similationManagerRequiredHost);
		scalarmDeploymentModel.getHostings().add(masterVMtoSimulationManager);

		HostingInstance masterVMtoSimulationManagerInstance = DeploymentFactory.eINSTANCE
				.createHostingInstance();
		masterVMtoSimulationManagerInstance
				.setName("masterVMtoSimulationManagerInstance");
		masterVMtoSimulationManagerInstance
				.setProvidedHostInstance(simulationManagerProvidedHostInstance);
		masterVMtoSimulationManagerInstance
				.setRequiredHostInstance(similationManagerRequiredHostInstance);
		masterVMtoSimulationManagerInstance
				.setType(masterVMtoSimulationManager);
		scalarmDeploymentModel.getHostingInstances().add(
				masterVMtoSimulationManagerInstance);

		// //// END definition of Deployment model
		return new Quintet<DeploymentModel, Quartet<InternalComponent, InternalComponent, InternalComponent, InternalComponent>, Quartet<InternalComponentInstance, InternalComponentInstance, InternalComponentInstance, InternalComponentInstance>, Quartet<VMInstance, VMInstance, VMInstance, VMInstance>, VM>(
				scalarmDeploymentModel,
				new Quartet<InternalComponent, InternalComponent, InternalComponent, InternalComponent>(
						experimentManagerIc, informationManagerIc,
						storageManagerIc, simulationManagerIc),
				new Quartet<InternalComponentInstance, InternalComponentInstance, InternalComponentInstance, InternalComponentInstance>(
						experimentManagerInstance, informationManagerInstance,
						storageManagerInstance, simulationManagerInstance),
				new Quartet<VMInstance, VMInstance, VMInstance, VMInstance>(
						experimentManagerVMInstance,
						informationManagerVMInstance, storageManagerVMInstance,
						simulationManagerVMInstance), firstVMTemplate);
	}

}
