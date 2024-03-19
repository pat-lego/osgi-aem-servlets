# OSGi Based Sevlets

## HttpService

This one is deployed via com.adobe.support.aem.osgi.servlets.httpservice.MainEntryPoint.java and uses the HttpService in OSGi to dynamically register a servlet.

Developers can implement there own HttpContext service and register it with the Servlet to provide means of authentication.

The servlet can be rendered at /httpservice

## Whiteboard

The whiteboard based servlet is registered via com.adobe.support.aem.osgi.servlets.SupportServletContext.java and uses the com.adobe.support.aem.osgi.servlets.whiteboard.SimpleWhiteBoardServlet.java servlet to handle requests.

The whiteboard implementation allows you to isolate the requests to a specific ServletContext which can handleSecurity in its own distinct way.

The servlet can be rendered at /support/whiteboard

## How to see if it is deployed

You can see the registered servlets via 
/system/console/status-httpservice

## How to build

mvn clean install