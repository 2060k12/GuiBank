package org.example;

import javax.swing.JOptionPane;

public class NetSavingAccount extends BankAccount {


    AtmGui atmGui = new AtmGui();
    int withdrawalLimit = 100000; // this is the default withdrawal limit

    // default constructor
    private NetSavingAccount() {
    }

    float interestRate = 5; // 5 % interest rate
    float bankBalance = 0; // default is zero
    int time = 1; // it is one month
    int deposit;
    int withdraw;

    public static NetSavingAccount createNetsavingAccount() {
        return new NetSavingAccount();
    }

    @Override
    public float interest() {
        return ((bankBalance * time * interestRate) / 100); // on monthly basis
    }

    @Override
    public void deposit() {
        if (deposit > 0) {
            bankBalance = bankBalance + deposit;
            JOptionPane.showMessageDialog(null, deposit + " deposited successfully");
            JOptionPane.showMessageDialog(null, "Bank balance: " + bankBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Deposit was unsuccessful");
        }
    }

    @Override
    public void withdraw() {
        try {
            // Check if there's enough balance before performing a withdrawal
            if (withdraw > bankBalance) {
                throw new NotEnoughBalanceException("Not enough balance for this transaction.");
            }
            // More code...
        } catch (NotEnoughBalanceException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if ((withdraw < bankBalance) && (withdraw < withdrawalLimit)) {
            if (withdraw == 0) {
                System.out.println("wrong input");
            } else {
                int hundred = withdraw / 100;
                int remainder = withdraw % 100;

                int fifty = remainder / 50;
                remainder = remainder % 50;

                int twenty = remainder / 20;
                remainder = remainder % 20;

                boolean cashWithdrawable = (remainder == 0);

                int cash = withdraw - remainder;

                if (cashWithdrawable) {
                    bankBalance = bankBalance - withdraw;
                    JOptionPane.showMessageDialog(null, "Withdrawal breakdown:"
                            + "\n100x " + hundred
                            + "\n50x " + fifty
                            + "\n20x: " + twenty
                            + "\nRemaining amount: " + remainder
                            + "\nTotal cash withdrawn: " + cash
                            + "\nCash withdrawable: " + cashWithdrawable
                            + "\n" + withdraw + " Withdrawn successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, Only 20, 50 & 100 notes are available");
                }
            }
        }
    }
}