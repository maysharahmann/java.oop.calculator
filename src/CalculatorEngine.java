import java.math.BigDecimal;
import java.math.RoundingMode;
public class CalculatorEngine {
	public static final String ERROR = "Error";
    String a = "0";
    String operator = null;
    String b = null;

    public boolean hasOperator() {
        return operator !=null;
    }

    public void setOperator(String operator) {
        this.operator= operator;
    }

    public void setA(String a) {
        this.a =a;
    }

    public String calculate(String currentDisplay) {
        b = currentDisplay;
        double numberA = Double.parseDouble(a);
        double numberB = Double.parseDouble(b);
        double result = 0;

        if (operator.equals("+")) {
            result = numberA + numberB;
        }
        else if (operator.equals("-")) {
            result = numberA - numberB;
        }
        else if (operator.equals("×")) {
            result = numberA * numberB;
        }
        else if (operator.equals("÷")) {
            if (numberB == 0){
                return ERROR;
            }
            result = numberA/numberB;
        }
        return formatNumber(result);
    }
    public String squareRoot(double number) {
        if (number < 0) {
            return ERROR;
        }
        return formatNumber(Math.sqrt(number));
    }
    public void clear() {
        a = "0";
        operator =null;
        b =null;
    }
    public static String formatNumber(double number) {
        if (Double.isNaN(number) || Double.isInfinite(number)) {
            return ERROR;
        }
        BigDecimal value = new BigDecimal(number).setScale(10, RoundingMode.HALF_UP);
        value = value.stripTrailingZeros();
        return value.toPlainString();
    }
}