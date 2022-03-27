package com.bytete.Weight.Interfaces;

import java.math.BigDecimal;

public interface BurmeseWeightConvertable extends WeightConvertable{

    BigDecimal toChainThayar();
    BigDecimal toViss();
    BigDecimal toSeitThar();
    BigDecimal toWattThar();
    BigDecimal toKyat();
    BigDecimal toMhu();
    BigDecimal toThaMhat();
    BigDecimal toNgarMhu();
    BigDecimal toPae();
    BigDecimal toYway();
    BigDecimal toYwayLay();

    BurmeseWeightConvertable fromKyat(BigDecimal kyat);
    BurmeseWeightConvertable fromPae(BigDecimal pae);
    BurmeseWeightConvertable fromYway(BigDecimal yway);
    BurmeseWeightConvertable fromYwayLay(BigDecimal ywayLay);
}
