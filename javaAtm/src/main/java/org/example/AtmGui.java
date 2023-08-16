package org.example;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AtmGui implements ActionListener {
    JTextField text;
    String enteredNumber;


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
        numPad.setLayout(new GridLayout(3, 3, 5, 5));

        // layout for userActivities
        userActivities.setLayout(new GridLayout(4, 1, 5, 0));

        //this is the screen


        // This is the numPad pannel
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        // this is the userActivities panel
        JButton button1 = new JButton("withdraw");
        JButton button2 = new JButton("Deposite");
        JButton button3 = new JButton("Balance Inquiry");
        JButton button4 = new JButton("Help");

        // Cancel and Enter panel
        JButton cancelButton = new JButton("Cancel");
        JButton enterButton = new JButton("Enter");

        text = new JTextField("welcome",10);
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

        // not screen panel
        // these are user activities
        userActivities.add(button1);
        userActivities.add(button2);
        userActivities.add(button3);
        userActivities.add(button4);

        enterCancel.add(cancelButton);
        enterCancel.add(enterButton);
        // add the panels in the frame
        frame.add(screen);
        notScreen.add(numPad);
        notScreen.add(userActivities);
        frame.add(notScreen);
        frame.add(enterCancel);

        // addding action to the buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        cancelButton.addActionListener(this);
        enterButton.addActionListener(this);

        // make the frames visible
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if (buttonName.equals("Cancel")) {
            JOptionPane.showMessageDialog(null, "Operation Cancelled", "Ait Bank", 1);
            System.exit(0);
        }
        else if (buttonName.equals("Enter")){
            text.setText("");
        }

        switch (buttonName) {
            case "1":
                text.setText(text.getText() + 1);
                break;
            case "2":
                text.setText(text.getText() + 2);
                break;
            case "3":
                text.setText(text.getText() + 3);
                break;
            case "4":
                text.setText(text.getText() + 4);
                break;
            case "5":
                text.setText(text.getText() + 5);
                break;
            case "6":
                text.setText(text.getText() + 6);
                break;
            case "7":
                text.setText(text.getText() + 7);
                break;
            case "8":
                text.setText(text.getText() + 8);
                break;
            case "9":
                text.setText(text.getText() + 9);
                break;
        }





    }

}
