package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Wells Fargo");

    public static void main(String[] args) {

        boolean optionFlag = true;

        while (optionFlag) {

            System.out.println("Please select a choice, 6 to print menu");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    addBranch();
                    break;
                case 2:
                    customerToBranch();
                    break;
                case 3:
                    existingCustomer();
                    break;
                case 4:
                    printCustlist();
                    break;
                case 5:
                    printAllCustlist();
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    optionFlag = false;
                    break;
                default:
                    optionFlag = false;
                    break;
            }

        }

    }

    private static void addBranch() {
        System.out.print("Please add branch name ");
        String name = scanner.next();
        bank.addBranch(name);
        //return;
    }

    private static void displayBranches() {
        //print the Branch list
        System.out.print("Branches in existence ");
        bank.getBranchList();
        //Ask the customer which branch to
        System.out.println("Please enter the branch you would like to add customer / make transactions to existing cust / \ndisplay transactions for a particular branch");
        String branchName = scanner.next();
        bank.addtoExistingBranch(branchName);
    }

    // We need to chose which Branch to add customers to, use the find method from Branch class to look for customers but make a similar method
    //before adding a customer to a branch prompt which branch to add them to
    private static void customerToBranch() {
        displayBranches();
        System.out.println("Please enter customer name to add to branch ");
        String name = scanner.next();
        System.out.println("Please enter initial transaction for new customer account ");
        double amt = scanner.nextInt();
        bank.addCustomer(name, amt);
        // return;
    }

    private static void existingCustomer() {
        displayBranches();
        System.out.println("Please enter existing customer name ");
        String name = scanner.next();
        System.out.println("Make transaction to existing customer ");
        double amt = scanner.nextInt();
        bank.addtoExisting(name, amt);
        // return;
    }


    private static void printCustlist() {
        boolean printed = false;
        System.out.println("Choose branch to list customers from ");
        String branchName = scanner.next();
          // add functionally to choose which branch to print
        if(bank.print(printed,branchName)){
        System.out.println("Do you want to optionally print list of Transactions (Y/N)");
        String decision = scanner.next().toUpperCase();
        //if yes print them, if not return

        if (decision.equals("Y")) {
            printed = true;
            bank.print(printed,branchName);
        }

        }
        return;
    }

    private static void printAllCustlist() {
        boolean printed = false;
        bank.printAll(printed);  // add functionally to choose which branch to print
        System.out.println("Do you want to optionally print list of Transactions (Y/N");
        String decision = scanner.next().toUpperCase();
        //if yes print them, if not return

        if (decision.equals("Y")) {
            printed = true;
            bank.printAll(printed);
        }

        return;
    }

    private static void printMenu() {
        System.out.println("Adding a new Branch:  1");
        System.out.println("Add a customer to that branch with initial transaction:  2");
        System.out.println("Add a transaction to an existing customer for that branch:  3");
        System.out.println("Show a list of customers for a particular branch:  4");
        System.out.println("Show a list of customers for all branches:  5");
        System.out.println("Quit:  7");
        return;
    }

}

