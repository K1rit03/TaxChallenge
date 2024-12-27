package com.tax.challenge.demo.controller;

import com.tax.challenge.demo.entities.Client;
import com.tax.challenge.demo.entities.Loan;
import com.tax.challenge.demo.entities.LoanResponse;
import com.tax.challenge.demo.services.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer-loans")
public class LoanServiceController {

    private final LoanService loanService;

    public LoanServiceController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public LoanResponse requestLoan(@RequestBody Client client) {
        List<Loan> loans = loanService.determineLoanType(client);
        return new LoanResponse(client.getName(), loans);
    }
}