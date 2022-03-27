package com.bytete.Mass.Interfaces;

import com.bytete.Mass.enums.WeightUnits;

import java.math.BigDecimal;

public interface WeightConvertable {
    String STANDARD_WEIGHT_UNIT = "gram";

    BigDecimal getStandardWeight();
    WeightConvertable setStandardWeight(BigDecimal gram);
    WeightConvertable convertFrom(WeightConvertable convertable);
    WeightConvertable convertFrom(BigDecimal value, WeightUnits.Types type);
    WeightConvertable convertFrom(double value, WeightUnits.Types type);

    WeightConvertable toBritishWeight();
    WeightConvertable toBurmeseWeight();
    WeightConvertable toIndianWeight();
    WeightConvertable toGermWeight();
    WeightConvertable toInternationalWeight();
    WeightConvertable toUniversalWeight();

}
