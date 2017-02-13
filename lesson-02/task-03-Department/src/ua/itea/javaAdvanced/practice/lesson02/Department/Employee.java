package ua.itea.javaAdvanced.practice.lesson02.Department;

import java.util.Calendar;

public class Employee extends Person{
    private int salary;
    private String position;

    public Employee(String name, String surName, Calendar birthDay){
        super(name, surName, birthDay);
    }

    public Employee(String name, String surName, boolean gender, Calendar birthDay, PhoneNumber phoneNumber,
                  Temperament temperament, int salary, String position){
        super(name, surName, gender, birthDay, phoneNumber, temperament);
        this.salary = salary;
        this.position = position;
    }

    void setSalary(int salary){
        this.salary = salary;
    }

    void setPosition(String position){
        this.position = position;
    }
}
