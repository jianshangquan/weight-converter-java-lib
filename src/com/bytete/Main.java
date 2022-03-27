package com.bytete;

import com.bytete.Mass.Model.BurmeseWeight;
import com.bytete.Mass.Model.InternationalWeight;
import com.bytete.Mass.WeightConverter;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {
        BurmeseWeight burmeseWeight = new BurmeseWeight(new InternationalWeight(16.666666666));
        System.out.println(burmeseWeight);
    }
}
