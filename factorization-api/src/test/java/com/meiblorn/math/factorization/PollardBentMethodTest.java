package com.meiblorn.math.factorization;

public class PollardBentMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardBentMethod();
    }
}