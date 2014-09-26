package com.meiblorn.math.factorization;

import com.meiblorn.math.MathUtils;
import com.meiblorn.math.domain.NumberMultiplierHolder;

import java.util.Random;

/**
 * @author Meiblorn on 11/09/14.
 */
public class PollardRhoMethod implements FactorizationMethod {

    private int iterationsCount = 1000;

    private static final Random random = new Random();

    @Override
    public NumberMultiplierHolder getMultipliersPairFor(int number) {

        NumberMultiplierHolder resultNumberMultiplierHolder = new NumberMultiplierHolder(number);

        long b0 = random.nextLong() % number;
        long b1 = b0;


        b1 = MathUtils.modPow(b1, b1, number);

        if (++b1 == number) {
            b1 = 0;
        }

        long g = MathUtils.gcd(Math.abs(b1 - b0), number);

        for (int iteration = 0; iteration < iterationsCount && (g == 1 || g == number); iteration++) {
            b0 = MathUtils.modPow(b0, b0, number);
            if (++b0 == number) {
                b0 = 0;
            }
            b1 = MathUtils.modPow(b1, b1, number);
            ++b1;
            b1 = MathUtils.modPow(b1, b1, number);
            if (++b1 == number) {
                b1 = 0;
            }
            g = MathUtils.gcd(Math.abs(b1 - b0), number);
        }

        resultNumberMultiplierHolder.setMultiplier((int) g);

        return resultNumberMultiplierHolder;

    }

    public int getIterationsCount() {
        return iterationsCount;
    }

    public void setIterationsCount(int iterationsCount) {
        this.iterationsCount = iterationsCount;
    }
}
