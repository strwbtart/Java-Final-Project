// This is an abstract class. It's a blueprint for all our math operations.
// We can't create an object directly from this class, but other classes
// can inherit from it. 

public abstract class Operation {
    // This is an abstract method. It doesn't have any code inside it.
    // Any class that "inherits" from Operation MUST provide its own
    // code for this method. This is a key part of Abstraction and Polymorphism.
    public abstract double perform(double num1, double num2);
}