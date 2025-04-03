package flexibleCalculator.service;

import flexibleCalculator.dto.ChainCalculationRequest;
import flexibleCalculator.exception.UnsupportedOpeException;
import flexibleCalculator.model.Operation;
import flexibleCalculator.model.operation.OperationStrategy;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalculatorService {
    private final Map<Operation, OperationStrategy> operationMap;

    // Inject all BinaryOperation beans and map them by their operation type
    @Autowired
    public CalculatorService(Map<String, OperationStrategy> operationBeans) {
        this.operationMap = operationBeans.values().stream()
                .collect(Collectors.toMap(OperationStrategy::getOperation, op -> op));
    }

    public Number calculate(Operation op, Number a, Number b) {
        OperationStrategy operation = operationMap.get(op);
        if (operation == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
        BigDecimal result = (BigDecimal) operation.calculate(a, b);
        return result.stripTrailingZeros();
    }

    public Number chainCalculate(Number initial, List<ChainCalculationRequest.OperationStep> steps) {
        BigDecimal result = new BigDecimal(initial.toString());
        for (ChainCalculationRequest.OperationStep step : steps) {
            result = (BigDecimal) calculate(step.getOperation(), result, step.getOperand());
        }
        return result.stripTrailingZeros();
    }
}
