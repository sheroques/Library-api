package com.library.model;

public class Customer {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String country;
    private String birthDate;
    private String status; 

    
    public Customer(Long id, String name, String lastname, String address, String city, String state, String country, String birthDate, String status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.birthDate = birthDate;
        this.status = status;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
