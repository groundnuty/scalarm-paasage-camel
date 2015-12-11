package eu.paasage.camel.agh.scalarm.model.submodels.organizations;

import eu.paasage.camel.location.Location;
import eu.paasage.camel.organisation.*;
import eu.paasage.camel.provider.ProviderModel;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Triplet;

/**
 * Created by orzech on 08/12/15.
 */
public class AGHOrganisationModel {

    public static User morzech ;

    public static  OrganisationModel createAGHOrganisationModel() {

        OrganisationModel AGHOrgModel = OrganisationFactory.eINSTANCE.createOrganisationModel();

        Organisation AGHOrg = OrganisationFactory.eINSTANCE.createOrganisation();
        AGHOrg.setName("AGH University of Science and Technology");
        AGHOrg.setPostalAddress("al. Mickiewicza 30, 30-059 Krakow, Poland");
        AGHOrg.setWww("http://www.agh.edu.pl/en/");
        AGHOrg.setEmail("morzech@agh.edu.pl");
        AGHOrgModel.setOrganisation(AGHOrg);

        User morzech = OrganisationFactory.eINSTANCE.createUser();
        morzech.setFirstName("Michal");
        morzech.setLastName("Orzechowski");
        morzech.setEmail("morzech@agh.edu.pl");

        PaaSageCredentials morzechCredentials = OrganisationFactory.eINSTANCE.createPaaSageCredentials();
        morzechCredentials.setPassword("morzech_at_agh_dot_edu_dot_pl");
        morzech.setPaasageCredentials(morzechCredentials);

        AGHOrgModel.getUsers().add(morzech);

        AGHOrgModel.setSecurityLevel(SecurityLevel.HIGH);

        AGHOrganisationModel.morzech = morzech ;

        return AGHOrgModel;

    }
}
