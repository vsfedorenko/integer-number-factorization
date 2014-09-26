package com.meiblorn.math.factorization;

import com.meiblorn.math.factorization.impl.PollardMonteCarloMethod;

public class PollardMonteCarloMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardMonteCarloMethod();
    }
}