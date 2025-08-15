// This is the file for our Addition class.
// See how it "extends" Operation? That means it's using the blueprint from our last file.
// It's like we're filling out the form we just created.

public class Addition extends Operation {
    // This is our code for the "perform" method that we were told to create.
    // We're literally just telling it to add the two numbers together.
    @Override
    public double perform(double num1, double num2) {
        return num1 + num2;
    }
}
