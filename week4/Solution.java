// Import your library
// Do not change the name of the Solution class
public class Solution {
    // Type your main code here
    /**
     * return true if n is prime and false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        double sqrtOfN = Math.sqrt(n);
        int tongSoUoc = 0;
        for (int p = 2; p <= sqrtOfN; p++) {
            if (n % p == 0) {
                tongSoUoc++;
            }
        }
        return tongSoUoc == 0;
    }
}