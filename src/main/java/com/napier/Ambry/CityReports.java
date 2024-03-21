package com.napier.Ambry;

/*
 * Filename:    CityReports.java
 * Author:      Cameron Smith
 * Last Edited: 21/03/2024
 * Purpose:     This class exists to store the functions designed to interact primarily/exclusively with the City.java file/type.
 */

import java.util.ArrayList;
import java.sql.*;

public class CityReports {
    // Epic 3 - All cities organised by population descending.
    // All cities in the world organised by largest population to smallest.
    public static ArrayList<City> WorldCities (){
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city ORDER BY population DESC";

        return CityStandard(select);
    }

    // Epic 3 - All cities in a region organised by largest population to smallest.
    public static ArrayList<City> RegionCities(String region){
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE region = '" + region + "' ORDER BY city.population DESC";

        return CityStandard(select);
    }

    // Epic 3 - All cities in a country organised by largest population to smallest.
    public static ArrayList<City> CountryCities(String country){
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE country.name = '" + country + "' ORDER BY city.population DESC";

        return CityStandard(select);
    }

    // Epic 3 - All cities in a district organised by largest population to smallest.
    public static ArrayList<City> DistrictCities(String district) {
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city WHERE District = '" + district + "' ORDER BY population DESC";

        return CityStandard(select);
    }
    // Epic 3 - All the cities in a continent organised by largest population to smallest.
    //Murdo Wallace
    //Last edited 07/03/2024
    //takes in a string for the continent and returns all cities within that continent organised by population
    public static ArrayList<City> ContinentCity(String continent) {
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city INNER JOIN country ON country.code = city.countryCode WHERE country.Continent = '" + continent+ "'ORDER BY city.population DESC";

        return CityStandard(select);
    }

    public static ArrayList<City> CityStandard(String select){
        //Stores the Cities relevant to the input SQL statement
        ArrayList<City> Cities = new ArrayList<City>();

        try {
            //Creates the statement as an SQL statement.
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            //Executes the query to return all values to be stored.

            //Creates a new city and stores the relevant values before adding it to the ArrayList.
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountryCode(rset.getString("city.CountryCode"));
                //Need to store Country but can only access via CountryCode
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));

                Cities.add(city);
            }
        } catch (SQLException e) {
            //Bypasses problems created by IntelliJ not thinking it's been integrated with SQL.
            throw new RuntimeException(e);
        }

        return Cities;
    }
}
