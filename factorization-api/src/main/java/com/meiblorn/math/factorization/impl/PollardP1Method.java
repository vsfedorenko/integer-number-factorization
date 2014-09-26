package com.meiblorn.math.factorization.impl;

import com.meiblorn.math.factorization.FactorizationMethod;
import com.meiblorn.math.utils.MathUtils;
import com.meiblorn.math.domain.NumberMultiplierHolder;

/**
 * @author Meiblorn on 11/09/14.
 */
public class PollardP1Method implements FactorizationMethod {

    private final int bParameter = 13;

    private final int primesUntilBParameter[] = {
            2, 3, 5, 7, 11, 13
    };

    @Override
    public NumberMultiplierHolder getMultipliersPairFor(int number) {

        NumberMultiplierHolder resultNumberMultiplierHolder = new NumberMultiplierHolder(number);

        long a = 5 % number;

        for (int i = 0; i < 10; i++) {
            while (MathUtils.gcd(a, number) != 1) {
                a = (a * a + 3) % number;
            }

            for (int prime : primesUntilBParameter) {
                long e = (long) Math.floor(Math.log(bParameter) / Math.log(prime));
                long aa = MathUtils.modPow(
                        a, MathUtils.modPow(prime, e, number), number
                );

                if (aa == 0) {
                    continue;
                }

                long g = MathUtils.gcd(aa - 1, number);
                if (g >= 1 && g < number) {
                    resultNumberMultiplierHolder.setMultiplier((int) g);
                    return resultNumberMultiplierHolder;
                }
            }
        }

        resultNumberMultiplierHolder.setMultiplier(1);
        return resultNumberMultiplierHolder;
    }

    public int getBParameter() {
        return bParameter;
    }

    public int[] getPrimesUntilBParameter() {
        return primesUntilBParameter;
    }

}
