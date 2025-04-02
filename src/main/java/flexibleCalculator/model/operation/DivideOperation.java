package flexibleCalculator.model.operation;

import flexibleCalculator.exception.CalculationException;
import flexibleCalculator.model.Operation;
import flexibleCalculator.util.ConvertDecimal;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DivideOperation implements OperationStrategy{
    @Override
    public Operation getOperation() {
        return Operation.DIVIDE;
    }

    @Override
    public Number calculate(Number a, Number b) {
        BigDecimal x = ConvertDecimal.toBigDecimal(a);
        BigDecimal y = ConvertDecimal.toBigDecimal(b);
        if (BigDecimal.ZERO.compareTo(y) == 0) {
            throw new CalculationException("Division by zero is not allowed.");
        }
        // Specify scale and rounding mode as needed for division
        return x.divide(y, 10, RoundingMode.HALF_UP);
    }
}
