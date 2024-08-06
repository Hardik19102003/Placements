public class FibonacciDP {
    // Function to compute the nth Fibonacci number using dynamic programming
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // Create an array to store Fibonacci numbers
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        // Fill the array using the DP approach
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    // Function to compute the nth Fibonacci number using dynamic programming with constant space
    public static int fibonacciConst(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // Variables to store the last two Fibonacci numbers
        int a = 0;
        int b = 1;

        // Variable to store the current Fibonacci number
        int current = 0;

        // Calculate the Fibonacci number using a loop
        for (int i = 2; i <= n; i++) {
            current = a + b; // Current Fibonacci number is the sum of the last two
            a = b;           // Update 'a' to the next number in the sequence
            b = current;     // Update 'b' to the current number in the sequence
        }

        return current;
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
