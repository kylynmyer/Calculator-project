/**
 * CalculatorModel.java — Sprint 4 Starter
 *
 * REMEMBER from Pong:
 *   Your PongGame class held the game logic — score, ball speed,
 *   collision detection. Nobody else touched that logic directly.
 *
 *   CalculatorModel does the same thing for the calculator.
 *   It holds all the math and state. No buttons. No display. Just logic.
 *
 * YOUR GOAL THIS SPRINT:
 *   Move all the math and state from Calculator.java into this class.
 *   The View will ask the Model what to display.
 *   The Controller will tell the Model what the user did.
 *
 * ✔ SELF-CHECK:
 *   Does CalculatorModel.java compile with NO Swing or AWT imports?
 *   If you see "import javax.swing" — something is wrong.
 */
public class CalculatorModel {

    // ── Step 1: Move your state fields here ──────────────────────────────────
    // These were in Calculator.java — move them here instead.
    // TODO: declare firstOperand (double), currentOperator (String),
    //       startNewNumber (boolean), and displayValue (String)
    private double firstOperand = 0;
    private String currentOperator = "";
    private boolean startNewNumber = true;
    private String displayValue = "0";


    // ────────────────────────────────────────────────────────────────────────
    //  INPUT METHODS
    // ────────────────────────────────────────────────────────────────────────

    /**
     * appendDigit — adds a digit to the display value
     *
     * THINK ABOUT IT:
     *   Same logic as before, but instead of calling display.setText()
     *   you update the displayValue field.
     *   The Controller will read displayValue and pass it to the View.
     */
    public void appendDigit(String digit) {
        // TODO: your code here
        if (startNewNumber) {
            displayValue = digit;
            startNewNumber = false;
        } else {
            displayValue = displayValue.equals("0") ? digit : displayValue + digit;
        }

    }
    

    /**
     * setOperator — stores the operator and first operand
     */
    public void setOperator(String operator) {
        // TODO: your code here
        firstOperand = parseDisplay();
        currentOperator = operator;
        startNewNumber = true;

    }

    /**
     * computeResult — does the math
     *
     * THINK ABOUT IT:
     *   Same logic as before, but store the result in displayValue
     *   instead of calling display.setText()
     */
    public void computeResult() {
        // TODO: your code here
        if (currentOperator.isEmpty()) {
            return; // No operator set, nothing to compute
        }
        double secondOperand = parseDisplay();
        double result = 0;
        switch (currentOperator) {
            case "+" -> result = firstOperand + secondOperand;
            case "-" -> result = firstOperand - secondOperand;
            case "*" -> result = firstOperand * secondOperand;
            case "/" -> {
                if (secondOperand == 0) {
                    displayValue = "Error";
                    currentOperator = "";
                    startNewNumber = true;
                    return;
                }
                result = firstOperand / secondOperand;
            }
        }
        displayValue = formatResult(result);
        currentOperator = "";
        startNewNumber = true;


    }

    /**
     * clear — resets everything
     */
    public void clear() {
        // TODO: your code here
        displayValue = "0";
        firstOperand = 0;
        currentOperator = "";
        startNewNumber = true;

    }

    /**
     * backspace — removes last character
     */
    public void backspace() {
        // TODO: your code here
        if (displayValue.length() > 1) {
            displayValue = displayValue.substring(0, displayValue.length() - 1);
        } else if (displayValue.length() == 1) {
            displayValue = "0";
        }

    }

    /**
     * toggleSign — flips positive/negative
     */
    public void toggleSign() {
        // TODO: your code here
        double currentValue = parseDisplay();
        currentValue *= -1;
        displayValue = formatResult(currentValue);

    }

    /**
     * applyPercent — divides by 100
     */
    public void applyPercent() {
        // TODO: your code here
        double currentValue = parseDisplay();
        currentValue /= 100;
        displayValue = formatResult(currentValue);

    }

    /**
     * appendDecimal — adds decimal point
     */
    public void appendDecimal() {
        // TODO: your code here
        if (startNewNumber) {
            displayValue = "0.";
            startNewNumber = false;
        } else if (!displayValue.contains(".")) {
            displayValue = displayValue + ".";
        }

    }

    // ────────────────────────────────────────────────────────────────────────
    //  ACCESSOR — the Controller reads this to update the View
    // ────────────────────────────────────────────────────────────────────────

    /**
     * getDisplayValue — returns what should be shown on screen
     *
     * The Controller calls this after every action, then passes
     * the result to the View. This is how Model talks to View
     * WITHOUT knowing the View exists.
     */
    public String getDisplayValue() {
        // TODO: return displayValue
        return displayValue; // placeholder — replace this
    }

    // ────────────────────────────────────────────────────────────────────────
    //  HELPERS — provided for you, do not modify
    // ────────────────────────────────────────────────────────────────────────

    private double parseDisplay() {
        try   { return Double.parseDouble(displayValue); }
        catch (NumberFormatException e) { return 0; }
    }

    private String formatResult(double value) {
        if (value == Math.floor(value) && !Double.isInfinite(value))
            return String.valueOf((long) value);
        return String.valueOf(value);
    }
}
