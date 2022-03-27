package com.bytete;

import com.bytete.Weight.Interfaces.WeightConvertable;
import com.bytete.Weight.Model.UniversalWeight;
import com.bytete.Weight.WeightConverter;

public abstract class Converter {
    public static UniversalWeight getMassConverterInstance(){
        return WeightConverter.getInstance();
    }
}
