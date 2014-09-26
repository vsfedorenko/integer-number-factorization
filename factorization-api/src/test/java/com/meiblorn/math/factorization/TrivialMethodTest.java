package com.meiblorn.math.factorization;

public class TrivialMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new TrivialMethod();
    }
}