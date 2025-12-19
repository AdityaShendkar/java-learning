-   A  **class**  is a template or blueprint used to categorize objects. For example, we can have classes like  **Animal, Birds, Vehicles and Furniture**. Each class can have multiple  **objects**, which represent real-world entities.
    -   The  **Animal**  class can have objects such as  **elephant, tiger, dog**  etc.
    -   The  **Birds**  class can have objects like  **sparrow, peacock**  etc.
    -   Similarly, other classes will have their respective objects.
-   Every class has its own  **methods**, which define the actions that objects can perform:
    -   The  **Animal**  class may have methods like  **eat(), run(), sleep()**  etc.
    -   The Birds class may have methods like  **fly(), eat()**  etc.
-   Since  **objects represent real-world entities**, they are used to  **call methods**  and perform actions.

## What is Class in Java ?

-   Class is a blueprint or prototype or template for creating objects in Java.
-   It is not a real-world entity, means it does not exist physically; it only defines how an object should behave.
-   Class does not occupy memory (but objects occupies memory).
-   **NOTE :**  Class metadata (such as the number of variables, variable names, method names, constructors, etc.) is stored in the Method Area.
- Syntax :
```java
access-modifiers class ClassName
{
	Fields (Instance Variables) – Store object data.
    Constructors – Initialize objects.
    Methods – Define object behavior.
    Static Members – Shared among all objects.
    Nested Classes – Class inside another class.
    Blocks – Static and instance blocks for initialization.
```
- Example :
```java
public class Animal
{
    //fields
	int eyes;
    String color;
    
    //method
    void run()
    {
        //body
    }
}
```

##### What is Method in Java ?

-   A method in Java is a block of code that performs a specific task and can be reused multiple times.

-   Syntax :
    
    ```java
    access-modifiers return-type methodName(List of Parameters)
    {
    	// body
    }
    ```
    
-   Example :
    
    ```java
    public void run(String name)
    {
        System.out.println(name+" is running");
    }
    ```
    
-   We can write computations, data processing, input/output operations, object manipulation, conditional logic etc inside methods to perform specific tasks efficiently.

## What is Object in Java ?

-   **Object is an instance of a class**  - Objects are created from a class blueprint and represent real data.
-   **Object is a real-world entity**  - It represents tangible things like a car, person, or book in programming.
-   **Object occupies memory**  - When an object is created (new ClassName()), it gets memory allocated in the heap.

-   Objects has its own :
    -   **Identity**  - Unique memory reference assigned by JVM
    -   **State / Attribute**  - Data stored in instance variables
    -   **Behaviour**  - Actions (methods)

-   Syntax :
    -   1. Creating Objects:
        -   ```java
            ClassName objectName = new ClassName();
            ```
            
            -   `ClassName objectName;`  — Declares a reference variable  `objectName`  of type  `ClassName`.
            -   `new ClassName();`  — Creates a new object of  `ClassName`  by allocating memory and calling its constructor.
            -   `=`  — Assigns the reference (address) of the newly created object to the variable  `objectName`.
            -   So overall:  `objectName`  now holds a reference to a new  `ClassName`  object in memory.
    -   2. Access Methods using Objects:
        -   ```java
            objectName.methodName();
            ```
            
    -   3. Access Fields/Variables using Objects
        -   ```java
            objectName.field_name;
            ```
            
-   Example :
    
    ```java
    public class Animal
    {
        String color;   //instance variable
        
        void run()  //method
        {
            System.out.println("Im running");
        }
        public static void main(String[] args)
        {
            Animal buzo = new Animal();     //creating object (buzo)
            buzo.run();                     //accessing run() method from buzo object
            buzo.color = "Black";           //setting value in instance variable using . operator
    
            System.out.println("Buzo color is "+buzo.color);    //accessing instance variable
        }
    }
    ```