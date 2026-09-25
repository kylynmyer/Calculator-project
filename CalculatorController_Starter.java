import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CalculatorController.java — Sprint 4 Starter
 *
 * REMEMBER from Pong:
 *   Your Main class created PongGame, Ball, and Paddles,
 *   and connected them together.
 *
 *   CalculatorController does the same thing.
 *   It creates the Model and the View, connects them,
 *   and listens for button clicks.
 *
 * YOUR GOAL THIS SPRINT:
 *   - Create a Model and a View in the constructor
 *   - Register this Controller as the button listener
 *   - In actionPerformed(), call the right Model method
 *   - After every action, ask the Model for the display value
 *     and pass it to the View
 *
 * ✔ SELF-CHECK:
 *   Does CalculatorController have NO Swing/AWT components?
 *   (No JButton, no JTextField — just logic)
 *   Does actionPerformed() end with view.setDisplay(model.getDisplayValue())?
 *   Does your calculator still work exactly like it did in Sprint 3?
 */
public class CalculatorController implements ActionListener {

    // ── Step 1: Declare your Model and View fields ───────────────────────────
    // TODO: declare model (CalculatorModel) and view (CalculatorView)



    // ── Constructor ───────────────────────────────────────────────────────────

    public CalculatorController() {
        // ── Step 2: Create the Model and View ────────────────────────────────
        // TODO: create a new CalculatorModel
        // TODO: create a new CalculatorView

        // ── Step 3: Wire them together ────────────────────────────────────────
        // TODO: call view.addButtonListener(this)
        //       "this" means this Controller is the listener
        // TODO: call view.show() to make the window appear

    }

    // ────────────────────────────────────────────────────────────────────────
    //  actionPerformed — called when any button is clicked
    // ────────────────────────────────────────────────────────────────────────

    /**
     * THINK ABOUT IT:
     *   This is the same switch you wrote in Calculator.java —
     *   but now instead of calling local methods like clearAll(),
     *   you call model.clear(), model.computeResult(), etc.
     *
     *   After EVERY case, add this line:
     *       view.setDisplay(model.getDisplayValue());
     *
     *   That's how the screen updates — Controller asks Model
     *   for the value, then tells View to show it.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // TODO: write your switch statement here
        // Route each button to the right model method
        // Remember to call view.setDisplay(model.getDisplayValue())
        // at the end

    }

    // ────────────────────────────────────────────────────────────────────────
    //  MAIN — entry point, do not modify
    // ────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(CalculatorController::new);
    }
}
