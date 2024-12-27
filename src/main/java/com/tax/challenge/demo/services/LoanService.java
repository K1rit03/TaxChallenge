package com.tax.challenge.demo.services;

import com.tax.challenge.demo.entities.Client;
import com.tax.challenge.demo.entities.Loan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public List<Loan> determineLoanType(Client client) {
        List<Loan> loans = new ArrayList<>();

        List<LoanRule> rules = List.of(
            new LoanRule(c -> c.getIncome() <= 3000, new Loan(0.04, "Empréstimo Pessoal")),
            new LoanRule(c -> c.getIncome() >= 3000 && c.getIncome() <= 5000 && c.getAge() < 30 && c.getLocation().equals("SP"), new Loan(0.03, "Empréstimo Consignado")),
            new LoanRule(c -> c.getIncome() >= 5000, new Loan(0.02, "Empréstimo Consignado"))
        );

        for (LoanRule rule : rules) {
            if (rule.getCondition().test(client)) {
                loans.add(rule.getLoan());
            }
        }

        if (loans.isEmpty()) {
            throw new IllegalArgumentException("Client not eligible for any loan");
        }

        return loans;
    }
}