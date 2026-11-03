import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class CalculatorButton extends JButton {
    public CalculatorButton(String value, String type) {
        super(value);
        setFont(new Font("Aptos", Font.PLAIN, 35));
        setFocusable(false);
        setBorder(new LineBorder(CalculatorTheme.BLACK));

        if (type.equals("top")) {
            setBackground(CalculatorTheme.LIGHTGRAY);
            setForeground(CalculatorTheme.BLACK);
        }
        else if (type.equals("right")) {
            setBackground(CalculatorTheme.ORANGE);
            setForeground(Color.white);
        }
        else {
            setBackground(CalculatorTheme.DARKGRAY);
            setForeground(Color.white);
        }
    }
}