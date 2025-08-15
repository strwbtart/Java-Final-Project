// Okay, so this first file is for our "Operation" class.
// It's not a normal class; it's an "abstract" class. Think of it like a blank form or a blueprint.
// We can't actually make an object from this class itself.
// But it's super useful because it tells all the other math classes what they MUST do.

public abstract class Operation {
    // This is an "abstract" method. It's like a to-do item for all the other classes.
    // It says, "Any class that uses this blueprint must have a method called 'perform'
    // that takes two numbers and does something with them."
    // We don't write the code for it here; we just declare that it has to exist.
    public abstract double perform(double num1, double num2);
}
