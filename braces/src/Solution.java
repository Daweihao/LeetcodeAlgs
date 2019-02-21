import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the braces function below.
    static String[] braces(String[] values) {
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(']', '[');
        mapping.put('}', '{');
        mapping.put(')', '(');

        Stack<Character> stack = new Stack<>();
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            String s = values[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (mapping.containsKey(c)) {
                    char topEle = stack.empty() ? '#' : stack.pop();
                    if (topEle != mapping.get(c))
                        result[i] = "No";
                    stack.clear();
                    break;

                } else {
                    stack.push(c);
                }
                if (stack.empty()) {
                    result[i] = "YES";
                    stack.clear();
                } else {
                    stack.clear();
                    result[i] = "NO";
                }
            }

        }
        return result;

    }
}

//    private static final Scanner scanner = new Scanner(System.in);