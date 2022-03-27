package com.bytete.Mass.Interfaces;

import java.math.BigDecimal;

public interface BritishWeightConvertable extends WeightConvertable{
    //https://en.wikipedia.org/wiki/Imperial_units

    BigDecimal toPound();
    BigDecimal toOunce();
    BigDecimal toStone();
    BigDecimal toQuarter();
    BigDecimal toHundredWeight();
    BigDecimal toTon();
    BigDecimal toSlug();

    BritishWeightConvertable fromPound(BigDecimal pound);
    BritishWeightConvertable fromOunce(BigDecimal ounce);
    BritishWeightConvertable fromStone(BigDecimal stone);
    BritishWeightConvertable fromQuarter(BigDecimal quarter);
    BritishWeightConvertable fromHundredWeight(BigDecimal hundredWeight);
    BritishWeightConvertable fromTon(BigDecimal ton);
    BritishWeightConvertable fromSlug(BigDecimal slug);
}
