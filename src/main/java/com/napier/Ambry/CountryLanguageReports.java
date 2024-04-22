package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;

/*
 * Filename:    CountryLanguageReports.java
 * Author:      Murdo Wallace
 * Last Edited: 21/04/2024 @ 11:52
 * Purpose:     This class exists to store the functions designed to interact primarily/exclusively with the CountryLanguage.java file/type.
 */
public class CountryLanguageReports {

    /**
     * Epic 9: population of all countries that speak chinese
     * Murdo Wallace
     */
    public static int speaksLanguage(String language) {
        String select = "SELECT SUM(country.Population) " +
                "FROM countrylanguage " +
                "JOIN country ON country.Code = countrylanguage.CountryCode " +
                "WHERE countrylanguage.Language='" + language + "'";

        try {
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            rset.next();
            return rset.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Murdo wallace
     * Stores the relevant standard for a CountryLanguage report.
     */
    public static ArrayList<CountryLanguage> CountryLanguageStandard(String select) {
        //Stores all countries returned by the input SQL statement.
        ArrayList<CountryLanguage> CountryLanguages = new ArrayList<>();

        try {
            //Creates an SQL statement.
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            //Executes the SQL statement input by a separate function.

            //Creates a new country, stores all relevant values.
            while (rset.next()) {
                CountryLanguage countryLanguage = new CountryLanguage();
                countryLanguage.setCountryCode(rset.getString("countryLanguage.CountryCode"));
                countryLanguage.setLanguage(rset.getString("countryLanguage.Language"));
                countryLanguage.setIsOfficial(rset.getString("countryLanguage.IsOfficial"));
                countryLanguage.setPercentage(rset.getFloat("countryLanguage.Percentage"));


                CountryLanguages.add(countryLanguage);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return CountryLanguages;
    }

}
