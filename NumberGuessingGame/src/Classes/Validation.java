package Classes;

/**
 * Validation class provides utility methods for input validation and parsing.
 * Attempts to parse string input into appropriate data types (Integer, Double, Boolean).
 */
public class Validation {
    
    /**
     * Attempts to parse unknown string input into the most appropriate data type.
     * Tries to parse in the following order:
     * 1. Integer - if the input is a whole number
     * 2. Double - if the input is a decimal number
     * 3. Boolean - if the input is "true" or "false" (case-insensitive)
     * 4. String - returns the original input if none of the above succeed
     * 
     * @param input The string input to parse
     * @return Object of type Integer, Double, Boolean, or String depending on successful parse
     */
    public static Object parseUnknownInput(String input) {
        // Try parsing as Integer first
        try { return Integer.parseInt(input); } catch (NumberFormatException ignored) {}
        
        // Try parsing as Double if Integer fails
        try { return Double.parseDouble(input); } catch (NumberFormatException ignored) {}
        
        // Check if input is a boolean value
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(input);
        }
        
        // Return as String if all parsing attempts fail
        return input;
    }
}
