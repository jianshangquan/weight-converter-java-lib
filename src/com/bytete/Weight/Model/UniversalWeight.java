package com.bytete.Weight.Model;

import com.bytete.Weight.Interfaces.*;
import com.bytete.Weight.enums.Weight;
import com.bytete.Weight.enums.WeightUnits;

import java.math.BigDecimal;

public class UniversalWeight extends InternationalWeight implements
        WeightConvertable,
        BritishWeightConvertable, BurmeseWeightConvertable, IndianWeightConvertable, GermWeightConvertable {

    private static volatile UniversalWeight instance;

    public UniversalWeight(){
        super();
    }

    public UniversalWeight(BigDecimal gram){
        this.gram = gram;
    }

    public UniversalWeight(WeightConvertable convertable){
        convertFrom(convertable);
    }


    public static UniversalWeight getInstance(){
        UniversalWeight weight = instance;
        if(weight == null){
            synchronized (UniversalWeight.class){
                if(weight == null){
                    instance = new UniversalWeight();
                    return instance;
                }
            }
        }
        return instance;
    }


    @Override
    public BigDecimal toOunce() {
        return toPound().multiply(BigDecimal.valueOf(16));
    }

    @Override
    public BigDecimal toPound() {
        return gram.multiply(Weight.STANDARD_TO_BRITISH_UK_POUND_WEIGHT);
    }

    @Override
    public BigDecimal toStone() {
        return toPound().multiply(BigDecimal.valueOf(0.0714286));
    }

    @Override
    public BigDecimal toQuarter() {
        return toPound().multiply(BigDecimal.valueOf(0.04));
    }

    @Override
    public BigDecimal toHundredWeight() {
        return toPound().multiply(BigDecimal.valueOf(0.00892857));
    }

    @Override
    public BigDecimal toTon() {
        return toPound().multiply(BigDecimal.valueOf(0.0005));
    }

    @Override
    public BigDecimal toSlug() {
        return toPound().multiply(BigDecimal.valueOf(0.031081));
    }

    @Override
    public UniversalWeight fromPound(BigDecimal pound) {
        gram = pound.multiply(Weight.BRITISH_UK_POUND_TO_STANDARD);
        return this;
    }

    @Override
    public UniversalWeight fromOunce(BigDecimal ounce) {
        fromPound(ounce.multiply(BigDecimal.valueOf(0.0625)));
        return this;
    }

    @Override
    public UniversalWeight fromStone(BigDecimal stone) {
        fromPound(stone.multiply(BigDecimal.valueOf(13.5)));
        return this;
    }

    @Override
    public UniversalWeight fromQuarter(BigDecimal quarter) {
        fromPound(quarter.multiply(BigDecimal.valueOf(25)));
        return this;
    }

    @Override
    public UniversalWeight fromHundredWeight(BigDecimal hundredWeight) {
        fromPound(hundredWeight.multiply(BigDecimal.valueOf(112)));
        return this;
    }

    @Override
    public UniversalWeight fromTon(BigDecimal ton) {
        fromPound(ton.multiply(BigDecimal.valueOf(2000)));
        return this;
    }

    @Override
    public UniversalWeight fromSlug(BigDecimal slug) {
        fromPound(slug.multiply(BigDecimal.valueOf(32.174)));
        return this;
    }

    @Override
    public BigDecimal toChainThayar() {
        return null;
    }

    @Override
    public BigDecimal toViss() {
        return null;
    }

    @Override
    public BigDecimal toSeitThar() {
        return null;
    }

    @Override
    public BigDecimal toWattThar() {
        return null;
    }

    @Override
    public BigDecimal toKyat() {
        return toPae().divide(BigDecimal.valueOf(16));
    }

    @Override
    public BigDecimal toMhu() {
        return null;
    }

    @Override
    public BigDecimal toThaMhat() {
        return null;
    }

    @Override
    public BigDecimal toNgarMhu() {
        return null;
    }

    @Override
    public BigDecimal toPae() {
        return getStandardWeight().multiply(Weight.STANDARD_TO_BURMESE_PAE_WEIGHT);
    }

    @Override
    public BigDecimal toYway() {
        return toPae().multiply(BigDecimal.valueOf(8));
    }

    @Override
    public BigDecimal toYwayLay() {
        return null;
    }

    @Override
    public UniversalWeight fromKyat(BigDecimal kyat) {
        gram = kyat.divide(BigDecimal.valueOf(16)).multiply(Weight.BURMESE_PAE_WEIGHT_TO_STANDARD);
        return this;
    }

    @Override
    public UniversalWeight fromPae(BigDecimal pae) {
        gram = pae.multiply(Weight.BURMESE_PAE_WEIGHT_TO_STANDARD);
        return this;
    }

    @Override
    public UniversalWeight fromYway(BigDecimal yway) {
        gram = yway.multiply(BigDecimal.valueOf(8)).multiply(Weight.BURMESE_PAE_WEIGHT_TO_STANDARD);
        return this;
    }

    @Override
    public UniversalWeight fromYwayLay(BigDecimal ywayLay) {
        fromYway(ywayLay.multiply(BigDecimal.valueOf(2)));
        return this;
    }

    @Override
    public UniversalWeight convertFrom(WeightConvertable convertable) {
        super.convertFrom(convertable);
        return this;
    }

    @Override
    public BigDecimal getStandardWeight() {
        return super.getStandardWeight();
    }

    @Override
    public UniversalWeight convertFrom(double value, WeightUnits.Types type) {
        return (UniversalWeight) super.convertFrom(value, type);
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
        return this;
    }

    @Override
    public UniversalWeight convertFrom(BigDecimal value, WeightUnits.Types type) {
        return (UniversalWeight) super.convertFrom(value, type);
    }

    @Override
    public BigDecimal toRatti() {
        return gram.multiply(Weight.STANDARD_TO_INDIAN_RATTI);
    }

    @Override
    public UniversalWeight fromRatti(BigDecimal value) {
        return this;
    }

    @Override
    public BigDecimal toCarat() {
        return gram.multiply(Weight.GERM_WEIGHT_CARAT_TO_STANDARD);
    }

    @Override
    public UniversalWeight fromCarat(BigDecimal value) {
        gram = value.multiply(Weight.GERM_WEIGHT_CARAT_TO_STANDARD);
        System.out.println(gram);
        return this;
    }

    @Override
    public UniversalWeight fromDecigram(BigDecimal decigram) {
        fromGram(decigram.multiply(BigDecimal.valueOf(0.1)));
        return this;
    }

    @Override
    public UniversalWeight fromCentigram(BigDecimal centigram) {
        fromGram(centigram.multiply(BigDecimal.valueOf(0.01)));
        return this;
    }

    @Override
    public UniversalWeight fromDekagram(BigDecimal dekagram) {
        fromGram(dekagram.multiply(BigDecimal.valueOf(10)));
        return this;
    }

    @Override
    public UniversalWeight fromHectogram(BigDecimal hectogram) {
        fromGram(hectogram.multiply(BigDecimal.valueOf(100)));
        return this;
    }

    @Override
    public UniversalWeight fromMetricgram(BigDecimal metricgram) {
        fromGram(metricgram.multiply(BigDecimal.valueOf(1_000)));
        return this;
    }
}
