package com.napier.Ambry;

/**
 * Filename:    CountryLanguage.java
 * Author:      Cameron Smith
 * Last Edited: 14/2/2024 @ 18:00
 * Purpose:     This class exists to store information about the city item
 *              found in world.sql
 */

public class City {
    /**
     * Cameron Smith
     * Stores the city's ID.
     */
    private int ID;

    /**
     * Cameron Smith
     * Gets and returns the ID value.
     */
    public int getID(){
        return ID;
    }
    /**
     * Cameron Smith
     * Sets the ID value from provided input.
     */
    public void setID(int setID){
        this.ID = setID;
    }
    /**
     * Cameron Smith
     * Stores the city name
     */
    private String Name;

    /**
     * Cameron Smith
     * Gets and returns the City name.
     */
    public String getName(){
        return Name;
    }

    /**
     * Cameron Smith
     * Sets the city name
     */
    public void setName(String setName){
        //Sets the City name from the input.
        this.Name = setName;
    }

    /**
     * Cameron Smith
     * Stores the CountryCode of the country the city is in.
     */
    private String CountryCode;

    /**
     * Cameron Smith
     * Gets and returns the CountryCode.
     */
    public String getCountryCode()
    {
        //Gets and returns the City's Country Code.
        return CountryCode;
    }
    /**
     * Cameron Smith
     * Sets the CountryCode based on input.
     */
    public void setCountryCode(String setCode){
        //Sets the City's country code from the input.
        this.CountryCode = setCode;
    }
    /**
     * Cameron Smith
     * Stores the district the city is in.
     */
    private String District;

    /**
     * Cameron Smith
     * Gets and returns the District.
     */
    public String getDistrict(){
        return District;
    }
    /**
     * Cameron Smith
     * Sets the District based on the input value.
     */
    public void setDistrict(String setDistrict){
        this.District = setDistrict;
    }

    /**
     * Cameron Smith
     * Stores the population of the city.
     */
    private int population;

    /**
     * Cameron Smith
     * Gets and returns the population of the city.
     */
    public int getPopulation(){
        //Gets and returns the city's District.
        return population;
    }

    /**
     * Cameron Smith
     * Sets the population of the city.
     */
    public void setPopulation(int setPopulation){
        //Sets the city's Population from the input.
        this.population = setPopulation;
    }
}