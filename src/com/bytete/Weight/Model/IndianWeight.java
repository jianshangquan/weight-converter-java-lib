package com.bytete.Weight.Model;

import com.bytete.Weight.Interfaces.IndianWeightConvertable;
import com.bytete.Weight.Interfaces.WeightConvertable;
import com.bytete.Weight.enums.Weight;
import com.bytete.Weight.enums.WeightUnits;

import java.math.BigDecimal;

public class IndianWeight implements IndianWeightConvertable {

    BigDecimal ratti;

    public IndianWeight(){
        ratti = BigDecimal.ZERO;
    }

    public IndianWeight(BigDecimal ratti){
        fromRatti(ratti);
    }

    public IndianWeight(double ratti){
        fromRatti(BigDecimal.valueOf(ratti));
    }

    public IndianWeight(WeightConvertable convertable){
        convertFrom(convertable);
    }

    @Override
    public BigDecimal toRatti() {
        return ratti;
    }

    @Override
    public IndianWeight fromRatti(BigDecimal value) {
        ratti = value;
        return this;
    }

    @Override
    public BigDecimal getStandardWeight() {
        return ratti.multiply(Weight.INDIAN_RATTI_TO_STANDARD);
    }

    @Override
    public WeightConvertable convertFrom(WeightConvertable convertable) {
        ratti = convertable.getStandardWeight().multiply(Weight.STANDARD_TO_INDIAN_RATTI);
        return this;
    }

    @Override
    public WeightConvertable convertFrom(BigDecimal value, WeightUnits.Types type) {
        return null;
    }

    @Override
    public WeightConvertable convertFrom(double value, WeightUnits.Types type) {
        return null;
    }

    @Override
    public BritishWeight toBritishWeight() {
        return new BritishWeight(this);
    }

    @Override
    public BurmeseWeight toBurmeseWeight() {
        return new BurmeseWeight(this);
    }

    @Override
    public IndianWeight toIndianWeight() {
        return new IndianWeight(this);
    }

    @Override
    public GermWeight toGermWeight() {
        return new GermWeight(this);
    }

    @Override
    public InternationalWeight toInternationalWeight() {
        return new InternationalWeight(this);
    }

    @Override
    public UniversalWeight toUniversalWeight() {
        return new UniversalWeight(this);
    }

}
