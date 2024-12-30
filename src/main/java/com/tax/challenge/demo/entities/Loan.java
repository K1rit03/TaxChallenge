package com.tax.challenge.demo.entities;

public class Loan {
    private double interestRate;
    private LoanType type;

    public Loan() {
    }

    public Loan(double interestRate, LoanType type) {
        this.interestRate = interestRate;
        this.type = type;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }
}