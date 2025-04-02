package flexibleCalculator.dto;

import flexibleCalculator.model.Operation;
public class CalculationRequest {
    private Operation operation;
    private double num1;
    private double num2;

    // Getters and setters
    public Operation getOperation() {
        return operation;
    }
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public double getNum1() {
        return num1;
    }
    public void setNum1(double num1) {
        this.num1 = num1;
    }
    public double getNum2() {
        return num2;
    }
    public void setNum2(double num2) {
        this.num2 = num2;
    }
}
