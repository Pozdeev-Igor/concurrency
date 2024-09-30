package org.example.a2_unsafe_factorizer;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * ТАК ДЕЛАТЬ НЕ СЛЕДУЕТ
 * <br>
 * <br>
 * Этот сервлет непотокобезопасный, потому что имеет состояние, которое может изменяться
 */
public class UnsafeCountingFactorizer extends GenericServlet implements Servlet {

    private long count = 0;

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }

    public long getCount() {
        return count;
    }
}
