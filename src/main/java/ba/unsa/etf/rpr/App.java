package ba.unsa.etf.rpr;

/**
 * Class App with a main method
 *
 */
public class App 
{
    /**
     * Main method which parses input from console and validates it
     */
    public static void main( String[] args )
    {
        try {
            InputCheck.check(args[0]);
            System.out.println(ExpressionEvaluator.evaluate(args[0]));
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
