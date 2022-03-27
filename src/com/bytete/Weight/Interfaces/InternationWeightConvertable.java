package com.bytete.Weight.Interfaces;

import java.math.BigDecimal;

public interface InternationWeightConvertable extends WeightConvertable {
    BigDecimal toMilligram();
    BigDecimal toDecigram();
    BigDecimal toCentigram();
    BigDecimal toGram();
    BigDecimal toDekagram();
    BigDecimal toHectogram();
    BigDecimal toMetricgram();
    BigDecimal toKilogram();

    InternationWeightConvertable fromDecigram(BigDecimal decigram);
    InternationWeightConvertable fromCentigram(BigDecimal centigram);
    InternationWeightConvertable fromGram(BigDecimal gram);
    InternationWeightConvertable fromDekagram(BigDecimal dekagram);
    InternationWeightConvertable fromHectogram(BigDecimal hectogram);
    InternationWeightConvertable fromMetricgram(BigDecimal metricgram);
    InternationWeightConvertable fromKilogram(BigDecimal kilogram);
    InternationWeightConvertable fromMilligram(BigDecimal milligram);

}
