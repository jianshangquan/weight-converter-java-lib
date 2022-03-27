package com.bytete;

import com.bytete.Mass.Model.UniversalWeight;
import com.bytete.Mass.WeightConverter;

public abstract class Converter {
    public static UniversalWeight getMassConverterInstance(){
        return WeightConverter.getInstance();
    }
    public static Converter getVolumeInstance(){ return null; }
    public static Converter getLiquidInstance(){ return null; }
    public static Converter getAreaInstance(){ return null; }
    public static Converter getLengthInstance(){ return null; }

}
