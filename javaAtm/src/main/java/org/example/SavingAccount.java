package org.example;
import javax.swing.JOptionPane;


public class SavingAccount extends BankAccount {


    // default constructer
    private SavingAccount() {
    }
    int withdrawalLimit = 10000; // this is the default withdrawal limit
    float interestRate = 2; // 2 % interest rate
    float bankBalance = 0; // default is zero

    // float bankBalanceWithInterest; // this is the balance after interest
    int time = 1;
    int deposit;

    int withdraw;

    public static SavingAccount createSavingAccount() {
        return new SavingAccount();
    }
    // abstract method


    @Override
    public float interest() {
        //    a = P(1 + r/n)^(nt)
        //    bankBalanceWithInterest =((float)Math.pow((bankBalance *(1 +interestRate /365)), (365*1)));
        return ((bankBalance * time * interestRate) / 100);

    }
    // abstract method

    @Override
    public void deposit() {

        if (deposit > 0) {
            bankBalance = bankBalance + deposit;

            JOptionPane.showMessageDialog(null, deposit + " deposited successfully");
            JOptionPane.showMessageDialog(null, "Bank balance: " + bankBalance);

            //atmGui.textBox.setText(deposit + ", deposited successfully");
            //atmGui.textBox.append("balance" + bankBalance);
        }

      /*  else{
            atmGui.textBox.setText("Deposit was not successful;");
        }*/
    }

    // abstract method

    @Override
    public void withdraw() {

            // Check if there's enough balance before performing a withdrawal

        try {
            // Check if there's enough balance before performing a withdrawal
            if (withdraw > bankBalance) {
                throw new NotEnoughBalanceException("Not enough balance for this transaction.");
            }
            // More code...
        } catch (NotEnoughBalanceException exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
            if ((withdraw <= bankBalance ) && (withdraw < withdrawalLimit)) {
                if (withdraw == 0) {
                    System.out.println("wrong input");
                } else {
                    int hundred = withdraw / 100; // Number of 100-dollar notes
                    int remainder = withdraw % 100; // Remaining amount after using 100-dollar notes

                    int fifty = remainder / 50; // Number of 50-dollar notes
                    remainder = remainder % 50; // Remaining amount after using 50-dollar notes

                    int twenty = remainder / 20; // Number of 20-dollar notes
                    remainder = remainder % 20; // Remaining amount after using 20-dollar notes

                    boolean cashWithdrawable = (remainder == 0); // Check if the remaining amount is zero

                    int cash = withdraw - remainder; // Amount withdrawn using 20, 50, and 100-dollar notes
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
