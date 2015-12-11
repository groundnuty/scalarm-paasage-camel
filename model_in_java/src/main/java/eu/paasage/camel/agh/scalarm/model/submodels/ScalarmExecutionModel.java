package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.Application;
import eu.paasage.camel.CamelFactory;
import eu.paasage.camel.CamelModel;
import eu.paasage.camel.RequirementGroup;
import eu.paasage.camel.RequirementOperatorType;
import eu.paasage.camel.deployment.DeploymentModel;
import eu.paasage.camel.execution.ExecutionContext;
import eu.paasage.camel.execution.ExecutionFactory;
import eu.paasage.camel.execution.ExecutionModel;
import eu.paasage.camel.organisation.User;
import eu.paasage.camel.scalability.HorizontalScalabilityPolicy;

/**
 * @author orzech
 */
public class ScalarmExecutionModel {

    public static ExecutionModel createExecutionModel(DeploymentModel scalarmDeploymentModel, CamelModel camelModel, ExecutionContext scalarmExecutionContext,
                                                        HorizontalScalabilityPolicy horizontalScalabilityPolicy, User user1) {
        ////// START definition of Execution model

        ExecutionModel execModel = ExecutionFactory.eINSTANCE.createExecutionModel();

        Application sensAppApplication = CamelFactory.eINSTANCE.createApplication();
        sensAppApplication.getDeploymentModels().add(scalarmDeploymentModel);
        sensAppApplication.setName("Scalarm");
        sensAppApplication.setOwner(user1);
        sensAppApplication.setVersion("v1.0");

        camelModel.getApplications().add(sensAppApplication);

        scalarmExecutionContext.setApplication(sensAppApplication);
        scalarmExecutionContext.setDeploymentModel(scalarmDeploymentModel);
        scalarmExecutionContext.setID("ScalarmEC1");

        RequirementGroup user1RG = CamelFactory.eINSTANCE.createRequirementGroup();

        user1RG.setId("user1HorizPolicySimulationManager");
        user1RG.setPriority(0);
        user1RG.setRequirementOperator(RequirementOperatorType.OR);
        user1RG.getRequirements().add(horizontalScalabilityPolicy);
        user1RG.setUser(user1);

        camelModel.getRequirements().add(user1RG);

        scalarmExecutionContext.setRequirementGroup(user1RG);
        scalarmExecutionContext.setTotalCost(0);

        execModel.getExecutionContexts().add(scalarmExecutionContext);

        // END definition of Execution model
        return execModel;

    }
}
