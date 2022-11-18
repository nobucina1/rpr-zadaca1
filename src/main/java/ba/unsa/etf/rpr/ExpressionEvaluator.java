package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class with a method which implements Dijkstra algorithm
 * @author Nermin Obucina
 * @version 1.0
 */

public class ExpressionEvaluator {
    /**
     *Method which implements Dijkstra Two-Stack Algorithm for Expression
     */
    public static Double evaluate(String str) {
        String[] array = str.split("\\s+"); //Splitting string to array of strings
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        for (String s: array) {
            // Read token, push if operator.
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            // Token not operator or paren: push double value.
            else vals.push(Double.parseDouble(s));
        }
        return vals.pop();
    }
}
