package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class EmployeeOperations {

    private SessionFactory factory;

    public EmployeeOperations() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }

    // CREATE
    public void addEmployee(Employee emp) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(emp);

        tx.commit();
        session.close();
        System.out.println("Employee added successfully!");
    }

    // READ
    public void getEmployee(int id) {
        Session session = factory.openSession();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.println(emp.getName());
        } else {
            System.out.println("Employee not found!");
        }

        session.close();
    }
  // UPDATE
    public void updateEmployee(int id, double newSalary) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            emp.setSalary(newSalary);
            session.update(emp);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteEmployee(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }

        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}
