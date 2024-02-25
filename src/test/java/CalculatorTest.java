import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        // Arrange: Setting up two numbers to add and the expected result
        double a = 10;
        double b = 5;
        char operator = '+';
        double expected = 15;

        // Act: Performing the addition operation
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Checking if the actual result matches the expected result
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSubtraction() {
        // Arrange: Setting up two numbers for subtraction and the expected result
        double a = 10;
        double b = 5;
        char operator = '-';
        double expected = 5;

        // Act: Performing the subtraction operation
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Verifying if the actual result matches the expected result
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testMultiplication() {
        // Arrange: Setting up two numbers for multiplication and the expected result
        double a = 10;
        double b = 5;
        char operator = '*';
        double expected = 50;

        // Act: Performing the multiplication operation
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Checking if the actual result is equal to the expected result
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDivision() {
        // Arrange: Preparing two numbers for division and the expected result
        double a = 10;
        double b = 5;
        char operator = '/';
        double expected = 2;

        // Act: Performing the division operation
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Confirming that the actual result matches the expected result
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDivisionByZero() {
        // Arrange: Setting up a division operation with zero to test for NaN result
        double a = 10;
        double b = 0;
        char operator = '/';
        double expected = Double.NaN;

        // Act: Performing the division by zero
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Ensuring the result is NaN as expected for division by zero
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testInvalidOperator() {
        // Arrange: Using an invalid operator to test error handling
        double a = 10;
        double b = 5;
        char operator = 'x'; // Invalid operator
        double expected = Double.NaN;

        // Act: Attempting to calculate with an invalid operator
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Checking that the result is NaN due to the invalid operator
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testLargeNumbersAddition() {
        // Arrange: Using the largest possible double values to test addition overflow
        double a = Double.MAX_VALUE;
        double b = Double.MAX_VALUE;
        char operator = '+';
        double expected = Double.POSITIVE_INFINITY;

        // Act: Performing the addition operation with large numbers
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Verifying that the result is positive infinity (overflow)
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testLargeNumbersMultiplication() {
        // Arrange: Testing multiplication with extremely large values for overflow
        double a = Double.MAX_VALUE;
        double b = 2;
        char operator = '*';
        double expected = Double.POSITIVE_INFINITY;

        // Act: Multiplying two very large numbers
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Ensuring the result is positive infinity (overflow)
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testZeroDivision() {
        // Arrange: Dividing a number by a very small number close to zero
        double a = 1;
        double b = Double.MIN_VALUE;
        char operator = '/';
        double expected = Double.POSITIVE_INFINITY;

        // Act: Performing the division operation
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Checking if the result is positive infinity (division by near-zero)
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testZeroMultiplication() {
        // Arrange: Multiplying zero with a very large number to test zero behavior
        double a = 0;
        double b = Double.MAX_VALUE;
        char operator = '*';
        double expected = 0;

        // Act: Performing the multiplication
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Checking if multiplying with zero results in zero
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testNegativeValues() {
        // Arrange: Testing multiplication with negative values
        double a = -10;
        double b = -5;
        char operator = '*';
        double expected = 50;

        // Act: Performing the multiplication of two negative numbers
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Confirming that the product of two negatives is positive
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testSubtractionResultingInNegative() {
        // Arrange: Setting up two numbers for subtraction to result in a negative value
        double a = 5;
        double b = 10;
        char operator = '-';
        double expected = -5;

        // Act: Performing the subtraction
        double actual = Calculator.calculate(a, b, operator);

        // Assert: Verifying that the result is a negative number
        assertEquals(expected, actual, 0.001);
    }
}