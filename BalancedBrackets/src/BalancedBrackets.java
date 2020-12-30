import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;

public class BalancedBrackets {

    static HashMap<Character, Character> pMap;

    static {
        pMap = new HashMap<>();
        pMap.put('(', ')');
        pMap.put('[', ']');
        pMap.put('{', '}');
    }

    static String balanceBrackets(String s) {
        // Checking input string to see if the string entered is even
        if (s.length() % 2 != 0) {
            return "NO"; //An odd string implies that there is no possible balance
        }
        //Implement a Stack in order to check if there is a balanced bracket
        Stack<Character> stack = new Stack<>();
        //For loop is used iterate through the given string
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (pMap.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || ch != pMap.get(stack.pop())) {
                return "NO";
            }
        }

        return stack.isEmpty()? "YES": "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(BalancedBrackets.balanceBrackets("[{()}]"));
        System.out.println(BalancedBrackets.balanceBrackets("[}()}]"));
        System.out.println(BalancedBrackets.balanceBrackets("([{()}])"));
    }
}
