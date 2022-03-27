package com.bytete.Mass.Model;

import com.bytete.Mass.Interfaces.BurmeseWeightConvertable;
import com.bytete.Mass.Interfaces.WeightConvertable;
import com.bytete.Mass.enums.Weight;
import com.bytete.Mass.enums.WeightUnits;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BurmeseWeight implements BurmeseWeightConvertable {

    BigDecimal kyat, pae ,yway;


    public BurmeseWeight(){}

    public BurmeseWeight(double pae){
        fromPae(BigDecimal.valueOf(pae));
    }

    public BurmeseWeight(BigDecimal pae){
        fromPae(pae);
    }

    public BurmeseWeight(WeightConvertable convertable){
        convertFrom(convertable);
    }


    public BurmeseWeight(BigDecimal kyat, BigDecimal pae, BigDecimal yway){
        this.kyat = kyat;
        this.pae = pae;
        this.yway = yway;
    }

    public BurmeseWeight(int kyat, int pae, double yway){
        this.kyat = new BigDecimal(kyat);
        this.pae = new BigDecimal(pae);
        this.yway = new BigDecimal(yway);
    }


    public BigDecimal getKyat() {
        return kyat;
    }

    public BigDecimal getPae() {
        return pae;
    }

    public BigDecimal getYway() {
        return yway;
    }

    public void setKyat(BigDecimal kyat) {
        this.kyat = kyat;
    }

    public void setPae(BigDecimal pae) {
        this.pae = pae;
    }

    public void setYway(BigDecimal yway) {
        this.yway = yway;
    }




    // Burmese weight
    @Override
    public BigDecimal toChainThayar() {
        return null;
    }

    @Override
    public BigDecimal toViss() {
        return toKyat().multiply(BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal toSeitThar() {
        return toViss().divide(BigDecimal.valueOf(4),WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING);
    }

    @Override
    public BigDecimal toWattThar() {
        return toViss().divide(BigDecimal.valueOf(2), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING);
    }

    @Override
    public BigDecimal toKyat() {
        return toPae().divide(BigDecimal.valueOf(16), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING);
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
        return kyat.multiply(BigDecimal.valueOf(16)).add(pae).add(yway.divide(BigDecimal.valueOf(8), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING));
    }

    @Override
    public BigDecimal toYway() {
        return toPae().multiply(BigDecimal.valueOf(8));
    }

    @Override
    public BigDecimal toYwayLay() {
        return toYway().divide(BigDecimal.valueOf(2), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING);
    }

    @Override
    public BurmeseWeightConvertable fromKyat(BigDecimal kyat) {
        this.kyat = kyat.setScale(0, RoundingMode.HALF_DOWN);
        this.pae = kyat.subtract(this.kyat)
                        .multiply(BigDecimal.valueOf(16))
                        .setScale(0, RoundingMode.HALF_DOWN);
        this.yway = kyat.multiply(BigDecimal.valueOf(16))
                        .remainder(BigDecimal.ONE).multiply(BigDecimal.valueOf(8));
        return this;
    }

    @Override
    public BurmeseWeightConvertable fromPae(BigDecimal pae) {
        this.kyat = pae.divide(BigDecimal.valueOf(16), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING)
                        .setScale(0, RoundingMode.DOWN);
        this.pae = pae.subtract(this.kyat.multiply(BigDecimal.valueOf(16))).setScale(0, RoundingMode.DOWN);
        this.yway = pae.remainder(BigDecimal.ONE).multiply(BigDecimal.valueOf(8));
        return this;
    }

    @Override
    public BurmeseWeightConvertable fromYway(BigDecimal yway) {
        this.kyat = yway.divide(BigDecimal.valueOf(128), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING)
                        .setScale(0, RoundingMode.HALF_DOWN);
        this.pae = yway.subtract(this.kyat.multiply(BigDecimal.valueOf(128)))
                        .divide(BigDecimal.valueOf(8), WeightConvertable.DEFAULT_WEIGHT_DECIMAL_PLACE, WeightConvertable.DEFAULT_ROUNDING)
                        .setScale(0, RoundingMode.HALF_DOWN);
        this.yway = yway.subtract(this.kyat.multiply(BigDecimal.valueOf(128)))
                        .subtract(this.pae.multiply(BigDecimal.valueOf(8)));
        return this;
    }

    @Override
    public BurmeseWeightConvertable fromYwayLay(BigDecimal ywayLay) {
        fromYway(ywayLay.multiply(BigDecimal.valueOf(2)));
        return this;
    }

    @Override
    public BigDecimal getStandardWeight() {
        return toPae().multiply(Weight.BURMESE_PAE_WEIGHT_TO_STANDARD);
    }

    @Override
    public BurmeseWeight setStandardWeight(BigDecimal gram) {
        BigDecimal pae = gram.multiply(Weight.STANDARD_TO_BURMESE_PAE_WEIGHT);
        fromPae(pae);
        return this;
    }

    @Override
    public BurmeseWeight convertFrom(WeightConvertable convertable) {
        BigDecimal pae = convertable.getStandardWeight().multiply(Weight.STANDARD_TO_BURMESE_PAE_WEIGHT);
        fromPae(pae);
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
        return this;
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
        return null;
    }

    @Override
    public String toString() {
        return "BurmeseWeight{" +
                "kyat=" + kyat +
                ", pae=" + pae +
                ", yway=" + yway +
                '}';
    }
}
