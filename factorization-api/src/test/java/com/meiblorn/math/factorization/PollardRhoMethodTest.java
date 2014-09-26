package com.meiblorn.math.factorization;

import com.meiblorn.math.factorization.impl.PollardRhoMethod;

public class PollardRhoMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardRhoMethod();
    }
}