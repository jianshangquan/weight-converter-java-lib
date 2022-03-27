package com.bytete;

import com.bytete.Mass.Model.BurmeseWeight;
import com.bytete.Mass.WeightConverter;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {
        BurmeseWeight burmeseWeight = new BurmeseWeight(200);
        System.out.println(burmeseWeight.toBurmeseWeight().toString());
    }
}
