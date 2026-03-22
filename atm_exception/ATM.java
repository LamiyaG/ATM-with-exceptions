package com.example.atm_exception;

import com.example.atm_exception.OptionsMenu;
import com.example.atm_exception.exceptions.InsufficientBalanceException;
import com.example.atm_exception.exceptions.InvalidAmountException;

import java.io.IOException;

public class ATM {
    public static void main(String[] args)  {
        OptionsMenu menu = new OptionsMenu();
        try {
            menu.getLogin();
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        } catch (InvalidAmountException e){
            System.out.println("Transaction Failed: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Sorry... Please restart the program");
        }
    }
}
