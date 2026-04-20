package com.sessiontracking;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get current session or create a new one
        HttpSession session = request.getSession(true);
        
        // 2. Set session expiry to 60 seconds (1 minute)
        session.setMaxInactiveInterval(60);

        // 3. Retrieve Session Metadata
        String sessionId = session.getId();
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        // 4. Logic for Visit Count
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        session.setAttribute("visitCount", visitCount);

        // 5. Generate HTML Response directly from Servlet
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html><head><title>Lab 9a: Servlet Session</title></head>");
        out.println("<body style='font-family: Arial; margin: 40px;'>");
        out.println("<h2 style='color: #2c3e50;'>Session Tracking Information</h2>");
        out.println("<div style='border: 1px solid #ddd; padding: 20px; width: 500px;'>");
        out.println("<p><b>Session ID:</b> " + sessionId + "</p>");
        out.println("<p><b>Creation Time:</b> " + createTime + "</p>");
        out.println("<p><b>Last Access Time:</b> " + lastAccessTime + "</p>");
        out.println("<p><b>Visit Count:</b> <span style='color:red;'>" + visitCount + "</span></p>");
        out.println("</div>");
        out.println("<br><p><i>Note: Session will expire after 60 seconds of inactivity.</i></p>");
        out.println("<button onclick='location.reload()'>Refresh Page</button>");
        out.println("</body></html>");
    }
}