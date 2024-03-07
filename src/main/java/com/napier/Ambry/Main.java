package com.napier.Ambry;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        // Create new Application Instance
        Database a = new Database();

        // Connect to database
        a.connect();
        ArrayList<City> Cities = City.WorldCities();

        /*
        ArrayList<City> Cities = City.WorldCities();
        System.out.println("Populated Cities in the World: ");
        for (int i = 0; i < Cities.size(); i++) {
            System.out.println("City: " + Cities.get(i).getName() + ": " + Cities.get(i).getPopulation());
        }
        Cities = City.RegionCities("Caribbean");
        System.out.println("Populated Cities in the Region: ");
        for (int i = 0; i < Cities.size(); i++) {
            System.out.println("City: " + Cities.get(i).getName() + ": " + Cities.get(i).getPopulation());
        }
        Cities=City.CountryCities("United Kingdom");
        System.out.println("Populated Cities in the Country: ");
        for (int i = 0; i < Cities.size(); i++) {
            System.out.println("City: " + Cities.get(i).getName() + ": " + Cities.get(i).getPopulation());
        }

         */
        Cities=City.ContinentCity("Asia");
        System.out.println("Populated Cities in the District: ");
        for (int i = 0; i < Cities.size(); i++) {
            System.out.println("City: " + Cities.get(i).getName() + ": " + Cities.get(i).getPopulation());
        }



        // Disconnect from database
        a.disconnect();
    }
}
