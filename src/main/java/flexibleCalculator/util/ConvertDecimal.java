package flexibleCalculator.util;
import java.math.BigDecimal;

public class ConvertDecimal {
    public static BigDecimal toBigDecimal(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        }
        // Using the string constructor preserves precision for integers and longs
        return new BigDecimal(number.toString());
    }
}
