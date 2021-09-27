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
                    System.out.println("Not yet Implemented");
            }
        }
    }

    private void addCustomer(Scanner inputReader) {
    }

    private void printMenu() {
        System.out.println("What do you want to do next;");
        System.out.println("   [1] Exit the program");
        System.out.println("   [2] Add a new Customer");
        System.out.println("   [3] Get Help");
        System.out.print("Type the number of the options you want;");
    }

}
