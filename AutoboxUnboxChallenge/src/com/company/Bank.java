package com.company;

import java.util.ArrayList;

public class Bank {


    //show list of customers for a particular branch

    //and optionally show their transactions or not

    //not sure if static
   private static ArrayList<Branch> branchList;
   public static Branch branch;
    public static Customer customer; // not sure about this static variable here, maybe put in branch will see
   public String bankName;

   public Bank(String name){
       bankName = name;
       branchList  = new ArrayList<Branch>();
    }


    //Add new branch to branch list

    public void addBranch(String branchName){
       branchList.add(new Branch(branchName));
    }

    public void addCustomer(String name, double amt){
       if(branch.newCustomer(name, amt)){
           System.out.println("Customer "+ name + " added to " + branch.getBranchName() + " with amount " + amt);
       }else{
           System.out.println("This customer already exists, please add funds through other channel (existing customer");
       }
       return;
    }

    public void addtoExisting(String name, double amt){
        if(branch.existingCustomer(name, amt)){
            System.out.println("Existing customer"+ name + " in branch " + branch.getBranchName() + " added funds " + amt);
        }else{
            System.out.println("Customer doesn't exist, please create an account to add funds");
        }
        return;
    }


    // print list of customers for a particular branch
   // might have to loop through
        public void print(){
               branch.printCustomerList();
               customer.printTransactions();
        }

}
