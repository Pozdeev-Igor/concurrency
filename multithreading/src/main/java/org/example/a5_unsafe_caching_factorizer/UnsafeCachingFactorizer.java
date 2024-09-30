package org.example.a5_unsafe_caching_factorizer;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ТАК ДЕЛАТЬ НЕ СЛЕДУЕТ
 * <br>
 * <br>
 * Сервлет, пытающийся кэшировать свой последний результат без адекватной атомарности
 * <br>
 * Не смотря на AtomicReference, этот класс содержит race condition
 */
public class UnsafeCachingFactorizer extends GenericServlet implements Servlet {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get()))
            encodeIntoResponse(resp, lastFactors.get());
        else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
