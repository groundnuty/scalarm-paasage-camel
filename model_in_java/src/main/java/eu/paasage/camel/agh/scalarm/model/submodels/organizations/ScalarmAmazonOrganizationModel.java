package eu.paasage.camel.agh.scalarm.model.submodels.organizations;

import eu.paasage.camel.organisation.*;
import eu.paasage.camel.provider.ProviderModel;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Triplet;

/**
 * @author orzech
 * @deprecated This model is not currently in use for the Scalarm example. The
 *             code is available in case we decide to support Amazon later on.
 */
public class ScalarmAmazonOrganizationModel {

	public static Triplet<OrganisationModel, CloudProvider, Location> createAmazonOrganizationModel(
			ProviderModel providerModel) {
		// //// BEGIN definition of Amazon Organization model

		OrganisationModel amazonOrgModel = OrganisationFactory.eINSTANCE
				.createOrganisationModel();
		EList<DataCenter> amazonDCs = amazonOrgModel.getDataCentres();
		EList<Location> amazonLocs = amazonOrgModel.getLocations();

		CloudProvider amazonProvider = OrganisationFactory.eINSTANCE
				.createCloudProvider();
		amazonProvider.setEmail("contact@amazon.com");
		amazonProvider.setIaaS(true);
		amazonProvider.setName("Amazon");
		amazonProvider.setPaaS(true);
		amazonProvider.setProviderModel(providerModel);
		amazonProvider.setPublic(true);
		amazonProvider.setSaaS(true);

		amazonOrgModel.setProvider(amazonProvider);

		Location amazonEuLocation = OrganisationFactory.eINSTANCE
				.createLocation();
		amazonEuLocation.setCountry("Ireland");
		amazonEuLocation.setLatitude(0);
		amazonEuLocation.setLongitude(0);
		amazonEuLocation.setName("amazon-eu");
		amazonLocs.add(amazonEuLocation);

		DataCenter amazonEuDataCenter = OrganisationFactory.eINSTANCE
				.createDataCenter();
		amazonEuDataCenter.setCloudProvider(amazonProvider);
		amazonEuDataCenter.setCodeName("amazon-eu");
		amazonEuDataCenter.setLocation(amazonEuLocation);
		amazonEuDataCenter.setName("European Amazon Data Centre");

		amazonDCs.add(amazonEuDataCenter);

		// //// END definition of Amazon Organisation model
		return new Triplet<OrganisationModel, CloudProvider, Location>(
				amazonOrgModel, amazonProvider, amazonEuLocation);
	}
}
