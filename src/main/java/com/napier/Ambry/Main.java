package com.napier.Ambry;

import java.util.ArrayList;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        // Create new Application Instance
        Database a = new Database();

        if(args.length < 1) {
            // Debugging
            a.connect("localhost:33060", 30000);
        } else {
            // Live
            a.connect("db:3306", 30000);
        }

        // Disconnect from database
        a.disconnect();
    }
}

