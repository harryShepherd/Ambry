package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        // Connect to database
        a.connect();
        //creating an arraylist to store the output of getAllCountryLargeToSmall
       ArrayList<Country> print = Country.getAllCountryLargeToSmall();
        //prints all of arraylist print
        System.out.print("getAllCountryLargeToSmall: \n");
        System.out.print("\n");
        for(int i = 0; i < print.size(); i++){
            System.out.print(print.get(i).getName() + "\n");
        }
        System.out.print("\n");

        //creating an arraylist to store the output of getAllCountryPerContinent
        //where the continent is asia
        ArrayList<Country> print2 = Country.getAllCountryPerContinent("Asia");
        System.out.print("getAllCountryPerContinent: \n");
        System.out.print("\n");
        //prints all of arraylist print2
        for(int i = 0; i < print2.size(); i++){
            System.out.print(print2.get(i).getName() + "\n");
        }



        // Disconnect from database
        a.disconnect();
    }
}

