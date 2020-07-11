package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branch;


    public Bank(String name) {
        this.name = name;
        this.branch = new ArrayList<Branch>();

    }

    public String getName() {
        return name;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branch.add(new Branch(branchName));
            return true;
        }
        return false;
    }
     public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch !=null){
            return branch.newCustomer(customerName,initialAmount);
            
        }
        return false;
     }
     public boolean addTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch!=null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
     }
     public boolean showCustomerList(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
         if (branch != null) {
             System.out.println("Customers details for branch " + branch.getName());

             ArrayList<Customer> branchCustomers = branch.getCustomers();
             for (int i = 0; i < branchCustomers.size(); i++) {
                 Customer branchCustomer = branchCustomers.get(i);
                 System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                 if (showTransactions) {
                     System.out.println("Transactions");
                     ArrayList<Double> transactions = branchCustomer.getTransactions();
                     for (int j = 0; j < transactions.size(); j++) {
                         System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                     }
                 }
             }
             return true;
         } else {
             return false;
         }
     }

    private Branch findBranch(String branchName){
        for (int i = 0; i < branch.size() ; i++) {
            Branch checkedBranch = this.branch.get(i);
            if(checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }




}
