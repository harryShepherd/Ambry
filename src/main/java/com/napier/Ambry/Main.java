package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        // Connect to database
        a.connect();
        //creating an arraylist to store the output of TopCityWorld

        ArrayList<City> print = City.TopCityWorld(5);
        System.out.print("Top N populated cities in the world: \n");
        System.out.print("\n");
        //Prints all of arraylist print
        for(int i = 0; i < print.size(); i++){
            System.out.print(print.get(i).getName() + "\n");
        }
        // Disconnect from database
        a.disconnect();
    }
}

