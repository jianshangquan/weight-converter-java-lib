package com.bytete.Mass.Interfaces;

import com.bytete.Mass.Model.*;
import com.bytete.Mass.enums.WeightUnits;

import java.math.BigDecimal;

public interface WeightConvertable {
    String STANDARD_WEIGHT_UNIT = "gram";

    BigDecimal getStandardWeight();
    WeightConvertable setStandardWeight(BigDecimal gram);
    WeightConvertable convertFrom(WeightConvertable convertable);
    WeightConvertable convertFrom(BigDecimal value, WeightUnits.Types type);
    WeightConvertable convertFrom(double value, WeightUnits.Types type);

    BritishWeight toBritishWeight();
    BurmeseWeight toBurmeseWeight();
    IndianWeight toIndianWeight();
    GermWeight toGermWeight();
    InternationalWeight toInternationalWeight();
    UniversalWeight toUniversalWeight();
}
