
# Inheritance in Java


## **I. Introduction to Inheritance**

Inheritance is one of the most important pillars of Object-Oriented Programming (OOP) in Java. It allows one class to **reuse the properties and methods of another class**, reducing code duplication and improving maintainability.

We can think of inheritance like a **family tree**. Just as children inherit traits from their parents, a child class inherits behavior and data from a parent class. However, the child is free to add its own features or even modify inherited behavior.

In Java, inheritance establishes an **“is-a” relationship** and is implemented using the `extends` keyword.

----------

## **II. Basic Concepts and Terminology**

### **1. Superclass and Subclass**

-   **Superclass (Parent Class):** The class being inherited.
    
-   **Subclass (Child Class):** The class that inherits from the superclass.
    

### **Example: Superclass**

```java
class Animal {
    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}

```

### **Example: Subclass**

```java
class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}

```

Here:

-   `Animal` is the **superclass**
    
-   `Dog` is the **subclass**
    
-   `Dog` automatically inherits `name` and `eat()` from `Animal`
    

----------

### **2. Using Inherited Members**

```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.name = "Buddy";      // inherited variable
        d.eat();               // inherited method
        d.bark();              // own method
    }
}

```

👉 This shows how a subclass can directly use members of its parent class.

----------

## **III. Types of Inheritance in Java (with Examples)**

----------

### **1. Single Inheritance**

Single inheritance means **one child class inherits from one parent class**.

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}

```

```java
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();   // inherited
        car.drive();   // own method
    }
}

```

✔ Java fully supports single inheritance.

----------

### **2. Multilevel Inheritance**

In multilevel inheritance, a class inherits from a class that is already inherited from another class.

```java
class LivingBeing {
    void breathe() {
        System.out.println("Living being is breathing");
    }
}

class Animal extends LivingBeing {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

```

```java
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.breathe();
        dog.eat();
        dog.bark();
    }
}

```

👉 This demonstrates how behavior flows **down the inheritance chain**.

----------

### **3. Hierarchical Inheritance**

One parent class, **multiple child classes**.

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    void drawCircle() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("Drawing a rectangle");
    }
}

```

Each child shares common behavior from `Shape` but adds its own logic.

----------

### **4. Why Java Does Not Support Multiple Inheritance with Classes**

```java
// This is NOT allowed in Java
class A {
    void show() { }
}

class B {
    void show() { }
}

// class C extends A, B { } ❌ Compile-time error

```

Java avoids this to prevent **ambiguity** (Diamond Problem).

----------

## **IV. Method Overriding and `super` Keyword**


### **1. Method Overriding**

Method overriding allows a subclass to provide a **specific implementation** of a method already defined in the superclass.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

```

```java
public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();   // Dog barks (Runtime Polymorphism)
    }
}

```

👉 The method call is resolved **at runtime**, not compile time.

----------

### **2. Using the `super` Keyword**

#### **Accessing Parent Method**

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound();   // calls parent method
        System.out.println("Dog barking");
    }
}

```

----------

#### **Accessing Parent Variable**

```java
class Animal {
    String color = "White";
}

class Dog extends Animal {
    String color = "Black";

    void printColor() {
        System.out.println(super.color); // White
        System.out.println(color);       // Black
    }
}

```

----------

## **V. Constructors and Inheritance**


### **1. Constructor Execution Order**

```java
class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor called");
    }
}

```

```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}

```

**Output:**

```
Animal constructor called
Dog constructor called

```

👉 Parent constructor always executes **first**.

----------

### **2. Calling Parameterized Parent Constructor**

```java
class Animal {
    Animal(String name) {
        System.out.println("Animal name: " + name);
    }
}

class Dog extends Animal {
    Dog() {
        super("Buddy"); // must be first statement
        System.out.println("Dog constructor");
    }
}

```

----------

## **VI. Interfaces as an Alternative to Multiple Inheritance**

Java allows multiple inheritance using **interfaces**.

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying");
    }

    public void swim() {
        System.out.println("Duck is swimming");
    }
}

```

👉 This solves the multiple inheritance problem **without ambiguity**.

----------

## **Conclusion**

Inheritance in Java enables us to build programs that are **structured, reusable, and scalable**. Through real-world class hierarchies, we reduce redundancy and enhance clarity in our designs. By using `extends`, method overriding, constructors, and the `super` keyword, we gain powerful tools to model complex relationships.

At the same time, Java carefully avoids dangerous designs like multiple class inheritance and instead offers interfaces as a clean alternative. When used thoughtfully, inheritance becomes a strong foundation—just like a well-designed blueprint that supports future growth without collapsing under complexity.

In short, **inheritance is not just about reusing code—it is about designing better software**.