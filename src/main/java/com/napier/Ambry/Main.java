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
        System.out.println("Top Populated Countries in the World: ");
        for (int i = 0; i < topN.size(); i++) {
            System.out.println("Country: " + topN.get(i).getName() + ": " + topN.get(i).getPopulation());
        }

        topN = Country.TopNContinent(10, "Europe");
        System.out.println("Continent: " + topN.get(0).getContinent());
        for (int i = 0; i < topN.size(); i++) {
            System.out.println(topN.get(i).getName() + ": " + topN.get(i).getPopulation());
        }

        topN = Country.TopNRegion(10, "Caribbean");
        System.out.println("Region: " + topN.get(0).getRegion());
        for (int i = 0; i < topN.size(); i++) {
            System.out.println(topN.get(i).getName() + ": " + topN.get(i).getPopulation());
        }

        // Disconnect from database
        a.disconnect();
    }
}
