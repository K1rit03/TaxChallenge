package com.tax.challenge.demo.services;

import com.tax.challenge.demo.entities.Client;
import com.tax.challenge.demo.entities.Loan;
import com.tax.challenge.demo.entities.LoanType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceTest {

    private LoanService loanService;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
    }

    @Test
    void testDetermineLoanTypePersonalLoan() {
        Client client = new Client("Alice", 2500, "SP", "123.456.789-00", 31);
        List<Loan> loans = loanService.determineLoanType(client);

        assertEquals(2, loans.size());
        assertEquals(LoanType.PERSONAL, loans.getFirst().getType());
        assertEquals(0.04, loans.getFirst().getInterestRate());
    }

    @Test
    void testDetermineLoanTypePersonalLoanWithConditions() {
        Client client = new Client("Bob", 4000, "SP", "987.654.321-00", 28);
        List<Loan> loans = loanService.determineLoanType(client);

        assertEquals(2, loans.size());
        assertTrue(loans.stream().anyMatch(loan -> loan.getType() == LoanType.PERSONAL));
        assertTrue(loans.stream().anyMatch(loan -> loan.getType() == LoanType.GUARANTEED));
    }

    @Test
    void testDetermineLoanTypeConsignmentLoan() {
        Client client = new Client("Charlie", 6000, "MG", "111.222.333-44", 35);
        List<Loan> loans = loanService.determineLoanType(client);

        assertEquals(1, loans.size());
        assertEquals(LoanType.CONSIGNMENT, loans.getFirst().getType());
        assertEquals(0.02, loans.getFirst().getInterestRate());
    }

    @Test
    void testDetermineLoanTypeGuaranteedLoan() {
        Client client = new Client("Dave", 4000, "SP", "555.666.777-88", 25);
        List<Loan> loans = loanService.determineLoanType(client);

        assertEquals(2, loans.size());
        assertTrue(loans.stream().anyMatch(loan -> loan.getType() == LoanType.PERSONAL));
        assertTrue(loans.stream().anyMatch(loan -> loan.getType() == LoanType.GUARANTEED));
    }

    @Test
    void testDetermineLoanTypeMultipleLoans() {
        Client client = new Client("Eve", 4000, "SP", "999.888.777-66", 25);
        List<Loan> loans = loanService.determineLoanType(client);

        assertEquals(2, loans.size());
        assertTrue(loans.stream().anyMatch(loan -> loan.getType() == LoanType.PERSONAL));
        assertTrue(loans.stream().anyMatch(loan -> loan.getType() == LoanType.GUARANTEED));
    }

    @Test
    void testDetermineLoanTypeNoEligibleLoan() {
        Client client = new Client("Frank", 4000, "MG", "333.444.555-66", 31);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> loanService.determineLoanType(client));

        assertEquals("Client not eligible for any loan", exception.getMessage());
    }
}