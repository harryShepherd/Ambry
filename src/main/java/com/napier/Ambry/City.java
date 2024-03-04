/**
 * Filename:    CountryLanguage.java
 * Author:      Cameron Smith
 * Last Edited: 14/2/2024 @ 18:00
 * Purpose:     This class exists to store information about the city item
 *              found in world.sql
 */

package com.napier.Ambry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    /**
     * Epic4: Top populated cities
     * Top N populated cities in a world, with N provided by user
     * Sam Wilson-Perkins
     */

    public static ArrayList<City> TopNPopCitiesInWorld(int n){

        //Stores the countries that meet the required criteria.
        ArrayList<City> TopCities = new ArrayList<City>();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        /*
        System.out.println("How many cities would you like to display?");
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
            String select = "SELECT * FROM city ORDER BY population DESC LIMIT " + n;

            //Executes the query stored in select.
            ResultSet rset = stmt.executeQuery(select);
            //Returns city code, name, continent, region, and population.
            //Stores the above values in the TopCities ArrayList which stores the cities meeting the criteria.
            while(rset.next()){
                City city = new City();
                city.setID(rset.getInt("city.ID"));
                city.setName(rset.getString("city.Name"));
                city.setPopulation(rset.getInt("city.Population"));
                city.setDistrict(rset.getString("city.District"));

                TopCities.add(city);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return TopCities;
    }

    /**
     * Epic4: Top N populated cities in a continent, with N provided by user
     * Sam Wilson-Perkins
     */

    /**
     * Epic4: Top N populated cities in a region, with N provided by user
     * Sam Wilson-Perkins
     */

    /**
     * Epic4: Top N populated cities in a country, with N provided by user
     * Sam Wilson-Perkins
     */

    /**
     * Epic4: Top N populated cities in a district, with N provided by user
     * Sam Wilson-Perkins
     */
}
