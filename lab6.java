import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * lab6.java
 * fall 2025
 * 
 * Lukas Finch
 * 
 * convert String to double using Java Collection Stack and Queue
 */

public class lab6 {

    public static void main(String[] args) {

        // provided test cases
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);

        // additional test cases
        test("123.456", 123.456);
        test("  -$12,345.67  ", -12345.67);
        test("42.", 42.0);

    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        boolean negative = false;
        boolean decimalFound = false;

        // Step 1: clean and analyze string
        a = a.trim();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                if (!decimalFound)
                    s.push(Character.getNumericValue(c));
                else
                    q.add(Character.getNumericValue(c));
            } else if (c == '.') {
                decimalFound = true;
            }
            // ignore $, commas, and spaces
        }

        // Step 2: process stack (whole number part)
        double multiplier = 1.0;
        while (!s.isEmpty()) {
            answer += s.pop() * multiplier;
            multiplier *= 10;
        }

        // Step 3: process queue (decimal part)
        double divisor = 10.0;
        while (!q.isEmpty()) {
            answer += q.remove() / divisor;
            divisor *= 10;
        }

        // Step 4: apply sign
        if (negative)
            answer *= -1;

        return answer;
    }// toDouble

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (Math.abs(actual - expected) < 0.000001)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
