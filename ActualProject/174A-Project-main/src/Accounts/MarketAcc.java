package Accounts;

import java.sql.ResultSet;

import javax.swing.text.Utilities;

public class MarketAcc {


    
    // get mrkt acc
    public static String get_market_account(String TaxID){
        String query = "SELECT H.ID_number " + 
                       "FROM Has_market_acc H, Customer C " + 
                       "WHERE H.username = C.username AND C.tax_ID = " + "'" + TaxID + "'";
        ResultSet resultSet = Utitity.makeStaticQuery(query);
        
        String output = "";
        try{
            if(!resultSet.next()){
                System.err.println("This TaxID Does Not Exist\n");
                System.exit(1);
            }
            res = resultSet.getString("ID_number");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return output;
    }


    // get_acc_balance

    public static double get_acc_balance(String customerUsername){//might need fixing CustomerFuncs takes in accountID
        String query = "SELECT A.balance " + 
                       "FROM Account A, Has_market_acc H" +
                       "WHERE A.ID_number = H.ID_number AND H.username = " + "'" + customerUsername + "'";
                       
        ResultSet outputSet = Utility.makeStaticQuery(query);


        double output = 0;

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

    // add and subtract balance

    public static void add_to_balance(String username, double amount){
        String query = "UPDATE Has_market_acc " +
                       "SET balance = balance + " amount + " " +
                       "WHERE username = \'" + username + "\';";
        Utility.makeStaticUpdate(query);

        int transaction_id = Customer_DB.get_next_id("DepositTransaction", "transaction_id");

        UPDATE = "INSERT INTO Deposit"
        //WORK ON Transaction ID STUFF
    }

    public static void subtract_from_balance(String username, double amount){
        String query = "UPDATE Has_market_acc " +
                       "SET balance = balance - " amount + " " +
                       "WHERE username = \'" + username + "\';";
        Utility.makeStaticUpdate(query);

        // WORK ON TRANSACTION ID

    }

    // deposit and withdraw on backend file on github
}
