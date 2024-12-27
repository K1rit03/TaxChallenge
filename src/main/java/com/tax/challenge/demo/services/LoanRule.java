package com.tax.challenge.demo.services;

import com.tax.challenge.demo.entities.Client;
import com.tax.challenge.demo.entities.Loan;

import java.util.function.Predicate;

public class LoanRule {
    private final Predicate<Client> condition;
    private final Loan loan;

    public LoanRule(Predicate<Client> condition, Loan loan) {
        this.condition = condition;
        this.loan = loan;
    }

    public Predicate<Client> getCondition() {
        return condition;
    }

    public Loan getLoan() {
        return loan;
    }
}