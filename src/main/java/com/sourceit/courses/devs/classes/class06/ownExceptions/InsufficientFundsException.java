package com.sourceit.courses.devs.classes.class06.ownExceptions;


public class InsufficientFundsException extends Exception{
    private double amount;
    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
}
