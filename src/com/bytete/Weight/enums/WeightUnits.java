package com.bytete.Weight.enums;

public interface WeightUnits {
    
    public enum Types {
        SI_SYSTEM,
        BRITISH_SYSTEM,
        BURMSESE_WEIGHT_SYSTEM,
        GERM_WEIGHT_SYSTEM,
        INDIAN_WEIGHT_SYSTEM
    }

    public enum SI_SYSTEM implements Weight {
        GRAM("Gram", "g");

        String name, localname;
        SI_SYSTEM(String name, String localname){
            this.name = name;
            this.localname = localname;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getLocalName() {
            return localname;
        }
    }

    public enum BURMESE_WEIGHT_SYSTEM implements Weight {
        PAE("Pae", "ပဲ"),
        YWAY("Yway", "ရွေး");

        String name, localname;
        BURMESE_WEIGHT_SYSTEM(String name, String localname){
            this.name = name;
            this.localname = localname;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getLocalName() {
            return localname;
        }
    }

    public enum BRITISH_SYSTEM implements Weight {
        POUND("Pound", "lb");

        String name, localname;
        BRITISH_SYSTEM(String name, String localname){
            this.name = name;
            this.localname = localname;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getLocalName() {
            return localname;
        }
    }

    public enum GERM_WEIGHT_SYSTEM implements Weight {
        KARAT("Carat", "c");

        String name, localname;
        GERM_WEIGHT_SYSTEM(String name, String localname){
            this.name = name;
            this.localname = localname;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getLocalName() {
            return localname;
        }
    }


    public enum INDIAN_WEIGHT_SYSTEM implements Weight{
        RATTI("Ratti", "rt");

        INDIAN_WEIGHT_SYSTEM(String name, String localname){
            this.name = name;
            this.localname = localname;
        }

        String name, localname;
        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getLocalName() {
            return null;
        }
    }
}
