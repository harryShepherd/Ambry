package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        // Connect to database
        a.connect();
        //creating an arraylist to store the output of Cities
        ArrayList<City> Cities = City.CapitalWorld();
        System.out.println("Populated Cities in the World: ");
        for (int i = 0; i < Cities.size(); i++) {
            System.out.println("City: " + Cities.get(i).getName() + ": " + Cities.get(i).getPopulation());
        }




        // Disconnect from database
        a.disconnect();
    }
}

