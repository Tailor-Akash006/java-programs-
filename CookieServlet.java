package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Global counter (tracks visits across the entire server session)
    int count = 0; 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Check for name in URL parameters (Initial Login)
        String userName = request.getParameter("userName");
        if (userName != null && !userName.isEmpty()) {
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(30); // Cookie valid for 30 seconds
            response.addCookie(userCookie);
            
            // Redirect to itself to clear the parameter from URL and show "Welcome Back"
            response.sendRedirect("CookieServlet");
            return;
        }

        // 2. Read existing cookies to identify user
        Cookie[] cookies = request.getCookies();
        String existingUser = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                    break;
                }
            }
        }

        // 3. Generate HTML Response
        out.println("<html><head><title>Session Tracking with Cookies</title></head><body>");

        if (existingUser != null) {
            count++; // Increment visit count
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h2 style='color:magenta;'>You have visited this page " + count + " times!</h2>");
            
            // Add a Logout Button
            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout and Clear Cookie'>");
            out.println("</form>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please log in.</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName' required>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 4. Logout Logic: Delete the cookie by setting MaxAge to 0
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); 
        response.addCookie(cookie);
        
        // Reset count if you want logout to reset the counter for this demo
        // count = 0; 

        response.sendRedirect("CookieServlet");
    }
}