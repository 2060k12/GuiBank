

// this is the old verson of my code


/*
package org.example;

import javax.swing.*;


public class Main {
    static boolean backToHome;
    static float totalBalance = 0;

    public static void main(String[] args) {
        // creating an object for our GUI class
        // this is the total balance of all account combined
        // an object for SavingAccount class
        SavingAccount savingAccount = SavingAccount.createSavingAccount();

        // an object for NetSaving class
        NetSavingAccount netsavingAccount = NetSavingAccount.createNetsavingAccount();

        // an object for ChequeAccount
        ChequeAccount chequeAccount = ChequeAccount.createChequeAccount();

        // an object for FixedAccount
        FixedAccount fixedAccount = FixedAccount.createFixedAccount();

        // A GUI based Panel to ask user about their name and account number
        savingAccount.accountNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your Account Number? "));
        savingAccount.accountName = (JOptionPane.showInputDialog(null, "What is your Name? "));

        // back to console based, this prints the name and accout number which was given by user
        System.out.println("Welcome, " + savingAccount.accountName + "!");
        System.out.println("@" + savingAccount.accountNumber);


        AtmGui atmGui = new AtmGui();
        atmGui.createGUI();


        atmGui.accInfo.setText("Welcome, " + savingAccount.accountName + ": @ " + savingAccount.accountNumber);


        // using an infinity loop so that it keeps on asking user for input an input and keeps generating output based on that
        while (true) {
            backToHome = false;

            while (!backToHome) {

                // Main part of our ATM
                // Assuming atmGui is your GUI object
                atmGui.newOptionTextField.setVisible(false);

                atmGui.amountTextField.setVisible(false);

                atmGui.optionTextField.setVisible(true);

                atmGui.option = 0;
                atmGui.newOption = 0;
                atmGui.enteredAmount = 0;


                // ask user to input for the option above
                // using switch case as we have different case, it is a better alternative for if else for our code.

                atmGui.button1.setEnabled(false);
                atmGui.button2.setEnabled(false);

                switch (atmGui.option) {

                    case (1):

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
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (atmGui.newOption > 0) {
                                break;

                            }
                        }
                        // if user choose option 1, it will ask user to enter the amount they want to deposit
                        if (atmGui.newOption == 1) {
                            atmGui.textBox.setText("Enter the amount you want to Deposit:\n");
                            atmGui.enterButton.setEnabled(false);
                            atmGui.button2.setEnabled(true);

                            // Making the new text field visible and the old one invisible
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);


                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;

                                }
                            }
                            savingAccount.deposit = atmGui.enteredAmount;
                            atmGui.enteredAmount = 0;
                            savingAccount.deposit();
                            // if user choose option 2, it will ask user to enter the amount they want to withdraw

                        } else if (atmGui.newOption == 2) {
                            atmGui.enterButton.setEnabled(false);
                            atmGui.textBox.setText(atmGui.textBox.getText() + "Current withdrawal Limit: " + savingAccount.withdrawalLimit);
                            atmGui.textBox.setText("\nEnter the amount you want to Withdraw:\n");
                            atmGui.optionTextField.setVisible(false);
                            atmGui.button1.setEnabled(true);
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);
                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    savingAccount.withdraw = atmGui.enteredAmount;
                                    savingAccount.withdraw();
                                    break;

                                }


                            }

                        } else if (atmGui.newOption == 3) {
                            atmGui.textBox.setText("Current limit: " + savingAccount.withdrawalLimit
                                    + "\nChoose:\n 1. Change Limit\n 2. Cancel");
                            atmGui.enterButton.setEnabled(true);

                            // Making the new text field visible and the old one invisible
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);
                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;

                                }
                            }

                            int optionChangeLimit = atmGui.enteredAmount;
                            if (optionChangeLimit == 1) {
                                savingAccount.withdrawalLimit = atmGui.enteredAmount;
                                atmGui.textBox.append("\nLimit Change Successfully!");
                                atmGui.textBox.append("\nNew limit: " + savingAccount.withdrawalLimit);
                            } else if (optionChangeLimit == 2) {
                                atmGui.textBox.append("\nOperation Cancelled!");
                            } else {
                                atmGui.textBox.append("\nWrong Input");
                            }


                        } else if (atmGui.newOption == 4) {

                            atmGui.textBox.setText("Saving Account\n"
                                    + "Saving Account Balance: " + (savingAccount.bankBalance + savingAccount.interest())
                                    + "\nInterest Rate: " + savingAccount.interestRate + "%"
                                    + "\nInterest earned: " + savingAccount.interest()
                                    + "\nInterest calculated Daily" +
                                    "\n" + "\n" +
                                    "\n In 3sec <------ Back to main screen >");

                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        break;

                    // case 2,  it shows the NetSaving account details and ask user to interact with it
                    // case 2, it shows the NetSaving account details and asks the user to interact with it
                    case 2:
                        // display screen
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
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (atmGui.newOption > 0) {
                                break;
                            }
                        }

                        if (atmGui.newOption == 1) {
                            atmGui.textBox.setText("Enter the amount you want to Deposit:\n");
                            atmGui.enterButton.setEnabled(false);

                            // Making the new text field visible and the old one invisible
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);


                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;

                                }
                            }
                            netsavingAccount.deposit = atmGui.enteredAmount;
                            atmGui.enteredAmount = 0;
                            netsavingAccount.deposit();

                        } else if (atmGui.newOption == 2) {
                            netsavingAccount.bankBalance = 1000;
                            atmGui.textBox.append("Enter the amount you want to Withdraw:\n");

                            // Making the new text field visible and the old one invisible
                            atmGui.optionTextField.setVisible(false);
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);

                            atmGui.textBox.setText(atmGui.textBox.getText() + "Current withdrawal Limit: " + netsavingAccount.withdrawalLimit);

                            atmGui.enteredAmount = 0;
                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;

                                }
                            }

                            netsavingAccount.withdraw = atmGui.enteredAmount;
                            netsavingAccount.withdraw();
                        } else if (atmGui.newOption == 3) {
                            atmGui.textBox.setText("NetSaving Account\n"
                                    + "NetSaving Account Balance: " + (netsavingAccount.bankBalance + netsavingAccount.interest())
                                    + "\nInterest Rate: " + netsavingAccount.interestRate + "%"
                                    + "\nInterest earned: " + netsavingAccount.interest()
                                    + "\nInterest calculated -> monthly" +
                                    "\n" + "\n" +
                                    "\n In 2sec <------ Back to main screen >");

                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        break;


                    // case 3,  it shows the Cheque account details and ask user to interact with it

                    case 3:
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
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (atmGui.newOption > 0) {
                                break;
                            }
                        }

                        if (atmGui.newOption == 1) {
                            atmGui.textBox.setText("Enter the amount you want to Deposit:\n"
                                    + " Current Deposit Limit: Unlimited");
                            atmGui.enterButton.setEnabled(false);

                            // Making the new text field visible and the old one invisible
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);


                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;

                                }
                            }
                            chequeAccount.deposit = atmGui.enteredAmount;
                            atmGui.enteredAmount = 0;
                            chequeAccount.deposit();

                        } else if (atmGui.newOption == 2) {
                            atmGui.textBox.setText("Enter the amount you want to Withdraw:\n");
                            atmGui.optionTextField.setVisible(false);
                            atmGui.button1.setEnabled(true);
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);
                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    chequeAccount.withdraw = atmGui.enteredAmount;
                                    chequeAccount.withdraw();
                                    break;

                                }


                            }


                        } else if (atmGui.newOption == 3) {
                            atmGui.textBox.setText("Cheque Account\n"
                                    + "Cheque Account Balance: " + (chequeAccount.bankBalance)
                                    + "\nNo interest" +
                                    "\n" + "\n" + "\n" + "\n" +
                                    "\n In 2sec <------ Back to main screen >");

                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        } else {
                            atmGui.textBox.append("Wrong Input");
                        }

                        break;

                    // case 4,  it shows the Cheque account details and ask user to interact with it

                    case 4:
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
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (atmGui.newOption > 0) {
                                break;
                            }
                        }

                        if (atmGui.newOption == 1) {
                            atmGui.textBox.setText("Enter the amount you want to Deposit:\n");
                            atmGui.enterButton.setEnabled(false);

                            // Making the new text field visible and the old one invisible
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);

                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;
                                }
                            }
                            fixedAccount.deposit = atmGui.enteredAmount;
                            atmGui.enteredAmount = 0;
                            fixedAccount.deposit();

                        } else if (atmGui.newOption == 2) {
                            atmGui.textBox.append("Enter the amount you want to Withdraw:\n");
                            atmGui.optionTextField.setVisible(false);
                            atmGui.newOptionTextField.setVisible(false);
                            atmGui.amountTextField.setVisible(true);
                            atmGui.textBox.append("Current withdrawal Limit: Unlimited ");
                            atmGui.enteredAmount = 0;
                            while (atmGui.enteredAmount == 0) {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (atmGui.enteredAmount > 0) {
                                    break;
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

                        break;


                }
                // this line updates totalBalance everytime a switch case is completed and before it goes back to the top using while loop
                totalBalance = netsavingAccount.bankBalance + savingAccount.bankBalance + chequeAccount.bankBalance + fixedAccount.bankBalance;
                break;
            }
        }


    }


}

*/
