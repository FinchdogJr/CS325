// lab3a.java
// lukas finch
// fall 2025
// power and GCD recursive functions
//
public class Main {
    public static void main(String[] args) {

        // calls to power function
        System.out.println("Power function calls:");
        System.out.println(power(2, 3));
        System.out.println(power(5, 2));
        System.out.println(power(3, 4));
        System.out.println();

        // calls to gcd function
        System.out.println("GCD function calls:");
        System.out.println(gcd(10, 45));
        System.out.println(gcd(48, 18));
        System.out.println(gcd(7, 13));
        System.out.println();

    }

    public static int power(int x, int y) {
        System.out.println("power(" + x + "," + y + ")");
        if (y == 0)
            return 1;
        else if (y == 1)
            return x;
        else
            return x * power(x, y - 1);
    }

    public static int gcd(int x, int y) {
        System.out.println("gcd(" + x + "," + y + ")");
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }
}