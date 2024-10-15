package com.library.controller;

import org.springframework.web.bind.annotation.*;

import com.library.model.Book;
import com.library.model.Loan;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private List<Loan> loans = new ArrayList<>();

    
    @GetMapping("/customer/{customerId}")
    public List<Loan> getLoansByCustomer(@PathVariable Long customerId) {
        List<Loan> customerLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getCustomer().getId().equals(customerId)) {
                customerLoans.add(loan);
            }
        }
        return customerLoans;
    }

    
    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        loans.add(loan);
        for (Book book : loan.getBooks()) {
            book.setStatus("BORROWED");
        }
        return loan;
    }

    
    @PatchMapping("/{id}/return")
    public Loan finalizeLoan(@PathVariable Long id) {
        Loan loan = loans.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
        if (loan != null) {
            for (Book book : loan.getBooks()) {
                book.setStatus("AVAILABLE");
            }
        }
        return loan;
    }
}
