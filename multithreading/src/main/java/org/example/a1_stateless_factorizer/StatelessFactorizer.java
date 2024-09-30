package org.example.a1_stateless_factorizer;


import javax.servlet.*;
import java.math.BigInteger;

public class StatelessFactorizer extends GenericServlet implements Servlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        var i = extractFromRequest(servletRequest);
        var factors = factor(i);
        encodeIntoResponse(servletResponse, factors);
    }

    private BigInteger extractFromRequest(ServletRequest servletRequest) {
        return new BigInteger("7");
    }

    private BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }
}
