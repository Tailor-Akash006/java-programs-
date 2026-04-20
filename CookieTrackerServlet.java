package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieTrackerServlet")
public class CookieTrackerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Get Name from Form
        String name = request.getParameter("userName");
        
        // 2. Manage Visit Count Cookie
        int visitCount = 0;
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }
        visitCount++;

        // 3. Create/Update Cookies
        Cookie nameCookie = new Cookie("user_name", name);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));
        
        // Demonstrate Expiry: Set to 45 seconds
        nameCookie.setMaxAge(45); 
        countCookie.setMaxAge(45);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // 4. Generate Response
        out.println("<html><body style='font-family: Arial; padding: 20px;'>");
        out.println("<h2 style='color: green;'>Welcome back, " + name + "!</h2>");
        out.println("<h3>You have visited this page <span style='color:red;'>" + visitCount + "</span> times.</h3>");
        out.println("<p><i>Note: These cookies will expire in 45 seconds of inactivity.</i></p>");
        
        out.println("<hr><h4>List of Active Cookies:</h4>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Cookie Name</th><th>Stored Value</th></tr>");
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }
        }
        out.println("</table>");
        
        out.println("<br><br><a href='index.html'>Go back to Login</a>");
        out.println("</body></html>");
    }

    // Handle GET so refreshes don't break the page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}