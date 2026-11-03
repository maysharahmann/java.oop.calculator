import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
    private final JLabel displayLabel;

    public DisplayPanel() {
        setLayout(new BorderLayout());

        displayLabel = new JLabel("0");
        displayLabel.setBackground(CalculatorTheme.BLACK);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial",Font.PLAIN,80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setOpaque(true);

        add(displayLabel);
    }
    public String getText() {
        return displayLabel.getText();
    }
    public void setText(String text) {
        displayLabel.setText(text);
    }
}