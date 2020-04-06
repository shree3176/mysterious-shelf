package com.shri.inventoryapp.entity;

import com.shri.inventoryapp.EmployeeType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long phoneNo;

    private String address;

    private EmployeeType employeeType;

}
