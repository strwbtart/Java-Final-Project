// Extends Operation for division. Includes a check to prevent division by zero.
//----------------------------------------------
public class Division extends Operation {
    // Our 'perform' method for division.
    @Override
    public double perform(double num1, double num2) {
        // Here we handle a potential error: division by zero.
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN; // 'NaN' stands for Not a Number. It's a special value to show an error.
        }
        return num1 / num2;
    }
}