## Introduction

-   Polymorphism is one of the main concepts of Object-Oriented Programming (OOP) in Java.
-   Poly → many, Morph → forms; so  **Polymorphism means "many forms"**.
-   It means the ability of a single entity (method, object, or operator) to behave in  **multiple ways**.
-   Java uses polymorphism to let us write flexible and reusable code.
-   **Real-world Examples :-**
    -   A person: acts as a teacher, father, son — different roles.
    -   Water: takes shape of the container it’s in.
    -   Sound: same sound word used in different tones.
-   **Advantage of Polymorphism :-**
    -   Increases  **flexibility and reusability**.
    -   Allows  **code extensibility**  without modifying existing code.
    -   Supports  **single task, multiple implementations**.
    -   Enhances  **maintainability and scalability**.

##### Types of Polymorphism in Java :-

1.  **_Compile-Time Polymorphism_**
    -   It is also known as  _Static Binding_  or  _Early Binding_.
    -   It is achieved by  _Method Overloading_  or  _Operator Overloading_.
    -   In compile-time polymorphism, the  _Java compiler_  decides at compile time which  _overloaded method_  or  _operator_  to invoke based on the  _method signature_  and  _reference type_.
    -   Program ([Method Overloading](https://smartprogramming.in/tutorials/java/method-overloading-in-java.php)):
        
        ```java
        class Calculator
        {
            void add(int a, int b)
            {
                System.out.println(a+b);
            }
        
            void add(double a, double b)
            {
                System.out.println(a+b);
            }
        }
        ```
        
    -   Here:
        -   `Calculator calc = new Calculator(); // Reference type = Calculator`
        -   `calc.add(5, 10); // method signature = add(int, int) → decided at compile-time`
 
 
2.  **_Runtime Polymorphism_**
    -   It is also known as  _Dynamic Binding_  or  _Late Binding_.
    -   It is achieved by  _Method Overriding_.
    -   In runtime polymorphism, the  _JVM (Java Virtual Machine)_  decides at runtime which  _overridden method_  to invoke based on the  _actual object_  (not the reference type).
    -   Program ([Method Overriding](https://smartprogramming.in/tutorials/java/method-overriding-in-java.php)):
        
        ```java
        class Animal
        {
            void makeSound()
            {
                System.out.println("Some generic sound");
            }
        }
        
        class Dog extends Animal
        {
            void makeSound()
            {
                System.out.println("Dog barks");
            }
        }
        ```
        
    -   Here:
        -   `Animal obj = new Dog(); // Reference type = Animal, Object type = Dog`
        -   `obj.makeSound(); // Method decided at runtime → calls Dog's makeSound()`
   
----------

##### Important Points

-   Some important points to remember about polymorphism in Java:
    1.  Polymorphism is mainly achieved through method overloading and method overriding.
        -   Overloading → Compile-time polymorphism
        -   Overriding → Runtime polymorphism
    2.  Polymorphism supports the Open/Closed Principle.
        -   Code is open for extension but closed for modification.
    3.  Polymorphism helps reduce code duplication by reusing the same interface or method name across different types.
    4.  Upcasting enables runtime polymorphism.
        -   Parent class reference can hold a child class object.
        -   Example:
            
            ```java
            Animal myDog = new Dog();
            ```