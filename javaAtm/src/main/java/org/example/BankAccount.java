package org.example;

// Parent class
public abstract class BankAccount {

    public BankAccount() {
    }


    public int accountNumber;
    public String accountName;



    // these are a abstract methods
    // actually Interface could be used here as well.
    // they are same but in case of interface, there are no methods with anything written inside the class which is the case with out methods
    public abstract float interest();

    public abstract void deposit();
    public abstract void withdraw();
}
