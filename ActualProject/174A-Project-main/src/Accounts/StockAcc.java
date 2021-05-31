package Accounts;
import java.sql.*;

public class StockAcc {
    public static void make_Stock_transaction(){}
    
    public static void delete_transaction(){}

    public static int get_total_shares(){}

    public static double get_total_profit(){}

    public static String get_transactions(){}

    public static ResultSet getTransactionsHistoryForCustomerOnTable(String customer_username, String table_name) {}
   
    public static String getTransactionsHistoryForCustomerStockAccount(String customer_username) {}

    public static double get_shares(String customer_username, String stock_symbol, double original_buying_price) {}

    // public static void buy_shares(String customer_username, int num_shares, String stock_symbol) {}

    public static void sell_shares(String customer_username, int num_shares, String stock_symbol, double original_buying_price) {}

    public static void setStock(String Stock_Sym, double Stock_Price) {
        // Here we need to have an update query for re setting the stock price 
    }
}
