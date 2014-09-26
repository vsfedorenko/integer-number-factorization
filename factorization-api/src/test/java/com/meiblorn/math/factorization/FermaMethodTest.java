package com.meiblorn.math.factorization;

/**
 * @author Meiblorn on 11/09/14.
 */
public class FermaMethodTest extends BaseFactorizationTest {

    @Override
    public FactorizationMethod getFactorizationMethod() {
        return new FermaMethod();
    }
}
