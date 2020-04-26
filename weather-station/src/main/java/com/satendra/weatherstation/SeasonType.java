package com.satendra.weatherstation;

public enum SeasonType {

    SPRING("Vasant Ritu"),

    SUMMER("Grishma Ritu"),

    MONSOON("Varsha Ritu"),

    AUTUMN("Sharad Ritu"),

    PRE_WINTER("Hemant Ritu"),
    
    WINTER("Shita Ritu");

    private String season;

    SeasonType(String season) {
        this.season = season;
    }


   @Override
    public String toString() {
        return season;
    }
}
