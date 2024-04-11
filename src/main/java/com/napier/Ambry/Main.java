package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;

import static com.napier.Ambry.CountryReports.*;

public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        if(args.length < 1) {
            // Debugging
            a.connect("localhost:33060", 30000);

            int pop = PopulationOfCountry("United Kingdom");

            System.out.println("Population of uk:" + pop);

            pop = PopulationNotLivingInCities("United Kingdom");

            System.out.println("Population of uk not living in cities:" + pop);

            pop = PopulationLivingInCities("United Kingdom");

            System.out.println("Population of uk living in cities:" + pop);

        } else {
            // Live
            a.connect("db:3306", 30000);
        }

        // Disconnect from database
        a.disconnect();
    }
}

