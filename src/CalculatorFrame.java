import java.awt.BorderLayout;
import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {
    private final int boardWidth=360;
    private final int boardHeight=540;

    public CalculatorFrame() {
        super("Calculator");
        setSize(boardWidth ,boardHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DisplayPanel displayPanel= new DisplayPanel();
        ButtonPanel buttonPanel=new ButtonPanel();
        CalculatorEngine engine=new CalculatorEngine();
        CalculatorController controller =new CalculatorController(displayPanel, engine);

        buttonPanel.createButtons(controller);

        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}