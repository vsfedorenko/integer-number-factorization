package com.meiblorn.math.factorization;

import com.meiblorn.math.factorization.impl.TrivialMethod;

public class TrivialMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new TrivialMethod();
    }
}