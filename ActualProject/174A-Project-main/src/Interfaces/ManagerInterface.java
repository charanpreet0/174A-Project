package Interfaces;

import java.security.Principal;

public class ManagerInterface {
    // lot of the same as the adminstratorintview for both this class and the other interface view you don't have to do the option handler
    // just the functions under it
    public void addInterest(){
        System.out.println("Do you want to add interest");

        String input = ViewUtility.loopUntilInputValid(new HashSet<String>(Arrays.asList("yes","YES","no","NO","Yes","No")), commmand_line_scanner);

        if(input.length() == 3){
            ManagerController.InterestAdder();// This does not exist yet
            System.out.println("Interest Added");
        }
    }


    public void monthlyStatements(){
        System.out.println("Enter Customer Username");
        HashSet<String> username_all = Utility.getAllValuesForColumn("Customers", "username");
        String user = ViewUtility.loopUntilInputValid(username_all, command_line_scanner);
        String statement = ManagerController.createStatement(user);
        System.out.println("The monthly statement report for " + user + ": \n\n");
        System.out.println(statement);
    }

    public void allActiveCustomers(){
        System.out.println("Do you want to list active customers");

        String input = ViewUtility.loopUntilInputValid( new HashSet<String>(Arrays.asList("yes","no")), command_line_scanner);
        if (input.equals("yes")){
            String allCustomers = ManagerController.createCustomerList();
            System.out.println(allCustomers + "\n");

        }
    }


    public void customerReport(){
        System.out.println("Enter the Customer Username");
        HashSet<String> usernamelist = Utility.getAllValuesForColumn("Customers", "username");
        String user = ViewUtility.loopUntilInputValid(usernamelist,command_line_scanner);
        System.out.println("Customer Report is below: \n " + AdministratorsController.customer_reports(user));
    }

    public void StartMarket(){
        //SET THIS UP
    }

    public void CloseMarket(){
        //SET THIS UP
    }

    public void newStock(){
        System.out.println("Enter Valid Stock Symbol: ");
        HashSet<String> StockList = Utility.getAllValuesForColumn("Stocks", "three_letter_symbol");
        String inputSymbol = ViewUtility.loopUntilInputValid(StockList, command_line_scanner);
        Pair<Double, Double> priceRange = new Pair<Double, Double>(new Double(0.0), Double.MAX_VALUE);
        String input = ViewUtility.loopUtilityInputValid(priceRange, command_line_scanner);
        DatabaseAdministration.setStockValue(inputSymbol, Double.parseDouble(input));
    }
    
    public void newDate(){
        System.out.println("Enter a New Date");

        Pair<Integer, Integer> year_range = new Pair<Integer, Integer>()

        Pair<Integer, Integer> 
        ///Work on This
    }
}
