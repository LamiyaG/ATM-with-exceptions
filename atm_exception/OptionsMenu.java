package com.example.atm_exception;

import com.example.atm_exception.Account;
import com.example.atm_exception.exceptions.InsufficientBalanceException;
import com.example.atm_exception.exceptions.InvalidAmountException;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionsMenu extends Account {
    Scanner menuInput = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException, InsufficientBalanceException, InvalidAmountException {
        int x = 1;
        do{
            try{
                data.put(12345, 12345);
                data.put(67890, 67890);

                System.out.println("Welcome to the ATM Project!!!");
                System.out.println("Enter your customer ID:");
                setCustomerID(menuInput.nextInt());

                System.out.println("Enter your PIN:");
                setCustomerPin(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n"+"Invalid Character(s) Detected. Only Numbers."+"\n");
                x = 2;
            }
            int cid = getCustomerID();
            int cpin = getCustomerPin();
            if(data.containsKey(cid) && data.get(cid) == cpin)
                getAccountType();
            else
                System.out.println("\n" + "Wrong Customer ID or PIN! Try Again...." + "\n");
        }while(x == 1);
    }

    public void getAccountType() throws InvalidAmountException, InsufficientBalanceException {
        System.out.println("\n" + "Select the account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - EXIT");

        int selection = menuInput.nextInt();

        switch(selection){
            case 1: getChecking();
                    break;

            case 2:getSavings();
                   break;

            case 3:System.out.println("Thank you for using this ATM. BYE!!!");
                    System.exit(0);
                    break;

            default:System.out.println("\n" + "Invalid Choice! Please enter correct menu option..." + "\n");
                    getAccountType();
        }
    }

    public void getChecking() throws InsufficientBalanceException, InvalidAmountException {
        System.out.println("\n" + "Select one from below:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Money");
        System.out.println("Type 4 - EXIT");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:System.out.println("Your Checking Account balance is " + moneyFormat.format(getCheckingBalance()));
                    getAccountType();
                    break;

            case 2:getCheckingWithdraw();
                    getAccountType();
                    break;

            case 3:getCheckingDeposit();
                    getAccountType();
                    break;

            case 4:System.out.println("Thank you for using this ATM. BYE!!!");
                    System.exit(0);
                    break;

            default:System.out.println("\n" + "Invalid Choice! Please enter correct menu option..." + "\n");
                    getChecking();

        }
    }

    public void getSavings() throws InsufficientBalanceException {
        System.out.println("\n" + "Select one from below:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Money");
        System.out.println("Type 4 - EXIT");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:System.out.println("Your Savings Account balance is " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;

            case 2:getSavingsWithdraw();
                getAccountType();
                break;

            case 3:getSavingsDeposit();
                getAccountType();
                break;

            case 4:System.out.println("Thank you for using this ATM. BYE!!!");
                System.exit(0);
                break;

            default:System.out.println("\n" + "Invalid Choice! Please enter correct menu option..." + "\n");
                getSavings();

        }
    }
}
