package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmGui implements ActionListener {

    // declaring these buttons and text fields here so that we can use them in the entire class and not just in the createGUI method only
    JTextField text;
    JLabel accInfo;
    JTextArea textBox;
    JTextField optionTextField;
    JTextField newOptionTextField;
    JTextField amountTextField;
    int option;
    int newOption;
    String enteredNumber;
    int enteredAmount;
    JButton cancelButton;
    JButton enterButton;
    JPanel restScreen;

    JButton button1;
    JButton button2;
    JButton button3;

    public void createGUI() {
        JFrame frame = new JFrame("Ait Bank");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // this is the layout for the entire frame
        frame.setLayout(null);

        // these are different panels or our GUI
        JPanel screen = new JPanel();

        screen.setBounds(0, 0, 500, 215);

        // this is the text area in the app


        screen.setBackground(new Color(0xcccccc));
        JPanel notScreen = new JPanel(); // this panel will hold all the other panels
        notScreen.setBounds(0, 220, 500, 200);

        JPanel numPad = new JPanel();
        JPanel userActivities = new JPanel();
        JPanel enterCancel = new JPanel();
        enterCancel.setBounds(0, 420, 500, 50);

        enterCancel.setLayout(new GridLayout(1, 2));

        notScreen.setLayout(new GridLayout(1, 2));

        // layout for numpad
        numPad.setLayout(new GridLayout(4, 3, 5, 5));

        // layout for userActivities
        userActivities.setLayout(new GridLayout(3, 1, 5, 0));

        //this is the screen
        JPanel accDetail = new JPanel();
        screen.setLayout(null);
        screen.add(accDetail);
        accDetail.setBounds(0, 0, 500, 40);
        accInfo = new JLabel("Welcome");
        accDetail.add(accInfo);

        restScreen = new JPanel();
        restScreen.setBounds(0, 40, 500, 175);
        textBox = new JTextArea();
        optionTextField = new JTextField();
        newOptionTextField = new JTextField();
        amountTextField = new JTextField();

        restScreen.add(textBox);
        restScreen.add(optionTextField);
        restScreen.add(newOptionTextField);
        restScreen.add(amountTextField);
        restScreen.setLayout(null);


        textBox.setBounds(10, 0, 480, 145);
        textBox.setEditable(false);
        //this is for the main page
        optionTextField.setBounds(10, 145, 480, 30);
        optionTextField.setBackground(new Color(0xbbbbbb));
        //this is for the inside page
        newOptionTextField.setBounds(10, 145, 480, 30);
        newOptionTextField.setBackground(new Color(123456));
        //using it even more inside
        //this is for the inside page
        amountTextField.setBounds(10, 145, 480, 30);
        amountTextField.setBackground(new Color(456432));

        //setting it not visible in the beginning only making it visible when we need it
        newOptionTextField.setVisible(false);
        amountTextField.setVisible(false);

        amountTextField.setEditable(false);
        optionTextField.setEditable(false);
        newOptionTextField.setEditable(false);
        screen.add(restScreen);


        // This is the numPad panel
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton();
        JButton b11 = new JButton("0");
        JButton b12 = new JButton("Clear");

        // this is the userActivities panel
        button1 = new JButton("withdraw");
        button2 = new JButton("Deposit");
        button3 = new JButton("Help");

        // Cancel and Enter panel
        cancelButton = new JButton("Cancel");
        enterButton = new JButton("Enter");

        text = new JTextField("welcome", 10);
        screen.add(text);
        // these are the num pad
        numPad.add(b1);
        numPad.add(b2);
        numPad.add(b3);
        numPad.add(b4);
        numPad.add(b5);
        numPad.add(b6);
        numPad.add(b7);
        numPad.add(b8);
        numPad.add(b9);
        numPad.add(b10);
        numPad.add(b11);
        numPad.add(b12);


        // not screen panel
        // these are user activities
        userActivities.add(button1);
        userActivities.add(button2);
        userActivities.add(button3);

        enterCancel.add(cancelButton);
        enterCancel.add(enterButton);
        // add the panels in the frame
        frame.add(screen);
        notScreen.add(numPad);
        notScreen.add(userActivities);
        frame.add(notScreen);
        frame.add(enterCancel);

        // adding action to the buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        b11.addActionListener(this);
        b12.addActionListener(this);
        cancelButton.addActionListener(this);
        enterButton.addActionListener(this);
        b10.setEnabled(false); // setting this button disable

        // make the frames visible
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();


        switch (buttonName) {
            // this is the case for our help button
            case "Help":
                String infoMessage =
                        "This program simulates an ATM (Automated Teller Machine) application that allows users\n" +
                                "to interact with different types of bank accounts:\n" +
                                "- Saving\n" +
                                "- NetSaving\n" +
                                "- Cheque\n" +
                                "- Fixed accounts.\n\n" +

                                "Features:\n" +
                                "- User authentication with a fixed password.\n" +
                                "- Account creation and interaction with deposit, withdrawal, balance checking, and limit changes.\n" +
                                "- Different account types with varying interest rates and features.\n\n" +

                                "How to use:\n" +
                                "1. Run the program.\n" +
                                "2. Enter your account number and password for authentication.\n" +
                                "3. Choose an account type and perform various actions.\n" +
                                "4. Follow the on-screen instructions for each account type.\n\n" +

                                "Note: This program uses a graphical user interface (GUI) created with Swing.\n" +
                                "The user's interaction with the GUI triggers actions on different bank accounts.";

                JOptionPane.showMessageDialog(null, infoMessage, "ATM Application Information", JOptionPane.INFORMATION_MESSAGE);
                break;


            // this is the case for our cancel button
            case "Cancel":
                System.exit(0);

                // this is the case for our withdraw button
            case "Enter":

                if (optionTextField.isVisible()) {
                    option = Integer.parseInt(optionTextField.getText());
                    optionTextField.setText("");


                } else if (newOptionTextField.isVisible()) {
                    newOption = Integer.parseInt(newOptionTextField.getText());
                    newOptionTextField.setText("");
                } else if (amountTextField.isVisible()) {
                    enterButton.setEnabled(false);
                }
                break;

            // this is the case for our withdraw button
            case "withdraw":
                enteredAmount = Integer.parseInt(amountTextField.getText());
                amountTextField.setText("");
                if (enteredAmount > 0) {
                    textBox.setText("Withdrawn Succseefully");
                }
                break;


            // this is the case for our deposit button
            case "Deposit":
                enteredAmount = Integer.parseInt(amountTextField.getText());
                amountTextField.setText("");
                textBox.setText("Deposit Succseefully");

                break;


            // below are the number buttons
            case "1":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("1");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("1");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 1);
                }
                break;
            case "2":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("2");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("2");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 2);
                }
                break;
            case "3":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("3");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("3");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 3);
                }
                break;
            case "4":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("4");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("4");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 4);
                }
                break;
            case "5":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("5");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("5");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 5);
                }
                break;
            case "6":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("6");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("1");
                    amountTextField.setText(amountTextField.getText() + 6);
                }
                break;
            case "7":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("7");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("7");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 7);
                }
                break;
            case "8":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("8");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("8");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 8);
                }
                break;
            case "9":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("9");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("9");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 9);
                }
                break;
            case ".":
                if (optionTextField.isVisible()) {
                    optionTextField.setText(optionTextField.getText() + "0");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText(newOptionTextField.getText() + "0");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + "0");
                }
                break;
            case "0":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("0");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("0");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText(amountTextField.getText() + 0);
                }
                break;
            case "Clear":
                if (optionTextField.isVisible()) {
                    optionTextField.setText("");
                } else if (newOptionTextField.isVisible()) {
                    newOptionTextField.setText("");
                } else if (amountTextField.isVisible()) {
                    amountTextField.setText("");
                }
                break;
        }


    }

}