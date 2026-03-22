package com.example.atm_exception;

import com.example.atm_exception.exceptions.InsufficientBalanceException;
import com.example.atm_exception.exceptions.InvalidAmountException;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerID;
    private int customerPin;
    private double checkingBalance = 2000;
    private double savingsBalance = 15000;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'S'###,##0.00");

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerPin(int customerPin) {
        this.customerPin = customerPin;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getCustomerPin() {
        return customerPin;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double calcCheckingAfterDeposit(double amount){
        checkingBalance += amount;
        return checkingBalance;
    }

    public double calcCheckingAfterWithdraw(double amount){
        checkingBalance -= amount;
        return checkingBalance;
    }

    public double calcSavingsAfterDeposit(double amount){
        savingsBalance += amount;
        return savingsBalance;
    }

    public double calcSavingsAfterWithdraw(double amount){
        savingsBalance -= amount;
        return savingsBalance;
    }

    public void getCheckingWithdraw() throws InsufficientBalanceException {
        System.out.println("Your Checking Account Balance is " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to withdraw from Checking Account:");
        double amount = input.nextDouble();

        if((checkingBalance - amount) <= 0)
            throw new InsufficientBalanceException("Insufficient Funds!");
        else
            System.out.println("Your new Checking Account balance is " + moneyFormat.format(calcCheckingAfterWithdraw(amount)));
    }

    public void getCheckingDeposit() throws InvalidAmountException{
        System.out.println("Your Checking Account Balance is " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to deposit to Checking Account:");
        double amount = input.nextDouble();

        if(amount <= 0)
            throw new InvalidAmountException("Deposit amount must be greater than or equal to 0!");
        else
            System.out.println("Your new Checking Account balance is " + moneyFormat.format(calcCheckingAfterDeposit(amount)));
    }

    public void getSavingsWithdraw() throws InsufficientBalanceException {
        System.out.println("Your Savings Account Balance is " + moneyFormat.format(savingsBalance));
        System.out.println("Enter the amount you want to withdraw from Savings Account:");
        double amount = input.nextDouble();

        if((checkingBalance - amount) <= 0)
            throw new InsufficientBalanceException("Insufficient Funds!");
        else
            System.out.println("Your new Savings Account balance is " + moneyFormat.format(calcSavingsAfterWithdraw(amount)));
    }

    public void getSavingsDeposit() throws InvalidAmountException{
        System.out.println("Your Savings Account Balance is " + moneyFormat.format(savingsBalance));
        System.out.println("Enter the amount you want to deposit to Savings Account:");
        double amount = input.nextDouble();

        if(amount <= 0)
            throw new InvalidAmountException("Deposit amount must be greater than or equal to 0!");
        else
            System.out.println("Your new Savings Account balance is " + moneyFormat.format(calcSavingsAfterDeposit(amount)));
    }
}
