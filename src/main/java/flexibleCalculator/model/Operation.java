package flexibleCalculator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import flexibleCalculator.exception.UnsupportedOpeException;

public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;
    @JsonCreator
    public static Operation fromValue(String value) {
        try {
            // Optionally convert the value to uppercase to make it case-insensitive
            return Operation.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new UnsupportedOpeException("Unsupported operation: " + value);
        }
    }
}
