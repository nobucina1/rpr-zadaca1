package ba.unsa.etf.rpr;

/**
 * Class with a method which checks if an input is valid
 * @author Nermin Obucina
 * @version 1.0
 */

public class InputCheck {
    /**
     * Method which checks if an input is valid
     */
    public static void check(String str) {
        int openNumb = 0, closeNumb = 0;

        //Checking if there is a bracket at the start and at the end
        if (str.charAt(0) != '(' || str.charAt(str.length()-1) != ')')
            throw new RuntimeException("This input is not valid!");

        for (int i=0; i<str.length(); i++) {

            //Checking if a char is a bracket, number, operator or 's'
            if (str.charAt(i) != ' ' && str.charAt(i) != '(' && str.charAt(i) != ')' && !Digit(str.charAt(i)) && !Operator(str.charAt(i)) && !CanDo(str.charAt(i)))
                throw new RuntimeException("This input is not valid!");

            //Checking if there is white space between every character
            if (str.charAt(i) == ' ') {
                if (str.charAt(i+1) != '(' && str.charAt(i+1) != ')' && !Digit(str.charAt(i+1)) && !Operator(str.charAt(i+1)) && str.charAt(i+1) != 's')
                    throw new RuntimeException("This input is not valid!");
                if (str.charAt(i-1) != '(' && str.charAt(i-1) != ')' && !Digit(str.charAt(i-1)) && !Operator(str.charAt(i-1)) && str.charAt(i-1) != 't')
                    throw new RuntimeException("This input is not valid!");
            }

            //Checking if a char is a 's' and then if rest of the word is "sqrt"
            else if (str.charAt(i) == 's' && !checkSqrt(str.charAt(i+1),str.charAt(i+2),str.charAt(i+3)))
                throw new RuntimeException("This input is not valid!");

            //Checking if there is a number after "sqrt" and if "sqrt" is between the brackets
            else if (str.charAt(i) == 's'){
                i = i + 4;
                if (str.charAt(i) != ' ') throw new RuntimeException("This input is not valid!");
                i = i + 1;
                if (str.charAt(i) != '(') throw new RuntimeException("This input is not valid!");
                if (str.charAt(i+1) != ' ') throw new RuntimeException("This input is not valid!");
                i = i+2;
                if (!Digit(str.charAt(i))) throw new RuntimeException("This input is not valid!");
                else
                    while (Digit(str.charAt(i))) i = i + 1;
                if (str.charAt((i)) != ' ') throw new RuntimeException("This input is not valid!");
                i = i + 1;
                if (str.charAt(i) != ')') throw new RuntimeException("This input is not valid!");
            }

            //Counting opened and closed brackets
            else if (str.charAt(i) == '(')
                openNumb = openNumb + 1;
            else if (str.charAt(i) == ')')
                closeNumb = closeNumb +1;
        }

        //Checking if there is a same number of opened and closed brackets
        if (openNumb != closeNumb) throw new RuntimeException("This input is not valid!");
    }

    /**
     * Method checks if a char is a number
     */
    public static boolean Digit(char c) {
        if (c >= '0' && c <= '9') return true;
        return false;
    }

    /**
     * Method checks if a char is an operator
     */
    public static boolean Operator(char c) {
        if (c != '+' && c != '-' && c != '*' && c != '/') return false;
        return true;
    }

    /**
     * Method checks if a sqrt is typed correctly
     */
    public static boolean checkSqrt( char c2, char c3, char c4) {
        if (c2 == 'q' && c3 == 'r' && c4 == 't') return true;
        return false;
    }

    /**
     *
     * Method checks if a char is not a part of sqrt
     */
    public static boolean CanDo(char c) {
        if (c == 's' || c == 'q' || c == 'r' || c == 't') return true;
        return false;
    }
}
