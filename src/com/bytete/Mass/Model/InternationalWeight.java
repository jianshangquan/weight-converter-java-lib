package com.bytete.Mass.Model;

import com.bytete.Mass.Interfaces.BritishWeightConvertable;
import com.bytete.Mass.Interfaces.BurmeseWeightConvertable;
import com.bytete.Mass.Interfaces.InternationWeightConvertable;
import com.bytete.Mass.Interfaces.WeightConvertable;
import com.bytete.Mass.enums.WeightUnits;

import java.math.BigDecimal;

public class InternationalWeight implements InternationWeightConvertable {
    private final BigDecimal UNIT_DIFFERENT_RATIO = BigDecimal.valueOf(10);

    BigDecimal gram;


    public InternationalWeight(){
        gram = BigDecimal.ZERO;
    }

    public InternationalWeight(BritishWeightConvertable britishWeight){
        convertFrom(britishWeight);
    }

    public InternationalWeight(BurmeseWeightConvertable burmeseWeight){
        convertFrom(burmeseWeight);
    }

    public InternationalWeight(InternationWeightConvertable internationalWeight){
        convertFrom(internationalWeight);
    }

    public InternationalWeight(WeightConvertable convertable){
        convertFrom(convertable);
    }

    public InternationalWeight(BigDecimal gram){
        this.gram = gram;
    }

    public InternationalWeight(double gram){
        this.gram = BigDecimal.valueOf(gram);
    }

    public InternationalWeight(BigDecimal value, WeightUnits.SI_SYSTEM unit){
        // TODO: calculate value relative to given unit
        this.gram = gram;
    }

    public InternationalWeight(double value, WeightUnits.SI_SYSTEM unit){
        // TODO: calculate value relative to given unit
        this.gram = BigDecimal.valueOf(value);
    }




    @Override
    public BigDecimal toMilligram() {
        return toDecigram().multiply(UNIT_DIFFERENT_RATIO);
    }

    @Override
    public BigDecimal toDecigram() {
        return toCentigram().multiply(UNIT_DIFFERENT_RATIO);
    }

    @Override
    public BigDecimal toCentigram() {
        return toGram().multiply(UNIT_DIFFERENT_RATIO);
    }

    @Override
    public BigDecimal toGram() {
        return gram;
    }

    @Override
    public BigDecimal toDekagram() {
        return toGram().divide(BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal toHectogram() {
        return toGram().divide(BigDecimal.valueOf(1_000));
    }

    @Override
    public BigDecimal toMetricgram() {
        return toGram().divide(BigDecimal.valueOf(10_000));
    }

    @Override
    public BigDecimal toKilogram() {
        return toGram().divide(BigDecimal.valueOf(100_000));
    }

    @Override
    public InternationWeightConvertable fromDecigram(BigDecimal decigram) {
        fromGram(decigram.multiply(BigDecimal.valueOf(0.1)));
        return this;
    }

    @Override
    public InternationWeightConvertable fromCentigram(BigDecimal centigram) {
        fromGram(centigram.multiply(BigDecimal.valueOf(0.01)));
        return this;
    }

    @Override
    public InternationalWeight fromGram(BigDecimal gram) {
        this.gram = gram;
        return this;
    }

    @Override
    public InternationWeightConvertable fromDekagram(BigDecimal dekagram) {
        fromGram(dekagram.multiply(BigDecimal.valueOf(10)));
        return this;
    }

    @Override
    public InternationWeightConvertable fromHectogram(BigDecimal hectogram) {
        fromGram(hectogram.multiply(BigDecimal.valueOf(100)));
        return this;
    }

    @Override
    public InternationWeightConvertable fromMetricgram(BigDecimal metricgram) {
        fromGram(metricgram.multiply(BigDecimal.valueOf(1_000)));
        return this;
    }

    @Override
    public InternationalWeight fromKilogram(BigDecimal kilogram) {
        this.gram = kilogram.multiply(BigDecimal.valueOf(1_000));
        return this;
    }

    @Override
    public InternationalWeight fromMilligram(BigDecimal milligram) {
        this.gram = milligram.multiply(BigDecimal.valueOf(0.001));
        return this;
    }

    @Override
    public BigDecimal getStandardWeight() {
        return toGram();
    }

    @Override
    public InternationalWeight setStandardWeight(BigDecimal gram) {
        this.gram = gram;
        return this;
    }

    @Override
    public InternationalWeight convertFrom(WeightConvertable convertable) {
        gram = convertable.getStandardWeight();
        return this;
    }

    @Override
    public InternationalWeight convertFrom(BigDecimal value, WeightUnits.Types type) {
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
    public InternationalWeight convertFrom(double value, WeightUnits.Types type) {
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
        return this;
    }

    @Override
    public UniversalWeight toUniversalWeight() {
        return new UniversalWeight(this);
    }
}
