package eu.paasage.camel.agh.scalarm.model;

import eu.paasage.camel.agh.scalarm.model.submodels.*;
import eu.paasage.camel.agh.scalarm.model.submodels.organizations.*;
import eu.paasage.camel.requirement.RequirementModel;
import eu.paasage.camel.type.TypeModel;
import org.eclipse.emf.ecore.EObject;

import eu.paasage.camel.CamelFactory;
import eu.paasage.camel.CamelModel;
import eu.paasage.camel.deployment.DeploymentModel;
import eu.paasage.camel.provider.ProviderModel;

/**
 * @author orzech
 */
public class ScalarmModel {

	public static EObject createScalarmModel() {

		CamelModel camelModel = CamelFactory.eINSTANCE.createCamelModel();
		camelModel.setName("Scalarm Camel Model");

		camelModel.getUnitModels().add(ScalarmUnitModel.createUnitModel());
		TypeModel typeModel = ScalarmTypeModel.createTypeModel() ;
		camelModel.getTypeModels().add(typeModel);
		camelModel.getLocationModels().add(ScalarmLocationModel.createLocationModel());


		ProviderModel gwdgProviderModel = ScalarmGWDGProviderModel.createGWDGProviderModel();
		camelModel.getProviderModels().add(gwdgProviderModel);
		camelModel.getOrganisationModels().add(AGHOrganisationModel.createAGHOrganisationModel());
		camelModel.getOrganisationModels().add(ScalarmGWDGOrganizationModel.createGWDGOrganizationModel(gwdgProviderModel));

		RequirementModel scalarmRequirementModel = ScalarmRequirmentModel.createScalarmRequirmentModel() ;
		camelModel.getRequirementModels().add(scalarmRequirementModel);
		DeploymentModel scalarmDeploymentModel = ScalarmDepolymentModel.createScalarmDepolymentModel() ;
		camelModel.getDeploymentModels().add(scalarmDeploymentModel);
		camelModel.getMetricModels().add(ScalarmMetricsModel.createScalarmMetricsModel());
		camelModel.getScalabilityModels().add(ScalarmScalabilityModel.createMyScalabilityModel());
		camelModel.getExecutionModels().add(ScalarmExecutionModel.createExecutionModel(scalarmDeploymentModel,camelModel,scalarmRequirementModel));


		return camelModel;

	}
}
