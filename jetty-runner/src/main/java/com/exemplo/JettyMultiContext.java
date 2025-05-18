package com.exemplo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyMultiContext {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext api = new WebAppContext();
        api.setContextPath("/api");
        api.setWar("../token-jwt/target/token-jwt-1.0-SNAPSHOT.war");

        WebAppContext admin = new WebAppContext();
        admin.setContextPath("/admin");
        admin.setWar("../admin-frontend/target/admin-frontend-1.0-SNAPSHOT.war");

        HandlerCollection handlers = new HandlerCollection();
        handlers.addHandler(api);
        handlers.addHandler(admin);

        server.setHandler(handlers);
        server.start();
        server.join();
    }
}