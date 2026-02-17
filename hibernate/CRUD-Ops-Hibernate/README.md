

# Hibernate CRUD Application

A simple Java-based CRUD (Create, Read, Update, Delete) application built using **Hibernate ORM** and **MySQL**.

This project demonstrates basic Hibernate configuration, entity mapping using annotations, and performing database operations using Session and Transaction.

---

## 🚀 Features

- Create Employee
- Read Employee by ID
- Update Employee salary
- Delete Employee
- Annotation-based configuration
- Hibernate automatic table creation

---

## 🛠️ Technologies Used

- Java
- Hibernate ORM
- MySQL
- IntelliJ IDEA 
- Maven 
```
## 📂 Project Structure

src/  
├── com.entity  
│    └── Employee.java  
│  
├── com.dao  
│    └── EmployeeOperations.java  
│  
└── com.client  
    └── CRUDClient.java

hibernate.cfg.xml

```

---

## 🗄️ Database Configuration

Make sure MySQL is running and create a database:

```sql
create database crudhibernate;

```

Update your `hibernate.cfg.xml`:

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/crudhibernate
</property>

<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">root</property>

<property name="hibernate.hbm2ddl.auto">update</property>

```

----------

## ▶️ How to Run the Project

1.  Clone the repository
    
2.  Open in IntelliJ / Eclipse
    
3.  Configure MySQL credentials in `hibernate.cfg.xml`
    
4.  Run `CRUDClient.java`
    
5.  Check MySQL database for created `employee` table
    

----------

## 📘 CRUD Operations Implemented

### 1️⃣ Create

```java
operations.addEmployee(new Employee("Dhoni", "HR", 90000));
```

### 2️⃣ Read

```java
operations.getEmployee(1);
```

### 3️⃣ Update

```java
operations.updateEmployee(1, 80000);
```

### 4️⃣ Delete

```java
operations.deleteEmployee(1);
```

This project is for learning purpose.
