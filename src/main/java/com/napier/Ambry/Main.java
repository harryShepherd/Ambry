package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;

import static com.napier.Ambry.CountryReports.*;
import static com.napier.Ambry.CityReports.*;

public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        if(args.length < 1) {
            // Debugging
            a.connect("localhost:33060", 30000);

            //TODO: Fill this up with stuff that showcases
            //TODO: that everything works.

        } else {
            // Live
            a.connect("db:3306", 30000);
        }


        System.out.println(CountryLanguageReports.speaksLanguage("Chinese"));
        System.out.println("test");
        // Disconnect from database
        a.disconnect();
    }
}

