package com.meiblorn.math.factorization.impl;

import com.meiblorn.math.domain.NumberMultiplierHolder;
import com.meiblorn.math.factorization.FactorizationMethod;

/**
 * @author Meiblorn on 11/09/14.
 */
public class FermaMethod implements FactorizationMethod {

    @Override
    public NumberMultiplierHolder getMultipliersPairFor(int number) {

        NumberMultiplierHolder resultNumberMultiplierHolder = new NumberMultiplierHolder(number);

        long x = (long) Math.sqrt(number);
        long y = 0;
        long r = x * x - y * y - number;

        while (true) {
            if (r == 0) {
                long g = x != y ? x - y : x + y;

                resultNumberMultiplierHolder.setMultiplier((int) g);
                return resultNumberMultiplierHolder;
            } else {
                if (r > 0) {
                    r -= y + y + 1;
                    ++y;
                } else {
                    r += x + x + 1;
                    ++x;
                }
            }
        }
    }

}
