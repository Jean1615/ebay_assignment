package flexibleCalculator.model.operation;

import flexibleCalculator.model.Operation;

public interface OperationStrategy {
    Operation getOperation();
    Number calculate(Number a, Number b);
}
