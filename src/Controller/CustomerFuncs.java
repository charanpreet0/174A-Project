package Controller;

import java.sql.Statement;
import java.sql.Connection;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import Controller.*;

public class CustomerFuncs {
    // In this class we will do the Functions for the customer such as signing up and checking who is active
    // as well as 
    public static void insert_Customer(String name, String state, String email_address, String tax_ID_num, String password, String username){
        String my_query = "INSERT INTO Customer(name, state, email_address, tax_ID_num, password, username)" 
                            + "VALUES (?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = CreateAndInitTable.connect();
    Statement stmt = conn.createStatement() )
    {
        PreparedStatement preparedStatement = stmt.prepareStatement(my_query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, state);
        preparedStatement.setString(3, email_address);
        preparedStatement.setString(4, tax_ID_num);
        preparedStatement.setString(5, password);
        preparedStatement.setString(6, username);
        preparedStatement.executeUpdate();
        PrintExtension.info("Registration succeeded, creating market account...");
    } catch (SQLException e) {
        PrintExtension.warning("Registration failed w/ SQLException");

        }   
        // need query customer from github backend file

        // list active from abels OR generateActiveUserList from github backend file

        // customer report from abels or generateCustomerReport from github backend file
    } 
}
