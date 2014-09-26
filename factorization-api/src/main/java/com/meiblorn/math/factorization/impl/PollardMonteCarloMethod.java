package com.meiblorn.math.factorization.impl;

import com.meiblorn.math.factorization.FactorizationMethod;
import com.meiblorn.math.utils.MathUtils;
import com.meiblorn.math.domain.NumberMultiplierHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Meiblorn on 11/09/14.
 */
public class PollardMonteCarloMethod implements FactorizationMethod {

    private int maxPrime = 100;

    private static final Random random = new Random();

    @Override
    public NumberMultiplierHolder getMultipliersPairFor(int number) {

        NumberMultiplierHolder resultNumberMultiplierHolder = new NumberMultiplierHolder(number);

        long b = random.nextLong() % (maxPrime - 2) + 2;
        List<Integer> primes = new ArrayList<Integer>();

        if (primes.isEmpty()) {
            primes.add(3);
        }

        for (int prime = 5; prime <= maxPrime; prime += 2) {
            boolean isPrime = true;
            for (Integer div : primes) {
                if (div * div > prime) {
                    break;
                }

                if (prime % div == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(prime);
            }
        }

        long g = 1;
        for (int i = 0; i < primes.size() && g == 1; i++) {
            int current = primes.get(i);
            while (current <= number) {
                current *= primes.get(i);
            }
            current /= primes.get(i);
            b = MathUtils.modPow(b, current, number);
            g = MathUtils.gcd(Math.abs(b - 1), number);
            if (g == number) {
                g = 1;
            }
        }

        resultNumberMultiplierHolder.setMultiplier((int) g);
        return resultNumberMultiplierHolder;
    }

    public int getMaxPrime() {
        return maxPrime;
    }

    public void setMaxPrime(int maxPrime) {
        this.maxPrime = maxPrime;
    }
}
