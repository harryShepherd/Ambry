package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        // Connect to database
        a.connect();

       // ArrayList<Country> print = Country.getAllCountryLargeToSmall();
        /*
        for(int i = 0; i < print.size(); i++){
            System.out.print(print.get(i).getName() + "\n");
        }
    */
        ArrayList<Country> print2 = Country.getAllCountryPerContinent();

        for(int i = 0; i < print2.size(); i++){
            System.out.print(print2.get(i).getName() + "\n");
        }



        // Disconnect from database
        a.disconnect();
    }
}

