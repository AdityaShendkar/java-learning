
# **Method Overriding in Java**


## **I. Introduction to Method Overriding**

Method Overriding is one of the most important mechanisms in Java and a **key pillar for achieving runtime polymorphism**. In simple terms, method overriding allows a **child class to provide its own implementation** of a method that is already defined in its parent class.

Think of method overriding as a polite disagreement between a parent and a child. The parent says, “This is how the method works,” and the child replies, “That’s fine, but I want to do it my way.” Java respects this choice and, at runtime, executes the child’s version of the method—provided the object belongs to the child class.

What makes method overriding truly powerful is that the **decision of which method to execute is made by the JVM at runtime**, based on the **actual object type**, not the reference type. This dynamic behavior is the heart of runtime polymorphism and is heavily used in real-world Java applications, frameworks, and APIs.

If polymorphism is the idea of “many forms,” then method overriding is the practical tool that brings this idea to life in Java.

---

## **II. Understanding Runtime Polymorphism Through Overriding**

To fully appreciate method overriding, we must clearly understand how **runtime polymorphism** works. In Java, when a parent class reference points to a child class object, the JVM determines which method implementation to call during program execution.

Let us consider a real-world analogy. Imagine a universal remote control. The same “power” button exists, but what actually happens depends on whether the remote is controlling a TV, an AC, or a music system. The button press is the same, but the behavior differs based on the actual device. This is exactly how method overriding works.

In Java terms:

* The **method call** is decided using the reference type.
* The **method execution** is decided using the object type.

This separation gives Java its dynamic nature. It allows developers to write **generic, extensible code** that adapts automatically when new subclasses are introduced.

Without method overriding, Java would lose much of its flexibility, and object-oriented design would feel rigid and repetitive.

---

## **III. Rules of Method Overriding in Java**

Java follows strict rules to ensure method overriding works correctly and predictably. These rules are not arbitrary; they exist to maintain consistency and avoid ambiguity in runtime behavior.

First, the **method name must be exactly the same** in both the parent and child classes. Even a small spelling difference means Java will treat it as a new method, not an overridden one.

Second, the method must exist in **two different classes**, and those classes must follow an **IS-A relationship**. In other words, method overriding requires **inheritance**. A class cannot override its own method.

Third, the **parameter list must be identical**, including:

* The number of parameters
* The data types of parameters
* The order of parameters

If any of these change, the method becomes overloaded instead of overridden.

Fourth, the **return type must be the same or covariant** (a subclass type of the original return type). This ensures type safety during runtime execution.

Finally, the overriding method must not reduce the **visibility (access level)** of the parent method. Java enforces this rule to ensure that a method accessible through a parent reference remains accessible when overridden.

These rules act like a contract between the parent and child classes, guaranteeing reliable runtime behavior.

---

## **IV. Example of Method Overriding (Bank Interest Rate)**

Let us now examine a classic and practical example that clearly demonstrates method overriding in Java.

```java
class Bank
{
    double getInterestRate()
    {
        return 0.0;
    }
}

class SBI extends Bank
{
    @Override
    double getInterestRate()
    {
        return 6.5;
    }
}

class HDFC extends Bank
{
    @Override
    double getInterestRate()
    {
        return 7.0;
    }
}

class ICICI extends Bank
{
    @Override
    double getInterestRate()
    {
        return 6.8;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Bank b1 = new SBI();
        Bank b2 = new HDFC();
        Bank b3 = new ICICI();

        System.out.println("SBI Interest Rate: " + b1.getInterestRate() + "%");
        System.out.println("HDFC Interest Rate: " + b2.getInterestRate() + "%");
        System.out.println("ICICI Interest Rate: " + b3.getInterestRate() + "%");
    }
}
```

### **Output**

```
SBI Interest Rate: 6.5%
HDFC Interest Rate: 7.0%
ICICI Interest Rate: 6.8%
```

In this example, `Bank` acts as the parent class with a default implementation. Each bank—SBI, HDFC, and ICICI—provides its own version of the `getInterestRate()` method.

Even though all objects are referenced using the `Bank` type, the JVM calls the appropriate method based on the **actual object**. This is runtime polymorphism in its purest form.

This design makes the code clean, extensible, and realistic—just like how real banks operate with different interest rates.

---

## **V. Advantages of Method Overriding**

Method overriding offers several practical benefits that make Java applications more powerful and maintainable.

The most significant advantage is **runtime polymorphism**. Java can decide at runtime which method to execute, allowing dynamic and flexible behavior. This is essential for building systems that adapt to changing requirements.

Method overriding also **improves code reusability**. We reuse method names from the parent class while customizing behavior in child classes. This reduces duplication and keeps the codebase clean.

Another major benefit is that it **strengthens inheritance**. Subclasses can enhance or modify parent behavior instead of rewriting entire logic. This promotes better object-oriented design.

From a readability standpoint, overridden methods make code **logical and organized**. Each class handles its own behavior while following a common structure, making the system easier to understand and maintain.

Method overriding also **encourages consistency**. Keeping method names the same across a class hierarchy ensures predictable behavior and a uniform API design.

Finally, method overriding is **widely used in frameworks and libraries** like Spring and Hibernate. These frameworks define default behavior in parent classes and allow developers to override methods to customize functionality.

---

## **VI. Important Points to Remember**

There are several critical points every Java developer must remember about method overriding.

Method overriding requires the **same method signature**, including name, return type, and parameter list. Any mismatch breaks overriding.

The overriding method must exist in a **subclass**, not in the same class.

The **access modifier** of the overriding method cannot be more restrictive than the overridden method. For example, a `public` method in the parent cannot be overridden as `private` in the child.

```java
// Valid override
protected void display() {}

// Invalid override if superclass method is public
private void display() {}
```

Certain methods **cannot be overridden**, including:

* Static methods
* Constructors
* The `main` method
* Methods marked as `final`, `private`, or `static`

The overriding method can throw **only the same or narrower checked exceptions** than the parent method.

Using the **@Override annotation** is highly recommended. It helps catch errors at compile time and improves code readability.

```java
@Override
void methodName() {
    // implementation
}
```

All these rules ensure that method overriding remains safe, predictable, and effective.

---

## **Conclusion**

Method overriding is a cornerstone of Java’s object-oriented power. It transforms inheritance from a static relationship into a dynamic, runtime-driven mechanism. By allowing child classes to redefine parent behavior, Java enables flexible, scalable, and real-world modeling of software systems.

Through method overriding, we achieve runtime polymorphism, improve reusability, enhance maintainability, and build applications that are open to extension but closed to modification. Whether we are designing simple programs or enterprise-level frameworks, method overriding remains an indispensable tool in our Java toolkit.

In essence, method overriding teaches us a powerful lesson: **behavior matters more than structure**, and Java gives us the freedom to decide that behavior at runtime.
