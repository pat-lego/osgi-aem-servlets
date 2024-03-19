package com.adobe.support.aem.osgi.servlets.httpservice;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = HttpContext.class, property = {
    "osgi.servletContext=" + SimpleHttpServiceHttpContext.CONTEXT
})
public class SimpleHttpServiceHttpContext implements HttpContext {

    public static final String CONTEXT = "support";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handleSecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("Handling security for path {}", request.getRequestURL());
        return true;
    }

    @Override
    public URL getResource(String name) {
        return null;
    }

    @Override
    public String getMimeType(String name) {
        return "text/plain";
    }
    
}
