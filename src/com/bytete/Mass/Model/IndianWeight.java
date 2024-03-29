package com.bytete.Mass.Model;

import com.bytete.Mass.Interfaces.IndianWeightConvertable;
import com.bytete.Mass.Interfaces.WeightConvertable;
import com.bytete.Mass.enums.Weight;
import com.bytete.Mass.enums.WeightUnits;

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
    public IndianWeight setStandardWeight(BigDecimal gram) {
        ratti = gram.multiply(Weight.STANDARD_TO_INDIAN_RATTI);
        return this;
    }

    @Override
    public IndianWeight convertFrom(WeightConvertable convertable) {
        ratti = convertable.getStandardWeight().multiply(Weight.STANDARD_TO_INDIAN_RATTI);
        return this;
    }

    @Override
    public IndianWeight convertFrom(BigDecimal value, WeightUnits.Types type) {
        switch (type){
            case SI_SYSTEM : convertFrom(new InternationalWeight(value));
                break;
            case GERM_WEIGHT_SYSTEM : convertFrom(new GermWeight(value));
                break;
            case INDIAN_WEIGHT_SYSTEM: convertFrom(new IndianWeight(value));
                break;
            case BRITISH_SYSTEM: convertFrom(new BritishWeight(value));
                break;
            case BURMSESE_WEIGHT_SYSTEM: convertFrom(new BurmeseWeight(value));
                break;
        }
        return this;
    }

    @Override
    public WeightConvertable convertFrom(double value, WeightUnits.Types type) {
        return convertFrom(BigDecimal.valueOf(value), type);
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

    @Override
    public String toString() {
        return "IndianWeight{" +
                "ratti=" + ratti +
                '}';
    }
}
