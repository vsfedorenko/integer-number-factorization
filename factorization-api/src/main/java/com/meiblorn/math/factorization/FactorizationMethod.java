package com.meiblorn.math.factorization;

import com.meiblorn.math.domain.NumberMultiplierHolder;

/**
 * @author Meiblorn on 11/09/14.
 */
public interface FactorizationMethod {

    NumberMultiplierHolder getMultipliersPairFor(int number);

}
