package com.meiblorn.math.factorization;

public class PollardMonteCarloMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardMonteCarloMethod();
    }
}