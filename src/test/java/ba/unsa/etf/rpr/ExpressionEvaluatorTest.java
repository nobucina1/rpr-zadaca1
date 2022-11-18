package ba.unsa.etf.rpr;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for ExpressionEvaluator class.
 * @author Nermin Obucina
 * @version 1.0
 */
public class ExpressionEvaluatorTest
{
    /**
     * Test from the assignment setting, result should be 101
     */
    @Test
    void test1()
    {
         String str = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
         assertEquals(101.0, ExpressionEvaluator.evaluate(str));
    }

    /**
     *Check if invalid input is thrown (as RuntimeException)
     */
    @Test
    void test2() {
        String str = "( 5 + sqrt (25) + )";
        assertThrows(RuntimeException.class, () -> {InputCheck.check(str);}, "This input is not valid!");
    }

    /**
     * Check sqrt operation
     */
    @Test
    void test3() {
        String str = "( 3 + sqrt ( 81 ) )"; //=12
        assertEquals(12.0, ExpressionEvaluator.evaluate(str));
    }

    /**
     * Check algorithm
     */
    @Test
    void test4() {
        String str = "( 2 + ( ( sqrt ( 64 ) * 3 ) * ( 30 / 6 ) ) )"; // =122
        assertEquals(122.0, ExpressionEvaluator.evaluate(str));
    }

    /**
     * Check algorithm
     */
    @Test
    void test5() {
        String str = "( ( 100 - ( 11 + ( 48 / 6 ) ) ) / ( ( 1 + sqrt ( 49 ) + ( 12 / 12 ) ) )"; //=9
        assertEquals(9.0, ExpressionEvaluator.evaluate(str));
    }

    /**
     * Check algorithm
     */
    @Test
    void test6() {
        String str = "( ( sqrt ( 25 ) * 4 ) + ( 75 / 3 ) )"; //=45
        assertEquals(45.0, ExpressionEvaluator.evaluate(str));
    }
}
