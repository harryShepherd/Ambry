package com.napier.Ambry;

public class Main {
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Disconnect from database
        // a.disconnect();
    }
}
