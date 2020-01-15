package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Branch {


    private String branchName;
    //need an arrayList of Customers

    //show a list of customers and their transacions, optionally or not
    //validation check of name wasnt used previously for that branch
    //if adding a transaction to an existing customer, check if they exist first


    // List of customers and list of their transactions of optionally. Might have to
// use static methods

// add data validation (check if customer exists for that branch, first upon
// customer creation
// and also if you want to add additional transactions

    private ArrayList<Customer> customerList;

    public Branch(String branchName) {
        this.branchName = branchName;
        customerList  = new ArrayList<Customer>();
    }

    //might have to put this in an empty constructor if it doesnt work


    public Branch(){
     customerList  = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return this.branchName;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    // create a function to add customers and then do another find function to check
// if the customer exists
// create a function to add funds (call function in customer) but first check if
// the customer exists, if
// if they dont exist u cant add funds, otherwise add funds to that particular
// customr

     //pass in string to find customer name, no need to pass the object

    private Customer findCustomer(String customerName) {

        for(int i = 0; i < this.customerList.size(); i++) {
            String name = this.customerList.get(i).getName();

            if(name.equals(customerName)) {
                return this.customerList.get(i);
            }

        }
        return null;

    }


    public boolean newCustomer(String customerName, double firstAmt) {
        if(findCustomer(customerName) == null){
            customerList.add(new Customer(customerName,firstAmt));
            return true;
        }else{
            return false;
        }

    }

    public boolean existingCustomer(String customerName, double Amt){

        Customer customer = findCustomer(customerName);

        if(customer != null){
            customer.addFunds(Amt);
            return true;
        }else{
            return false;
        }

    }

    //used to hide the customer list printing below
    public void printCustomerList() {
        printList();
    }


    private void printList() {
        System.out.println(Arrays.toString(customerList.toArray()));
    }




}
