


## Association (HAS-A Relationship)

### Definition

**Association** represents a relationship where one class **uses** or **interacts with** another class, but both classes can exist **independently**.

----------

### Example

**Car HAS-A Engine**

-   A `Car` uses an `Engine`
    
-   An `Engine` can exist without a `Car`
    
-   This is a **loose coupling** example of association
    

----------

### How Association Is Achieved

Association is achieved by:

-   Declaring an object reference of one class inside another class
    
-   Passing the dependent object using a **constructor or setter**
    

----------



### We can achieve Association using:

1.  **Direct Reference Variables**
    
2.  **Constructor Injection**
    
3.  **Setter Injection**
    

----------

## Program 1: Association using Direct Reference Variables

### Explanation

-   `Company` directly creates and uses an `Employee`
    
-   Object reference is declared as an **instance variable**
    
-   Simple but **tight coupling**
    

----------

### Code

```java
class Employee
{
    String name = "Ravi";
    int empId = 201;

    void showEmployee()
    {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
    }
}

class Company
{
    String companyName = "Infosys";

    // Direct reference variable
    Employee employee = new Employee();  // Object created inside the class

    void showCompanyDetails()
    {
        System.out.println("Company: " + companyName);
        employee.showEmployee();
    }
}

public class MainApp
{
    public static void main(String[] args)
    {
        Company company = new Company();
        company.showCompanyDetails();
    }
}

```

### Output

```
Company: Infosys
Employee Name: Ravi
Employee ID: 201

```

----------

## Program 2: Association using Constructor Injection

### Explanation

-   `Employee` object is created **outside**
    
-   Injected into `Company` using constructor
    
-   Promotes **loose coupling** and flexibility
    

----------

### Code

```java
class Employee
{
    String name;
    int empId;

    Employee(String name, int empId)
    {
        this.name = name;
        this.empId = empId;
    }

    void showEmployee()
    {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
    }
}

class Company
{
    String companyName;
    private Employee employee;

    // Constructor Injection
    Company(String companyName, Employee employee)
    {
        this.companyName = companyName;
        this.employee = employee;
    }

    void showCompanyDetails()
    {
        System.out.println("Company: " + companyName);
        employee.showEmployee();
    }
}

public class MainApp
{
    public static void main(String[] args)
    {
        Employee emp = new Employee("Ravi", 201);
        Company company = new Company("Infosys", emp);

        company.showCompanyDetails();
    }
}

```

### Output

```
Company: Infosys
Employee Name: Ravi
Employee ID: 201

```

----------

## Program 3: Association using Setter Injection

### Explanation

-   Dependency is injected **after object creation**
    
-   Useful when dependency is **optional or changeable**
    
-   Common in frameworks like **Spring**
    

----------

### Code

```java
class Employee
{
    String name;
    int empId;

    Employee(String name, int empId)
    {
        this.name = name;
        this.empId = empId;
    }

    void showEmployee()
    {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
    }
}

class Company
{
    String companyName;
    private Employee employee;

    Company(String companyName)
    {
        this.companyName = companyName;
    }

    // Setter Injection
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    void showCompanyDetails()
    {
        System.out.println("Company: " + companyName);
        employee.showEmployee();
    }
}

public class MainApp
{
    public static void main(String[] args)
    {
        Employee emp = new Employee("Ravi", 201);
        Company company = new Company("Infosys");

        // Inject dependency using setter
        company.setEmployee(emp);

        company.showCompanyDetails();
    }
}

```

### Output

```
Company: Infosys
Employee Name: Ravi
Employee ID: 201

```

----------

