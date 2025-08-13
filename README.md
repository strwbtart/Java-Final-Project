# Simple Calculator

This is a basic calculator program in Java. It was developed as a final project to demonstrate basic programming logic and the application of Object-Oriented Programming (OOP) principles. The calculator possesses the ability of carrying out basic mathematical calculations and has a basic, user-friendly interface.

-----

## Features ✨

  * **Basic Arithmetic:** Perform addition, subtraction, multiplication, and division.
  * **User-Friendly Interface:** A clear display for input and results with intuitive button controls.
  * **OOP Design:** Built using key OOP concepts for a robust and maintainable structure.

-----

## Tech Stack 🛠️

  **Language:** Java
  **IDE:** Developed using Visual Studio Code (but can be run with any Java-supported IDE like Eclipse or IntelliJ IDEA)
  **GUI Framework:** Java Swing (for the graphical user interface)

-----

## Object-Oriented Programming (OOP) Concepts Applied 🧠

This project was designed to specifically showcase an understanding of OOP. 
You must use at least four of these concepts in your application.

  **Classes and Objects**: The application is structured around classes like `Calculator` (to handle the main logic and state) and `Operation` (to represent mathematical actions). Objects of these classes are instantiated to run the application.

  **Encapsulation**: The internal state of the `Calculator` class (like the current display value or pending operation) is kept private. Access to this state is controlled through public methods, preventing direct, uncontrolled modification from outside the class.

  **Abstraction**: An abstract `Operation` class was created to serve as a blueprint. It defines a method signature, like `perform(a, b)`, that all specific operation classes must implement, abstracting the concept of a mathematical operation.

  **Inheritance**: Concrete classes such as `Addition`, `Subtraction`, `Multiplication`, and `Division` inherit from the abstract `Operation` class. This allows them to share a common type while providing their own unique implementation of the `perform` method.

  **Polymorphism**: The `Calculator` can use a single method to execute any operation. This method accepts an object of the `Operation` parent class. When the method is called, Java's runtime polymorphism ensures the correct `perform` method of the subclass (e.g., `Addition` or `Multiplication`) is executed.

-----

## Getting Started 🚀

To get a local copy up and running, follow these simple steps.

### Prerequisites

Make sure you have the Java Development Kit (JDK) installed on your machine.

### Installation & Running

1.  **Clone the repository:**
    
    git clone https://github.com/strwbtart/Java-Final-Project.git
    
2.  **Navigate to the project directory:**
    
    cd simple-calculator
    
3.  **Compile the Java files:**
    
    javac *.java
    
4.  **Run the application:**
    
    java Main
    

-----

## Usage 📋

1.  Launch the application to see the calculator interface.
2.  Click the number buttons to input your first number.
3.  Click an operator button (+, -, \*, /).
4.  Click the number buttons to input your second number.
5.  Click the '=' button to see the result displayed.
6.  Click the 'C' button to clear the current calculation and start a new one.

-----


## Author ✍️

  * **Group Members:** Emma Pacheco & Carolina Cantu-Garcia