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

        // Disconnect from database
        a.disconnect();
    }
}
