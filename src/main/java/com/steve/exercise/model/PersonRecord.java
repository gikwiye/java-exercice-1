package com.steve.exercise.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class PersonRecord {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dob;
    private Address address;
    private String ni;
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRecord that = (PersonRecord) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(address, that.address) &&
                Objects.equals(ni, that.ni) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dob, address, ni, salary);
    }

}
