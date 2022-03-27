package com.bytete.Weight.Interfaces;

import java.math.BigDecimal;

public interface IndianWeightConvertable extends WeightConvertable{
    BigDecimal toRatti();
    IndianWeightConvertable fromRatti(BigDecimal value);
}
