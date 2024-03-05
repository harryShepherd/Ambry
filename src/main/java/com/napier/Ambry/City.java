/**
 * Filename:    CountryLanguage.java
 * Author:      Cameron Smith
 * Last Edited: 14/2/2024 @ 18:00
 * Purpose:     This class exists to store information about the city item
 *              found in world.sql
 */

package com.napier.Ambry;
import java.util.ArrayList;
import java.sql.*;

public class City {
    //Stores the City ID
    private int ID;
    public int getID(){
        //Gets and returns the ID.
        return ID;
    }
    public void setID(int setID){
        //Sets the ID from a given input.
        this.ID = setID;
    }
    //Stores the City name
    private String Name;
    public String getName(){
        //Gets and returns the City name.
        return Name;
    }
    public void setName(String setName){
        //Sets the City name from the input.
        this.Name = setName;
    }
    //Stores the City's Country Code.
    private String CountryCode;
    public String getCountryCode()
    {
        //Gets and returns the City's Country Code.
        return CountryCode;
    }
    public void setCountryCode(String setCode){
        //Sets the City's country code from the input.
        this.CountryCode = setCode;
    }
    //Stores the city's District.
    private String District;
    public String getDistrict(){
        //Gets and returns the city's District.
        return District;
    }
    public void setDistrict(String setDistrict){
        //Sets the city's District from the input.
        this.District = setDistrict;
    }
    //stores the city's population.
    private int population;
    public int getPopulation(){
        //Gets and returns the city's District.
        return population;
    }
    public void setPopulation(int setPopulation){
        //Sets the city's Population from the input.
        this.population = setPopulation;
    }

    public static ArrayList<City> WorldCities (){
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city ORDER BY population DESC";

        return CityStandard(select);
    }

    public static ArrayList<City> RegionCities(String region){
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE region = '" + region + "' ORDER BY city.population DESC";

        return CityStandard(select);
    }

    public static ArrayList<City> CountryCities(String country){
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE country.name = '" + country + "' ORDER BY city.population DESC";

        return CityStandard(select);
    }

    public static ArrayList<City> DistrictCities(String district) {
        //Stores the query to be sent to the database.
        String select = "SELECT * FROM city WHERE District = '" + district + "' ORDER BY population DESC";

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
                //Need to store Country
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
