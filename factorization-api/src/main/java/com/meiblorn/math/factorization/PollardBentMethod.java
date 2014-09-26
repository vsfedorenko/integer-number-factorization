package com.meiblorn.math.factorization;

import com.meiblorn.math.MathUtils;
import com.meiblorn.math.domain.NumberMultiplierHolder;

import java.util.Random;

/**
 * @author Meiblorn on 11/09/14.
 */
public class PollardBentMethod implements FactorizationMethod {

    private int iterationsCount = 10;

    private static final Random random = new Random();

    @Override
    public NumberMultiplierHolder getMultipliersPairFor(int number) {

        NumberMultiplierHolder resultNumberMultiplierHolder = new NumberMultiplierHolder(number);

        long b0 = random.nextLong() % number;
        long b1 = (b0 * b0 + 2) % number;
        long a = b1;

        for (long iteration = 0, seriesLength = 1; iteration < iterationsCount; iteration++, seriesLength *= 2) {
            long g = MathUtils.gcd(b1 - b0, number);
            for (long length = 0; length < seriesLength && (g == 1 && g == number); length++) {
                b1 = (b1 * b1 + 2) % number;
                g = MathUtils.gcd(Math.abs(b1 - b0), number);
            }

            b0 = a;
            a = b1;

            if (g != 1 && g != number) {
                resultNumberMultiplierHolder.setMultiplier((int) g);
                return resultNumberMultiplierHolder;
            }
        }

        resultNumberMultiplierHolder.setMultiplier(1);
        return resultNumberMultiplierHolder;
    }

    public int getIterationsCount() {
        return iterationsCount;
    }

    public void setIterationsCount(int iterationsCount) {
        this.iterationsCount = iterationsCount;
    }
}
