/**
 * Filename:    Country.java
 * Author:      Murdo Wallace
 * Last Edited: 13/2/2024 @ 14:47
 * Purpose:     This class exists to store information about the country item
 *              found in world.sql
 */

package com.napier.Ambry;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Country {
    private String code;
    private String Name;
    private String Continent;
    private String Region;
    private float SurfaceArea;
    private int IndepYear;
    private int Population;
    private float LifeExpectancy;
    private float GNP;
    private float GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private int Capital;
    private String Code2;

    // Getter and setter for code
    public String getCode() {
        return code;
    }
    public void setCode(String newCode) {
        this.code = newCode;
    }

    // Getter and setter for name
    public String getName() {
        return Name;
    }
    public void setName(String newName) {
        this.Name = newName;
    }

    // Getter and setter for Continent
    public String getContinent() {
        return Continent;
    }
    public void setContinent(String newContinent) {
        this.Continent = newContinent;
    }

    // Getter and setter for Region
    public String getRegion() {
        return Region;
    }
    public void setRegion(String newRegion) {
        this.Region = newRegion;
    }

    // Getter and setter for SurfaceArea
    public float getSurfaceArea() {
        return SurfaceArea;
    }
    public void setSurfaceArea(float newSurfaceArea) {
        this.SurfaceArea = newSurfaceArea;
    }

    // Getter and setter for IndepYear
    public int getIndepYear() {
        return IndepYear;
    }
    public void setIndepYear(int newIndepYear) {
        this.IndepYear = newIndepYear;
    }

    // Getter and setter for Population
    public int getPopulation() {
        return Population;
    }
    public void setPopulation(int newPopulation) {
        this.Population = newPopulation;
    }

    // Getter and setter for LifeExpectancy
    public float getLifeExpectancy() {
        return LifeExpectancy;
    }
    public void setLifeExpectancy(float newLifeExpectancy) {
        this.LifeExpectancy = newLifeExpectancy;
    }

    // Getter and setter for GNP
    public float getGNP() {
        return GNP;
    }
    public void setGNP(float newGNP) {
        this.GNP = newGNP;
    }

    // Getter and setter for GNPOld
    public float getGNPOld() {
        return GNPOld;
    }
    public void setGNPOld(float newGNPOld) {
        this.GNPOld = newGNPOld;
    }

    // Getter and setter for LocalName
    public String getLocalName() {
        return LocalName;
    }
    public void setLocalName(String newLocalName) {
        this.LocalName = newLocalName;
    }

    // Getter and setter for GovernmentForm
    public String getGovernmentForm() {
        return GovernmentForm;
    }
    public void setGovernmentForm(String newGovernmentForm) {
        this.GovernmentForm = newGovernmentForm;
    }

    // Getter and setter for HeadOfState
    public String getHeadOfState() {
        return HeadOfState;
    }
    public void setHeadOfState(String newHeadOfState) {
        this.HeadOfState = newHeadOfState;
    }

    // Getter and setter for Capital
    public int getCapital() {
        return Capital;
    }
    public void setCapital(int newCapital) {
        this.Capital = newCapital;
    }

    // Getter and setter for Code2
    public String getCode2() {
        return Code2;
    }

    public void setCode2(String newCode2) {
        this.Code2 = newCode2;
    }
}
