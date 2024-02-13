package com.napier.Ambry;

public class City {
    private int ID;
    public int getID(){
        return ID;
    }
    public void setID(int setID){
        this.ID = setID;
    }
    private String Name;

    public String getName(){
        return Name;
    }
    public void setName(String setName){
        this.Name = setName;
    }
    private String CountryCode;
    public String getCountryCode()
    {
        return CountryCode;
    }
    public void setCountryCode(String setCode){
        this.CountryCode = setCode;
    }
    private String District;
    public String getDistrict(){
        return District;
    }
    public void setDistrict(String setDistrict){
        this.District = setDistrict;
    }
    private int population;

    public int getPopulation(){
        return population;
    }
    public void setPopulation(int setPopulation){
        this.population = setPopulation;
    }
}
