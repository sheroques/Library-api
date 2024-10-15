package com.library.model;

import java.util.List;

public class Loan {
    private Long id;
    private Customer customer;
    private List<Book> books;
    private String loanDate;
    private String returnDate;

    public Loan(Long id, Customer customer, List<Book> books, String loanDate, String returnDate) {
        this.id = id;
        this.customer = customer;
        this.books = books;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}

