import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * CalculatorView.java — Sprint 4 Starter
 *
 * REMEMBER from Pong:
 *   Your Paddles and Ball classes knew how to draw themselves.
 *   They didn't know anything about scoring or game logic.
 *
 *   CalculatorView does the same thing.
 *   It builds the window, buttons, and display.
 *   It does NOT do any math. It just shows what it is told.
 *
 * YOUR GOAL THIS SPRINT:
 *   Move all the UI code from Calculator.java into this class.
 *   Add a setDisplay() method so the Controller can update the screen.
 *   Add an addButtonListener() method so the Controller can
 *   listen for button clicks.
 *
 * ✔ SELF-CHECK:
 *   Does CalculatorView only contain UI code?
 *   Does it have NO math, NO operators, NO firstOperand?
 *   Can you describe what each method does in one sentence?
 */
public class CalculatorView extends JFrame {

    // ── Step 1: Declare your UI fields ───────────────────────────────────────
    // TODO: declare display (JTextField) and buttons (JButton[])
    private JTextField display;
    private JButton[] buttons = new JButton[20];



    private static final String[] BUTTON_LABELS = {
        "C",   "⌫",  "%",  "/",
        "7",   "8",  "9",  "*",
        "4",   "5",  "6",  "-",
        "1",   "2",  "3",  "+",
        "+/-", "0",  ".",  "="
    };

    // ── Constructor ───────────────────────────────────────────────────────────

    public CalculatorView() {
        // ── Step 2: Build the window ──────────────────────────────────────────
        // TODO: move all your window setup code here from Calculator.java
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("SansSerif", Font.BOLD, 28));
        display.setBackground(new Color(30, 30, 30));
        display.setForeground(Color.WHITE);
        display.setPreferredSize(new Dimension(300, 70));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(new Color(45, 45, 45));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String label : BUTTON_LABELS) {
            JButton btn = createButton(label);
            buttonPanel.add(btn);
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // (title, close operation, resizable, display, buttonPanel, layout)
        // IMPORTANT: do NOT call addActionListener here —
        //            the Controller will do that in addButtonListener()


    }

    // ────────────────────────────────────────────────────────────────────────
    //  PUBLIC API — these are the only ways the Controller talks to the View
    // ────────────────────────────────────────────────────────────────────────

    /**
     * setDisplay — updates the text shown on the calculator screen
     *
     * The Controller calls this after every button press.
     * THINK ABOUT IT: one line — display.setText(text)
     */
    public void setDisplay(String text) {
        // TODO: your code here
        display.setText(text);

    }


    /**
     * addButtonListener — registers the Controller as the click listener
     *
     * THINK ABOUT IT:
     *   Loop through all buttons and call btn.addActionListener(listener)
     *   The Controller passes itself as the listener.
     */
    public void addButtonListener(ActionListener listener) {
        // TODO: your code here
        for (JButton btn : buttons) {
            btn.addActionListener(listener);
        }

    }

    /**
     * show — makes the window visible
     * Called by the Controller when everything is ready.
     */
    public void show() {
        setVisible(true);
    }

    // ────────────────────────────────────────────────────────────────────────
    //  PRIVATE HELPER
    // ────────────────────────────────────────────────────────────────────────

    /**
     * createButton — builds and styles one button
     * TODO: move your createButton code here from Calculator.java
     */
    private JButton createButton(String label) {
        // TODO: your code here

        return new JButton(label); // placeholder — replace this
    }
}
