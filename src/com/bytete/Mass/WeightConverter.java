package com.bytete.Mass;

import com.bytete.Mass.Model.UniversalWeight;

public class WeightConverter {
    public static int decimalPlaces = 8;
    public static UniversalWeight getInstance(){
        return UniversalWeight.getInstance();
    }

//    public static BigDecimal convertFrom(BigDecimal value, WeightUnits.Types);


//    public static WeightConvertable convertFrom(WeightConvertable convertable, WeightUnits.Types type) throws Exception{
//        if(type == WeightUnits.Types.BURMSESE_WEIGHT_SYSTEM) return new BurmeseWeight(convertable);
//        if(type == WeightUnits.Types.GERM_WEIGHT_SYSTEM) return null;
//        if(type == WeightUnits.Types.BRITISH_SYSTEM) return new BritishWeight(convertable);
//        if(type == WeightUnits.Types.SI_SYSTEM) return new BritishWeight(convertable);
//        else {
//            throw new Exception("UN-KNOWN WEIGHT UNITS");
//        }
//    }
//
//    public static BigDecimal convertFrom(WeightConvertable convertable, Weight toWeightUnits){
//        return null;
//    }

//    public static BigDecimal convertFrom(BigDecimal weight, Weight toWeightUnits){
//        return null;
//    }
//
//    public static BigDecimal convertFrom(BigDecimal weight, Weight fromWeightUnits, Weight toWeightUnits){
//        if(fromWeightUnits instanceof WeightUnits.BURMESE_WEIGHT_SYSTEM){
//            new BurmeseWeight(weight).convertFromStandardWeight();
//        }
//        return null;
//    }
//
//    public static BigDecimal convertFrom(double weight, Weight fromWeightUnits, Weight toWeightUnits){
//        return convertFrom(BigDecimal.valueOf(weight), fromWeightUnits, toWeightUnits);
//    }
}
