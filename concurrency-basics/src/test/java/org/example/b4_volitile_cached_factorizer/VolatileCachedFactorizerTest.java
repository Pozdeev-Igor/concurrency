package org.example.b4_volitile_cached_factorizer;

import org.example.b3_one_value_cache.OneValueCache;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

class VolatileCachedFactorizerTest {

    @Test
    void serviceTest() {
        ServletRequest servletRequest = new ServletRequestImpl();
        ServletResponse servletResponse = new ServletResponseImpl();
        var cache = new OneValueCache(null, new BigInteger[]{BigInteger.TEN});
        var factorizer = new VolatileCachedFactorizer(cache);

        factorizer.service(servletRequest, servletResponse);
    }

}