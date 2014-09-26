package com.meiblorn.math.factorization;

public class PollardP1MethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardP1Method();
    }
}