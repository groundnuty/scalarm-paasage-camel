package eu.paasage.camel.agh.scalarm.model.submodels.organizations;

import org.eclipse.emf.common.util.EList;
import org.javatuples.Triplet;

import eu.paasage.camel.organisation.CloudProvider;
import eu.paasage.camel.organisation.Credentials;
import eu.paasage.camel.organisation.DataCenter;
import eu.paasage.camel.organisation.Location;
import eu.paasage.camel.organisation.OrganisationFactory;
import eu.paasage.camel.organisation.OrganisationModel;
import eu.paasage.camel.provider.ProviderModel;

/**
 * @author orzech 
 * 
 */
public class ScalarmGWDGOrganizationModel {

    public static Triplet<OrganisationModel, CloudProvider, Location> createGWDGOrganizationModel(ProviderModel providerModel) {

        OrganisationModel gwdgOrgModel = OrganisationFactory.eINSTANCE.createOrganisationModel();
        EList<DataCenter> gwdgDCs = gwdgOrgModel.getDataCentres();
        EList<Location> gwdgLocs = gwdgOrgModel.getLocations();
        
        EList<Credentials> gwdgCredentials = gwdgOrgModel.getCredentials();

        CloudProvider gwdgProvider = OrganisationFactory.eINSTANCE.createCloudProvider();
        gwdgProvider.setEmail("contact@gwdg.de");
        gwdgProvider.setIaaS(true);
        gwdgProvider.setName("GWDG");
        gwdgProvider.setPaaS(true);
        gwdgProvider.setProviderModel(providerModel);
        gwdgProvider.setPublic(false);
        gwdgProvider.setSaaS(false);

        gwdgOrgModel.setProvider(gwdgProvider);
        
        Credentials user1gwdgCredentials = OrganisationFactory.eINSTANCE.createCredentials();
        user1gwdgCredentials.setCloudProvider(gwdgProvider);
        gwdgCredentials.add(user1gwdgCredentials);
        
        Location gwdgLocation = OrganisationFactory.eINSTANCE.createLocation();
        gwdgLocation.setCountry("Germany");
        gwdgLocation.setCity("Goettingen");
        gwdgLocation.setLatitude(0);
        gwdgLocation.setLongitude(0);
        gwdgLocation.setName("goettingen-dc");

        gwdgLocs.add(gwdgLocation);

        DataCenter gwdgDataCenter = OrganisationFactory.eINSTANCE.createDataCenter();
        gwdgDataCenter.setCloudProvider(gwdgProvider);
        gwdgDataCenter.setCodeName("gdc");
        gwdgDataCenter.setLocation(gwdgLocation);
        gwdgDataCenter.setName("Goettingen Data Centre");

        gwdgDCs.add(gwdgDataCenter);

        return new Triplet<OrganisationModel, CloudProvider, Location>(gwdgOrgModel, gwdgProvider, gwdgLocation);
    }

}
