package com.client;

import com.dao.EmployeeOperations;
import com.entity.Employee;

public class CRUDClient {

    public static void main(String[] args) {

        EmployeeOperations operations = new EmployeeOperations();

        // CREATE
        Employee emp4 = new Employee(4, "Omkar", "HR", 500.00);
        operations.addEmployee(emp4);

        // READ
        operations.getEmployee(1);

       // UPDATE
        operations.updateEmployee(1, 100000);

       // DELETE
        operations.deleteEmployee(4);

        operations.closeFactory();
    }
}

