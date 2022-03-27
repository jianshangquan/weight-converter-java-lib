package com.bytete.Weight.enums;

import java.math.BigDecimal;

public interface Weight {
    BigDecimal STANDARD_TO_BURMESE_PAE_WEIGHT = BigDecimal.valueOf(0.96000384000015);
    BigDecimal STANDARD_TO_BRITISH_UK_POUND_WEIGHT = BigDecimal.valueOf(0.00220462);
    BigDecimal STANDARD_TO_INTERNATIONAL_WEIGHT = BigDecimal.valueOf(0);
    BigDecimal STANDARD_TO_GERM_WEIGHT_CARAT = BigDecimal.valueOf(5);
    BigDecimal STANDARD_TO_INDIAN_RATTI = BigDecimal.valueOf(5.49);

    BigDecimal BURMESE_PAE_WEIGHT_TO_STANDARD = BigDecimal.valueOf(1.041666625);
    BigDecimal BRITISH_UK_POUND_TO_STANDARD = BigDecimal.valueOf(453.592);
    BigDecimal INTERNATIONAL_WEIGHT_TO_STANDARD = BigDecimal.valueOf(0);
    BigDecimal GERM_WEIGHT_CARAT_TO_STANDARD = BigDecimal.valueOf(0.2);
    BigDecimal INDIAN_RATTI_TO_STANDARD = BigDecimal.valueOf(0.182); // 5.49

    String getName();
    String getLocalName();
}
