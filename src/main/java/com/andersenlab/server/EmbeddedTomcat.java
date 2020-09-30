package com.andersenlab.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServlet;
import java.io.File;

@Component
public class EmbeddedTomcat {

    private Tomcat tomcat = new Tomcat();

    @PostConstruct
    public void startTomcat() throws LifecycleException {

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

    @PreDestroy
    public void stopTomcat() throws LifecycleException {
        tomcat.stop();
    }

}
