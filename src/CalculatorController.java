import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

public class CalculatorController implements ActionListener {
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    DisplayPanel displayPanel;
    CalculatorEngine engine;

    public CalculatorController(DisplayPanel displayPanel, CalculatorEngine engine) {
        this.displayPanel = displayPanel;
        this.engine = engine;
    }
    private boolean isError() {
        return displayPanel.getText().equals(CalculatorEngine.ERROR);
    }

    void handleSquareRoot() {
        if (isError()) {
            return;
        }
        double num = Double.parseDouble(displayPanel.getText());
        displayPanel.setText(engine.squareRoot(num));
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonValue = button.getText();

        if (Arrays.asList(rightSymbols).contains(buttonValue)){
            handleOperator(buttonValue);
        }
        else if (Arrays.asList(topSymbols).contains(buttonValue)){
            handleTopSymbol(buttonValue);
        }
        else if (buttonValue.equals("√")) {
            handleSquareRoot();
        }
        else {
            handleDigit(buttonValue);
        }
    }

    void handleOperator(String value) {
    	  if (isError()){
    	        return;
    	    }
        if (value.equals("=")) {
            if (engine.hasOperator()){
                displayPanel.setText(engine.calculate(displayPanel.getText()));
                engine.clear();
            }
        }
        else {
            if (!engine.hasOperator()) {
                engine.setA(displayPanel.getText());
                displayPanel.setText("0");
            }
            engine.setOperator(value);
        }
    }
    void handleTopSymbol(String value) {
        if (value.equals("AC")) {
            engine.clear();
            displayPanel.setText("0");
            return;
        }

        if (isError()){
            return;
        }
        double num= Double.parseDouble(displayPanel.getText());

        if (value.equals("+/-")) {
            num = num * -1;
            displayPanel.setText(CalculatorEngine.formatNumber(num));
        }
        else if (value.equals("%")) {
            num = num / 100;
            displayPanel.setText(CalculatorEngine.formatNumber(num));
        }
    }

    void handleDigit(String value) {
        String current = displayPanel.getText();
        if (isError()) {
            current = "0";
        }
        if (value.equals(".")) {
            if (!current.contains(".")) {
                displayPanel.setText(current + value);
            }
        }
        else if ("0123456789".contains(value)) {
            if (current.equals("0")) {
                displayPanel.setText(value);
            }
            else {
                displayPanel.setText(current + value);
            }
        }
    }
}