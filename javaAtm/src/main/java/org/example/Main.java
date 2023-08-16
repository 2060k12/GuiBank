package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {
/*
    public static void main(String[] args) {
        // this is the total balance of all account combined
        float totalBalance = 0;

        // an object for SavingAccount class
        SavingAccount savingAccount = SavingAccount.createSavingAccount();

        // an object for NetSaving class
        NetsavingAccount netsavingAccount = new NetsavingAccount();

        // an object for ChequeAccount
        ChequeAccount chequeAccount = new ChequeAccount();

        // an object for FixedAccount
        FixedAccount fixedAccount = new FixedAccount();

        // object for Scanner class to take an input
        Scanner scanner = new Scanner(System.in);

        // A GUI based Panel to ask user about their name and account number
        savingAccount.accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Account Number? "));
        savingAccount.accountName = (JOptionPane.showInputDialog(null, "What is your Name? "));

        // back to console based, this prints the name and accout number which was given by user
        System.out.println("Welcome, " + savingAccount.accountName + "!");
        System.out.println("@" + savingAccount.accountNumber);


        // using an infinity loop so that it keeps on asking user for input an input and keeps generating output based on that
        while (true) {
            // Main part of our ATM
            System.out.println("Choose Which account do you want to open: ");
            System.out.println("Total Balance: " + totalBalance);
            System.out.println("1. Saving account ");
            System.out.println("2. Netsavers account ");
            System.out.println("3. Cheque account ");
            System.out.println("4. Fixed account ");
            System.out.println("5. Exit ");
            System.out.println("------------------------------------------------");


            // ask user to input for the option above
            int option = scanner.nextInt();
// using switch case as we have different case, it is a better alternative for if else for our code.
            switch (option) {
// case 1,  it shows the saving account details and ask user to interact with it
                case (1):

                    // display screen
                    System.out.println("Saving Account");
                    System.out.println("Saving Account Balance: " + (savingAccount.bankBalance + savingAccount.interest()));
                    System.out.println("Interest Rate: " + savingAccount.interestRate + "%");
                    System.out.println("Interest earned: " + savingAccount.interest());
                    System.out.println("Choose: ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Set/ Change your Withdraw Limit");
                    System.out.println("4. Show Balance");

                    int newOption = scanner.nextInt();
                    if (newOption == 1) {
                        System.out.println("Enter the amount you want to Deposit: ");
                        savingAccount.deposit = scanner.nextInt();
                        savingAccount.deposit();
                        System.out.println("------------------------------------------------");

                    } else if (newOption == 2) {
                        System.out.println("Enter the amount you want to Withdraw: ");
                        System.out.println("Current withdrawal Limit: " + savingAccount.withdrawalLimit);
                        savingAccount.withdraw = scanner.nextInt();
                        savingAccount.withdraw();
                        System.out.println("------------------------------------------------");

                    } else if (newOption == 3) {
                        System.out.println("Current limit: " + savingAccount.withdrawalLimit);
                        System.out.println("Choose: \n 1. Change Limit \n 2. Cancel");
                        int optionChangeLimit = scanner.nextInt();
                        if (optionChangeLimit == 1) {
                            savingAccount.withdrawalLimit = scanner.nextInt();
                            System.out.println("Limit Change Successfully! ");
                            System.out.println("New limit: " + savingAccount.withdrawalLimit);
                        } else if (optionChangeLimit == 2) {
                            System.out.println("Operation Cancelled!");

                        } else {
                            System.out.println("Wrong Input");
                        }
                        System.out.println("------------------------------------------------");

                    } else if (newOption == 4) {
                        System.out.println("Saving Account");
                        System.out.println("Saving Account Balance: " + (savingAccount.bankBalance + savingAccount.interest()));
                        System.out.println("Interest Rate: " + savingAccount.interestRate + "%");
                        System.out.println("Interest earned: " + savingAccount.interest());
                        System.out.println("Interest calculated Daily");
                        System.out.println("------------------------------------------------");

                    } else {
                        System.out.println("Wrong Input");
                        System.out.println("------------------------------------------------");
                    }
                    break;

// case 2,  it shows the NetSaving account details and ask user to interact with it

                case (2):
                    // display screen
                    System.out.println("NetSaving Account");
                    System.out.println("NetSaving Account Balance: " + (netsavingAccount.bankBalance + netsavingAccount.interest()));
                    System.out.println("Interest Rate: " + netsavingAccount.interestRate + "%");
                    System.out.println("Interest earned: " + netsavingAccount.interest());
                    System.out.println("Choose: ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Show Balance");


                    int newOptionNetSaving = scanner.nextInt();
                    if (newOptionNetSaving == 1) {
                        System.out.println("Enter the amount you want to Deposit: ");
                        netsavingAccount.deposit = scanner.nextInt();
                        netsavingAccount.deposit();
                        System.out.println("------------------------------------------------");

                    } else if (newOptionNetSaving == 2) {
                        System.out.println("Enter the amount you want to Withdraw: ");
                        System.out.println("Current withdrawal Limit: " + netsavingAccount.withdrawalLimit);
                        netsavingAccount.withdraw = scanner.nextInt();
                        netsavingAccount.withdraw();
                        System.out.println("------------------------------------------------");

                    } else if (newOptionNetSaving == 3) {
                        System.out.println("NetSaving Account");
                        System.out.println("NetSaving Account Balance: " + (netsavingAccount.bankBalance + netsavingAccount.interest()));
                        System.out.println("Interest Rate: " + netsavingAccount.interestRate + "%");
                        System.out.println("Interest earned: " + netsavingAccount.interest());
                        System.out.println("Interest calculated monthly");
                        System.out.println("------------------------------------------------");

                    } else {
                        System.out.println("Wrong Input");
                        System.out.println("------------------------------------------------");
                    }
                    break;


// case 3,  it shows the Cheque account details and ask user to interact with it

                case (3):
                    // display screen
                    System.out.println("Cheque Account");
                    System.out.println("Cheque Account Balance: " + (chequeAccount.bankBalance));
                    System.out.println("Choose: ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Show Balance");

                    int newOptionChequeSaving = scanner.nextInt();
                    if (newOptionChequeSaving == 1) {
                        System.out.println("Enter the amount you want to Deposit: ");
                        chequeAccount.deposit = scanner.nextInt();
                        chequeAccount.deposit();
                        System.out.println("------------------------------------------------");

                    } else if (newOptionChequeSaving == 2) {
                        System.out.println("Enter the amount you want to Withdraw: ");
                        System.out.println("No withdraw limit! ");
                        chequeAccount.withdraw = scanner.nextInt();
                        chequeAccount.withdraw();
                        System.out.println("------------------------------------------------");

                    } else if (newOptionChequeSaving == 3) {
                        System.out.println("NetSaving Account");
                        System.out.println("NetSaving Account Balance: " + (chequeAccount.bankBalance));
                        System.out.println("NO interest");
                        System.out.println("------------------------------------------------");

                    } else {
                        System.out.println("Wrong Input");
                        System.out.println("------------------------------------------------");
                    }
                    break;
// case 4,  it shows the Cheque account details and ask user to interact with it

                case (4):
                    // display screen
                    System.out.println("Fixed Account");
                    System.out.println("Fixed Account Balance: " + (fixedAccount.bankBalance + fixedAccount.interest()));
                    System.out.println("Interest Rate: " + fixedAccount.interestRate + "%");
                    System.out.println("Potential Interest: " + fixedAccount.potentialInterest());
                    System.out.println("Choose: ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Show Balance");

                    int newOptionFixedSaving = scanner.nextInt();
                    if (newOptionFixedSaving == 1) {
                        System.out.println("Enter the amount you want to Deposit: ");
                        fixedAccount.deposit = scanner.nextInt();
                        fixedAccount.deposit();
                        System.out.println("------------------------------------------------");

                    } else if (newOptionFixedSaving == 2) {
                        System.out.println("Enter the amount you want to Withdraw: ");
                        System.out.println("Current withdrawal Limit: Unlimited ");
                        fixedAccount.withdraw = scanner.nextInt();
                        fixedAccount.withdraw();
                        System.out.println("------------------------------------------------");

                    } else if (newOptionFixedSaving == 3) {
                        System.out.println("Fixed Account");
                        System.out.println("Fixed Account Balance: " + (fixedAccount.bankBalance + fixedAccount.interest()));
                        System.out.println("Interest Rate: " + fixedAccount.interestRate + "%");
                        System.out.println("Interest earned: " + fixedAccount.interest());
                        System.out.println("Potential Interest: " + fixedAccount.potentialInterest());
                        System.out.println("Interest calculated on fixed contract, Currently on 1 year plan");
                        System.out.println("------------------------------------------------");

                    } else {
                        System.out.println("Wrong Input");
                        System.out.println("------------------------------------------------");
                    }
                    break;

                case (5):
                    System.out.println("------------------------------------------------");
                    System.out.println("ThankYou! for using AIT Bank \uD83D\uDE00\n");
                    System.exit(0);

// A default output that will be shown if anything unexpected is done
                default:
                    System.out.println("Invalid Input, Try again");


            }
            // this line updates totalBalance everytime a switch case is completed and before it goes back to the top using while loop
            totalBalance = netsavingAccount.bankBalance + savingAccount.bankBalance + chequeAccount.bankBalance + fixedAccount.bankBalance;


        }

    }
*/


    public static void main(String[] args) {
        AtmGui atmGui = new AtmGui();
        atmGui.createGUI();

    }
}
