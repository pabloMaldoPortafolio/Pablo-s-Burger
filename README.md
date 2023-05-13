# Object-Oriented Programming Basics

<h1>Pablo’s Burger Description and Demo</h1>

This is a tutorial about the basics of Object Oriented Programming using Java.
Before we start learning about Object Oriented Programming, let’s check what does the Pablo’s Burger code Does. 

<p>Project Description: We want to create an application for our fast food restaurant. Every meal order will have 3 items, a hamburger, a drink and a side item. This application let us select the type of burger and add as many toppings as we want and give us the total price of a burger with the price. We can also set the size of the drink and adjust the price. This is a simple application that let us explore properties of Object-Oriented Programming.</p>

Schema used in this project:

<p>
<img src="https://i.imgur.com/Kg5eH9w.png" height="80%" width="80%" alt="Disk Sanitization Steps"/>
</p>

Sample Outputs: 


This is the output with base burger with no toppings, and without changing the drink size. This use the default constructor.
<p>
<img src="https://i.imgur.com/mbdMl9Q.png" height="80%" width="80%" alt="Disk Sanitization Steps"/>
</p>

This output is by adding some toppings and setting the drink to small. This use the contructor with specific parameters, and it also uses addBurgerToppings(..) method to add toppings.
<p>
<img src="https://i.imgur.com/9Cd3qvB.png" height="80%" width="80%" alt="Disk Sanitization Steps"/>
</p>



Now let’s study some OOP concepts used in this project. 

<h2>Introduction to Object-Oriented Programming Using Java: </h2>

Object-Oriented Programming (OOP) is all about creating “objects”. An object can represent any concept in the real world. This objects are made by their properties (variables) and behaviors (methods). OOP simplifies software development and maintenance by creating well organized objects. Please note that for many concepts we will use Pablo’s Burger project as example for concepts. Below, we will study some basic concepts used by OOP languajes.

**Objects:**

As said before, an object represent any entity in the real world and it’s made by state and behavior. An Object can be defined as an instance of a class. An object contains an address and take some space in memory. In java we need to instantiate an object in order to be used. Instantiate a class means creating an Object that can be used of a given class, this will allocate memory for the object. So if we have a class name MealOrder (as seen in project Pablo’s Burger), to instantiate that class we need to use “new”:

```java
MealOrder instanceName = new MealOrder();
```

**Class:**

A Class is a template used to create objects and to define object data types and methods. First we create a class, then we can instantiate that class to create an Object which has allocated memory. We can create many Objects based on one class, and all of them will share the same methods and variables. One type of method used in classes is a constructor, a Constructors are used to create and initialize new objects in a class. Every class must have a constructor, either a default one provided by the Java compiler or a new one written for that class. A method is defined as a constructor when it has the same name as the class, we can have more than one constructor if we want. An example of a constructor is: 

```java
//This is a constructor which will set the variables when the object is instantiated 
public Item(String type,String name, double price){
    this.type = type;
    this.name = name;
    this.price = price;
}// note that the name of the class is Item, so the constructor is also call Item
```

**Inheritance** 

Inheritance allow us to create a new class (child) based in another class (parents class) , this new class will have all the variables and methods from the class that inherited from. This provides us with code reusability, meaning that if many classes share some similarities, we can create a parent class with all this similarities, so then we don’t need to define them in each class. For example, we have an Animal class that has some generic definitions of animals, then we can create other more specific classes like Dog or Cat that can inherit every variable and method from Animal class. 

To make child class inherate every method and variable from parent class we need to use “extends” in the class name. After doing this declaration, we can say that child class “IS-A” parent class. So using Pablo’s burger project, we have: 

```java
public class Burger extends Item{ … }
```

Here we can say that Burger “IS A” Item. Now the class Burger will have all the methods and variables that Item has. Every class can only extend one class, and by default, every class extends a class name Object. 

**Polymorphism**

Polymorphism is the ability of an object to take different forms. This means that a class can provide different implementations of a method depending on the type of object that is passed. If we recall from inheritance, a child class IS-A parent class, this means that a child class can be itself or can also be its parent class. 

This will be more clear with an example. Let’s say that we have: public class Dog extends Animal. 

```java
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Pug", "Brian");
        printName(dog);
    }
    public static void printName(Animal animal){
        System.out.println("Hi! My name is: " + animal.getName());
    }
} //output of this code is: “Hi! My name is Brian
```

In the method “printName” we can see that the parameter asked by the method is an Animal, in this case we passed a Dog object but the code still works, this is thanks to polymorphism. Because Dog “IS-A” Animal, we can use Dog as if it were the animal object and the compiler will notice that Dog IS-A Animal, that is why this code can run with no problem. This is very helpful because now we can have any Class that extend animal use this “printName” method and it will work with any child class of Animal.


**Abstraction** 

Abstraction is the process of hiding implementation details and showing only functionality to the user. There are 2 ways to achive abstraction, one is by using interfaces, and the other one is by using abstract classes which will we cover in this section.

Abstract classes in java are created by using the key work “abstract” in the class declaration. Abstract classes create a template that can have implemented methods and variables. It is important to know that you can NOT create an instance of an abstract class. 

An abstract class can have abstract and non-abstract methods. Non-abstract methods are regular methods that can be used by their children. Abstract methods are methods that will not have code inside but they MUST be implemented by every child. Let’s see the example of the following Animal abstract class. 

```java
public abstract class Animal {
    String name;
    public Animal(String name){
        this.name = name;
    }
    public abstract void makeNoise();
    public abstract int numberOfLegs();
    public String getName(){
        return name;
    }
    public void printName(){
        System.out.println("Hello! my name is" + name);
    }
}
```
In the abstract class above, we can see that the abstract class has abstract and non-abstract methods. The non-abstract method can be use by any child as is. However, the abstract methods MUST be implemented by child classes, in fact we would see a compile error if we extend the Animal class but do not implement makeNoise() and numberOfLegs(). Abstract classes are useful because it give us implementations that are use by every animal, and it also obligate us to implements the methods that are specific to each animal child but may be different for each, like in this example each animal makes a different noise, so it makes sense to make this method abstract.


**Interfaces**

Another way to achieve abstraction in Java is by using Interfaces. Like abstract classes, you can not create an instance of an Interface. In Java, we can only extend one class, but we can implement many interfaces. To implement an interface we use the word “implements” instead of extends. Interfaces are created with the keyword “Interface” as seen bellow.

```java
public interface  Animal {


    public void makeNoise();
    public int numberOfLegs();
    public String getName();
    public void printName();
}
```
Interfaces do not have class variables or implemented methods. Notice that we also can not create a constructor for an interface. We can only create a template that must be implemented by their child and this is very useful to force child classes to have a behavior that we want.  

**Encapsulation** 

Encapsulation in Java is wrapping code and data into a single known unit. This will protect a field to be accessible only by member of the same class. In simple words, if we declare local variables as public, then any instance of that class will have direct access over that variables and that can be very problematic. To solve that, we can create private variables that are only access by the class itself, then we can create setters and getters to access or changing them. 

```java
public class  Animal {
    private String name;
    private int legs;

    //getters
    public String getName() {
        return name;
    }
    public int getLegs() {
        return legs;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLegs(int legs) {
        this.legs = legs;
    }
}
```

As seen in the class above, every field of the class is private and can only be access by the class Animal. Then if we need to get or change the variable, we can make setters and getters as seen above. This gives us control over the variables and it encapsulates the class as a whole rather than being able to access specific fields. Encapsulation gives us better control, security and flexibility over a class. 

<br />

