package org.example;

public class ChequeAccount extends BankAccount{

    public ChequeAccount() {
    }

    public ChequeAccount(float bankBalance, int deposit, int withdraw) {
        this.bankBalance = bankBalance;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    float  bankBalance =0; // default is zero

        int deposit;

        int withdraw;

        // abstract method
        @Override
        public float interest(){
            return 0;
            // there is no interest in cheque account

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

            if ((withdraw < bankBalance) ) {
                {
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
            }
            else{
                System.out.println("Unsuccessful! ");
            }
        }

    }

