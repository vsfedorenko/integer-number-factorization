package com.meiblorn.math.factorization.impl;

import com.meiblorn.math.factorization.FactorizationMethod;
import com.meiblorn.math.utils.MathUtils;
import com.meiblorn.math.domain.NumberMultiplierHolder;

import java.util.List;

/**
 * @author Meiblorn on 11/09/14.
 */
public class TrivialMethod implements FactorizationMethod {

    private int maxPrime = 100;

    @Override
    public NumberMultiplierHolder getMultipliersPairFor(int number) {

        NumberMultiplierHolder resultNumberMultiplierHolder = new NumberMultiplierHolder(number);

        if (number == 2 || number == 3) {
            resultNumberMultiplierHolder.setMultiplier(1);
            return resultNumberMultiplierHolder;
        }
        if (number < 2) {
            resultNumberMultiplierHolder.setMultiplier(1);
            return resultNumberMultiplierHolder;
        }
        if (number % 2 == 0) {
            resultNumberMultiplierHolder.setMultiplier(2);
            return resultNumberMultiplierHolder;
        }

        List<Integer> primes = MathUtils.getPrimes(maxPrime);

        for (Integer prime : primes) {
            if (prime * prime > number) {
                break;
            } else if (number % prime == 0) {
                resultNumberMultiplierHolder.setMultiplier(prime);
                return resultNumberMultiplierHolder;
            }
        }

        if (number < maxPrime * maxPrime) {
            resultNumberMultiplierHolder.setMultiplier(1);
            return resultNumberMultiplierHolder;
        }

        resultNumberMultiplierHolder.setMultiplier(1);
        return resultNumberMultiplierHolder;

    }

    public int getMaxPrime() {
        return maxPrime;
    }

    public void setMaxPrime(int maxPrime) {
        this.maxPrime = maxPrime;
    }
}
