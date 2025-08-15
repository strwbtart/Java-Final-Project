// This is the most important file! It's the "brain" of our app.
// It creates the window, the buttons, the display, and handles all the logic.
// This is where we see Encapsulation and Polymorphism in action.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // These are our "private" variables.
    // They can ONLY be used inside this Calculator class.
    // This is Encapsulation! It protects our data from being changed by accident.
    private JFrame frame; // The main window of our app.
    private JTextField display; // The screen that shows numbers.
    private double currentNumber; // The number we're currently working with.
    private String currentOperator; // The math symbol we're using (+, -, etc.).
    private boolean startOfNewNumber; // Tells us if we just started typing a new number.

    // This is the "constructor." It's a special method that runs as soon as we
    // create a new Calculator object. It's where we set everything up.
    public Calculator() {
        // Let's create our window.
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);

        // Now we make the display screen and put it at the top.
        display = new JTextField("0");
        display.setBounds(10, 10, 265, 50);
        display.setEditable(false); // We don't want people typing in the display.
        frame.add(display);

        // We set our starting values.
        currentNumber = 0;
        currentOperator = "="; // We start with the equals sign.
        startOfNewNumber = true; // We're ready to type our first number.

        // This is a list of all the button labels we want to have.
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // We'll loop through our list of buttons to create and place them on the window.
        int x = 10;
        int y = 70;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBounds(x, y, 60, 60);
            frame.add(button);

            // This is how we make our buttons do something!
            // We're telling each button to listen for a click, and when it's clicked,
            // it should use our special `ButtonClickListener` class.
            button.addActionListener(new ButtonClickListener());

            // We change the x and y values to move to the next spot for the next button.
            x += 70;
            if (x > 220) {
                x = 10;
                y += 70;
            }
        }

        // Finally, we tell the window to show up on the screen.
        frame.setVisible(true);
    }

    // This is a special class that sits inside our main Calculator class.
    // Its only job is to handle clicks from any of our buttons.
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the text from the button that was just clicked (like "7" or "+").
            String command = e.getActionCommand();

            // We use an "if-else if-else" to figure out what kind of button it was.
            if (command.matches("[0-9]")) {
                // If it's a number, we call our "handleNumber" method.
                handleNumber(command);
            } else if (command.equals("C")) {
                // If it's "C", we call our "handleClear" method.
                handleClear();
            } else {
                // If it's not a number or "C", it must be an operator, so we
                // call our "handleOperator" method.
                handleOperator(command);
            }
        }
    }

    // This method runs when we click a number button.
    private void handleNumber(String number) {
        if (startOfNewNumber) {
            // If we just cleared or pressed an operator, the display should be replaced.
            display.setText(number);
            startOfNewNumber = false;
        } else {
            // If we're still typing the same number, we just add the new digit to the end.
            display.setText(display.getText() + number);
        }
    }

    // This method runs when we click the "C" button. It resets everything.
    private void handleClear() {
        display.setText("0");
        currentNumber = 0;
        currentOperator = "=";
        startOfNewNumber = true;
    }

    // This method runs when we click an operator button (+, -, etc.).
    private void handleOperator(String operator) {
        // First, we grab the number that's currently on the display.
        double displayNumber = Double.parseDouble(display.getText());

        // This is the cool part, where Polymorphism comes in!
        // We call our special `getOperation` method and give it the last operator we pressed.
        // It's going to give us back the correct Operation object (Addition, Subtraction, etc.).
        Operation op = getOperation(currentOperator);
        
        // Then we use that object to perform the calculation!
        // We don't have to know if it's an Addition or Subtraction object;
        // we just know it has a `perform` method we can use.
        currentNumber = op.perform(currentNumber, displayNumber);
        
        // We update the display with the new result.
        display.setText(String.valueOf(currentNumber));

        // And finally, we get ready for the next operation.
        currentOperator = operator;
        startOfNewNumber = true;
    }
    
    // This is a helper method that does the polymorphic magic.
    // Based on the operator symbol, it gives us back the right Operation object.
    private Operation getOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            // This is the "default" case. It runs if none of the others match.
            // We use this for when the calculator first starts, or after the "=" button is pressed.
            default:
                // This is a special way to make a temporary Operation object on the fly.
                // It's like a dummy operation that just returns the second number,
                // which is exactly what we want when we're entering the first number.
                return new Operation() {
                    @Override
                    public double perform(double num1, double num2) {
                        return num2;
                    }
                };
        }
    }
    
    // This is the very first thing that runs when we start the program.
    public static void main(String[] args) {
        // This is a special command that makes sure our app window is created safely.
        SwingUtilities.invokeLater(Calculator::new);
    }
}
