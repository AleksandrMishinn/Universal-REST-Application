package com.andersenlab.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.io.File;


public class EmbeddedTomcat {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        tomcat.setPort(8080);

        String docBase = new File(".").getAbsolutePath();

        Context context = tomcat.addContext("", docBase);

        HttpServlet servlet = new TestServlet();

        String servletName = "Servlet1";
        String urlPattern = "/test";

        tomcat.addServlet("", servletName, servlet);
        context.addServletMappingDecoded(urlPattern, servletName);

        tomcat.start();
        tomcat.getServer().await();
    }
}
