// This class "extends" (or inherits from) the Operation class.
// It provides the specific logic for adding two numbers.
//----------------------------------------------
public class Addition extends Operation {
    // This method is a concrete implementation of the abstract 'perform' method.
    // It's a simple function that adds two numbers together.
    @Override
    public double perform(double num1, double num2) {
        return num1 + num2;
    }
}