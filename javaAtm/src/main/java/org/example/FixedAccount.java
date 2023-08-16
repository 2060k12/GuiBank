package org.example;

public class FixedAccount extends BankAccount {
    //constructers
    public FixedAccount() {
    }

    public FixedAccount(float interestRate, float bankBalance, int time, int deposit, boolean earlyWithdraw, int withdraw) {
        this.interestRate = interestRate;
        this.bankBalance = bankBalance;
        this.time = time;
        this.deposit = deposit;
        this.earlyWithdraw = earlyWithdraw;
        this.withdraw = withdraw;
    }

    float interestRate = 15; // 15 % interest rate
    float bankBalance = 0; // default is zero

    // float bankBalanceWithInterest; // this is the balance after interest
    int time = 1; // keeping the withdraw time for fixed account 1 year
    int deposit;
    boolean earlyWithdraw = true;
    int withdraw;

    // calculates the interest rate
    @Override
    public float interest() {
        if (earlyWithdraw) {
            return 0;

        } else {

            return ((bankBalance * time * interestRate) / 100);

            /*float interestRatePerYear = interestRate; // Assuming interest rate is already provided on an annual basis
            int numberOfMonths = 12;
            float exponent = numberOfMonths * 1; // Adjust the exponent calculation for a year

            bankBalanceWithInterest = (float) (bankBalance * Math.pow((1 + interestRatePerYear), exponent));
            return bankBalanceWithInterest - bankBalance;*/
        }

    }

    // potential interest
    // A potential interest, which will be given after the contract period
    public float potentialInterest() {
        return ((bankBalance * time * interestRate) / 100);
    }


    // Deposit abstract method edited for this account
    @Override
    public void deposit() {

        if (deposit > 0) {
            bankBalance = bankBalance + deposit;
            System.out.println(deposit + ", deposited successfully");
        } else {
            System.out.println("Deposit was unsuccessfull");
        }
    }

    // Withdraw abstract method
    @Override
    public void withdraw() {

        if ((withdraw <= bankBalance)) {
            int hundred = withdraw / 100; // Number of 100-dollar notes
            int remainder = withdraw % 100; // Remaining amount after using 100-dollar notes

            int fifty = remainder / 50; // Number of 50-dollar notes
            remainder = remainder % 50; // Remaining amount after using 50-dollar notes

            int twenty = remainder / 20; // Number of 20-dollar notes
            remainder = remainder % 20; // Remaining amount after using 20-dollar notes

            boolean cashWithdrawable = (remainder == 0); // Check if the remaining amount is zero

            int cash = withdraw - remainder; // Amount withdrawn using 20, 50, and 100-dollar notes

            System.out.println("Withdrawal breakdown:");
            System.out.println("100x " + hundred);
            System.out.println("50x " + fifty);
            System.out.println("20x: " + twenty);
            System.out.println("Remaining amount: " + remainder);
            System.out.println("Total cash withdrawn: " + cash);
            System.out.println("Cash withdrawable: " + cashWithdrawable);
            if (remainder != 0) earlyWithdraw = false;
            if (cashWithdrawable) {
                bankBalance = bankBalance - withdraw;
                System.out.println(withdraw + ", Withdrawn successfully");
            } else {
                System.out.println("Sorry, Only 20, 50 & 100 notes are available");
            }

        }
        if (earlyWithdraw) {
            System.out.println("No Interest gained! WithDrawn too early!");
        }

            else{
                System.out.println("Unsuccessful! ");
            }
        }
    }

