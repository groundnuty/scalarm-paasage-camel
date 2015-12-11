package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.*;
import eu.paasage.camel.deployment.*;
import eu.paasage.camel.organisation.CloudProvider;
import eu.paasage.camel.provider.Constraint;
import eu.paasage.camel.provider.Feature;
import eu.paasage.camel.provider.ProviderModel;
import org.javatuples.*;

/**
 * @author orzech
 *         This class creates deployment model there is one function at the bottom that
 *         actually returns the model, and a number of helper functions
 */

public class ScalarmDepolymentModel {

    public static InternalComponent storageManager;
    public static InternalComponent informationService;
    public static InternalComponent experimentManager;
    public static InternalComponent simulationManager;

    public static VM cpuIntensiveUbuntuGermany ;

    public static DeploymentModel createScalarmDepolymentModel() {


        DeploymentModel scalarmDeploymentModel = DeploymentFactory.eINSTANCE.createDeploymentModel();

        scalarmDeploymentModel.setName("Scalarm Deployment Model");


        VMRequirementSet coreIntensiveUbuntuGermanyRS = DeploymentFactory.eINSTANCE.createVMRequirementSet();
        coreIntensiveUbuntuGermanyRS.setName("CoreIntensiveUbuntuGermanyRS");
        coreIntensiveUbuntuGermanyRS.setOsOrImageRequirement(ScalarmRequirmentModel.ubuntuRequirement);
        coreIntensiveUbuntuGermanyRS.setQuantitativeHardwareRequirement(ScalarmRequirmentModel.coreIntensiveRequirment);
        coreIntensiveUbuntuGermanyRS.setLocationRequirement(ScalarmRequirmentModel.germanyRequirement);

        VMRequirementSet cpuIntensiveUbuntuGermanyRS = DeploymentFactory.eINSTANCE.createVMRequirementSet();
        cpuIntensiveUbuntuGermanyRS.setName("CPUIntensiveUbuntuGermanyRS");
        cpuIntensiveUbuntuGermanyRS.setOsOrImageRequirement(ScalarmRequirmentModel.ubuntuRequirement);
        cpuIntensiveUbuntuGermanyRS.setQuantitativeHardwareRequirement(ScalarmRequirmentModel.cpuIntensiveRequirment);
        cpuIntensiveUbuntuGermanyRS.setLocationRequirement(ScalarmRequirmentModel.germanyRequirement);

        VMRequirementSet storageIntensiveUbuntuGermanyRS = DeploymentFactory.eINSTANCE.createVMRequirementSet();
        storageIntensiveUbuntuGermanyRS.setName("StorageIntensiveUbuntuGermanyRS");
        storageIntensiveUbuntuGermanyRS.setOsOrImageRequirement(ScalarmRequirmentModel.ubuntuRequirement);
        storageIntensiveUbuntuGermanyRS.setQuantitativeHardwareRequirement(ScalarmRequirmentModel.storageIntensiveRequirment);
        storageIntensiveUbuntuGermanyRS.setLocationRequirement(ScalarmRequirmentModel.germanyRequirement);


        //coreIntensive
        VM coreIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createVM();
        coreIntensiveUbuntuGermany.setName("CoreIntensiveUbuntuGermany");
        coreIntensiveUbuntuGermany.setVmRequirementSet(coreIntensiveUbuntuGermanyRS);
        scalarmDeploymentModel.getVms().add(coreIntensiveUbuntuGermany);

        VMInstance coreIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createVMInstance();
        coreIntensiveUbuntuGermanyInstance.setName("CoreIntensiveUbuntuGermanyInstance");
        coreIntensiveUbuntuGermanyInstance.setType(coreIntensiveUbuntuGermany);
        coreIntensiveUbuntuGermanyInstance.setVmType(ScalarmGWDGProviderModel.wmTypes);
        coreIntensiveUbuntuGermanyInstance.setVmTypeValue(ScalarmGWDGProviderModel.m1XLargeVm);

        ProvidedHost coreIntensiveUbuntuGermanyHost = DeploymentFactory.eINSTANCE.createProvidedHost();
        coreIntensiveUbuntuGermanyHost.setName("CoreIntensiveUbuntuGermanyHost");
        coreIntensiveUbuntuGermany.getProvidedHosts().add(coreIntensiveUbuntuGermanyHost);

        ProvidedHostInstance coreIntensiveUbuntuGermanyHostInstance = DeploymentFactory.eINSTANCE.createProvidedHostInstance();
        coreIntensiveUbuntuGermanyHostInstance.setName("CoreIntensiveUbuntuGermanyHostInstance");
        coreIntensiveUbuntuGermanyHostInstance.setType(coreIntensiveUbuntuGermanyHost);
        coreIntensiveUbuntuGermanyInstance.getProvidedHostInstances().add(coreIntensiveUbuntuGermanyHostInstance);

        RequiredHost coreIntensiveUbuntuGermanyHostReq = DeploymentFactory.eINSTANCE.createRequiredHost();
        coreIntensiveUbuntuGermanyHostReq.setName("coreIntensiveUbuntuGermanyHostReq");

        RequiredHostInstance coreIntensiveUbuntuGermanyHostReqInstance = DeploymentFactory.eINSTANCE.createRequiredHostInstance();
        coreIntensiveUbuntuGermanyHostReqInstance.setName("CoreIntensiveUbuntuGermanyHostReqInstance");
        coreIntensiveUbuntuGermanyHostReqInstance.setType(coreIntensiveUbuntuGermanyHostReq);

        // cpuIntensive
        VM cpuIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createVM();
        cpuIntensiveUbuntuGermany.setName("CPUIntensiveUbuntuGermany");
        cpuIntensiveUbuntuGermany.setVmRequirementSet(cpuIntensiveUbuntuGermanyRS);
        scalarmDeploymentModel.getVms().add(cpuIntensiveUbuntuGermany);

        VMInstance cpuIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createVMInstance();
        cpuIntensiveUbuntuGermanyInstance.setName("CPUIntensiveUbuntuGermanyInstance");
        cpuIntensiveUbuntuGermanyInstance.setType(cpuIntensiveUbuntuGermany);
        cpuIntensiveUbuntuGermanyInstance.setVmType(ScalarmGWDGProviderModel.wmTypes);
        cpuIntensiveUbuntuGermanyInstance.setVmTypeValue(ScalarmGWDGProviderModel.m1XLargeVm);
        scalarmDeploymentModel.getVmInstances().add(cpuIntensiveUbuntuGermanyInstance);

        ProvidedHost cpuIntensiveUbuntuGermanyHost = DeploymentFactory.eINSTANCE.createProvidedHost();
        cpuIntensiveUbuntuGermanyHost.setName("CPUIntensiveUbuntuGermanyHost");
        cpuIntensiveUbuntuGermany.getProvidedHosts().add(cpuIntensiveUbuntuGermanyHost);

        ProvidedHostInstance cpuIntensiveUbuntuGermanyHostInstance = DeploymentFactory.eINSTANCE.createProvidedHostInstance();
        cpuIntensiveUbuntuGermanyHostInstance.setName("CPUIntensiveUbuntuGermanyHostInstance");
        cpuIntensiveUbuntuGermanyHostInstance.setType(cpuIntensiveUbuntuGermanyHost);
        cpuIntensiveUbuntuGermanyInstance.getProvidedHostInstances().add(cpuIntensiveUbuntuGermanyHostInstance);

        RequiredHost cpuIntensiveUbuntuGermanyHostReq = DeploymentFactory.eINSTANCE.createRequiredHost();
        cpuIntensiveUbuntuGermanyHostReq.setName("CPUIntensiveUbuntuGermanyHostReq");

        RequiredHostInstance cpuIntensiveUbuntuGermanyHostReqInstance = DeploymentFactory.eINSTANCE.createRequiredHostInstance();
        cpuIntensiveUbuntuGermanyHostReqInstance.setName("CPUIntensiveUbuntuGermanyHostReqInstance");
        cpuIntensiveUbuntuGermanyHostReqInstance.setType(cpuIntensiveUbuntuGermanyHostReq);


        // storageIntensive
        VM storageIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createVM();
        storageIntensiveUbuntuGermany.setName("StorageIntensiveUbuntuGermany");
        storageIntensiveUbuntuGermany.setVmRequirementSet(storageIntensiveUbuntuGermanyRS);
        scalarmDeploymentModel.getVms().add(storageIntensiveUbuntuGermany);

        VMInstance storageIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createVMInstance();
        storageIntensiveUbuntuGermanyInstance.setName("StorageIntensiveUbuntuGermanyInstance");
        storageIntensiveUbuntuGermanyInstance.setType(storageIntensiveUbuntuGermany);
        storageIntensiveUbuntuGermanyInstance.setVmType(ScalarmGWDGProviderModel.wmTypes);
        cpuIntensiveUbuntuGermanyInstance.setVmTypeValue(ScalarmGWDGProviderModel.m1XLargeVm);
        scalarmDeploymentModel.getVmInstances().add(storageIntensiveUbuntuGermanyInstance);

        ProvidedHost storageIntensiveUbuntuGermanyHost = DeploymentFactory.eINSTANCE.createProvidedHost();
        storageIntensiveUbuntuGermanyHost.setName("StorageIntensiveUbuntuGermanyHost");
        storageIntensiveUbuntuGermany.getProvidedHosts().add(storageIntensiveUbuntuGermanyHost);

        ProvidedHostInstance storageIntensiveUbuntuGermanyHostInstance = DeploymentFactory.eINSTANCE.createProvidedHostInstance();
        storageIntensiveUbuntuGermanyHostInstance.setName("StorageIntensiveUbuntuGermanyHostInstance");
        storageIntensiveUbuntuGermanyHostInstance.setType(storageIntensiveUbuntuGermanyHost);
        storageIntensiveUbuntuGermanyInstance.getProvidedHostInstances().add(storageIntensiveUbuntuGermanyHostInstance);

        RequiredHost storageIntensiveUbuntuGermanyHostReq = DeploymentFactory.eINSTANCE.createRequiredHost();
        storageIntensiveUbuntuGermanyHostReq.setName("storageIntensiveUbuntuGermanyHostReq");

        RequiredHostInstance storageIntensiveUbuntuGermanyHostReqInstance = DeploymentFactory.eINSTANCE.createRequiredHostInstance();
        storageIntensiveUbuntuGermanyHostReqInstance.setName("StorageIntensiveUbuntuGermanyHostReqInstance");
        storageIntensiveUbuntuGermanyHostReqInstance.setType(storageIntensiveUbuntuGermanyHostReq);


        // Paring of ProvidedHostInstance with firstProvidedHostType
        // ExperimentManager
        Hosting experimentManagerToCoreIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createHosting();
        experimentManagerToCoreIntensiveUbuntuGermany.setName("ExperimentManagerToCoreIntensiveUbuntuGermany");
        experimentManagerToCoreIntensiveUbuntuGermany.setProvidedHost(coreIntensiveUbuntuGermanyHost);
        experimentManagerToCoreIntensiveUbuntuGermany.setRequiredHost(coreIntensiveUbuntuGermanyHostReq);
        scalarmDeploymentModel.getHostings().add(experimentManagerToCoreIntensiveUbuntuGermany);

        HostingInstance experimentManagerToCoreIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createHostingInstance();
        experimentManagerToCoreIntensiveUbuntuGermanyInstance.setName("ExperimentManagerToCoreIntensiveUbuntuGermanyInstance");
        experimentManagerToCoreIntensiveUbuntuGermanyInstance.setProvidedHostInstance(coreIntensiveUbuntuGermanyHostInstance);
        experimentManagerToCoreIntensiveUbuntuGermanyInstance.setRequiredHostInstance(coreIntensiveUbuntuGermanyHostReqInstance);
        experimentManagerToCoreIntensiveUbuntuGermanyInstance.setType(experimentManagerToCoreIntensiveUbuntuGermany);
        scalarmDeploymentModel.getHostingInstances().add(experimentManagerToCoreIntensiveUbuntuGermanyInstance);

        // StorageManager
        Hosting storageManagerToStorageIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createHosting();
        storageManagerToStorageIntensiveUbuntuGermany.setName("StorageManagerToStorageIntensiveUbuntuGermany");
        storageManagerToStorageIntensiveUbuntuGermany.setProvidedHost(storageIntensiveUbuntuGermanyHost);
        storageManagerToStorageIntensiveUbuntuGermany.setRequiredHost(storageIntensiveUbuntuGermanyHostReq);
        scalarmDeploymentModel.getHostings().add(storageManagerToStorageIntensiveUbuntuGermany);

        HostingInstance storageManagerToStorageIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createHostingInstance();
        storageManagerToStorageIntensiveUbuntuGermanyInstance.setName("StorageManagerToStorageIntensiveUbuntuGermanyInstance");
        storageManagerToStorageIntensiveUbuntuGermanyInstance.setProvidedHostInstance(storageIntensiveUbuntuGermanyHostInstance);
        storageManagerToStorageIntensiveUbuntuGermanyInstance.setRequiredHostInstance(storageIntensiveUbuntuGermanyHostReqInstance);
        storageManagerToStorageIntensiveUbuntuGermanyInstance.setType(storageManagerToStorageIntensiveUbuntuGermany);
        scalarmDeploymentModel.getHostingInstances().add(storageManagerToStorageIntensiveUbuntuGermanyInstance);

        // InformationManager
        Hosting informationServiceToCoreIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createHosting();
        informationServiceToCoreIntensiveUbuntuGermany.setName("InformationServiceToCoreIntensiveUbuntuGermany");
        informationServiceToCoreIntensiveUbuntuGermany.setProvidedHost(coreIntensiveUbuntuGermanyHost);
        informationServiceToCoreIntensiveUbuntuGermany.setRequiredHost(coreIntensiveUbuntuGermanyHostReq);
        scalarmDeploymentModel.getHostings().add(informationServiceToCoreIntensiveUbuntuGermany);

        HostingInstance informationServiceToCoreIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createHostingInstance();
        informationServiceToCoreIntensiveUbuntuGermanyInstance.setName("InformationServiceToCoreIntensiveUbuntuGermanyInstance");
        informationServiceToCoreIntensiveUbuntuGermanyInstance.setProvidedHostInstance(coreIntensiveUbuntuGermanyHostInstance);
        informationServiceToCoreIntensiveUbuntuGermanyInstance.setRequiredHostInstance(coreIntensiveUbuntuGermanyHostReqInstance);
        informationServiceToCoreIntensiveUbuntuGermanyInstance.setType(informationServiceToCoreIntensiveUbuntuGermany);
        scalarmDeploymentModel.getHostingInstances().add(informationServiceToCoreIntensiveUbuntuGermanyInstance);

        // SimulationManager
        Hosting simulationManagerToCPUIntensiveUbuntuGermany = DeploymentFactory.eINSTANCE.createHosting();
        simulationManagerToCPUIntensiveUbuntuGermany.setName("SimulationManagerToCPUIntensiveUbuntuGermany");
        simulationManagerToCPUIntensiveUbuntuGermany.setProvidedHost(cpuIntensiveUbuntuGermanyHost);
        simulationManagerToCPUIntensiveUbuntuGermany.setRequiredHost(cpuIntensiveUbuntuGermanyHostReq);
        scalarmDeploymentModel.getHostings().add(simulationManagerToCPUIntensiveUbuntuGermany);

        HostingInstance simulationManagerToCPUIntensiveUbuntuGermanyInstance = DeploymentFactory.eINSTANCE.createHostingInstance();
        simulationManagerToCPUIntensiveUbuntuGermanyInstance.setName("SimulationManagerToCPUIntensiveUbuntuGermanyInstance");
        simulationManagerToCPUIntensiveUbuntuGermanyInstance.setProvidedHostInstance(cpuIntensiveUbuntuGermanyHostInstance);
        simulationManagerToCPUIntensiveUbuntuGermanyInstance.setRequiredHostInstance(cpuIntensiveUbuntuGermanyHostReqInstance);
        simulationManagerToCPUIntensiveUbuntuGermanyInstance.setType(simulationManagerToCPUIntensiveUbuntuGermany);
        scalarmDeploymentModel.getHostingInstances().add(simulationManagerToCPUIntensiveUbuntuGermanyInstance);


        // Define Experiment Manager
        InternalComponent experimentManagerIc = DeploymentFactory.eINSTANCE.createInternalComponent();
        InternalComponentInstance experimentManagerInstance = DeploymentFactory.eINSTANCE.createInternalComponentInstance();

        experimentManagerIc.setName("ExperimentManager");

        InternalComponentInstance experimentManagerCompResource = DeploymentFactory.eINSTANCE.createInternalComponentInstance();
        experimentManagerCompResource.setName("ExperimentManager");

        Configuration experimentManagerCompResourceConf = DeploymentFactory.eINSTANCE.createConfiguration();
        experimentManagerCompResourceConf.setDownloadCommand("wget https://github.com/kliput/scalarm_service_scripts/archive/paasage.tar.gz && sudo apt-get update && sudo apt-get install -y groovy ant && tar -zxvf paasage.tar.gz && cd scalarm_service_scripts-paasage");
        experimentManagerCompResourceConf.setInstallCommand("cd scalarm_service_scripts-paasage && ./experiment_manager_install.sh");
        experimentManagerCompResourceConf.setStartCommand("cd scalarm_service_scripts-paasage && ./experiment_manager_start.sh");
        experimentManagerIc.getConfigurations().add(experimentManagerCompResourceConf);


        ProvidedCommunication experimentManagerProvidedCommunication = DeploymentFactory.eINSTANCE.createProvidedCommunication();
        experimentManagerProvidedCommunication.setName("ExperimentManager");
        experimentManagerProvidedCommunication.setPortNumber(443);
        experimentManagerIc.getProvidedCommunications().add(experimentManagerProvidedCommunication);

        RequiredCommunication experimentManagerReqStorageCommunication = DeploymentFactory.eINSTANCE.createRequiredCommunication();
        experimentManagerReqStorageCommunication.setIsMandatory(true);
        experimentManagerReqStorageCommunication.setName("ExperimentManager_consumes_SotrageManager");
        experimentManagerReqStorageCommunication.setPortNumber(20001);
        experimentManagerIc.getRequiredCommunications().add(experimentManagerReqStorageCommunication);

        RequiredCommunication experimentManagerReqInfoCommunication = DeploymentFactory.eINSTANCE.createRequiredCommunication();
        experimentManagerReqInfoCommunication.setIsMandatory(true);
        experimentManagerReqInfoCommunication.setName("ExperimentManager_consumes_Information Service");
        experimentManagerReqInfoCommunication.setPortNumber(11300);
        experimentManagerIc.getRequiredCommunications().add(experimentManagerReqInfoCommunication);


        experimentManagerInstance.setName("experimentManagerInstance");
        experimentManagerInstance.setType(experimentManagerIc);


        ProvidedCommunicationInstance experimentManagerProvidedCommunicationInstance = DeploymentFactory.eINSTANCE.createProvidedCommunicationInstance();
        experimentManagerProvidedCommunicationInstance.setName("experimentManagerProvidedCommunicationInstance");
        experimentManagerProvidedCommunicationInstance.setType(experimentManagerProvidedCommunication);
        experimentManagerInstance.getProvidedCommunicationInstances().add(experimentManagerProvidedCommunicationInstance);

        RequiredCommunicationInstance experimentManagerReqStorageCommunicationInstance = DeploymentFactory.eINSTANCE.createRequiredCommunicationInstance();
        experimentManagerReqStorageCommunicationInstance.setName("experimentManagerReqStorageCommunicationInstance");
        experimentManagerReqStorageCommunicationInstance.setType(experimentManagerReqStorageCommunication);
        experimentManagerInstance.getRequiredCommunicationInstances().add(experimentManagerReqStorageCommunicationInstance);

        RequiredCommunicationInstance experimentManagerReqInfoCommunicationInstance = DeploymentFactory.eINSTANCE.createRequiredCommunicationInstance();
        experimentManagerReqInfoCommunicationInstance.setName("experimentManagerReqInfoCommunicationInstance");
        experimentManagerReqInfoCommunicationInstance.setType(experimentManagerReqInfoCommunication);
        experimentManagerInstance.getRequiredCommunicationInstances().add(experimentManagerReqInfoCommunicationInstance);


        experimentManagerIc.setRequiredHost(coreIntensiveUbuntuGermanyHostReq);
        experimentManagerInstance.setRequiredHostInstance(coreIntensiveUbuntuGermanyHostReqInstance);
        scalarmDeploymentModel.getInternalComponents().add(experimentManagerIc);
        scalarmDeploymentModel.getInternalComponentInstances().add(experimentManagerInstance);


        // 2. StorageManager
        InternalComponent storageManagerIc = DeploymentFactory.eINSTANCE.createInternalComponent();
        InternalComponentInstance storageManagerInstance = DeploymentFactory.eINSTANCE.createInternalComponentInstance();

        storageManagerIc.setName("StorageManager");

        InternalComponentInstance storageManagerResource = DeploymentFactory.eINSTANCE.createInternalComponentInstance();
        storageManagerResource.setName("StorageManager");

        Configuration storageManagerResourceConf = DeploymentFactory.eINSTANCE.createConfiguration();
        storageManagerResourceConf.setDownloadCommand("wget https://github.com/kliput/scalarm_service_scripts/archive/paasage.tar.gz && sudo apt-get update && sudo apt-get install -y groovy ant && tar -zxvf paasage.tar.gz && cd scalarm_service_scripts-paasage");
        storageManagerResourceConf.setInstallCommand("cd scalarm_service_scripts-paasage && ./storage_manager_install.sh");
        storageManagerResourceConf.setStartCommand("cd scalarm_service_scripts-paasage && ./storage_manager_start.sh");
        storageManagerIc.getConfigurations().add(storageManagerResourceConf);


        ProvidedCommunication storageManagerProvidedCommunicationMongodNnginx = DeploymentFactory.eINSTANCE.createProvidedCommunication();
        storageManagerProvidedCommunicationMongodNnginx.setName("StorageManager_nginx");
        storageManagerProvidedCommunicationMongodNnginx.setPortNumber(20001);
        storageManagerIc.getProvidedCommunications().add(storageManagerProvidedCommunicationMongodNnginx);

        RequiredCommunication storgeManagerReqInfoCommunication = DeploymentFactory.eINSTANCE.createRequiredCommunication();
        storgeManagerReqInfoCommunication.setIsMandatory(true);
        storgeManagerReqInfoCommunication.setName("SotrageManager_consumes_Information Service");
        storgeManagerReqInfoCommunication.setPortNumber(11300);
        storageManagerIc.getRequiredCommunications().add(storgeManagerReqInfoCommunication);


        storageManagerInstance.setName("storageManagerInstance");
        storageManagerInstance.setType(storageManagerIc);


        ProvidedCommunicationInstance storageManagerProvidedCommunicationMongodNnginxInstance = DeploymentFactory.eINSTANCE.createProvidedCommunicationInstance();
        storageManagerProvidedCommunicationMongodNnginxInstance.setName("storageManagerProvidedCommunicationMongodNnginxInstance");
        storageManagerProvidedCommunicationMongodNnginxInstance.setType(storageManagerProvidedCommunicationMongodNnginx);
        storageManagerInstance.getProvidedCommunicationInstances().add(storageManagerProvidedCommunicationMongodNnginxInstance);

        RequiredCommunicationInstance storgeManagerReqInfoCommunicationInstance = DeploymentFactory.eINSTANCE.createRequiredCommunicationInstance();
        storgeManagerReqInfoCommunicationInstance.setName("storgeManagerReqInfoCommunicationInstance");
        storgeManagerReqInfoCommunicationInstance.setType(storgeManagerReqInfoCommunication);
        storageManagerInstance.getRequiredCommunicationInstances().add(storgeManagerReqInfoCommunicationInstance);


        storageManagerIc.setRequiredHost(cpuIntensiveUbuntuGermanyHostReq);
        storageManagerInstance.setRequiredHostInstance(cpuIntensiveUbuntuGermanyHostReqInstance);
        scalarmDeploymentModel.getInternalComponents().add(storageManagerIc);
        scalarmDeploymentModel.getInternalComponentInstances().add(storageManagerInstance);


        // Information Service
        InternalComponent informationManagerIc = DeploymentFactory.eINSTANCE.createInternalComponent();
        informationManagerIc.setName("InfomrationService");

        InternalComponentInstance informationManagerResource = DeploymentFactory.eINSTANCE.createInternalComponentInstance();
        informationManagerResource.setName("InfomrationService");

        Configuration informationManagerResourceConf = DeploymentFactory.eINSTANCE.createConfiguration();
        informationManagerResourceConf.setDownloadCommand("wget https://github.com/kliput/scalarm_service_scripts/archive/paasage.tar.gz && sudo apt-get update && sudo apt-get install -y groovy ant && tar -zxvf paasage.tar.gz && cd scalarm_service_scripts-paasage");
        informationManagerResourceConf.setInstallCommand("cd scalarm_service_scripts-paasage && ./information_service_install.sh");
        informationManagerResourceConf.setStartCommand("cd scalarm_service_scripts-paasage && ./information_service_start.sh");
        informationManagerIc.getConfigurations().add(informationManagerResourceConf);


        ProvidedCommunication informationManagerProvidedCommunication = DeploymentFactory.eINSTANCE.createProvidedCommunication();
        informationManagerProvidedCommunication.setName("InfomrationService");
        informationManagerProvidedCommunication.setPortNumber(11300);
        informationManagerIc.getProvidedCommunications().add(informationManagerProvidedCommunication);


        InternalComponentInstance informationManagerInstance = DeploymentFactory.eINSTANCE.createInternalComponentInstance();
        informationManagerInstance.setName("informationManagerInstance");
        informationManagerInstance.setType(informationManagerIc);


        ProvidedCommunicationInstance informationManagerProvidedCommunicationInstance = DeploymentFactory.eINSTANCE.createProvidedCommunicationInstance();
        informationManagerProvidedCommunicationInstance.setName("informationManagerProvidedCommunicationInstance");
        informationManagerProvidedCommunicationInstance.setType(informationManagerProvidedCommunication);
        informationManagerInstance.getProvidedCommunicationInstances().add(informationManagerProvidedCommunicationInstance);


        informationManagerIc.setRequiredHost(coreIntensiveUbuntuGermanyHostReq);
        informationManagerInstance.setRequiredHostInstance(coreIntensiveUbuntuGermanyHostReqInstance);
        scalarmDeploymentModel.getInternalComponents().add(informationManagerIc);
        scalarmDeploymentModel.getInternalComponentInstances().add(informationManagerInstance);


        // SimulationManager
        InternalComponent simulationManagerIc = DeploymentFactory.eINSTANCE.createInternalComponent();

        simulationManagerIc.setName("SimulationManager");

        InternalComponentInstance simulationManagerResource = DeploymentFactory.eINSTANCE.createInternalComponentInstance();
        simulationManagerResource.setName("SimulationManager");

        Configuration simulationManagerResourceConf = DeploymentFactory.eINSTANCE.createConfiguration();
        simulationManagerResourceConf.setDownloadCommand("wget https://github.com/kliput/scalarm_service_scripts/archive/paasage.tar.gz && sudo apt-get update && sudo apt-get install -y groovy ant && tar -zxvf paasage.tar.gz && cd scalarm_service_scripts-paasage");
        simulationManagerResourceConf.setInstallCommand("cd scalarm_service_scripts-paasage && ./simulation_manager_install.sh");
        simulationManagerResourceConf.setStartCommand("cd scalarm_service_scripts-paasage && ./simulation_manager_start.sh");
        simulationManagerIc.getConfigurations().add(simulationManagerResourceConf);


        RequiredCommunication similationManagerReqInfoCommunication = DeploymentFactory.eINSTANCE.createRequiredCommunication();
        similationManagerReqInfoCommunication.setIsMandatory(true);
        similationManagerReqInfoCommunication.setName("SimulationManagerr_consumes_Information Service");
        similationManagerReqInfoCommunication.setPortNumber(11300);
        simulationManagerIc.getRequiredCommunications().add(similationManagerReqInfoCommunication);

        RequiredCommunication simulationManagerReqStorCommunication = DeploymentFactory.eINSTANCE.createRequiredCommunication();
        simulationManagerReqStorCommunication.setIsMandatory(true);
        simulationManagerReqStorCommunication.setName("SimulationManagerr_consumes_StorageManager");
        simulationManagerReqStorCommunication.setPortNumber(20001);
        simulationManagerIc.getRequiredCommunications().add(simulationManagerReqStorCommunication);

        RequiredCommunication similationManagerReqExpCommunication = DeploymentFactory.eINSTANCE.createRequiredCommunication();
        similationManagerReqExpCommunication.setIsMandatory(true);
        similationManagerReqExpCommunication.setName("SimulationManagerr_consumes_Experiment Manager");
        similationManagerReqExpCommunication.setPortNumber(443);
        simulationManagerIc.getRequiredCommunications().add(similationManagerReqExpCommunication);

        InternalComponentInstance simulationManagerInstance = DeploymentFactory.eINSTANCE.createInternalComponentInstance();
        simulationManagerInstance.setName("simulationManagerInstance");
        simulationManagerInstance.setType(simulationManagerIc);

        RequiredCommunicationInstance similationManagerReqInfoCommunicationInstance = DeploymentFactory.eINSTANCE.createRequiredCommunicationInstance();
        similationManagerReqInfoCommunicationInstance.setName("similationManagerReqInfoCommunicationInstance");
        similationManagerReqInfoCommunicationInstance.setType(similationManagerReqInfoCommunication);
        simulationManagerInstance.getRequiredCommunicationInstances().add(similationManagerReqInfoCommunicationInstance);

        RequiredCommunicationInstance simulationManagerReqStorCommunicationInstance = DeploymentFactory.eINSTANCE.createRequiredCommunicationInstance();
        simulationManagerReqStorCommunicationInstance.setName("simulationManagerReqStorCommunicationInstance");
        simulationManagerReqStorCommunicationInstance.setType(simulationManagerReqStorCommunication);
        simulationManagerInstance.getRequiredCommunicationInstances().add(simulationManagerReqStorCommunicationInstance);

        RequiredCommunicationInstance similationManagerReqExpCommunicationInstance = DeploymentFactory.eINSTANCE.createRequiredCommunicationInstance();
        similationManagerReqExpCommunicationInstance.setName("similationManagerReqExpCommunicationInstance");
        similationManagerReqExpCommunicationInstance.setType(similationManagerReqExpCommunication);
        simulationManagerInstance.getRequiredCommunicationInstances().add(similationManagerReqExpCommunicationInstance);


        simulationManagerIc.setRequiredHost(storageIntensiveUbuntuGermanyHostReq);
        simulationManagerInstance.setRequiredHostInstance(storageIntensiveUbuntuGermanyHostReqInstance);
        scalarmDeploymentModel.getInternalComponents().add(simulationManagerIc);
        scalarmDeploymentModel.getInternalComponentInstances().add(simulationManagerInstance);


        // Define communications between instances

        Communication experimentManagerToStorageManager = DeploymentFactory.eINSTANCE.createCommunication();
        experimentManagerToStorageManager.setName("experimentManagerToStorageManager");
        experimentManagerToStorageManager.setProvidedCommunication(storageManagerProvidedCommunicationMongodNnginx);
        experimentManagerToStorageManager.setRequiredCommunication(experimentManagerReqStorageCommunication);
        scalarmDeploymentModel.getCommunications().add(experimentManagerToStorageManager);

        CommunicationInstance experimentManagerToStorageManagerInstance = DeploymentFactory.eINSTANCE.createCommunicationInstance();
        experimentManagerToStorageManagerInstance.setName("experimentManagerToStorageManagerInstance");
        experimentManagerToStorageManagerInstance.setProvidedCommunicationInstance(storageManagerProvidedCommunicationMongodNnginxInstance);
        experimentManagerToStorageManagerInstance.setRequiredCommunicationInstance(experimentManagerReqStorageCommunicationInstance);
        experimentManagerToStorageManagerInstance.setType(experimentManagerToStorageManager);
        scalarmDeploymentModel.getCommunicationInstances().add(experimentManagerToStorageManagerInstance);

        // All consumes InfomrationService port
        // //experimentManagerToInformationService
        Communication experimentManagerToInformationService = DeploymentFactory.eINSTANCE.createCommunication();
        experimentManagerToInformationService.setName("experimentManagerToInformationService");
        experimentManagerToInformationService.setProvidedCommunication(informationManagerProvidedCommunication);
        experimentManagerToInformationService.setRequiredCommunication(experimentManagerReqInfoCommunication);
        scalarmDeploymentModel.getCommunications().add(experimentManagerToInformationService);

        CommunicationInstance experimentManagerToInformationServiceInstance = DeploymentFactory.eINSTANCE.createCommunicationInstance();
        experimentManagerToInformationServiceInstance.setName("experimentManagerToInformationServiceInstance");
        experimentManagerToInformationServiceInstance.setProvidedCommunicationInstance(informationManagerProvidedCommunicationInstance);
        experimentManagerToInformationServiceInstance.setRequiredCommunicationInstance(experimentManagerReqInfoCommunicationInstance);
        experimentManagerToInformationServiceInstance.setType(experimentManagerToInformationService);
        scalarmDeploymentModel.getCommunicationInstances().add(experimentManagerToInformationServiceInstance);

        // storageManagerToInformationService
        Communication storageManagerToInformationService = DeploymentFactory.eINSTANCE.createCommunication();
        storageManagerToInformationService.setName("storageManagerToInformationService");
        storageManagerToInformationService.setProvidedCommunication(storageManagerProvidedCommunicationMongodNnginx);
        storageManagerToInformationService.setRequiredCommunication(storgeManagerReqInfoCommunication);
        scalarmDeploymentModel.getCommunications().add(storageManagerToInformationService);

        CommunicationInstance storageManagerToInformationServiceInstance = DeploymentFactory.eINSTANCE.createCommunicationInstance();
        storageManagerToInformationServiceInstance.setName("storageManagerToInformationServiceInstance");
        storageManagerToInformationServiceInstance.setProvidedCommunicationInstance(storageManagerProvidedCommunicationMongodNnginxInstance);
        storageManagerToInformationServiceInstance.setRequiredCommunicationInstance(storgeManagerReqInfoCommunicationInstance);
        storageManagerToInformationServiceInstance.setType(storageManagerToInformationService);
        scalarmDeploymentModel.getCommunicationInstances().add(storageManagerToInformationServiceInstance);

        // simulationManagerToInformationService
        Communication simulationManagerToInformationService = DeploymentFactory.eINSTANCE.createCommunication();
        simulationManagerToInformationService.setName("simulationManagerToInformationService");
        simulationManagerToInformationService.setProvidedCommunication(informationManagerProvidedCommunication);
        simulationManagerToInformationService.setRequiredCommunication(similationManagerReqInfoCommunication);
        scalarmDeploymentModel.getCommunications().add(simulationManagerToInformationService);

        CommunicationInstance simulationManagerToInformationServiceInstance = DeploymentFactory.eINSTANCE.createCommunicationInstance();
        simulationManagerToInformationServiceInstance.setName("simulationManagerToInformationServiceInstance");
        simulationManagerToInformationServiceInstance.setProvidedCommunicationInstance(informationManagerProvidedCommunicationInstance);
        simulationManagerToInformationServiceInstance.setRequiredCommunicationInstance(similationManagerReqInfoCommunicationInstance);
        simulationManagerToInformationServiceInstance.setType(simulationManagerToInformationService);
        scalarmDeploymentModel.getCommunicationInstances().add(simulationManagerToInformationServiceInstance);

        // Simulation Manager consumes all
        // simulationManagerToStorageManager
        Communication simulationManagerToStorageManager = DeploymentFactory.eINSTANCE.createCommunication();
        simulationManagerToStorageManager.setName("simulationManagerToStorageManager");
        simulationManagerToStorageManager.setProvidedCommunication(storageManagerProvidedCommunicationMongodNnginx);
        simulationManagerToStorageManager.setRequiredCommunication(simulationManagerReqStorCommunication);
        scalarmDeploymentModel.getCommunications().add(simulationManagerToStorageManager);

        CommunicationInstance simulationManagerToStorageManagerInstance = DeploymentFactory.eINSTANCE.createCommunicationInstance();
        simulationManagerToStorageManagerInstance.setName("simulationManagerToStorageManagerInstance");
        simulationManagerToStorageManagerInstance.setProvidedCommunicationInstance(storageManagerProvidedCommunicationMongodNnginxInstance);
        simulationManagerToStorageManagerInstance.setRequiredCommunicationInstance(simulationManagerReqStorCommunicationInstance);
        simulationManagerToStorageManagerInstance.setType(simulationManagerToStorageManager);
        scalarmDeploymentModel.getCommunicationInstances().add(simulationManagerToStorageManagerInstance);

        // Simulation Manager consumes Experiment Manager
        Communication simulationManagerToExperimentManager = DeploymentFactory.eINSTANCE.createCommunication();
        simulationManagerToExperimentManager.setName("simulationManagerToExperimentManager");
        simulationManagerToExperimentManager.setProvidedCommunication(experimentManagerProvidedCommunication);
        simulationManagerToExperimentManager.setRequiredCommunication(similationManagerReqExpCommunication);
        scalarmDeploymentModel.getCommunications().add(simulationManagerToExperimentManager);

        CommunicationInstance simulationManagerToExperimentManagerInstance = DeploymentFactory.eINSTANCE.createCommunicationInstance();
        simulationManagerToExperimentManagerInstance.setName("simulationManagerToExperimentManagerInstance");
        simulationManagerToExperimentManagerInstance.setProvidedCommunicationInstance(experimentManagerProvidedCommunicationInstance);
        simulationManagerToExperimentManagerInstance.setRequiredCommunicationInstance(similationManagerReqExpCommunicationInstance);
        simulationManagerToExperimentManagerInstance.setType(simulationManagerToExperimentManager);
        scalarmDeploymentModel.getCommunicationInstances().add(simulationManagerToExperimentManagerInstance);

        return scalarmDeploymentModel ;
    }

}
