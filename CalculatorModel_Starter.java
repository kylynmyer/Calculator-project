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

    }

    /**
     * setOperator — stores the operator and first operand
     */
    public void setOperator(String operator) {
        // TODO: your code here

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

    }

    /**
     * clear — resets everything
     */
    public void clear() {
        // TODO: your code here

    }

    /**
     * backspace — removes last character
     */
    public void backspace() {
        // TODO: your code here

    }

    /**
     * toggleSign — flips positive/negative
     */
    public void toggleSign() {
        // TODO: your code here

    }

    /**
     * applyPercent — divides by 100
     */
    public void applyPercent() {
        // TODO: your code here

    }

    /**
     * appendDecimal — adds decimal point
     */
    public void appendDecimal() {
        // TODO: your code here

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

        return "0"; // placeholder — replace this
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
