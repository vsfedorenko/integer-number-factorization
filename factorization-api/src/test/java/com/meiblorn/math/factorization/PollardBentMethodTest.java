package com.meiblorn.math.factorization;

import com.meiblorn.math.factorization.impl.PollardBentMethod;

public class PollardBentMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new PollardBentMethod();
    }
}