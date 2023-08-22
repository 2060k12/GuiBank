package org.example;
import javax.swing.*;
public class Main {

    static boolean backToHome;
    static float totalBalance = 0;

    public static void main(String[] args) {
        //creating a new object of the all the classes

        SavingAccount savingAccount = SavingAccount.createSavingAccount();
        NetSavingAccount netSavingAccount = NetSavingAccount.createNetsavingAccount();

        ChequeAccount chequeAccount = ChequeAccount.createChequeAccount();
        FixedAccount fixedAccount = FixedAccount.createFixedAccount();
        // setting an empty password ;
        String password ="";

        //setting the account number and name
        savingAccount.accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Account Number? "));
        savingAccount.accountName = (JOptionPane.showInputDialog(null, "What is your Name? "));

        // settting the password for the account
        while(true){
            password = (JOptionPane.showInputDialog(null, "Password? "));
            if(password.equals("1234")){
                break;
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Password");
            }
        }

// this will print welcome in the console
        System.out.println("Welcome, " + savingAccount.accountName + "!");
        System.out.println("@" + savingAccount.accountNumber);

        AtmGui atmGui = new AtmGui();
        atmGui.createGUI();
        atmGui.accInfo.setText("Welcome, " + savingAccount.accountName + ": @ " + savingAccount.accountNumber);

        //infinity loop, it doesn't end until the program is terminated or exit button is pressed
        while (true) {
            backToHome = false;

            while (!backToHome) {
                atmGui.newOptionTextField.setVisible(false);
                atmGui.amountTextField.setVisible(false);
                atmGui.optionTextField.setVisible(true);
                atmGui.option = 0;
                atmGui.newOption = 0;
                atmGui.enteredAmount = 0;
                atmGui.enterButton.setEnabled(true);
                atmGui.button1.setEnabled(false);
                atmGui.button2.setEnabled(false);

                // this is the main screen of the application
                atmGui.textBox.setText(
                        "Choose Which account do you want to open: \n"
                                + "Total Balance: " + totalBalance + "\n"
                                + "1. Saving account\n"
                                + "2. NetSavers account\n"
                                + "3. Cheque account\n"
                                + "4. Fixed account\n"
                );

                // Switch case for the application

                switch (atmGui.option) {
                    case 1:
                        handleSavingAccount(savingAccount, atmGui);
                        break;
                    case 2:
                        handleNetSavingAccount(netSavingAccount, atmGui);
                        break;
                    case 3:
                        handleChequeAccount(chequeAccount, atmGui);
                        break;
                    case 4:
                        handleFixedAccount(fixedAccount, atmGui);
                        break;
                }
                // this will set the total balance of all the accounts everytime the while loops reaches here, and after this as we have a infinity loop, it will go on like this
                totalBalance = netSavingAccount.bankBalance + savingAccount.bankBalance + chequeAccount.bankBalance + fixedAccount.bankBalance;
                break;
            }
        }
    }

    private static void handleSavingAccount(SavingAccount savingAccount, AtmGui atmGui) {
        // ... (code for handling SavingAccount)
        // display screen
        atmGui.textBox.setText(
                "Saving Account\n"
                        + "Saving Account Balance: " + (savingAccount.bankBalance + savingAccount.interest()) + "\n"
                        + "Interest Rate: " + savingAccount.interestRate + "%\n"
                        + "Interest earned: " + savingAccount.interest() + "\n"
                        + "Choose:\n"
                        + "1. Deposit\n"
                        + "2. Withdraw\n"
                        + "3. Set/Change your Withdraw Limit\n"
                        + "4. Show Balance\n"
        );
        atmGui.optionTextField.setVisible(false);
        atmGui.amountTextField.setVisible(false);
        atmGui.newOptionTextField.setVisible(true);
        atmGui.button1.setEnabled(false);
        atmGui.button2.setEnabled(false);
        while (atmGui.newOption == 0) {
            Timer timer = new Timer(1, null);
            timer.setRepeats(false); // Stop after one execution

            timer.start();
            
        }

        // if user choose option 1, it will ask user to enter the amount they want to deposit
        if (atmGui.newOption == 1) {
            atmGui.button2.setEnabled(true);
            atmGui.textBox.setText("Enter the amount you want to Deposit:\n");
            atmGui.enterButton.setEnabled(false);
            atmGui.button2.setEnabled(true);

            // Making the new text field visible and the old one invisible
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);


            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                }
            }
            savingAccount.deposit = atmGui.enteredAmount;
            atmGui.enteredAmount = 0;
            savingAccount.deposit();
            // if user choose option 2, it will ask user to enter the amount they want to withdraw

        } else if (atmGui.newOption == 2) {
            atmGui.enterButton.setEnabled(false);
            atmGui.button1.setEnabled(true);
            atmGui.textBox.setText("Current withdrawal Limit: " + savingAccount.withdrawalLimit);
            atmGui.textBox.append("\nEnter the amount you want to Withdraw:\n");
            atmGui.optionTextField.setVisible(false);
            atmGui.button1.setEnabled(true);
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);
            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {

                    if (atmGui.enteredAmount > 0) {
                        savingAccount.withdraw = atmGui.enteredAmount;
                        savingAccount.withdraw();
                        break;

                    }
                }
            }

        }else if (atmGui.newOption == 3) {
            atmGui.textBox.setText("Current limit: " + savingAccount.withdrawalLimit
                    + "\nChoose:\n 1. Change Limit\n 2. Cancel");
            atmGui.enterButton.setEnabled(true);

            // Making the new text field visible and the old one invisible
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);

            Timer timer = new Timer(1, null);
            timer.setRepeats(false); // Stop after one execution

            timer.addActionListener(e -> {
                String newLimit = JOptionPane.showInputDialog(null, "Enter new limit: ");
                if (newLimit != null) {
                    savingAccount.withdrawalLimit = Integer.parseInt(newLimit);
                    JOptionPane.showMessageDialog(null, "Limit Change Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Limit Change Cancelled!");
                }
                atmGui.enteredAmount = 0;
            });

            timer.start();
        }
        else if (atmGui.newOption == 4) {

            atmGui.textBox.setText("Saving Account\n"
                    + "Saving Account Balance: " + (savingAccount.bankBalance + savingAccount.interest())
                    + "\nInterest Rate: " + savingAccount.interestRate + "%"
                    + "\nInterest earned: " + savingAccount.interest()
                    + "\nInterest calculated Daily"+
                    "\n" + "\n" +
                    "\n In 3sec <------ Back to main screen >");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            

        }

    }

    private static void handleNetSavingAccount(NetSavingAccount netsavingAccount, AtmGui atmGui) {
        /// display screen
        atmGui.textBox.setText(
                "NetSaving Account\n"
                        + "NetSaving Account Balance: " + (netsavingAccount.bankBalance + netsavingAccount.interest()) + "\n"
                        + "Interest Rate: " + netsavingAccount.interestRate + "%\n"
                        + "Interest earned: " + netsavingAccount.interest() + "\n"
                        + "Choose:\n"
                        + "1. Deposit\n"
                        + "2. Withdraw\n"
                        + "3. Show Balance\n"
        );

        atmGui.optionTextField.setVisible(false);
        atmGui.amountTextField.setVisible(false);
        atmGui.newOptionTextField.setVisible(true);

        while (atmGui.newOption == 0) {
            Timer timer = new Timer(1, null);
            timer.setRepeats(false); // Stop after one execution
            timer.start();
            
        }


        if (atmGui.newOption == 1) {
            atmGui.button2.setEnabled(true);
            atmGui.textBox.setText("Enter the amount you want to Deposit:\n");
            atmGui.enterButton.setEnabled(false);

            // Making the new text field visible and the old one invisible
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);


            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                }
            }

            netsavingAccount.deposit = atmGui.enteredAmount;
            atmGui.enteredAmount = 0;
            netsavingAccount.deposit();

        } else if (atmGui.newOption == 2) {
            atmGui.button1.setEnabled(true);
            atmGui.textBox.setText("Enter the amount you want to Withdraw:\n");

            // Making the new text field visible and the old one invisible
            atmGui.optionTextField.setVisible(false);
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);

            atmGui.textBox.setText(atmGui.textBox.getText() + "Current withdrawal Limit: " + netsavingAccount.withdrawalLimit);

            atmGui.enteredAmount = 0;
            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                    if (atmGui.enteredAmount > 0) {
                        netsavingAccount.withdraw = atmGui.enteredAmount;
                        netsavingAccount.withdraw();
                    }
                }
            }


        } else if (atmGui.newOption == 3) {
            atmGui.textBox.setText("NetSaving Account\n"
                    + "NetSaving Account Balance: " + (netsavingAccount.bankBalance + netsavingAccount.interest())
                    + "\nInterest Rate: " + netsavingAccount.interestRate + "%"
                    + "\nInterest earned: " + netsavingAccount.interest()
                    + "\nInterest calculated -> monthly" +
                    "\n" + "\n" +
                    "\n In 3sec <------ Back to main screen ");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
        }
    }

    private static void handleChequeAccount(ChequeAccount chequeAccount, AtmGui atmGui) {
        // ... (code for handling ChequeAccount)
        // display screen
        atmGui.textBox.setText(
                "Cheque Account\n"
                        + "Cheque Account Balance: " + chequeAccount.bankBalance + "\n"
                        + "Choose:\n"
                        + "1. Deposit\n"
                        + "2. Withdraw\n"
                        + "3. Show Balance\n"
        );

        atmGui.optionTextField.setVisible(false);
        atmGui.amountTextField.setVisible(false);
        atmGui.newOptionTextField.setVisible(true);

        while (atmGui.newOption == 0) {
            Timer timer = new Timer(1, null);
            timer.setRepeats(false); // Stop after one execution

            timer.start();
            
        }

        if (atmGui.newOption == 1) {
            atmGui.button2.setEnabled(true);
            atmGui.textBox.setText("Enter the amount you want to Deposit:\n"
                    + " Current Deposit Limit: Unlimited");
            atmGui.enterButton.setEnabled(false);

            // Making the new text field visible and the old one invisible
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);


            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                }
            }
            chequeAccount.deposit = atmGui.enteredAmount;
            atmGui.enteredAmount = 0;
            chequeAccount.deposit();

        } else if (atmGui.newOption == 2) {
            atmGui.button1.setEnabled(true);
            atmGui.textBox.setText("Enter the amount you want to Withdraw:\n");
            atmGui.optionTextField.setVisible(false);
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);
            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                    if (atmGui.enteredAmount > 0) {
                        chequeAccount.withdraw = atmGui.enteredAmount;
                        chequeAccount.withdraw();
                        break;
                    }
                }


            }


        } else if (atmGui.newOption == 3) {
            atmGui.textBox.setText("Cheque Account\n"
                    + "Cheque Account Balance: " + (chequeAccount.bankBalance)
                    + "\nNo interest" +
                    "\n" + "\n" + "\n" + "\n" +
                    "\n In 3sec <------ Back to main screen >");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static void handleFixedAccount(FixedAccount fixedAccount, AtmGui atmGui) {
        // ... (code for handling FixedAccount)
        // display screen
        atmGui.textBox.setText(
                "Fixed Account\n"
                        + "Fixed Account Balance: " + (fixedAccount.bankBalance + fixedAccount.interest()) + "\n"
                        + "Interest Rate: " + fixedAccount.interestRate + "%\n"
                        + "Potential Interest: " + fixedAccount.potentialInterest() + "\n"
                        + "Choose:\n"
                        + "1. Deposit\n"
                        + "2. Withdraw\n"
                        + "3. Show Balance\n"
        );

        atmGui.optionTextField.setVisible(false);
        atmGui.amountTextField.setVisible(false);
        atmGui.newOptionTextField.setVisible(true);

        while (atmGui.newOption == 0) {
            Timer timer = new Timer(1, null);
            timer.setRepeats(false); // Stop after one execution
            while (timer.isRunning()) {
                // Keep the loop running while the timer is running
            }
            timer.start();
            
        }

        if (atmGui.newOption == 1) {
            atmGui.textBox.setText("Enter the amount you want to Deposit:\n");
            atmGui.button2.setEnabled(true);
            atmGui.enterButton.setEnabled(false);

            // Making the new text field visible and the old one invisible
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);
            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                }
            }
            fixedAccount.deposit = atmGui.enteredAmount;
            atmGui.enteredAmount = 0;
            fixedAccount.deposit();

        } else if (atmGui.newOption == 2) {
            atmGui.button1.setEnabled(true);
            atmGui.textBox.setText("Enter the amount you want to Withdraw:\n");
            atmGui.optionTextField.setVisible(false);
            atmGui.newOptionTextField.setVisible(false);
            atmGui.amountTextField.setVisible(true);
            atmGui.textBox.append("Current withdrawal Limit: Unlimited ");
            atmGui.enteredAmount = 0;
            while (atmGui.enteredAmount == 0) {
                Timer timer = new Timer(1, null);
                timer.setRepeats(false); // Stop after one execution

                timer.start();
                while (timer.isRunning()) {
                    // Keep the loop running while the timer is running
                    if (atmGui.enteredAmount > 0) {
                        fixedAccount.withdraw = atmGui.enteredAmount;
                        fixedAccount.withdraw();
                        break;
                    }
                }
            }

            fixedAccount.withdraw = atmGui.enteredAmount;
            fixedAccount.withdraw();
        } else if (atmGui.newOption == 3) {
            atmGui.textBox.setText("Fixed Account\n"
                    + "Fixed Account Balance: " + (fixedAccount.bankBalance + fixedAccount.interest())
                    + "\nInterest Rate: " + fixedAccount.interestRate + "%"
                    + "\nInterest earned: " + fixedAccount.interest()
                    + "\nPotential Interest: " + fixedAccount.potentialInterest()
                    + "\nInterest calculated -> fixed contract -> Currently on 1 year plan"
                    + "\n" + "\n"
                    + "\n In 3sec <------ Back to main screen >");


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
        }
    }
}
