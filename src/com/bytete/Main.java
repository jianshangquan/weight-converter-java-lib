package com.bytete;

import com.bytete.Mass.WeightConverter;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {

        BigDecimal result = WeightConverter.getInstance().fromTon(BigDecimal.valueOf(1)).toPound();
        System.out.println(result);

    }
}
