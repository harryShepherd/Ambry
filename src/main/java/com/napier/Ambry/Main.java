package com.napier.Ambry;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        // Create new Application Instance
        Database a = new Database();

        // Connect to database
        a.connect();

        ArrayList<Country> countries = a.getAllCountries();

        System.out.println("Size of countries list: ");
        System.out.println(countries.size());

        for(int i =0; i < countries.size(); i++) {
            System.out.println(countries.get(i).getName());
        }

        // Disconnect from database
        a.disconnect();
    }
}
