package eu.paasage.camel.agh.scalarm.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import eu.paasage.camel.CamelFactory;
import eu.paasage.camel.CamelModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmDepolymentModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmExecutionModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmFlexiantProviderModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmGWDGProviderModel;
import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmScalabilityModel;
import eu.paasage.camel.agh.scalarm.model.submodels.organizations.ScalarmFlexiantOrganizationModel;
import eu.paasage.camel.agh.scalarm.model.submodels.organizations.ScalarmGWDGOrganizationModel;
import eu.paasage.camel.agh.scalarm.model.submodels.organizations.ScalarmSintefOrganizationModel;
import eu.paasage.camel.deployment.DeploymentModel;
import eu.paasage.camel.deployment.InternalComponent;
import eu.paasage.camel.deployment.InternalComponentInstance;
import eu.paasage.camel.deployment.VM;
import eu.paasage.camel.deployment.VMInstance;
import eu.paasage.camel.execution.ExecutionContext;
import eu.paasage.camel.execution.ExecutionModel;
import eu.paasage.camel.organisation.CloudProvider;
import eu.paasage.camel.organisation.Location;
import eu.paasage.camel.organisation.OrganisationModel;
import eu.paasage.camel.organisation.User;
import eu.paasage.camel.provider.Constraint;
import eu.paasage.camel.provider.Feature;
import eu.paasage.camel.provider.ProviderModel;
import eu.paasage.camel.scalability.HorizontalScalabilityPolicy;
import eu.paasage.camel.scalability.ScalabilityModel;

/**
 * @author orzech
 */
public class ScalarmModel {

	public static EObject createScalarmModel() {
		CamelModel camelModel = CamelFactory.eINSTANCE.createCamelModel();
		EList<OrganisationModel> orgModels = camelModel.getOrganisationModels();

		// ProviderModel
		Triplet<ProviderModel, Feature, Constraint> flexiantProviderReturns = ScalarmFlexiantProviderModel
				.createFlexiantProviderModel();
		ProviderModel flexiantProviderModel = flexiantProviderReturns
				.getValue0();
		Feature vmFeature = flexiantProviderReturns.getValue1();
		Constraint mediumVmConstraint = flexiantProviderReturns.getValue2();
		camelModel.getProviderModels().add(flexiantProviderModel);

		ProviderModel gwdgProviderModel = ScalarmGWDGProviderModel
				.createGWDGProviderModel();
		camelModel.getProviderModels().add(gwdgProviderModel);

		/*
		 * the Amazon organization model is not used for the example
		 * 
		 * Triplet<OrganisationModel, CloudProvider, Location> amazonReturns =
		 * ScalarmAmazonOrganizationModel
		 * .createAmazonOrganizationModel(flexiantProviderModel);
		 * OrganisationModel amazonOrgModel = amazonReturns.getValue0();
		 * CloudProvider amazonProvider = amazonReturns.getValue1(); Location
		 * amazonEuLocation = amazonReturns.getValue2();
		 * orgModels.add(amazonOrgModel);
		 */

		// Flexiant organization model
		Triplet<OrganisationModel, CloudProvider, Location> flexiantReturns = ScalarmFlexiantOrganizationModel
				.createFlexiantOrganizationModel(flexiantProviderModel);
		OrganisationModel flexiantOrgModel = flexiantReturns.getValue0();
		CloudProvider flexiantProvider = flexiantReturns.getValue1();
		// Location flexiantLocation = flexiantReturns.getValue2();
		orgModels.add(flexiantOrgModel);

		// GWDG organization model
		Triplet<OrganisationModel, CloudProvider, Location> gwdgReturns = ScalarmGWDGOrganizationModel
				.createGWDGOrganizationModel(gwdgProviderModel);
		OrganisationModel gwdgOrgModel = gwdgReturns.getValue0();
		CloudProvider gwdgProvider = gwdgReturns.getValue1();
		Location gwdgLocation = gwdgReturns.getValue2();
		orgModels.add(gwdgOrgModel);

		// SINTEF organization model
		Pair<OrganisationModel, User> sintefReturns = ScalarmSintefOrganizationModel
				.createSintefOrganizationModel(flexiantProvider, gwdgProvider);
		OrganisationModel sintefOrgModel = sintefReturns.getValue0();
		User user1 = sintefReturns.getValue1();

		orgModels.add(sintefOrgModel);

		// Deployment
		Quintet<DeploymentModel, Quartet<InternalComponent, InternalComponent, InternalComponent, InternalComponent>, Quartet<InternalComponentInstance, InternalComponentInstance, InternalComponentInstance, InternalComponentInstance>, Quartet<VMInstance, VMInstance, VMInstance, VMInstance>, VM> deploymentReturn = ScalarmDepolymentModel
				.createScalarmDepolymentModel(gwdgProvider, gwdgLocation,
						camelModel, vmFeature, mediumVmConstraint);

		DeploymentModel sensAppDeploymentModel = deploymentReturn.getValue0();
		Quartet<InternalComponent, InternalComponent, InternalComponent, InternalComponent> internalComponentReturns = deploymentReturn
				.getValue1();
		// InternalComponent experimentManagerIc =
		// internalComponentReturns.getValue0();
		// InternalComponent informationManagerIc =
		// internalComponentReturns.getValue1();
		// InternalComponent storageManagerIc =
		// internalComponentReturns.getValue2();
		InternalComponent simulationManagerIc = internalComponentReturns
				.getValue3();

		Quartet<InternalComponentInstance, InternalComponentInstance, InternalComponentInstance, InternalComponentInstance> internalComponentInstancesReturns = deploymentReturn
				.getValue2();
		// InternalComponentInstance experimentManagerInstance =
		// internalComponentInstancesReturns.getValue0();
		// InternalComponentInstance informationManagerInstance =
		// internalComponentInstancesReturns.getValue1();
		// InternalComponentInstance storageManagerInstance =
		// internalComponentInstancesReturns.getValue2();
		InternalComponentInstance simulationManagerInstance = internalComponentInstancesReturns
				.getValue3();

		Quartet<VMInstance, VMInstance, VMInstance, VMInstance> vmInstancesReturns = deploymentReturn
				.getValue3();
		// VMInstance experimentManagerVMInstance =
		// vmInstancesReturns.getValue0();
		// VMInstance informationManagerVMInstance =
		// vmInstancesReturns.getValue1();
		// VMInstance storageManagerVMInstance = vmInstancesReturns.getValue2();
		VMInstance simulationManagerVMInstance = vmInstancesReturns.getValue3();

		// VM firstVMTemplate = deploymentReturn.getValue4();

		camelModel.getDeploymentModels().add(sensAppDeploymentModel);

		// Scalability
		Triplet<ScalabilityModel, ExecutionContext, HorizontalScalabilityPolicy> scalabilitReturns = ScalarmScalabilityModel
				.createMyScalabilityModel(simulationManagerIc,
						simulationManagerInstance, simulationManagerVMInstance);
		ScalabilityModel scalabilityModel = scalabilitReturns.getValue0();
		ExecutionContext scalarmExecutionContext = scalabilitReturns
				.getValue1();
		HorizontalScalabilityPolicy horizontalPolicyScalarm = scalabilitReturns
				.getValue2();
		camelModel.getScalabilityModels().add(scalabilityModel);
		
		// add the scalability policy to the user that defined it
		user1.getRequirements().add(horizontalPolicyScalarm);
		
		// Execution
		ExecutionModel execModel = ScalarmExecutionModel
				.createExecutionModel(sensAppDeploymentModel, camelModel,
						scalarmExecutionContext, horizontalPolicyScalarm, user1);
		camelModel.getExecutionModels().add(execModel);

		return camelModel;

	}
}
