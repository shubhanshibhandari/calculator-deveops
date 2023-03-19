import org.example.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    public static final double DELTA = 1e-3;
    Calculator calculator = new Calculator();
    @Test
    public void sumTruePositive() {
        assertEquals("Finding Sum for True positive", 20, calculator.sum(15,5), DELTA);
        assertEquals("Finding Sum for True positive", 10, calculator.sum(20,-10), DELTA);
    }
    @Test
    public void sumFalsePositive() {
        assertNotEquals("Finding Sum for False positive", 10, calculator.sum(15,5), DELTA);
        assertNotEquals("Finding Sum for False positive", 30, calculator.sum(20,-10), DELTA);
    }

    @Test
    public void subtractTruePositive() {
        assertEquals("Finding difference for True positive", 10, calculator.subtract(15,5), DELTA);
        assertEquals("Finding difference for True positive", 30, calculator.subtract(20,-10), DELTA);
    }
    @Test
    public void subtractFalsePositive() {
        assertNotEquals("Finding difference for False positive", 20, calculator.subtract(15,5), DELTA);
        assertNotEquals("Finding difference for False positive", 10, calculator.subtract(20,-10), DELTA);
    }

    @Test
    public void multiplyTruePositive() {
        assertEquals("Finding multiply for True positive", 75, calculator.multiply(15,5), DELTA);
        assertEquals("Finding multiply for True positive", -200, calculator.multiply(20,-10), DELTA);
    }
    @Test
    public void multiplyFalsePositive() {
        assertNotEquals("Finding multiply for False positive", 100, calculator.multiply(15,5), DELTA);
        assertNotEquals("Finding multiply for False positive", 200, calculator.multiply(20,-10), DELTA);
    }

    @Test
    public void divideTruePositive() {
        assertEquals("Finding divide for True positive", 3, calculator.divide(15,5), DELTA);
        assertEquals("Finding divide for True positive", -2, calculator.divide(20,-10), DELTA);
    }
    @Test(expected = ArithmeticException.class)
    public void divideWithZeroTruePositive() {
        calculator.divide(15,0);
    }

    @Test
    public void divideFalsePositive() {
        assertNotEquals("Finding divide for False positive", 10, calculator.divide(15,5), DELTA);
        assertNotEquals("Finding divide for False positive", 30, calculator.divide(20,-10), DELTA);
    }

    @Test
    public void factorialTruePositive() {
        assertEquals("Finding factorial of a number for True Positive", 6, calculator.factorial(3), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 720, calculator.factorial(6), DELTA);
    }

    @Test
    public void factorialTrueNegative() {
        assertNotEquals("Finding factorial of a number for True Negative", 69, calculator.factorial(5), DELTA);
        assertNotEquals("Finding factorial of a number for True Negative", 42, calculator.factorial(10), DELTA);
    }

    @Test
    public void powerTruePositive() {
        assertEquals("Finding power for True Positive", 32, calculator.power(2, 5), DELTA);
        assertEquals("Finding power for True Positive", 81, calculator.power(9, 2), DELTA);
    }

    @Test
    public void powerTrueNegative() {
        assertNotEquals("Finding power for True Negative", 69, calculator.power(2, 2), DELTA);
        assertNotEquals("Finding power for True Negative", -69420, calculator.power(-2, 20), DELTA);
    }

    @Test
    public void logTruePositive() {
        assertEquals("Finding natural log for True Positive", 0, calculator.naturalLog(1), DELTA);
        assertEquals("Finding natural log for True Positive", 5.703782474656201, calculator.naturalLog(300), DELTA);
    }

    @Test
    public void logTrueNegative() {
        assertNotEquals("Finding natural log for True Negative", 69, calculator.naturalLog(2.4), DELTA);
        assertNotEquals("Finding natural log for True Negative", 420, calculator.naturalLog(2.1), DELTA);
    }

    @Test
    public void sqrootTruePositive() {
        assertEquals("Finding square root for True Positive", 11, calculator.squareRoot(121), DELTA);
        assertEquals("Finding square root for True Positive", 121, calculator.squareRoot(14641), DELTA);
    }

    @Test
    public void sqrootTrueNegative() {
        assertNotEquals("Finding square root for True Negative", 69, calculator.squareRoot(3), DELTA);
        assertNotEquals("Finding square root for True Negative", -42, calculator.squareRoot(4), DELTA);
    }


}