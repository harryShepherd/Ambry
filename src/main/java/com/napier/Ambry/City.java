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
        ArrayList<City> Cities = new ArrayList<City>();

        try{
            //Stores the statement
            Statement stmt = Database.con.createStatement();
            //Stores the query to be sent to the database.
            String select = "SELECT * FROM city ORDER BY population DESC";

            //Executes the query stored in select.
            ResultSet rset = stmt.executeQuery(select);
            //Returns country code, name, continent, region, and population.
            //Stores the above values in the TopCountries ArrayList which stores the countries meeting the criteria.
            while(rset.next()){
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setPopulation(rset.getInt("city.Population"));

                Cities.add(city);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Cities;
    }

    public static ArrayList<City> RegionCities(String region){
        ArrayList<City> Cities = new ArrayList<City>();

        try{
            //Stores the statement
            Statement stmt = Database.con.createStatement();
            //Stores the query to be sent to the database.
            String select = "SELECT * FROM city JOIN country ON city.CountryCode = country.Code WHERE region = '" + region + "' ORDER BY city.population DESC";

            //Executes the query stored in select.
            ResultSet rset = stmt.executeQuery(select);
            //Returns country code, name, continent, region, and population.
            //Stores the above values in the TopCountries ArrayList which stores the countries meeting the criteria.
            while(rset.next()){
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setPopulation(rset.getInt("city.Population"));

                Cities.add(city);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Cities;
    }
}
