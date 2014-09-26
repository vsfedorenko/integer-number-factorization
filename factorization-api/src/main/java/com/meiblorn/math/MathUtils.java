package com.meiblorn.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meiblorn on 11/09/14.
 */
public class MathUtils {

    public static long gcd(long a, long b) {
        long factor = Math.max(a, b);
        for (long loop = factor; loop > 1; loop--) {
            if (a % loop == 0 && b % loop == 0) {
                return loop;
            }
        }
        return 1;
    }

    public static long modPow(long a, long b, long n) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long m = modPow(a, b / 2, n);
        return b % 2 == 0 ? (m * m) % n : ((m * m) % n) * a % n;
    }

    public static List<Integer> getPrimes(int n) {

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {
                for (int j = i; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
