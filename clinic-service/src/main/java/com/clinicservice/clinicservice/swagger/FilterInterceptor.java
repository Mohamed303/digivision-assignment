package com.clinicservice.clinicservice.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FilterInterceptor implements Filter {
    private static final Logger logger = LoggerFactory.getLogger("default-logger");

    @Override
    public void init(FilterConfig fc) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        StringBuilder message = new StringBuilder();

        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");

        message.append("Request   ").append( request.getMethod() ).append(  request.getRequestURL().toString()).append("\n");
        logger.info(message.toString());

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            message.append("Response  ").append(((HttpServletResponse) resp).getStatus());

            logger.info(message.toString());
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {
    }


}
