package org.example;

import javax.swing.JOptionPane;

public class FixedAccount extends BankAccount {

    float interestRate = 15; // 15 % interest rate
    float bankBalance = 0; // default is zero
    int time = 1; // keeping the withdraw time for fixed account 1 year
    int deposit;
    boolean earlyWithdraw = true;
    int withdraw;

    // default constructor
    private FixedAccount() {
    }

    public static FixedAccount createFixedAccount() {
        return new FixedAccount();
    }

    @Override
    public float interest() {
        if (earlyWithdraw) {
            return 0;
        } else {
            return ((bankBalance * time * interestRate) / 100);
        }
    }

    public float potentialInterest() {
        return ((bankBalance * time * interestRate) / 100);
    }

    @Override
    public void deposit() {
        if (deposit > 0) {
            bankBalance = bankBalance + deposit;
            JOptionPane.showMessageDialog(null, deposit + " deposited successfully");
            JOptionPane.showMessageDialog(null, "Bank balance: " + bankBalance);
        }
    }

    @Override
    public void withdraw() {
        if (withdraw ==0){
            System.out.println("wrong input");
        }

        else {
            try {
                // Check if there's enough balance before performing a withdrawal
                if (withdraw > bankBalance) {
                    throw new NotEnoughBalanceException("Not enough balance for this transaction.");
                }
                // More code...
            } catch (NotEnoughBalanceException exc) {
                JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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

                if (remainder != 0) {
                    earlyWithdraw = false;
                }
                if (earlyWithdraw) {
                    JOptionPane.showMessageDialog(null, "No Interest gained! Withdrawn too early!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, Only 20, 50 & 100 notes are available");
            }


        }


    }
}
