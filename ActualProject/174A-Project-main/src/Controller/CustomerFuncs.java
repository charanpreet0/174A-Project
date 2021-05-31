package Controller;

import java.sql.Statement;

import Accounts.MarketAcc;

import java.sql.Connection;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import Controller.*;
import jdk.jshell.execution.Util;

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

        public static String retrieve_Customer_name(CHAR username){
            String query = "SELECT C.name " +
                           "From Customers C " + 
                           "WHERE C.username = " + "'" + username + "'";
            ResultSet outputSet = Utility.makeStaticQuery(query);

            String output;

            try{
                if(!outputSet.isBeforeFirst()){
                    System.err.println("Username does not exist");
                }
                
                output = outputSet.getDouble("balance");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return output;
        }

        // list active from abels OR generateActiveUserList from github backend file

        public static String list_active(){    
            String query = "SELECT * " +
                        "FROM Customer C ";
                        
            ResultSet outputSet = Utility.makeStaticQuery(query);
            String output = "";
            try{
                while(outputSet.next()){
                    String username = resultSet.getString("username");
                    String tax_ID = resultSet.getString("Tax_ID");

                    Statement x = Utility.statement;
                    Utility.statement = Utility.connection.createStatement();

                    int totalshares = StockTransaction_DB.get_total_shares(tax_ID);////CHANGE

                    Utility.statement.close();
                    Utility.statement = x;

                    if(total >= 1000){
                        output += "USERNAME: " + username + " TAXID: " + tax_ID + "\n";

                    }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return output;

        }
        // customer report from abels or generateCustomerReport from github backend file

        public static String report(){
            String query = "SELECT * " +
                           "FROM Customers";
            ResultSet outputSet = Utility.makeStaticQuery(query);
            String  output = "";
            try{
                while(outputSetnext()){
                    String user = outputSet.getString("username");
                    String taxID = resultSet.getString("TAXID");
                    Statement x = Utility.statement;
                    Utility.statement = Utility.connection.createStatement();

                    String market_acc_id = MarketAcc.get_market_account(TaxID);
                    double balance_one = MarketAcc.get_acc_balance(market_acc_id);
                    String balance_final = (new balance_one).toString();
                    Utility.statement.close();
                    Utility.statement = x;


                    output += "Username: " + user + ", TAXID: " + taxID
                    + " ,Market Account ID: " +  market_acc_id +
                    " ,balance: " + balance_final + "\n";
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return output;
        }


    } 
}
