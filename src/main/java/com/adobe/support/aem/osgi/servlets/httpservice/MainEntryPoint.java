package com.adobe.support.aem.osgi.servlets.httpservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
public class MainEntryPoint {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(target = "(osgi.servletType=" + SimpleHttpServiceServlet.TYPE
            + ")", cardinality = ReferenceCardinality.AT_LEAST_ONE, bind = "bindSupportServices", unbind = "unbindSupportServices")
    List<SupportService> supportServices;

    @Reference
    private HttpService httpService;

    @Activate
    public void activate() throws ServletException, NamespaceException {
        for (SupportService supportService : supportServices) {
            this.httpService.registerServlet(supportService.getAlias(), supportService.getServlet(), null, null);
        }

    }

    public void bindSupportServices(SupportService supportService) {
        if (this.supportServices == null) {
            this.supportServices = new ArrayList<>();
        }
        this.supportServices.add(supportService);
    }

    public void unbindSupportServices(SupportService supportService) {
        if (this.supportServices == null) {
            return;
        }
        this.supportServices.remove(supportService);
    }
}
