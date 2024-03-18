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
       ArrayList<CountryLanguage> print = CountryLanguageReports.test();
        //prints all of arraylist print
        System.out.print("getAllCountryLargeToSmall: \n");
        System.out.print("\n");
        for(int i = 0; i < print.size(); i++){
            System.out.print(print.get(i).getCountryCode() + "\n");
        }




        // Disconnect from database
        a.disconnect();
    }
}

