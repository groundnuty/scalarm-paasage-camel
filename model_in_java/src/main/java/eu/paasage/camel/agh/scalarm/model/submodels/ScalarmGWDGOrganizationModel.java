package eu.paasage.camel.agh.scalarm.model.submodels.organizations;

import eu.paasage.camel.agh.scalarm.model.submodels.ScalarmLocationModel;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Triplet;

import eu.paasage.camel.organisation.CloudProvider;
import eu.paasage.camel.organisation.DataCenter;
import eu.paasage.camel.organisation.OrganisationFactory;
import eu.paasage.camel.organisation.OrganisationModel;
import eu.paasage.camel.provider.ProviderModel;

/**
 * @author orzech 
 * 
 */
public class ScalarmGWDGOrganizationModel {

    public static OrganisationModel createGWDGOrganizationModel(ProviderModel providerModel) {

        OrganisationModel gwdgOrgModel = OrganisationFactory.eINSTANCE.createOrganisationModel();

        CloudProvider gwdgProvider = OrganisationFactory.eINSTANCE.createCloudProvider();
        gwdgProvider.setEmail("gwdg@gwdg.de");
        gwdgProvider.setWww("www.gwdg.de");
        gwdgProvider.setIaaS(true);
        gwdgProvider.setName("GWDG");
        gwdgProvider.setPaaS(false);
        gwdgProvider.setProviderModel(providerModel);
        gwdgProvider.setPublic(true);
        gwdgProvider.setSaaS(false);

        gwdgOrgModel.setProvider(gwdgProvider);

        DataCenter gwdgDataCenter = OrganisationFactory.eINSTANCE.createDataCenter();
        gwdgDataCenter.setCodeName("gwdg");
        gwdgDataCenter.setLocation(ScalarmLocationModel.germany);
       gwdgOrgModel.getDataCentres().add(gwdgDataCenter);


        return gwdgOrgModel;
    }

}
