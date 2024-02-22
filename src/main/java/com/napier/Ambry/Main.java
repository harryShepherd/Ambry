package com.napier.Ambry;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        // Create new Application Instance
        Database a = new Database();
        // Connect to database
        a.connect();


        ArrayList<Country> topN = Country.TopNWorld(10);
        for (int i = 0; i < topN.size(); i++) {
            System.out.println(topN.get(i).getName() + ": " + topN.get(i).getPopulation());
        }


        // Disconnect from database
        a.disconnect();
    }
}
