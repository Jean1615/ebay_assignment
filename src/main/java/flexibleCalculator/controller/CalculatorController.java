package flexibleCalculator.controller;


import flexibleCalculator.dto.CalculationRequest;
import flexibleCalculator.dto.CalculationResponse;
import flexibleCalculator.dto.ChainCalculationRequest;
import flexibleCalculator.dto.ChainCalculationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import flexibleCalculator.service.CalculatorService;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        double result = calculatorService.calculate(
                request.getOperation(),
                request.getNum1(),
                request.getNum2()
        ).doubleValue();
        return new CalculationResponse(result);
    }

    @PostMapping("/chainCalculate")
    public ChainCalculationResponse chainCalculate(@RequestBody ChainCalculationRequest request) {
        Number result = calculatorService.chainCalculate(request.getInitial(), request.getSteps());
        return new ChainCalculationResponse(result);
    }
    @GetMapping("/")
    public String initialpage(){
        return "Hello World";
    }
}
