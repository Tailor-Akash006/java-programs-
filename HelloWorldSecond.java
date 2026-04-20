package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple Java Servlet that displays "Hello World" and the current server time.
 * Access URL: http://localhost:8080/ProjectName/HelloWorldSecond
 */
@WebServlet("/HelloWorldSecond")
public class HelloWorldSecond extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloWorldSecond() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Set the response content type to HTML
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        // 2. Generate the HTML output
        out.println("<html>");
        out.println("<head><title>Servlet Time Demo</title></head>");
        out.println("<body>");
        out.println("<h2 style='color:blue;'>Hello World!!!</h2>");
        out.println("<p style='color:magenta;'>The server time is: " + new Date() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delegate POST requests to doGet for consistent behavior
        doGet(request, response);
    }
}