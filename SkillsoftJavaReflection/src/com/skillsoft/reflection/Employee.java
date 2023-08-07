package com.skillsoft.reflection;

import java.util.Random;

public class Employee {

    public static final String ORGANIZATION = "Skillsoft";

    private static final Random employeeIdGenerator = new Random();

    private int employeeId;
    private String name;
    private String title;
    private double salary;

    public Employee() {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
    }

    public Employee(String name, String title, double salary) {
        this();

        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private double computeBonusInternal(float bonusPercentage) {
        return salary * bonusPercentage;
    }

    public void incrementSalary(float percentageIncrement) {
        salary = salary + percentageIncrement * salary;
    }

    public double computeTotalSalary(float bonusPercentage) {
        return salary + computeBonusInternal(bonusPercentage);
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Titla: %s, Salary: %f",
                employeeId, name, title, salary);
    }
}
