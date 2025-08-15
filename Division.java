// Last one for our math operations! This is for division.
// It also uses the Operation blueprint, but has a little extra smarts built in.

public class Division extends Operation {
    // This is our "perform" method for division.
    @Override
    public double perform(double num1, double num2) {
        // Here's the special part: we're checking if the second number is zero.
        // You can't divide by zero, so we want to stop that from happening and not break our app.
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero.");
            // We'll return a special value called "Double.NaN" which stands for "Not a Number".
            // It's a way to signal that something went wrong with the math.
            return Double.NaN; 
        }
        return num1 / num2;
    }
}
