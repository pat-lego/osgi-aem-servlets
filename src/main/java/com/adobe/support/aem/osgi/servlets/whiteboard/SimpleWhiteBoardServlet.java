package com.adobe.support.aem.osgi.servlets.whiteboard;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

import com.adobe.support.aem.osgi.servlets.SupportServletContext;

@Component(service = { Servlet.class }, property = {
        HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/whiteboard/*",
        HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_SELECT +
                "=("
                + HttpWhiteboardConstants.HTTP_WHITEBOARD_CONTEXT_NAME + "=" + SupportServletContext.CONTEXT_NAME +
                ")"
})
public class SimpleWhiteBoardServlet extends HttpServlet {

   

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        try(Writer writer = response.getWriter()) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/plain");
            writer.write("Hello World");
        }
    }

}
