package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.Application;
import eu.paasage.camel.CamelFactory;
import eu.paasage.camel.CamelModel;
import eu.paasage.camel.requirement.RequirementGroup;
import eu.paasage.camel.agh.scalarm.model.submodels.organizations.AGHOrganisationModel;
import eu.paasage.camel.deployment.DeploymentModel;
import eu.paasage.camel.execution.ExecutionContext;
import eu.paasage.camel.execution.ExecutionFactory;
import eu.paasage.camel.execution.ExecutionModel;
import eu.paasage.camel.organisation.User;
import eu.paasage.camel.requirement.RequirementFactory;
import eu.paasage.camel.requirement.RequirementModel;
import eu.paasage.camel.requirement.RequirementOperatorType;


/**
 * @author orzech
 */
public class ScalarmExecutionModel {

    public static ExecutionModel createExecutionModel(DeploymentModel scalarmDeploymentModel, CamelModel camelModel,
                                                      RequirementModel scalarmRequirmentModel) {

        ExecutionModel execModel = ExecutionFactory.eINSTANCE.createExecutionModel();
        execModel.setName("Scalarm Execution Model");

        Application scalarmApplicatin = CamelFactory.eINSTANCE.createApplication();
        scalarmApplicatin.getDeploymentModels().add(scalarmDeploymentModel);
        scalarmApplicatin.setName("Scalarm");
        scalarmApplicatin.setOwner(AGHOrganisationModel.morzech);
        scalarmApplicatin.setVersion("v1.0");
        camelModel.getApplications().add(scalarmApplicatin);

        RequirementGroup morzechRG = RequirementFactory.eINSTANCE.createRequirementGroup();
        morzechRG.setName("morzechRG");
        morzechRG.setRequirementOperator(RequirementOperatorType.OR);
        morzechRG.getRequirements().add(ScalarmRequirmentModel.horizontalScaleSimulationManager);
        scalarmRequirmentModel.getRequirements().add(morzechRG);

        ExecutionContext scalarmExecutionContext = ExecutionFactory.eINSTANCE.createExecutionContext();
        scalarmExecutionContext.setApplication(scalarmApplicatin);
        scalarmExecutionContext.setDeploymentModel(scalarmDeploymentModel);
        scalarmExecutionContext.setName("ScalarmEC1");
        scalarmExecutionContext.setRequirementGroup(morzechRG);
        scalarmExecutionContext.setTotalCost(0);
        execModel.getExecutionContexts().add(scalarmExecutionContext);

        return execModel;

    }
}
