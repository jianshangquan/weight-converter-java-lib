package com.bytete;

import com.bytete.Weight.Interfaces.WeightConvertable;
import com.bytete.Weight.Model.*;
import com.bytete.Weight.WeightConverter;
import com.bytete.Weight.enums.WeightUnits;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {

        // fromPound
        // fromOunce
        // fromYway     =>      need to check
        // fromCarat
        BigDecimal result = WeightConverter.getInstance().fromCarat(BigDecimal.valueOf(100)).toPound();
        System.out.println(result);
    }
}
