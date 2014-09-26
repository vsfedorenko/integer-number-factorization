package com.meiblorn.math.factorization;

public class PollardRhoMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardRhoMethod();
    }
}