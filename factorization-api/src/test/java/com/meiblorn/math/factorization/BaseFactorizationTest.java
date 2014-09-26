package com.meiblorn.math.factorization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meiblorn.math.domain.NumberMultiplierHolder;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Meiblorn on 11/09/14.
 */
public abstract class BaseFactorizationTest {

    private static Gson gson = new Gson();

    protected abstract FactorizationMethod getFactorizationMethod();

    protected String getTestCaseFile() {
        return "factorization-test-cases.json";
    }

    @Test
    public void testGetFactorizationForNumber() throws Exception {
        List<NumberMultiplierHolder> numberMultiplierHolderList = gson.fromJson(
                new InputStreamReader(getClass().getResourceAsStream(getTestCaseFile())),
                new TypeToken<List<NumberMultiplierHolder>>(){}.getType()
        );

        for (NumberMultiplierHolder expectedNumberMultiplierHolder : numberMultiplierHolderList) {
            NumberMultiplierHolder actualNumberMultiplierHolder = getFactorizationMethod().getMultipliersPairFor(
                    expectedNumberMultiplierHolder.getNumber()
            );

            assertEquals(expectedNumberMultiplierHolder.getNumber(), actualNumberMultiplierHolder.getNumber());
            assertEquals(expectedNumberMultiplierHolder.getMultiplier(), actualNumberMultiplierHolder.getMultiplier());
        }
    }


}
