package com.bytete.Mass.Interfaces;

import java.math.BigDecimal;

public interface GermWeightConvertable extends WeightConvertable{
    BigDecimal toCarat();

    GermWeightConvertable fromCarat(BigDecimal value);
}
