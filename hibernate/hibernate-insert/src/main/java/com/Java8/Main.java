package com.Java8;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        System.out.println("Step 1: Creating Employee object...");
        Employee e1 = new Employee(3,"Abhishek", "backend-Dev",76.20);
        System.out.println("Employee object created successfully.");
        //===============================================================

        System.out.println("Step 2: Loading Hibernate configuration file...");
        Configuration hbconfg = new Configuration();
        hbconfg.configure().addAnnotatedClass(Employee.class);
        System.out.println("Hibernate configuration loaded.");
        //===============================================================

        System.out.println("Step 3: Building SessionFactory...");
        SessionFactory sf = hbconfg.buildSessionFactory();
        System.out.println("SessionFactory created successfully.");
        //===============================================================

        System.out.println("Step 4: Opening Hibernate Session...");
        Session ssn = sf.openSession();
        System.out.println("Session opened successfully.");
        //===============================================================

        System.out.println("Step 5: Saving Employee object into database...");
        ssn.save(e1);
        System.out.println("Employee saved successfully.");
        //===============================================================

        System.out.println("Step 6: Beginning Transaction...Committing Transaction...");
        ssn.beginTransaction().commit();
        System.out.println("Transaction committed successfully.");
        //===============================================================

        System.out.println("Step 7: Closing Session and SessionFactory...");
        ssn.close();
        sf.close();
        //===============================================================

        System.out.println("Hibernate Insert Operation Completed Successfully.");
    }
}