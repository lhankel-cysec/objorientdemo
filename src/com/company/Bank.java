package com.company;

import java.sql.Array;
import java.util.ArrayList;
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
                    System.out.println("Add Customer, Not yet Implemented");
                    break;
            }
        }
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
        System.out.println("   [3] Get Help");
        System.out.println("===========================================");
        System.out.print("Type the number of the options you want:");
    }

}
