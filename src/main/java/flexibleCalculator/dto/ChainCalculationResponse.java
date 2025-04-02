package flexibleCalculator.dto;

public class ChainCalculationResponse {
    private Number result;

    public ChainCalculationResponse(Number result) {
        this.result = result;
    }

    public Number getResult() {
        return result;
    }
    public void setResult(Number result) {
        this.result = result;
    }
}