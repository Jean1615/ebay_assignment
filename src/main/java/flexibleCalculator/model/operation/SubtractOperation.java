package flexibleCalculator.model.operation;

import flexibleCalculator.model.Operation;
import flexibleCalculator.util.ConvertDecimal;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class SubtractOperation implements OperationStrategy {
    @Override
    public Operation getOperation() {
        return Operation.SUBTRACT;
    }

    @Override
    public Number calculate(Number a, Number b) {
        BigDecimal x = ConvertDecimal.toBigDecimal(a);
        BigDecimal y = ConvertDecimal.toBigDecimal(b);
        return x.subtract(y);
    }

}
