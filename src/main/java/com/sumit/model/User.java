package com.sumit.model;

public class User {
    private String name;
    private String department;
    private Long salary;

    public User(String name, String developer, Long salary) {
        this.name=name;
        this.department=developer;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        salary = salary;
    }
}
