package com.tax.challenge.demo.entities;


import java.util.List;

public class Client {
    private String name;
    private double income;
    private String location;
    private String cpf;
    private Integer age;


    public Client() {
    }

    public Client(String name, double income, String location, String cpf, Integer age) {
        this.name = name;
        this.income = income;
        this.location = location;
        this.cpf = cpf;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}