// And again, for multiplication.
// We're filling in the "perform" method from the Operation blueprint.

public class Multiplication extends Operation {
    // This method multiplies the two numbers. Easy!
    @Override
    public double perform(double num1, double num2) {
        return num1 * num2;
    }
}
