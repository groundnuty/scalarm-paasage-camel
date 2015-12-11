package eu.paasage.camel.agh.scalarm.model.submodels;

import eu.paasage.camel.provider.Constraint;
import eu.paasage.camel.provider.Feature;
import eu.paasage.camel.provider.ProviderModel;
import eu.paasage.camel.type.*;
import org.javatuples.Triplet;

/**
 * Created by orzech on 10/12/15.
 */
public class ScalarmTypeModel {


    public static Range rangeFrom0To100Int;
    public static Range rangeFrom0To10000Int;
    public static Range rangeFrom0To100Double;


    public static TypeModel createTypeModel() {

        TypeModel typeModel = TypeFactory.eINSTANCE.createTypeModel();
        typeModel.setName("Scalarm Type Model");

       /*
            Definition of Range Range_0_100 {
                primitive type: IntType
                lower limit {int value 0 included}
                upper limit {int value 100}
            }
       */

        Range rangeFrom0To100Int = TypeFactory.eINSTANCE.createRange();
        rangeFrom0To100Int.setPrimitiveType(TypeEnum.INT_TYPE);

        Limit int0Limit = TypeFactory.eINSTANCE.createLimit();
        int0Limit.setIncluded(true);
        IntegerValue int0Value = TypeFactory.eINSTANCE.createIntegerValue();
        int0Value.setValue(0);
        int0Limit.setValue(int0Value);

        Limit int100Limit = TypeFactory.eINSTANCE.createLimit();
        int100Limit.setIncluded(true);
        IntegerValue int100Value = TypeFactory.eINSTANCE.createIntegerValue();
        int100Value.setValue(100);
        int0Limit.setValue(int100Value);

        rangeFrom0To100Int.setLowerLimit(int0Limit);
        rangeFrom0To100Int.setUpperLimit(int100Limit);
        typeModel.getDataTypes().add(rangeFrom0To100Int);


        /*
            range Range_0_10000 {
                primitive type: IntType
                lower limit {int value 0}
                upper limit {int value 1000 included}
            }
       */

        Range rangeFrom0To10000Int = TypeFactory.eINSTANCE.createRange();
        rangeFrom0To10000Int.setPrimitiveType(TypeEnum.INT_TYPE);

        Limit int0Limit1 = TypeFactory.eINSTANCE.createLimit();
        int0Limit.setIncluded(true);
        IntegerValue int0Value1 = TypeFactory.eINSTANCE.createIntegerValue();
        int0Value.setValue(0);
        int0Limit.setValue(int0Value1);

        Limit int10000Limit = TypeFactory.eINSTANCE.createLimit();
        int10000Limit.setIncluded(true);
        IntegerValue int1000Value = TypeFactory.eINSTANCE.createIntegerValue();
        int1000Value.setValue(10000);
        int10000Limit.setValue(int1000Value);

        rangeFrom0To10000Int.setLowerLimit(int0Limit1);
        rangeFrom0To10000Int.setUpperLimit(int10000Limit);
        typeModel.getDataTypes().add(rangeFrom0To10000Int);


       /*
            range DoubleRange_0_100 {
                primitive type: DoubleType
                lower limit {double value 0.0 included}
                upper limit {double value 100.0 included}
            }
       */

        Range rangeFrom0To100Double = TypeFactory.eINSTANCE.createRange();
        rangeFrom0To100Double.setPrimitiveType(TypeEnum.DOUBLE_TYPE);

        Limit double0Limit = TypeFactory.eINSTANCE.createLimit();
        double0Limit.setIncluded(true);
        DoublePrecisionValue double0Value = TypeFactory.eINSTANCE.createDoublePrecisionValue();
        double0Value.setValue(0.0);
        double0Limit.setValue(double0Value);

        Limit double100Limit = TypeFactory.eINSTANCE.createLimit();
        double100Limit.setIncluded(true);
        IntegerValue double100Value = TypeFactory.eINSTANCE.createIntegerValue();
        double100Value.setValue(100);
        double100Limit.setValue(double100Value);

        rangeFrom0To100Double.setLowerLimit(double0Limit);
        rangeFrom0To100Double.setUpperLimit(double100Limit);
        typeModel.getDataTypes().add(rangeFrom0To100Double);


        ScalarmTypeModel.rangeFrom0To100Int =rangeFrom0To100Int;
        ScalarmTypeModel.rangeFrom0To10000Int =rangeFrom0To10000Int;
        ScalarmTypeModel.rangeFrom0To100Double =rangeFrom0To100Double;



    return typeModel;
    }
}
