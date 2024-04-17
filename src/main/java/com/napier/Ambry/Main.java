package com.napier.Ambry;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.sql.*;

import static com.napier.Ambry.CountryReports.*;
import static com.napier.Ambry.CountryLanguageReports.*;
import static com.napier.Ambry.CityReports.*;

public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        if(args.length < 1) {
            // Debugging
            a.connect("localhost:33060", 30000);

            // initializing some variables we'll use later
            ArrayList<Country> countries;
            ArrayList<City> cities;
            int pop;

            System.out.println("\nAll the countries in the world organised by largest population to smallest.");
            countries = getAllCountryLargeToSmall();
            for(int i = 0; i < 5; i++) {
                System.out.println(countries.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll the countries in a continent organised by largest population to smallest");
            countries = getAllCountryPerContinent("Europe");
            for(int i = 0; i < 5; i++) {
                System.out.println(countries.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll the countries in a region organised by largest population to smallest");
            countries = getAllCountryPerRegion("Western Europe");
            for(int i = 0; i < 5; i++) {
                System.out.println(countries.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nThe top N populated countries in the world where N is provided by the user");
            countries = TopNWorld(5);
            for(int i = 0; i < 5; i++) {
                System.out.println(countries.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nThe top N populated countries in a continent where N is provided by the user");
            countries = TopNContinent(5, "Africa");
            for(int i = 0; i < 5; i++) {
                System.out.println(countries.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nThe top N populated countries in a region where N is provided by the user");
            countries = TopNRegion(5, "Middle East");
            for(int i = 0; i < 5; i++) {
                System.out.println(countries.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll cities in the world organised by largest population to smallest");
            cities = WorldCities();
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll cities in a region organised by largest population to smallest");
            cities = RegionCities("Middle East");
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll cities in a country organised by largest population to smallest");
            cities = CountryCities("United Kingdom");
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll cities in a district organised by largest population to smallest");
            cities = DistrictCities("England");
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll the cities in a continent organised by largest population to smallest");
            cities = ContinentCity("North America");
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nTop N populated cities in a world, with N provided by user");
            cities = TopCitiesWorld(5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nTop N populated cities in a continent, with N provided by user");
            cities = TopCitiesContinent("Asia",5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nTop N populated cities in a region, with N provided by user");
            cities = TopCitiesRegion("South America",5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nTop N populated cities in a country, with N provided by user");
            cities = TopCitiesCountry("France",5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nTop N populated cities in a district, with N provided by user");
            cities = TopCitiesDistrict("England",5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll the capital cities in the world organised by largest population to smallest");
            cities = CapitalWorld();
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll the capital cities in a continent organised by largest population to smallest");
            cities = CapitalContinent("Africa");
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nAll the capital cities in a region organised by largest population to smallest");
            cities = CapitalRegion("North America");
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nThe top N populated capital cities in a continent where N is provided by the user");
            cities = ContinentCapitals("Europe", 5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nThe top N populated capital cities in the world where N is provided by the user");
            cities = WorldCapitals(5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nThe top N populated capital cities in a region where N is provided by the user");
            cities = RegionCapitals("Caribbean", 5);
            for(int i = 0; i < 5; i++) {
                System.out.println(cities.get(i).getName() + "'s population: " + countries.get(i).getPopulation());
            }

            System.out.println("\nDisplay the population of people in each region");
            pop = PopulationInRegion("Caribbean");
            System.out.println("Population of the Caribbean: " + pop);

            System.out.println("\nDisplay the population of people living in cities in each region");
            pop = PopulationLivingInCitiesRegion("Caribbean");
            System.out.println("Population of the Caribbean living in cities: " + pop);

            System.out.println("\nDisplay the population of people not living in cities in each region");
            pop = PopulationNotLivingInCitiesRegion("Caribbean");
            System.out.println("Population of the Caribbean not living in cities: " + pop);


            System.out.println("\nDisplay the population of people in each continent");
            pop = PopulationInContinent("Oceania");
            System.out.println("Population of Oceania: " + pop);

            System.out.println("\nDisplay the population of people living in cities in each continent");
            pop = PopulationLivingInCitiesContinent("Oceania");
            System.out.println("Population of Oceania living in cities: " + pop);

            System.out.println("\nDisplay the population of people not living in cities in each continent");
            pop = PopulationNotLivingInCitiesContinent("Oceania");
            System.out.println("Population of Oceania not living in cities: " + pop);

            System.out.println("\nThe population of people in each country");
            pop = PopulationOfCountry("Australia");
            System.out.println("Population of Australia : " + pop);

            System.out.println("\nThe population of people living in cities in each country");
            pop = PopulationLivingInCities("Australia");
            System.out.println("Population of Australia living in cities : " + pop);

            System.out.println("\nThe population of people in each country");
            pop = PopulationNotLivingInCities("Australia");
            System.out.println("Population of Australia not living in cities : " + pop);

            System.out.println("\nThe population of the world");
            long long_pop = WorldPop();
            System.out.println("Population of the world : " + long_pop);

            System.out.println("\nThe population of a district");
            pop = DistrictPop("England");
            System.out.println("Population of England : " + pop);

            System.out.println("\nThe population of a city");
            pop = CityPop("London");
            System.out.println("Population of London : " + pop);

            System.out.println("\nThe population of people that speak a language");
            pop = speaksLanguage("Chinese");
            System.out.println("Population of Chinese speakers : " + pop);

        } else {
            // Live
            a.connect("db:3306", 30000);
        }

        // Disconnect from database
        a.disconnect();
    }
}

