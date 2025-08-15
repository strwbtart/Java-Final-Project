// This is the main class for our calculator. It handles the user interface
// and all the application's logic. It uses the other classes we created.
// This class demonstrates Encapsulation and Polymorphism.
//----------------------------------------------
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // These are private fields. They can only be accessed from within this class.
    // This is Encapsulation: it protects the internal state of our calculator.
    private JFrame frame;
    private JTextField display;
    private double currentNumber;
    private String currentOperator;
    private boolean startOfNewNumber;

    // This is the constructor. It runs when we create a new Calculator object.
    // It sets up our entire user interface.
    public Calculator() {
        // Create the main window for the calculator
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);

        // Create the text field for the display
        display = new JTextField("0");
        display.setBounds(10, 10, 265, 50);
        display.setEditable(false);
        frame.add(display);

        // Initialize our calculator's state
        currentNumber = 0;
        currentOperator = "=";
        startOfNewNumber = true;

        // This is where we create the buttons and add them to the window.
        // We will create them in a grid-like pattern.
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        int x = 10;
        int y = 70;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBounds(x, y, 60, 60);
            frame.add(button);

            // Add an "ActionListener" to each button.
            // This is how our program knows when a button is clicked.
            button.addActionListener(new ButtonClickListener());

            // Move to the next position for the next button
            x += 70;
            if (x > 220) {
                x = 10;
                y += 70;
            }
        }

        // Make the window visible
        frame.setVisible(true);
    }

    // This is an inner class that handles all button clicks.
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the text from the button that was clicked
            String command = e.getActionCommand();

            // Check if the clicked button is a number
            if (command.matches("[0-9]")) {
                handleNumber(command);
            }
            // Check if it's the "C" (Clear) button
            else if (command.equals("C")) {
                handleClear();
            }
            // Otherwise, it must be an operator
            else {
                handleOperator(command);
            }
        }
    }

    // Method to handle when a number button is pressed
    private void handleNumber(String number) {
        if (startOfNewNumber) {
            // If it's a new number, replace the display with this number
            display.setText(number);
            startOfNewNumber = false;
        } else {
            // Otherwise, add the number to the end of the display
            display.setText(display.getText() + number);
        }
    }

    // Method to handle when the clear button is pressed
    private void handleClear() {
        display.setText("0");
        currentNumber = 0;
        currentOperator = "=";
        startOfNewNumber = true;
    }

    // Method to handle when an operator button is pressed
    private void handleOperator(String operator) {
        // Get the number currently in the display
        double displayNumber = Double.parseDouble(display.getText());

        // This is where Polymorphism happens!
        // We create an Operation object based on the 'currentOperator'
        // and call its 'perform' method.
        Operation op = getOperation(currentOperator);
        // The 'perform' method will call the correct function (addition, subtraction, etc.)
        currentNumber = op.perform(currentNumber, displayNumber);
        
        // Update the display with the new result
        display.setText(String.valueOf(currentNumber));

        // Set the new operator
        currentOperator = operator;
        startOfNewNumber = true;
    }
    
    // This helper method returns the correct operation object based on the operator string.
    // It's another great example of Polymorphism in action.
    private Operation getOperation(String operator) {
        // This 'switch' statement checks the operator string and
        // returns the correct class object.
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            // The default case handles the first number entered or the equals button.
            default:
                // We're returning a simple operation that just returns the second number.
                // This is a neat trick to handle the first number correctly.
                return new Operation() {
                    @Override
                    public double perform(double num1, double num2) {
                        return num2;
                    }
                };
        }
    }
    
    // The main method is the starting point of our program.
    // It simply creates a new Calculator object to run the app.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
