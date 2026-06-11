package db;

import java.sql.*;
import java.util.*;

public class DBUtil {
    public static List<Object[]> getDBData() throws Exception {
        // Connect to your local database
        String url = "jdbc:mysql://localhost:3306/testdb";
        Connection con = DriverManager.getConnection(url, "root", "pass@word1");
        Statement stmt = con.createStatement();
        
        // Select data from your registration table
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        List<Object[]> data = new ArrayList<>();
        
        while (rs.next()) {
            data.add(new Object[] { 
            		rs.getString("firstname"), rs.getString("lastname"), rs.getString("address"),
            	    rs.getString("city"), rs.getString("state"), rs.getString("zip"),
            	    rs.getString("phone"), rs.getString("ssn"), rs.getString("username"),
            	    rs.getString("password"), rs.getString("confirm")
            });
        }
        con.close();
        return data;
    }
}