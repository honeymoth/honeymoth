import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        int[] x = primes(30);
        System.out.println(Arrays.toString(x));
        int[][] a = primeFactors(56);
        for (int i = 0; i != a.length; ++i) {
            System.out.print(Arrays.toString(a[i]) + " ");
        }
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i != n + 1; ++i) {
            prime[i] = true;
        }
        int p = 2;
        int k;
        for (int i = 2; i != Math.round(Math.sqrt(n + 1)); ++i) {
            if (prime[i]) {
                p = i;
            }
            k = 1;
            while (p + p * k <= prime.length - 1) {
                prime[p + p * k] = false;
                k = k + 1;
            }
        }
        return prime;
    }

    private static int[] primes(int n) {
        boolean[] sieve = sieveOfEratosthenes(n);
        int count = 0;
        for (int i = 0; i != sieve.length; ++i) {
            if (sieve[i]) {
                count = count + 1;
            }
        }
        int[] primes = new int[count];
        count = 0;
        for (int i = 0; i != n + 1; ++i) {
            if (sieve[i]) {
                primes[count] = i;
                count = count + 1;
            }
        }
        return primes;
    }

    private static int[][] primeFactors(int n) {
        int[] dividers = primes(n);
        int i = 0;
        int size = 0;
        for (int j = 0; j != dividers.length; ++j) {
            if (n % dividers[j] == 0) {
                size = size + 1;
            }
        }
        int[][] result = new int[size][];
        int step = 0;
        int degree;
        while (dividers[i] * dividers[i] <= n) {
            degree = 0;
            int[] cell = new int[2];
            while (n % dividers[i] == 0) {
                n = n / dividers[i];
                degree = degree + 1;
            }
            cell[0] = dividers[i];
            cell[1] = degree;
            if (degree != 0) {
                result[step] = cell;
                step = step + 1;
            }
            i = i + 1;
        }
        degree = 1;
        if (n != 1) {
            int[] cell = new int[2];
            cell[0] = dividers[i];
            cell[1] = degree;
            result[step] = cell;
        }
        return result;
    }
}

