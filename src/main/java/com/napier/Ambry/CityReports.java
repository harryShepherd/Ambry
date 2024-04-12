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


    /*
     * Epic4: Top populated cities
     * Top N populated cities in a world, with N provided by user
     * Sam Wilson-Perkins
     */
    public static ArrayList<City> TopCitiesWorld (int N){
        //Stores query that gets sent to database.
        String select = "SELECT * FROM city ORDER BY population DESC LIMIT " + N;

        return CityStandard(select);
    }

    /*
     * Epic4: Top N populated cities in a continent, with N provided by user
     * Sam Wilson-Perkins
     */
    public static ArrayList<City> TopCitiesContinent (String continent, int N){
        //Stores query that gets sent to database.
        String select = "SELECT * " +
                "FROM city INNER JOIN country ON country.Code = city.CountryCode " +
                " WHERE country.Continent = '" + continent
                + "' ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }

    /*
     * Epic4: Top N populated cities in a region, with N provided by user
     * Sam Wilson-Perkins
     */

    public static ArrayList<City> TopCitiesRegion (String region, int N){
        //Stores query that gets sent to database.
        String select = "SELECT * " +
                "FROM city INNER JOIN country ON country.Code = city.CountryCode " +
                " WHERE country.Region = '" + region
                + "' ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }

    /*
     * Epic4: Top N populated cities in a country, with N provided by user
     * Sam Wilson-Perkins
     */
    public static ArrayList<City> TopCitiesCountry (String country, int N){
        //Stores query that gets sent to database.
        String select = "SELECT * " +
                "FROM city INNER JOIN country ON country.Code = city.CountryCode " +
                " WHERE country.name = '" + country
                + "' ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }


    /*
     * Epic4: Top N populated cities in a district, with N provided by user
     * Sam Wilson-Perkins
     */
    public static ArrayList<City> TopCitiesDistrict (String district, int N){
        //Stores query that gets sent to database.
        String select = "SELECT * " +
                "FROM city WHERE district = '" + district
                + "' ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }


    /*
        Epic 5, task 1
        Created by: Cameron
        Date: 16/03/2024
    */
    public static ArrayList<City> CapitalWorld(){
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE city.id = country.capital ORDER BY city.population DESC";
        return CityStandard(select);
    }
    /*
        Epic 5, task 2
        Created by: Cameron
        Date: 16/03/2024
    */
    public static ArrayList<City> CapitalContinent(String continent){
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE city.id = country.capital AND country.Continent = '" + continent + "' ORDER BY city.population DESC";
        return CityStandard(select);
    }
    /*
        Epic 5, task 3
        Created by: Cameron
        Date: 16/03/2024
    */
    public static ArrayList<City> CapitalRegion(String region){
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE city.id = country.capital AND country.Region = '" + region + "' ORDER BY city.population DESC";
        return CityStandard(select);
    }

    //Task 24 (Epic 6): The top N populated capital cities in a continent where N is provided by the user.
    //Murdo Wallace
    //Last edited 07/03/2024
    //takes in a continent as a string and the limit of cities show as a string
    public static ArrayList<City> ContinentCapitals(String continent, int N) {
        //Stores the query to be sent to the database.
        String select = "SELECT * " +
                "FROM city INNER JOIN country ON country.capital = city.ID " +
                " WHERE country.Continent = '" + continent
                + "' ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }

    //Task 26 (Epic 6):The top N populated capital cities in the world where N is provided by the user.
    //Murdo Wallace
    //Last edited 07/03/2024
    //Outputs capitals cities ordered by population. Takes in a string that will determine the limit of the output
    public static ArrayList<City> WorldCapitals(int N) {
        //Stores the query to be sent to the database.
        String select = "SELECT * " +
                "FROM city INNER JOIN country ON country.capital = city.ID ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }

    //Task 41 (epic 6)The top N populated capital cities in a region where N is provided by the user.
    //Murdo Wallace
    //Last edited 07/03/2024
    ///takes in a continent as a string and the limit of cities show as a string
    public static ArrayList<City> RegionCapitals(String Region, int N) {
        //Stores the query to be sent to the database.
        String select = "SELECT * " +
                "FROM city INNER JOIN country ON country.capital = city.ID " +
                " WHERE country.Region = '" + Region
                + "' ORDER BY city.population DESC LIMIT " + N;

        return CityStandard(select);
    }

    /**
     * Epic 7: Display the  population of people, people living in cities, and people not living in cities in each region
     * Harry Shepherd
     */
    public static int PopulationInRegion(String region) {
        int pop;
        String select = "SELECT SUM(country.Population) FROM country WHERE country.Region='" + region + "'";

        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            rset.next(); // this stops resultset having a massive fit
            pop = rset.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pop;
    }

    public static int PopulationLivingInCitiesRegion(String region) {
        int pop = 0;
        String select = "SELECT SUM(city.Population) FROM city JOIN country ON country.Code = city.CountryCode" +
                " WHERE country.Region='" + region + "'";
        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            rset.next(); // this stops resultset having a massive fit
            pop = rset.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pop;
    }

    public static int PopulationNotLivingInCitiesRegion(String region) {
        int pop = PopulationInRegion(region);
        int pop_in_city = PopulationLivingInCitiesRegion(region);

        return pop - pop_in_city;
    }

    public static int PopulationInContinent(String continent) {
        int pop = 0;

        String select = "SELECT SUM(country.Population) FROM country WHERE country.Continent='" + continent + "'";

        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            rset.next();
            pop = rset.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pop;
    }

    public static int PopulationLivingInCitiesContinent(String continent) {
        int pop = 0;

        String select = "SELECT SUM(city.Population) FROM city JOIN country ON city.CountryCode = country.Code" +
        " WHERE country.Continent='" + continent + "'";
        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            rset.next();
            pop = rset.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pop;
    }

    public static int PopulationNotLivingInCitiesContinent(String continent) {
        int pop = PopulationInContinent(continent);
        int pop_in_city = PopulationLivingInCitiesContinent(continent);

        return pop - pop_in_city;
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
