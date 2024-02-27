/**
 * Filename:    Country.java
 * Author:      Murdo Wallace
 * Last Edited: 13/2/2024 @ 14:47
 * Purpose:     This class exists to store information about the country item
 *              found in world.sql
 */

package com.napier.Ambry;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.io.InputStreamReader;

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

        //Stores the countries that meet the required criteria.
        ArrayList<Country> TopCountries = new ArrayList<Country>();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        /*
        System.out.println("How many countries would you like to display?");
        try {
            n = Integer.parseInt(read.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

        try{
            //Stores the statement
            Statement stmt = Database.con.createStatement();
            //Stores the query to be sent to the database.
            String select = "SELECT * FROM country ORDER BY population DESC LIMIT " + n;

            //Executes the query stored in select.
            ResultSet rset = stmt.executeQuery(select);
            //Returns country code, name, continent, region, and population.
                //Stores the above values in the TopCountries ArrayList which stores the countries meeting the criteria.
            while(rset.next()){
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setContinent(rset.getString("country.Continent"));

                TopCountries.add(country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return TopCountries;
    }
    public static ArrayList<Country> TopNContinent(int n, String continent){
        //Created by: Cameron Smith
        //Epic 2, Task #6

        //Stores the top N countries by population in a continent.
        ArrayList<Country> TopCountries = new ArrayList<Country>();

        /*
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How many countries would you like to display?");
        try {
            n = Integer.parseInt(read.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("What continent would you like to look at?");
        try {
            continent = read.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

        try{
            //Stores the statement
            Statement stmt = Database.con.createStatement();
            //Stores the query to be sent to the database.
            String select = "SELECT * FROM country WHERE country.continent='" + continent + "' ORDER BY population DESC LIMIT " + n;

            //Executes the query stored in select.
            ResultSet rset = stmt.executeQuery(select);
            //Returns country code, name, continent, region, and population.
            //Stores the above values in the TopCountries ArrayList which stores the countries meeting the criteria.
            while(rset.next()){
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setPopulation(rset.getInt("country.Population"));
                TopCountries.add(country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return TopCountries;
    }

    public static ArrayList<Country> TopNRegion (int n, String region){
        //Created by: Cameron Smith
        //Epic 2, Task #7

        //Stores the top N countries by population in a continent.
        ArrayList<Country> TopCountries = new ArrayList<Country>();

        try{
            //Stores the statement
            Statement stmt = Database.con.createStatement();
            //Stores the query to be sent to the database.
            String select = "SELECT * FROM country WHERE country.region='" + region + "' ORDER BY population DESC LIMIT " + n;

            //Executes the query stored in select.
            ResultSet rset = stmt.executeQuery(select);
            //Returns country code, name, continent, region, and population.
            //Stores the above values in the TopCountries ArrayList which stores the countries meeting the criteria.
            while(rset.next()){
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                TopCountries.add(country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return TopCountries;
    }
}
