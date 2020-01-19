package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Bank {


    //show list of customers for a particular branch

    //and optionally show their transactions or not

    //not sure if static
    private static ArrayList<Branch> branchList;
    private Branch branch;  //might have to make static so that  we can select which branches
    //public static Customer customer; // not sure about this static variable here, maybe put in branch will see
    private String bankName;

    public static void getBranchList() {
        for(int i = 0; i < branchList.size(); i++) {
            System.out.println();
            System.out.println(branchList.get(i).getBranchName());
        }
    }

    public Bank(String name) {
        bankName = name;
        branchList = new ArrayList<Branch>();
    }


    //Add new branch to branch list
    //create a function to check if branch exists - find,

    //public void addtoExistingBranch{


    public void addBranch(String branchName){
       if(findBranch(branchName) == null){
           branch = new Branch(branchName);
           branchList.add(branch);
       }else{
           System.out.println(branchName + " already exists");
       }
       return;
    }

    public void addtoExistingBranch(String branchName){

       Branch existingBranch =  findBranch(branchName);
        if(existingBranch != null){
           this.branch = existingBranch;
        }else{
            System.out.println("No such branch exists, to add customers to\n");
        }
    }


    private Branch findBranch(String branchName){


        for(int i = 0; i < this.branchList.size(); i++) {
            String name = this.branchList.get(i).getBranchName();

            if(name.toUpperCase().equals(branchName.toUpperCase())) {
                return this.branchList.get(i); // returns found branch
            }

        }
        return null;


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
            System.out.println("Existing customer "+ name + " in branch " + branch.getBranchName() + " added funds " + amt);
        }else{
            System.out.println("Customer doesn't exist, please create an account to add funds");
        }
        return;
    }


    // print list of customers for a particular branch
   // might have to loop through

       //if we choose which branch to print, we don't need to print all branches. Or we can leave this method as a checker to see if everything is added where it is supposed to be
        public boolean print(boolean printed, String branchName){
            Branch existingBranch = findBranch(branchName);
            if(existingBranch != null) {
                this.branch = existingBranch;
                System.out.println("customers in " + this.branch.getBranchName() +  " are below");
                System.out.println();
                System.out.println(this.branch.getBranchName());
                ArrayList<Customer> tempCustlist = this.branch.getCustomerList();
                for(int j = 0; j < tempCustlist.size(); j++){
                    if(printed){
                        System.out.println("Customer " + tempCustlist.get(j).getName() );
                        ArrayList<Double> transactions = tempCustlist.get(j).getTransaction();
                        System.out.println(Arrays.toString(transactions.toArray()) + " Total Balance " + tempCustlist.get(j).printCustTotalBalance());
                    }else{
                        System.out.println("Customer " + tempCustlist.get(j).getName());
                    }

                }
                return true;
            }
            return  false;
        }


        public void printAll(boolean printed){
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
                    System.out.println(Arrays.toString(transactions.toArray()) +" Total Balance " + tempCustlist.get(j).printCustTotalBalance());
                }else{
                    System.out.println("Customer " + tempCustlist.get(j).getName());
                }

            }
        }

    }




//
//    public void print(boolean printed){
//        // branch.printCustomerList();
//        //customer.printTransactions();

//
//        System.out.println("customers in branches are below");
//        for(int i = 0; i < branchList.size(); i++){
//            System.out.println();
//            System.out.println(branchList.get(i).getBranchName());
//            //System.out.println(Arrays.toString(branchList.get(i).getCustomerList().toArray()));
//            ArrayList<Customer> tempCustlist = branchList.get(i).getCustomerList();
//            for(int j = 0; j < tempCustlist.size(); j++){
//                if(printed){
//                    System.out.println("Customer " + tempCustlist.get(j).getName());
//                    ArrayList<Double> transactions = tempCustlist.get(j).getTransaction();
//                    System.out.println(Arrays.toString(transactions.toArray()));
//                }else{
//                    System.out.println("Customer " + tempCustlist.get(j).getName());
//                }
//
//            }
//        }
//
//    }






}
