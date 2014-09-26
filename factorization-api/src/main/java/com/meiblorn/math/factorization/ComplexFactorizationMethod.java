package com.meiblorn.math.factorization;

import com.meiblorn.math.domain.NumberMultiplierHolder;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Meiblorn on 11/09/14.
 */
public class ComplexFactorizationMethod {

    private static final TrivialMethod TRIVIAL_METHOD = new TrivialMethod();

    private static final PollardMonteCarloMethod POLLARD_MONTE_CARLO_METHOD = new PollardMonteCarloMethod();

    private static final PollardRhoMethod POLLARD_RHO_METHOD = new PollardRhoMethod();

    private static final PollardBentMethod POLLARD_BENT_METHOD = new PollardBentMethod();

    private static final PollardP1Method POLLARD_P_1_METHOD = new PollardP1Method();

    private static final FermaMethod FERMA_METHOD = new FermaMethod();

    private static final List<FactorizationMethod> FACTORIZATION_METHODS_CHAIN = new ArrayList<FactorizationMethod>(Arrays.asList(
            POLLARD_MONTE_CARLO_METHOD,
            POLLARD_RHO_METHOD,
            POLLARD_P_1_METHOD,
            POLLARD_BENT_METHOD,
            FERMA_METHOD
    ));


    public Map<Integer, Integer> getMultipliersFor(int number) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        getMultipliersFor(number, resultMap);
        return resultMap;
    }

    private void getMultipliersFor(int number, Map<Integer, Integer> resultMap) {
        NumberMultiplierHolder currentNumberMultiplierHolder = null;
        if (number == 1) {
            resultMap.put(1, 1);
            return;
        }

        if (new BigInteger(String.valueOf(number)).isProbablePrime(100)) {
            incrementOrAddResultMap(resultMap, number);
            return;
        }

        if (number < 1000 * 1000) {
            currentNumberMultiplierHolder = TRIVIAL_METHOD.getMultipliersPairFor(number);
            int div = currentNumberMultiplierHolder.getMultiplier() != 1
                    ? currentNumberMultiplierHolder.getMultiplier()
                    : currentNumberMultiplierHolder.getNumber();

            incrementOrAddResultMap(resultMap, div);

            getMultipliersFor(number / div, resultMap);
        } else {
            for (FactorizationMethod factorizationMethod : FACTORIZATION_METHODS_CHAIN) {
                currentNumberMultiplierHolder = factorizationMethod.getMultipliersPairFor(number);
                if (currentNumberMultiplierHolder.getMultiplier() != 1) {
                    break;
                }
            }

            if (currentNumberMultiplierHolder != null) {
                getMultipliersFor(currentNumberMultiplierHolder.getMultiplier(), resultMap);
                getMultipliersFor(number / currentNumberMultiplierHolder.getMultiplier(), resultMap);
            }
        }
    }

    private void incrementOrAddResultMap(Map<Integer, Integer> resultMap, int number) {
        if (!resultMap.containsKey(number)) {
            resultMap.put(number, 0);
        }

        resultMap.put(
                number, resultMap.get(number) + 1
        );
    }

}