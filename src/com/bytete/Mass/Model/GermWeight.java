package com.bytete.Mass.Model;

import com.bytete.Mass.Interfaces.GermWeightConvertable;
import com.bytete.Mass.Interfaces.WeightConvertable;
import com.bytete.Mass.enums.Weight;
import com.bytete.Mass.enums.WeightUnits;

import java.math.BigDecimal;

public class GermWeight implements GermWeightConvertable {
    BigDecimal carat;

    public GermWeight(){
        carat = BigDecimal.ZERO;
    }

    public GermWeight(BigDecimal carat){
        this.carat = carat;
    }


    public GermWeight(double carat){
        this.carat = BigDecimal.valueOf(carat);
    }


    public GermWeight(WeightConvertable convertable){
        convertFrom(convertable);
    }

    @Override
    public BigDecimal toCarat() {
        return carat;
    }

    @Override
    public GermWeightConvertable fromCarat(BigDecimal value) {
        this.carat = value;
        return this;
    }

    @Override
    public BigDecimal getStandardWeight() {
        return carat.multiply(Weight.GERM_WEIGHT_CARAT_TO_STANDARD);
    }

    @Override
    public GermWeight setStandardWeight(BigDecimal gram) {
        this.carat = gram.multiply(Weight.STANDARD_TO_GERM_WEIGHT_CARAT);
        return this;
    }

    @Override
    public GermWeight convertFrom(WeightConvertable convertable) {
        carat = convertable.getStandardWeight().multiply(Weight.STANDARD_TO_GERM_WEIGHT_CARAT);
        return this;
    }




    @Override
    public WeightConvertable convertFrom(BigDecimal value, WeightUnits.Types type) {
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
        return this;
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
