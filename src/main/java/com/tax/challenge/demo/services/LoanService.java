package com.tax.challenge.demo.services;

import com.tax.challenge.demo.entities.Client;
import com.tax.challenge.demo.entities.Loan;
import com.tax.challenge.demo.entities.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {



    private static final List<LoanRule> LOAN_RULES = List.of(
            new LoanRule(c -> c.getIncome() >= 3000 && c.getIncome() <= 5000 && c.getAge() < 30 && c.getLocation().equals("SP"), new Loan(0.04, LoanType.PERSONAL)),
            new LoanRule(c -> c.getIncome() <= 3000, new Loan(0.04, LoanType.PERSONAL)),
            new LoanRule(c -> c.getIncome() >= 3000 && c.getIncome() <= 5000 && c.getAge() < 30 && c.getLocation().equals("SP"), new Loan(0.03, LoanType.GUARANTEED)),
            new LoanRule(c -> c.getIncome() >= 5000, new Loan(0.02, LoanType.CONSIGNMENT))
    );
        public List<Loan> determineloanType(Client client){
            List<Loan> loans = new ArrayList<>();
            for (LoanRule rule : LOAN_RULES) {
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