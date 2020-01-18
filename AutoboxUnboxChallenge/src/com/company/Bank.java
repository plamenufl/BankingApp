package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {


    //show list of customers for a particular branch

    //and optionally show their transactions or not

    //not sure if static
   private static ArrayList<Branch> branchList;
   public Branch branch;  //might have to make static so that  we can select which branches
    public static Customer customer; // not sure about this static variable here, maybe put in branch will see
   public String bankName;

   public Bank(String name){
       bankName = name;
       branchList  = new ArrayList<Branch>();
    }


    //Add new branch to branch list

    public void addBranch(String branchName){
        branch = new Branch(branchName);
       branchList.add(branch);
       return;
    }

    public void addCustomer(String name, double amt){
       if(branch.newCustomer(name, amt)){
           System.out.println();
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

       //if we choose which branch to print, we don't need to print all branches. Or we can leave this method as a checker to see if everything is added where it is supposed to be
        public void print(boolean printed){
              // branch.printCustomerList();
               //customer.printTransactions();
            System.out.println("customers in branches are below");
            for(int i = 0; i < branchList.size(); i++){
                System.out.println();
                System.out.println(branchList.get(i).getBranchName());
                //System.out.println(Arrays.toString(branchList.get(i).getCustomerList().toArray()));
                ArrayList<Customer> tempCustlist = branchList.get(i).getCustomerList();
                for(int j = 0; j < tempCustlist.size(); j++){
                    if(printed){
                        System.out.println("Customer " + tempCustlist.get(j).getName());
                        ArrayList<Double> transactions = tempCustlist.get(j).getTransaction();
                        System.out.println(Arrays.toString(transactions.toArray()));
                    }else{
                        System.out.println("Customer " + tempCustlist.get(j).getName());
                    }

                }
            }

        }





}
