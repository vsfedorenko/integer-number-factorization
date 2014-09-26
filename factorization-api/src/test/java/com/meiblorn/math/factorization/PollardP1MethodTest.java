package com.meiblorn.math.factorization;

import com.meiblorn.math.factorization.impl.PollardP1Method;

public class PollardP1MethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardP1Method();
    }
}