package eu.paasage.camel.agh.scalarm.model.submodels.organizations;

import org.eclipse.emf.common.util.EList;
import org.javatuples.Pair;

import eu.paasage.camel.organisation.CloudProvider;
import eu.paasage.camel.organisation.Credentials;
import eu.paasage.camel.organisation.OrganisationFactory;
import eu.paasage.camel.organisation.OrganisationModel;
import eu.paasage.camel.organisation.Organization;
import eu.paasage.camel.organisation.User;

/**
 * @author orzech, nikolayn
 */
public class ScalarmSintefOrganizationModel {

    public static Pair<OrganisationModel, User> createSintefOrganizationModel(CloudProvider flexiantCloudProvider, CloudProvider gwdgCloudProvider) {

        OrganisationModel sintefOrgModel = OrganisationFactory.eINSTANCE.createOrganisationModel();
        EList<User> sintefUsers = sintefOrgModel.getUsers();

        User user1 = OrganisationFactory.eINSTANCE.createUser();
        user1.setEmail("user@sintef.no");
        user1.setFirstName("User1");
        user1.setLastName("User");

        sintefUsers.add(user1);

        Credentials user1FlexiantCredentials = OrganisationFactory.eINSTANCE.createCredentials();
        user1FlexiantCredentials.setCloudProvider(flexiantCloudProvider);
        user1FlexiantCredentials.setPrivateSSHKey("To be defined");
        user1FlexiantCredentials.setPublicSSHKey("To be defined");
        user1FlexiantCredentials.setSecurityGroup("To be defined");
        
        user1.getCredentials().add(user1FlexiantCredentials);
        
        Credentials user1GWDGCredentials = OrganisationFactory.eINSTANCE.createCredentials();
        user1GWDGCredentials.setCloudProvider(gwdgCloudProvider);
        user1GWDGCredentials.setPrivateSSHKey("To be defined");
        user1GWDGCredentials.setPublicSSHKey("To be defined");
        user1GWDGCredentials.setSecurityGroup("To be defined");
        
        user1.getCredentials().add(user1GWDGCredentials);
        
        Organization sintefOrganization = OrganisationFactory.eINSTANCE.createOrganization();
        sintefOrganization.setEmail("contact@sintef.no");
        sintefOrganization.setName("SINTEF");
        sintefOrganization.setPostalAddress("SINTEF, Pb. 124 Blindern, 0314 Oslo");
        sintefOrganization.setWww("http://www.sintef.no/");

        sintefOrgModel.setOrganization(sintefOrganization);
        
        return new Pair<OrganisationModel, User>(sintefOrgModel, user1);
    }

}
