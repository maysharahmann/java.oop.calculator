import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    String[] buttonValues = {
        "AC", "+/-", "%", "÷",
        "7", "8", "9", "×",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    public ButtonPanel() {
        setLayout(new GridLayout(5, 4));
        setBackground(CalculatorTheme.BLACK);
    }

    public void createButtons(ActionListener listener) {
        for (int i = 0; i < buttonValues.length; i++) {
            String value = buttonValues[i];
            String type = "normal";

            if (Arrays.asList(topSymbols).contains(value)) {
                type = "top";
            }
            else if (Arrays.asList(rightSymbols).contains(value)) {
                type = "right";
            }

            CalculatorButton button = new CalculatorButton(value, type);
            button.addActionListener(listener);
            add(button);
        }
    }
}