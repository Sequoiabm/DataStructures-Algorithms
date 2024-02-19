public class FibonacciBetter {
    // Function to calculate Fibonacci numbers using memoization
    public static long betterF(int N) {
        // If N is 0 or 1, return N as it's the base case
        if (N <= 1) return N;

        // Create an array to store Fibonacci values up to N
        long[] fibArray = new long[N + 1];
        fibArray[0] = 0; // F(0) is 0
        fibArray[1] = 1; // F(1) is 1

        // Calculate and store Fibonacci values from 2 to N
        for (int i = 2; i <= N; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        // Return the Fibonacci value for N
        return fibArray[N];
    }

    public static void main(String[] args) {
        // Loop through and calculate Fibonacci values for N from 0 to 99
        for (int N = 0; N < 100; N++) {
            // Print N and its corresponding Fibonacci value
            System.out.println(N + " " + betterF(N));
        }
    }
}

//--------------------------------------------------------------------------------------------------

// What is the largest value of N for which this program takes less 1 hour to compute the
// value of F(N)? 
// ANSWER: 56 225851433717 while hitting 57 365435296162 just at the 1 hour mark 

//Develop a better implementation of F(N) that saves computed values in
// an array.

