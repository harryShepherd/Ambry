package com.napier.Ambry;

/*
 * Filename:    CountryReports.java
 * Author:      Cameron Smith
 * Last Edited: 21/03/2024
 * Purpose:     This class exists to store the functions designed to interact primarily/exclusively with the Country.java file/type.
 */

import java.util.ArrayList;
import java.sql.*;

public class CountryReports {
    /**
     * Epic1: Countries by Largest population to Smallest
     * All the countries in the world organised by largest population to smallest.
     * Murdo Wallace / Cameron Smith
     */
    public static ArrayList<Country> getAllCountryLargeToSmall() {
        //connects to the database
        String select = "SELECT * FROM country ORDER BY Population DESC";
        return CountryStandard(select);
    }
    /**
     * Epic1: All the countries in a continent organised by largest population to smallest.
     * returns All the countries in a continent organised by largest population to smallest.
     * Murdo Wallace / Harry Shepherd / Cameron Smith
     */
    public static ArrayList<Country> getAllCountryPerContinent(String cont) {
        String select = "";
        if(cont != null) {
            select = "SELECT * FROM country WHERE Continent='" + cont + "'ORDER BY Population DESC";
        }
        return CountryStandard(select);
    }
    /**
     * Epic1: All the countries in a region organised by largest population to smallest.
     * All the countries in a region organised by largest population to smallest.
     * Murdo Wallace / Cameron Smith
     */
    public static ArrayList<Country> getAllCountryPerRegion(String region) {
        String select = "";
        if(region != null) {
            select = "SELECT * FROM country WHERE Region ='" + region + "'ORDER BY population DESC";
        }
        return CountryStandard(select);
    }

    /**
     * Epic 2: The top N populated countries in the world where N is provided by the user.
     * Cameron Smith
     */
    public static ArrayList<Country> TopNWorld(int n){
        //Created by: Cameron Smith
        //Epic 2, Task #5

        String select = "";
        if(n > 0) {
            select = "SELECT * FROM country ORDER BY population DESC LIMIT " + n;
        }
        return CountryStandard(select);
    }

    /**
     * Epic 2: The top N populated countries in a continent where N is provided by the user.
     * Cameron Smith
     */
    public static ArrayList<Country> TopNContinent(int n, String continent){
        //Created by: Cameron Smith
        //Epic 2, Task #6
        String select = "";
        if(n > 0 && continent != null) {
            select = "SELECT * FROM country WHERE country.continent='" + continent + "' ORDER BY population DESC LIMIT " + n;
        }
        return CountryStandard(select);
    }

    /**
     * Epic 2: The top N populated countries in a region where N is provided by the user.
     * Cameron Smith
     */
    public static ArrayList<Country> TopNRegion (int n, String region){
        //Created by: Cameron Smith
        //Epic 2, Task #7
        String select = "";
        if(n > 0 && region != null) {
            select = "SELECT * FROM country WHERE country.region='" + region + "' ORDER BY population DESC LIMIT " + n;
        }
        return CountryStandard(select);
    }

    /**
     * Epic 7: The population of people in each country
     * Harry Shepherd
     */
    public static int PopulationOfCountry(String country) {
        int pop = 0;
        String select = "SELECT * FROM country WHERE country.name='" + country + "'";
        return CountryStandard(select).get(0).getPopulation();
    }

    /**
     * Epic 7: The population of people living in cities in each country
     * Harry Shepherd
     */
    public static int PopulationLivingInCities(String country) {
        int pop = 0;
        String select = "SELECT * FROM country WHERE country.name='" + country + "'";
        Country selected_country = CountryStandard(select).get(0);
        select = "SELECT SUM(city.Population) FROM city WHERE city.CountryCode='" + selected_country.getCode() + "'";

        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);

            while (rset.next()) {
                pop = rset.getInt(1);
            }
        } catch (SQLException e) {
            //Bypasses problems created by IntelliJ not thinking it's been integrated with SQL.
            throw new RuntimeException(e);
        }
        return pop;
    }

    /**
     * Epic 7: The population of people not living in cities in each country
     * Harry Shepherd
     */
    public static int PopulationNotLivingInCities(String country) {
        int pop = PopulationOfCountry(country);
        int pop_in_city = PopulationLivingInCities(country);

        return pop - pop_in_city;
    }

    /**
     * Epic 8: Population of the world
     * Sam Wilson-Perkins
     */
    public static long WorldPop(){
        long pop=0;
        //Stores the query to be sent to the database.
        String select = "SELECT SUM(population) FROM country";
        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            rset.next();
            pop = rset.getLong(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pop;
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

