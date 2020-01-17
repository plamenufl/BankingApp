package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("Wells Fargo");
    public static void main(String[] args) {

         boolean optionFlag = true;

        while(optionFlag) {

            System.out.println("Please select a choice, 5 to print menu");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
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
                    printMenu();
                    break;
                case 6:
                    optionFlag = false;
                    break;
                default:
                    optionFlag = false;
                    break;
            }

        }

        }

        public static void addBranch(){
        System.out.print("Please add branch name ");
        String name = scanner.next();
        bank.addBranch(name);
        return;
        }

       public static void customerToBranch(){
        System.out.print("Please enter customer name to add to branch ");
        String name = scanner.next();
        System.out.print("Please enter initial transaction for new customer account ");
        double amt = scanner.nextInt();
        bank.addCustomer(name,amt);
        return;
        }

         public static void existingCustomer(){
        System.out.print("Please enter existing customer name ");
        String name = scanner.next();
        System.out.print("Make transcation to existing customer");
        double amt = scanner.nextInt();
        bank.addtoExisting(name,amt);
        return;
        }

        public static void printCustlist(){
            System.out.print("Print list of customers for that Branch");
            bank.print();
            return;
        }

        public static void printMenu(){
            System.out.println("Adding a new Branch:  1");
            System.out.println("Add a customer to that branch with initial transaction:  2");
            System.out.println("Add atransaction to an existing customer for that branch:  3");
            System.out.println("Show a list of customers to that branch:  4");
            System.out.println("Quit:  6");
            return;
        }

    }

