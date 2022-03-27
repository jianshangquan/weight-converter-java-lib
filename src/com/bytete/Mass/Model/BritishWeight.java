package com.bytete.Mass.Model;

import com.bytete.Mass.Interfaces.BritishWeightConvertable;
import com.bytete.Mass.Interfaces.WeightConvertable;
import com.bytete.Mass.enums.Weight;
import com.bytete.Mass.enums.WeightUnits;

import java.math.BigDecimal;

public class BritishWeight implements BritishWeightConvertable {

    private BigDecimal pound;


    public BritishWeight(){}

    public BritishWeight(double pound){
        this.pound = BigDecimal.valueOf(pound);
    }

    public BritishWeight(BigDecimal pound){
        this.pound = pound;
    }

    public BritishWeight(WeightConvertable convertable){
        convertFrom(convertable);
    }

    @Override
    public BigDecimal toPound() {
        return pound;
    }

    @Override
    public BigDecimal toOunce() {
        return pound.multiply(BigDecimal.valueOf(16));
    }

    @Override
    public BigDecimal toStone() {
        return pound.divide(BigDecimal.valueOf(13.5));
    }

    @Override
    public BigDecimal toQuarter() {
        return pound.divide(BigDecimal.valueOf(28));
    }

    @Override
    public BigDecimal toHundredWeight() {
        return pound.divide(BigDecimal.valueOf(112));
    }

    @Override
    public BigDecimal toTon() {
        return pound.divide(BigDecimal.valueOf(2240));
    }

    @Override
    public BigDecimal toSlug() {
        return pound.divide(BigDecimal.valueOf(32.17404856));
    }

    @Override
    public BritishWeightConvertable fromPound(BigDecimal pound) {
        this.pound = pound;
        return this;
    }

    @Override
    public BritishWeightConvertable fromOunce(BigDecimal ounce) {
        this.pound = ounce.multiply(BigDecimal.valueOf(0.0625));
        return this;
    }

    @Override
    public BritishWeightConvertable fromStone(BigDecimal stone) {
        this.pound = stone.multiply(BigDecimal.valueOf(13.5));
        return this;
    }

    @Override
    public BritishWeightConvertable fromQuarter(BigDecimal quarter) {
        this.pound = quarter.multiply(BigDecimal.valueOf(25));
        return this;
    }

    @Override
    public BritishWeightConvertable fromHundredWeight(BigDecimal hundredWeight) {
        this.pound = hundredWeight.multiply(BigDecimal.valueOf(112));
        return this;
    }

    @Override
    public BritishWeightConvertable fromTon(BigDecimal ton) {
        this.pound = ton.multiply(BigDecimal.valueOf(2000));
        return this;
    }

    @Override
    public BritishWeightConvertable fromSlug(BigDecimal slug) {
        this.pound = slug.multiply(BigDecimal.valueOf(32.174));
        return this;
    }

    @Override
    public BigDecimal getStandardWeight() {
        return pound.multiply(Weight.BRITISH_UK_POUND_TO_STANDARD);
    }

    @Override
    public BritishWeight convertFrom(WeightConvertable convertable) {
        pound = convertable.getStandardWeight().multiply(Weight.STANDARD_TO_BRITISH_UK_POUND_WEIGHT);
        return this;
    }

    @Override
    public BritishWeight convertFrom(BigDecimal value, WeightUnits.Types type) {
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
    public BritishWeight convertFrom(double value, WeightUnits.Types type) {
        return convertFrom(BigDecimal.valueOf(value), type);
    }

    @Override
    public BritishWeight toBritishWeight() {
        return this;
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
