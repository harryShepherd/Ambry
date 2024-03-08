/**
 * Filename:    Country.java
 * Author:      Murdo Wallace
 * Last Edited: 13/2/2024 @ 14:47
 * Purpose:     This class exists to store information about the country item
 *              found in world.sql
 */

package com.napier.Ambry;
import java.util.ArrayList;
import java.sql.*;

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

    public static ArrayList<Country> TopNWorld(int n){
        //Created by: Cameron Smith
        //Epic 2, Task #5

        String select = "SELECT * FROM country ORDER BY population DESC LIMIT " + n;
        return CountryStandard(select);
    }
    public static ArrayList<Country> TopNContinent(int n, String continent){
        //Created by: Cameron Smith
        //Epic 2, Task #6
        String select = "SELECT * FROM country WHERE country.continent='" + continent + "' ORDER BY population DESC LIMIT " + n;
        return CountryStandard(select);
    }

    public static ArrayList<Country> TopNRegion (int n, String region){
        //Created by: Cameron Smith
        //Epic 2, Task #7
        String select = "SELECT * FROM country WHERE country.region='" + region + "' ORDER BY population DESC LIMIT " + n;
        return CountryStandard(select);
    }

    public static String getCountryCode(String CountryCode){
        String countryName = null;
        try {

            Statement stmt = Database.con.createStatement();
            String str_select =
                    "SELECT Name FROM country WHERE country.code = '" + CountryCode + "'";
            ResultSet rset = stmt.executeQuery(str_select);

            while (rset.next()) {
                countryName = (rset.getString("country.Name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return countryName;
    }

    public static ArrayList<Country> CountryStandard(String select) {
        //Stores all countries returned by the input SQL statement.
        ArrayList<Country> Countries = new ArrayList<Country>();

        try {
            //Creates an SQL statement.
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            //Executes the SQL statement input by a seperate function.

            //Creates a new country, stores all relevant values.
            while (rset.next()) {
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getInt("country.Capital"));

                Countries.add(country);
            }
        } catch (SQLException e) {
            //Bypasses problems created by IntelliJ not thinking it's been integrated with SQL.
            throw new RuntimeException(e);
        }
        return Countries;
    }
}
