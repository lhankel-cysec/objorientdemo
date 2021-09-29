package com.company;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> allAccunts;
    private ArrayList<Customer> allCustomers;

    public Bank(){
        allCustomers = new ArrayList<Customer>();
        allAccunts = new ArrayList<BankAccount>();
    }

    public void doBanking(){
        var inputReader = new Scanner(System.in);
        while(true){
            printMenu();
            var userChoice = inputReader.nextInt();
            switch (userChoice){
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer(inputReader);
                    break;
                case 3:
                    System.out.print("What is the customer ID of the customer to select:");
                    var idToFind = inputReader.nextInt();
                    var customer = getCutomer(idToFind);
                    if(customer.isPresent()){
                        doCustomerMenu(inputReader, customer.get());
                    }
                    else
                        System.out.println("No such customer exists at this time");
                    break;
            }
        }
    }

    private void doCustomerMenu(Scanner inputReader, Customer customer) {
        while (true) {
            printCustomerMenu();
            //Ask the user which choice they want and read that in
            System.out.print("Enter selection:");
            var choice = inputReader.nextInt();
            //Create a switch statement to select among the choices
            switch (choice){
                case 1:
                    BankAccount newAccount = addAccountToCustomer(inputReader, customer);
                    allAccunts.add(newAccount);
                    break;
                case 2:
                    System.out.println("To do");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please choose one of the choices on the list");
            }
        }
    }

    private BankAccount addAccountToCustomer(Scanner inputReader, Customer cust) {
        //Ask the user how much the initial balance should be
        System.out.println("How much should the initial balance be");
        var initialDeposit = inputReader.nextFloat();
        //Call open account in the customer
        var newAccount = cust.openAccount(initialDeposit);
        System.out.println("Created account with"+ newAccount.getAccountID());
        //return the newly created account
        return newAccount;


    }

    private void printCustomerMenu() {
        System.out.println("#################################");
        System.out.println("Please select what to do with this customer");
        System.out.println("     [1] Open account");
        System.out.println("     [2] Close account");
        System.out.println("     [3] return to main menu");
        System.out.println("#################################");
    }

    private Optional<Customer> getCutomer(int CustomerID){
        for(var currentCustomer : allCustomers){
            if(currentCustomer.getID()==CustomerID )
                return Optional.of(currentCustomer);
        }
        return Optional.empty();
    }

    private void addCustomer(Scanner inputReader) {
        inputReader.nextLine();//eats \nfrom previous call to nextInt
        System.out.print("Enter the new Customer's name:");
        var newCustomerName = inputReader.nextLine();
        System.out.println("Enter the new Customer's Tax ID (SSN):");
        var newCustomerTaxID = inputReader.nextInt();
        var newCustomer = new Customer(newCustomerName, newCustomerTaxID);
        allCustomers.add(newCustomer);
        System.out.println("Success! Created new Customer with name;" +newCustomer.getName() +" and taxID;"+ newCustomer.getID());
    }

    private void printMenu() {
        System.out.println("===========================================");
        System.out.println("What do you want to do next;");
        System.out.println("   [1] Exit the program");
        System.out.println("   [2] Add a new Customer");
        System.out.println("   [3] Select Customer");
        System.out.println("===========================================");
        System.out.print("Type the number of the options you want:");
    }

}
