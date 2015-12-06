package com.soneca.wmtest.api.bootstrap;

/**
 * @author andre
 * @since 06/12/2015 12:11
 */
public class App {


    public static void main(String[] args) throws Exception {
        /*ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "*//*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                RouteEntrypoint.class.getCanonicalName());




        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }*/
    }



}
