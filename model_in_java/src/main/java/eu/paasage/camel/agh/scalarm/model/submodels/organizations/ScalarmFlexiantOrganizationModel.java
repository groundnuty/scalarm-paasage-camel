package eu.paasage.camel.agh.scalarm.model.submodels.organizations;

import eu.paasage.camel.organisation.*;
import eu.paasage.camel.provider.ProviderModel;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Triplet;

/**
 * @author orzech
 */
public class ScalarmFlexiantOrganizationModel {

    public static Triplet<OrganisationModel, CloudProvider, Location> createFlexiantOrganizationModel(ProviderModel providerModel) {

        OrganisationModel flexiantOrgModel = OrganisationFactory.eINSTANCE.createOrganisationModel();
        EList<DataCenter> flexiantDCs = flexiantOrgModel.getDataCentres();
        EList<Location> flexiantLocs = flexiantOrgModel.getLocations();

        CloudProvider flexiantProvider = OrganisationFactory.eINSTANCE.createCloudProvider();
        flexiantProvider.setEmail("contact@flexiant.com");
        flexiantProvider.setIaaS(true);
        flexiantProvider.setName("Flexiant");
        flexiantProvider.setPaaS(true);
        flexiantProvider.setProviderModel(providerModel);
        flexiantProvider.setPublic(true);
        flexiantProvider.setSaaS(false);

        flexiantOrgModel.setProvider(flexiantProvider);

        Location flexiantLocation = OrganisationFactory.eINSTANCE.createLocation();
        flexiantLocation.setCountry("Scotland");
        flexiantLocation.setCity("Edinburgh");
        flexiantLocation.setLatitude(0);
        flexiantLocation.setLongitude(0);
        flexiantLocation.setName("flexiant");

        flexiantLocs.add(flexiantLocation);

        DataCenter flexiantEuDataCenter = OrganisationFactory.eINSTANCE.createDataCenter();
        flexiantEuDataCenter.setCloudProvider(flexiantProvider);
        flexiantEuDataCenter.setCodeName("flexiant");
        flexiantEuDataCenter.setLocation(flexiantLocation);
        flexiantEuDataCenter.setName("Flexiant Data Centre");

        flexiantDCs.add(flexiantEuDataCenter);

        return new Triplet<OrganisationModel, CloudProvider, Location>(flexiantOrgModel, flexiantProvider, flexiantLocation);

    }
}
