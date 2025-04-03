package flexibleCalculator;

import flexibleCalculator.dto.ChainCalculationRequest;
import flexibleCalculator.exception.CalculationException;
import flexibleCalculator.model.Operation;
import flexibleCalculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import flexibleCalculator.model.operation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BasicAndChainTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        Map<Operation, OperationStrategy> operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, new AddOperation());
        operationMap.put(Operation.SUBTRACT, new SubtractOperation());
        operationMap.put(Operation.MULTIPLY, new MultiplyOperation());
        operationMap.put(Operation.DIVIDE, new DivideOperation());
        Map<String, OperationStrategy> beanMap = operationMap.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().name(), Map.Entry::getValue));//convert for test
        calculatorService = new CalculatorService(beanMap);
    }

    @Test
    void testAddition() {
        assertEquals(new BigDecimal(5).stripTrailingZeros(), calculatorService.calculate(Operation.ADD, 2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(new BigDecimal(4).stripTrailingZeros(), calculatorService.calculate(Operation.SUBTRACT, 10, 6));
    }

    @Test
    void testMultiplication() {
        assertEquals(new BigDecimal(15).stripTrailingZeros(), calculatorService.calculate(Operation.MULTIPLY, 3, 5));
    }

    @Test
    void testDivision() {
        assertEquals(new BigDecimal(2.5).stripTrailingZeros(), calculatorService.calculate(Operation.DIVIDE, 5, 2));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(CalculationException.class, () -> calculatorService.calculate(Operation.DIVIDE, 10, 0));
    }

    @Test
    void testChainCalculationWithNoSteps() {
        Number initial = 42;
        List<ChainCalculationRequest.OperationStep> steps = List.of(); // empty list
        Number result = calculatorService.chainCalculate(initial, steps);
        assertEquals(new BigDecimal(42).stripTrailingZeros(), result); // should return initial as-is
    }
    @Test
    void testDivideOperation() {
        BigDecimal v1 = new BigDecimal("1000000000000000000000");
        BigDecimal v2 = new BigDecimal("2000000000000000000000");
        assertEquals(new BigDecimal(0.5).stripTrailingZeros(), calculatorService.calculate(Operation.DIVIDE, v1, v2));
    }


}