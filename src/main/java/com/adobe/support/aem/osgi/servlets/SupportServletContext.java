package com.adobe.support.aem.osgi.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.context.ServletContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = ServletContextHelper.class, property = {
    "osgi.http.whiteboard.context.name=" + SupportServletContext.CONTEXT_NAME,
    "osgi.http.whiteboard.context.path=/support"
})
public class SupportServletContext extends ServletContextHelper {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String CONTEXT_NAME = "com.patlego.support.whiteboard.test";

    @Override
    public boolean handleSecurity(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equals("/support/pat")) {
            logger.warn("No Pat's allowed!");
            return false;
        } else {
            return true;
        }
    }
}