package flexibleCalculator.dto;


import flexibleCalculator.model.Operation;
import java.util.List;

public class ChainCalculationRequest {
    private Number initial;
    private List<OperationStep> steps;

    public Number getInitial() {
        return initial;
    }
    public void setInitial(Number initial) {
        this.initial = initial;
    }
    public List<OperationStep> getSteps() {
        return steps;
    }
    public void setSteps(List<OperationStep> steps) {
        this.steps = steps;
    }

    // Nested DTO representing one operation step in the chain
    public static class OperationStep {
        private Operation operation;
        private Number operand;

        public Operation getOperation() {
            return operation;
        }
        public void setOperation(Operation operation) {
            this.operation = operation;
        }
        public Number getOperand() {
            return operand;
        }
        public void setOperand(Number operand) {
            this.operand = operand;
        }
    }
}
