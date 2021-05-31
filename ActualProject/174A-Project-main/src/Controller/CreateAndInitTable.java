package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author sqlitetutorial.net
 */
public class CreateAndInitTable{

    /**
     * Create a new table in the test database
     *
     */

    public static String[] createArray() {
        String sql1 = "CREATE TABLE Customer(\n"
                + " name STRING,\n"
                + " state CHAR(2),\n"
                + " email_address CHAR(30),\n"
                + " tax_ID_num CHAR(9),\n"
                + " password CHAR(20),\n"
                + " username CHAR(20),\n"
                + " PRIMARY KEY (username)\n"
                + ");";

        String sql2 = "CREATE TABLE Movies(\n"
                + " title CHAR(30),\n"
                + " production_year CHAR(4),\n"
                + " reviews STRING,\n"
                + " ranking INTEGER,\n"
                + " PRIMARY KEY (title),\n"
                + ");";

        String sql3 = "CREATE TABLE Actor_Director(\n"
                + " name STRING,\n"
                + " stock_symbol CHAR(5),\n"
                + " dob char(10),\n"
                + " PRIMARY KEY (name),\n"
                + ");";

        String sql4 = "CREATE TABLE movie_contract(\n"
                + " title CHAR(30),\n"
                + " state CHAR(2),\n"
                + " email_address CHAR(30),\n"
                + " tax_ID_num CHAR(9),\n"
                + " password CHAR(20),\n"
                + " username CHAR(20),\n"
                + " PRIMARY KEY (username)\n"
                + ");";

        String sql5 = "CREATE TABLE Movie_contract(\n"
                + " title CHAR(30),\n"
                + " name STRING,\n"
                + " total_value REAL,\n"
                + " year CHAR(4),\n"
                + " role STRING,\n"
                + " FOREIGN KEY (title) REFERENCES Movies,\n"
                + " FOREIGN KEY (name) REFERENCES Actor_Director,\n"
                + " ON DELETE CASCADE,\n"
                + " ON UPDATE CASCADE,\n"
                + ");";
        String sql6 = "CREATE TABLE Has_stock(\n"
                + " name STRING,\n"
                + " three_letter_symbol CHAR(3),\n"
                + " PRIMARY KEY (name,three_letter_symbol),\n"
                + " FOREIGN KEY (name) REFERENCES Actor_Director,\n"
                + " FOREIGN KEY (three_letter_symbol) REFERENCES Stocks,\n"
                + ");"; 

        String sql7 = "CREATE TABLE Has_market_acc(\n"
                + " username CHAR(20),\n"
                + " ID_number CHAR(9),\n"
                + " date_created CHAR(10),\n"
                + " initial_deposit REAL,\n"
                + " PRIMARY KEY (username, ID_number),\n"
                + " FOREIGN KEY (username) REFERENCES Customer,\n"
                + " FOREIGN KEY (ID_number) REFERENCES Market_Acc,\n"
                + " CHECK (initial_deposit >= 1000),\n"
                + ");";

        String sql8 = "CREATE TABLE has_these_trans(\n"
                + " transaction_id INTEGER,\n"
                + " ID_number CHAR(9),\n"
                + " PRIMARY KEY (ID_number,transaction_id),\n"
                + " FOREIGN KEY (ID_number) REFERENCES Account,\n"
                + " FOREIGN KEY (transaction_id) REFERENCES transactions,\n"
                + ");";

        String sql9 = "CREATE TABLE has_stock_Acc(\n"
                + " username CHAR(30),\n"
                + " ID_number CHAR(9),\n"
                + " PRIMARY KEY (ID_number,username),\n"
                + " FOREIGN KEY (ID_number) REFERENCES Stock_Acc,\n"
                + " FOREIGN KEY (username) REFERENCES Customer,\n"
                + ");";
        
        String sql10 = "CREATE TABLE is_stock(\n"
                + " three_letter_symbol CHAR(3),\n"
                + " ID_number CHAR(9),\n"
                + " PRIMARY KEY (ID_number,three_letter_symbol),\n"
                + " FOREIGN KEY (ID_number) REFERENCES Stock_Acc,\n"
                + " FOREIGN KEY (three_letter_symbol) REFERENCES Stocks,\n"
                + ");";

        String sql11 = "CREATE TABLE buying_stock(\n"
                + " transaction_id INTEGER,\n"
                + " three_letter_symbol CHAR(3),\n"
                + " PRIMARY KEY (transaction_id, three_letter_symbol),\n"
                + " FOREIGN KEY (transaction_id) REFERENCES transactions,\n"
                + " FOREIGN KEY (three_letter_symbol) REFERENCES Stocks,\n"
                + ");";

        String sql12 = "CREATE TABLE selling_stock(\n"
                + " transaction_id INTEGER,\n"
                + " three_letter_symbol CHAR(3),\n"
                + " PRIMARY KEY (transaction_id, three_letter_symbol),\n"
                + " FOREIGN KEY (transaction_id) REFERENCES transactions,\n"
                + " FOREIGN KEY (three_letter_symbol) REFERENCES Stocks,\n"
                + ");";
        
        String sql13 = "CREATE TABLE Account(\n"
                + " ID_number CHAR(9) NOT NULL,\n"
                + " list_of_transactions CHAR(1000),\n"
                + " balance REAL DEFAULT 0,\n"
                + " PRIMARY KEY (ID_number),\n"
                + " ON DELETE CASCADE,\n"
                + " ON UPDATE CASCADE,\n"
                + ");";

        String sql14 = "CREATE TABLE Market_Acc(\n"
                + " ID_number CHAR(9) NOT NULL,\n"
                + " list_of_transactions CHAR(1000),\n"
                + " balance REAL NOT NULL,\n"
                + " UNIQUE (ID_number),\n"
                + " PRIMARY KEY(ID_number),\n"
                + " CHECK (balance >= 0),\n"
                + ");";

        String sql15 = "CREATE TABLE Stock_Acc(\n"
                + " ID_number CHAR(9) NOT NULL,\n"
                + " list_of_transactions CHAR(1000),\n"
                + " balance_inshares INTEGER DEFAULT 0,\n"
                + " UNIQUE (ID_number),\n"
                + " PRIMARY KEY(ID_number),\n"
                + ");";

        String sql16 = "CREATE TABLE Stocks(\n"
                + " daily_closing_prices REAL,\n"
                + " current_price REAL,\n"
                + " three_letter_symbol CHAR(3),\n"
                + " PRIMARY KEY (three_letter_symbol),\n"
                + ");";

        String sql17 = "CREATE TABLE transactions(\n"
                + " transaction_id INTEGER,\n"
                + " date_of_transaction CHAR(10),\n"
                + " PRIMARY KEY (transaction_id),\n"
                + ");";

        String sql18 = "CREATE TABLE Accrue_interest(\n"
                + " transaction_id INTEGER,\n"
                + " date_of_transaction CHAR(10),\n"
                + " PRIMARY KEY (transaction_id),\n"
                + ");";

        String sql19 = "CREATE TABLE withdraw(\n"
                + " transaction_id INTEGER,\n"
                + " date_of_transaction CHAR(10),\n"
                + " withdrawal_amount REAL,\n"
                + " PRIMARY KEY (transaction_id),\n"
                + ");";

        String sql20 = "CREATE TABLE deposits(\n"
                + " transaction_id INTEGER,\n"
                + " date_of_transaction CHAR(10),\n"
                + " money_to_deposit REAL,\n"
                + " PRIMARY KEY (transaction_id),\n"
                + ");";

        String sql21 = "CREATE TABLE sell(\n"
                + " transaction_id INTEGER,\n"
                + " date_of_transaction CHAR(10),\n"
                + " number_shares INTEGER,\n"
                + " buying_price REAL,\n"
                + " PRIMARY KEY (transaction_id),\n"
                + ");";

        

        

        return new String[] {sql1, sql2, sql3, sql4, sql5, sql6, sql7, sql8, sql9, sql10, sql11, sql12, sql13, sql14, sql15, sql16, sql17, sql18, sql19, sql20, sql21};

    }
    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:sqlite/db/Project1.db";
        // Change ':/Users/karanveer/Desktop/School/Spring_21/CS174A/' to whatever it is for you'
        // To find it go to the db and then pwd
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void createNewTable() {
        // SQLite connection string
        // String url = "jdbc:sqlite:/Users/karanveer/Desktop/School/Spring_21/CS174A/174A-Project/sqlite/db";
        // Change ':/Users/karanveer/Desktop/School/Spring_21/CS174A/' to whatever it is for you'
        // To find it go to the db and then pwd
        String[] arr = createArray(); // Make an Array of Strings with all of the create Table commands 

        
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
            // create a new table
            for(int i = 0; i < arr.length; i++) {
                stmt.execute(arr[i]);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    // public static void CreateTable(String[] args) {
    //     createNewTable();
    //hi s
    // }

}
