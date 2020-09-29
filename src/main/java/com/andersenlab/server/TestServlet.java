package com.andersenlab.server;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("<html><title>Welcome</title><body>");
        writer.println("<h1>It's Works!</h1>");
        writer.println("</body></html>");
    }
}
