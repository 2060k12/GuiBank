package org.example;

public class SavingAccount extends BankAccount{
    // default constructer
    private SavingAccount() {
    }

    public SavingAccount(float interestRate, float bankBalance, int time, int withdrawalLimit, int deposit, int withdraw) {
        this.interestRate = interestRate;
        this.bankBalance = bankBalance;
        this.time = time;
        this.withdrawalLimit = withdrawalLimit;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    float interestRate = 2; // 2 % interest rate
    float  bankBalance =0; // default is zero

    // float bankBalanceWithInterest; // this is the balance after interest
    int time = 1;
    int withdrawalLimit = 10000; // this is the default withdrawal limit
    int deposit;

    int withdraw;

    public static SavingAccount createSavingAccount() {
        return new SavingAccount();
    }
    // abstract method





    @Override
    public float interest(){
    //    a = P(1 + r/n)^(nt)
    //    bankBalanceWithInterest =((float)Math.pow((bankBalance *(1 +interestRate /365)), (365*1)));
        return ((bankBalance * time * interestRate) /100);

    }
    // abstract method

    @Override
    public void deposit() {

        if (deposit > 0 ){
            bankBalance = bankBalance + deposit;
            System.out.println(deposit + ", deposited successfully");
        }

        else{
            System.out.println("Deposit was unsuccessfull");
        }
    }

    // abstract method

    @Override
    public void withdraw() {

        // trial withdraw




        // trial

        if ((withdraw <= bankBalance) && (withdraw < withdrawalLimit) ) {
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
            if (cashWithdrawable) {
                bankBalance = bankBalance - withdraw;
                System.out.println(withdraw + ", Withdrawn successfully");
            } else {

                System.out.println("Sorry, Only 20, 50 & 100 notes are available");
            }
        }
        else{
            System.out.println("Unsuccessful! ");
        }
    }

}
