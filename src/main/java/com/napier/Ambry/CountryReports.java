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
        String select = "SELECT * FROM country WHERE Continent='" + cont + "'ORDER BY Population DESC";
        return CountryStandard(select);
    }
    /**
     * Epic1: All the countries in a region organised by largest population to smallest.
     * All the countries in a region organised by largest population to smallest.
     * Murdo Wallace / Cameron Smith
     */
    public static ArrayList<Country> getAllCountryPerRegion(String region) {
        String select = "SELECT * FROM country WHERE Region ='" + region + "'ORDER BY population DESC";
        return CountryStandard(select);
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

    // what is this
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

