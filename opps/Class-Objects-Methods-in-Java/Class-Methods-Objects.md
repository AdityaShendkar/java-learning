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