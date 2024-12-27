package com.tax.challenge.demo.entities;

public class Loan {
    private double interestRate;
    private String type;

    public Loan() {
    }

    public Loan(double interestRate, String type) {
        this.interestRate = interestRate;
        this.type = type;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}