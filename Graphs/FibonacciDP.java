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

    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}
