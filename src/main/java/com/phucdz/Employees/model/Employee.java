package com.phucdz.Employees.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String group_employee;
    private String name;
    private String sex;
    @NotEmpty
    @Pattern(regexp = "^(09[0-9]{8}|(03[0-9]{8}))$",message = " phonenumber not validate")
    private String number;
    @Email(message = "{Email not validate}")
    @NotBlank(message ="{Not Blank}")
    private String email;

    public Employee() {
    }

    public Employee(String group_employee, String name, String sex,  String number, String email) {
        this.group_employee = group_employee;
        this.name = name;
        this.sex = sex;
        this.number = number;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_employee() {
        return group_employee;
    }

    public void setGroup_employee(String group_employee) {
        this.group_employee = group_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
