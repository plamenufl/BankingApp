package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {

    private String name;
    private double amount;

    private  ArrayList<Double> transaction = new ArrayList<Double>();


    public Customer(String name, double amount) {
        this.name = name;
        this.amount = amount;
        transaction.add(this.amount);

    }



    //add a method to add a transaction not a constructor
    private void addFund(double amount) {
        transaction.add(amount);
    }

    public void addFunds(double amount) {
     addFund(amount);
    }

//    public Customer(double amount) {
//        this.amount = amount;
//        transaction.add(this.amount);
//    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }


    private double printInfo(){

        double totalBalance = 0.0;

        for(int i =0; i < transaction.size() ;i++){
           totalBalance += transaction.get(i);
        }

        //System.out.println(Arrays.toString(transaction.toArray()));
        return totalBalance;
    }
    //might have to do a a static method to print all transactions for all customers
    public double printCustTotalBalance(){
      return  printInfo();
    }
}
