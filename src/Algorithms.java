import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        sieveOfEratosthenes(30);
        System.out.println();
        int[] x = primes(7);
        System.out.println(Arrays.toString(x));
        primeFactors(60);
        System.out.println();
        System.out.println(binarySearch(new int[]{1, 5, 3, 1, 8, 3}, 8));
    }

    private static void sieveOfEratosthenes(int n) {
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
        for (int i = 0; i != n + 1; ++i) {
            if (prime[i]) {
                System.out.print(" " + i);
            }

        }
    }

    private static int[] primes(int n) {
        int[] prime = new int[n + 1];
        int[] result = new int[n];
        int p;
        int k = 0;
        for (int i = 1; i != Math.round(Math.sqrt(n)); ++i) {
            p = 2;
            while (i * p + p <= n) {
                prime[i * p + p] = i * p + p;
                p = p + 1;
            }
        }
        for (int i = 2; i != n + 1; ++i) {
            if (prime[i] != i) {
                result[k] = i;
                k = k + 1;
            }
        }
        return result;
    }

    private static void primeFactors(int n) {
        int[] primes = primes(n);
        int i = n - 1;
        while (primes[i] == 0) {
            i = i - 1;
        }
        while (n != 1) {
            if (n % primes[i] == 0) {
                n = n / primes[i];
                System.out.print(primes[i] + " ");
            } else {
                i = i - 1;
            }
        }
    }

    private static int binarySearch(int[] x, int n) {
        for (int i = 0; i != x.length - 1; ++i) {
            for (int j = i; j != x.length; ++j) {
                if (x[i] >= x[j]) {
                    int k = x[i];
                    x[i] = x[j];
                    x[j] = k;
                }
            }
        }
        System.out.println(Arrays.toString(x));
        int i = x.length / 2;
        int beginning = x[0];
        int ending = x[x.length - 1];
        while (x[i] != n) {
            if (i == 0) {
                break;
            }
            if (i == x.length - 1) {
                break;
            }
            if (x[i] > n) {
                ending = i;
                i = (i - beginning) / 2;
            } else {
                beginning = i;
                i = (ending + i) / 2;
            }
        }
        return i + 1;
    }
}

