
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

class EdgeCaseTest {

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
    void testUnsupportedOperation() {
        Map<String, OperationStrategy> customMap = new HashMap<>();
        calculatorService = new CalculatorService(customMap);

        assertThrows(UnsupportedOperationException.class, () ->
                calculatorService.calculate(Operation.ADD, 1, 2)
        );
    }

    @Test
    void testCalculationException() {

        assertThrows(CalculationException.class, () ->
                calculatorService.calculate(Operation.DIVIDE, 1, 0)
        );
    }

}