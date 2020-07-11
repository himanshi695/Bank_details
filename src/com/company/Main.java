package com.company;

public class Main {

    public static void main(String[] args) {
	Bank bank = new Bank("ICICI");
	bank.addBranch("Mathura");

	bank.addCustomer("Mathura","Himanshi",100.00);
	bank.addCustomer("Mathura","Reema",50.00);
	bank.addCustomer("Mathura","Sanchi",30.00);


	bank.showCustomerList("Mathura",true);
	bank.showCustomerList("Agra",true);
    }
}
