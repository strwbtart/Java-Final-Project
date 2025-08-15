// Same thing here, but for subtraction.
// We're extending the Operation blueprint and making our own version of the "perform" method.

public class Subtraction extends Operation {
    // This method does what it says: it subtracts the second number from the first.
    @Override
    public double perform(double num1, double num2) {
        return num1 - num2;
    }
}
