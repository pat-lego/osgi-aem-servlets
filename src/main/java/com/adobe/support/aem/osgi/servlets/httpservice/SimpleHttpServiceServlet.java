package com.adobe.support.aem.osgi.servlets.httpservice;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = { SupportService.class }, immediate = true,
property = {
    "osgi.servletType=" + SimpleHttpServiceServlet.TYPE
})
public class SimpleHttpServiceServlet extends HttpServlet implements SupportService {

    public static final  String TYPE = "support";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Invoking the Http Servlet Service");
        try (Writer writer = resp.getWriter()) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("text/plain");
            writer.write("Hello from the Http Service");
        }
   
    }

    @Override
    public String getAlias() {
        return "/httpservice";
    }

    @Override
    public HttpServlet getServlet() {
        return this;
    }
}
