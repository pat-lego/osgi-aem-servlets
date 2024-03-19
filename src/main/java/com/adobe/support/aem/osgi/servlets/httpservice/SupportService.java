package com.adobe.support.aem.osgi.servlets.httpservice;

import javax.servlet.http.HttpServlet;

public interface SupportService {
    
    /**
     * Return the URL for the servlet
     */
    public String getAlias();


    public HttpServlet getServlet();
}
