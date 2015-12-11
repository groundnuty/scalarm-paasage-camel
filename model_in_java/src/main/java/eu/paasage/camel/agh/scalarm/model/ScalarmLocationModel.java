package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.location.Country;
import eu.paasage.camel.location.GeographicalRegion;
import eu.paasage.camel.location.LocationFactory;
import eu.paasage.camel.location.LocationModel;
import eu.paasage.camel.organisation.DataCenter;

/**
 * Created by orzech on 10/12/15.
 */
public class ScalarmLocationModel {
    /*
    location model ScalarmLocation {
        region EU {
            name: 'Europe'
        }

        country DE {
            name: 'Germany'
            parent regions [ScalarmLocation.EU]
        }

        country UK {
            name: 'United Kingdom'
            parent regions [ScalarmLocation.EU]
        }

    }
     */

    public static Country germany ;
    public static Country uk ;

    public static LocationModel createLocationModel() {

        LocationModel lm = LocationFactory.eINSTANCE.createLocationModel();
        lm.setName("Scalarm Location Model");

        GeographicalRegion europe = LocationFactory.eINSTANCE.createGeographicalRegion();
        europe.setName("Europe");
        europe.setId("EU");
        lm.getRegions().add(europe);

        Country germany = LocationFactory.eINSTANCE.createCountry();
        germany.setName("Germany");
        germany.setId("DE");
        germany.getParentRegions().add(europe);
        lm.getCountries().add(germany);


        Country uk = LocationFactory.eINSTANCE.createCountry();
        uk.setName("United Kingdom");
        uk.setId("UK");
        uk.getParentRegions().add(uk);
        lm.getCountries().add(uk);

        ScalarmLocationModel.germany = germany ;
        ScalarmLocationModel.uk = uk ;

        return lm;
    }

}
