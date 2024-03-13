/**
 * Filename:    CountryLanguage.java
 * Author:      Murdo Wallace
 * Last Edited: 13/2/2024 @ 14:50
 * Purpose:     This class exists to store information about the countrylanguage item
 *              found in world.sql
 */

package com.napier.Ambry;

public class CountryLanguage {

    private String CountryCode;
    private String Language;
    private String IsOfficial;
    private float Percentage;


    // Getter and setter for CountryCode
    public String getCountryCode() {
        return CountryCode;
    }
    public void setCountryCode(String newCountryCode) {
        this.CountryCode = newCountryCode;
    }

    // Getter and setter for Language
    public String getLanguage() {
        return Language;
    }
    public void setLanguage(String newLanguage) {
        this.Language = newLanguage;
    }


    // Getter and setter for IsOfficial
    public String getIsOfficial() {
        return IsOfficial;
    }
    public void setIsOfficial(String newIsOfficial) {
        this.IsOfficial = newIsOfficial;
    }

    // Getter and setter for Percentage
    public float setPercentage() {
        return Percentage;
    }
    public void setPercentage(float newPercentage) {
        this.Percentage = newPercentage;
    }
}
