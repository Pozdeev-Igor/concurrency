package org.example.b3_one_value_cache;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class OneValueCacheTest {

    @Test
    void getFactorsTest() {
        var factors = new BigInteger[]{BigInteger.TEN, BigInteger.TWO};
        var oneValueCache = new OneValueCache(BigInteger.ONE, factors);

        assertEquals(oneValueCache.getFactors(BigInteger.ONE).length, factors.length);
        assertNull(oneValueCache.getFactors(BigInteger.TWO));
        assertNull(oneValueCache.getFactors(null));
    }

    @Test
    void getFactorsTestNull() {
        var factors = new BigInteger[]{BigInteger.TEN, BigInteger.TWO};
        var oneValueCache = new OneValueCache(null, factors);

        assertNull(oneValueCache.getFactors(BigInteger.ONE));
    }
}