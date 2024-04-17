package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;

/*
 * Filename:    CityReports.java
 * Author:      Cameron Smith
 * Last Edited: 14/2/2024 @ 18:00
 * Purpose:     This class exists to store the functions designed to interact primarily/exclusively with the CountryLanguage.java file/type.
 */
public class CountryLanguageReports {

    /**
     * Epic 9: population of all countries that speak chinese
     * Murdo Wallace
     */
    public static int speaksLanguage(String language) {
        int pop = 0;
        String select = "SELECT SUM(country.Population) AS total_population_of_chinese_speakers " +
                "FROM countrylanguage " +
                "JOIN country ON country.Code = countrylanguage.CountryCode " +
                "WHERE countrylanguage.Language='Chinese' AND country.Name=?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
             PreparedStatement stmt = conn.prepareStatement(select)) {
            stmt.setString(1, language);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pop = rs.getInt("total_population_of_chinese_speakers");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pop;
    }



    public static ArrayList<CountryLanguage> CountryLanguageStandard(String select) {
        //Stores all countries returned by the input SQL statement.
        ArrayList<CountryLanguage> CountryLanguages = new ArrayList<CountryLanguage>();



        try {
            //Creates an SQL statement.
            Statement stmt = Database.con.createStatement();
            ResultSet rset = stmt.executeQuery(select);
            //Executes the SQL statement input by a seperate function.

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
