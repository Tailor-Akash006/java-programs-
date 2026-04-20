<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Session Activated</title></head>
<body style="font-family: Arial; padding: 40px;">
    <%
        String name = request.getParameter("uname");
        String timeStr = request.getParameter("timeout");
        
        if (name != null && timeStr != null) {
            int minutes = Integer.parseInt(timeStr);
            int seconds = minutes * 60; // Convert minutes to seconds for the API
            
            // Store data in session
            session.setAttribute("user_name", name);
            session.setAttribute("user_time", timeStr);
            
            // Set the dynamic interval
            session.setMaxInactiveInterval(seconds);
            
            out.print("<h2 style='color:green;'>Hello " + name + "!</h2>");
            out.print("The session has started for <b>" + minutes + " minute(s)</b>.");
            out.print("<br>Stored Name: " + name);
            out.print("<br>Stored Expiry: " + minutes + " min(s)");
        }
    %>
    <br><br>
    <p>Press the link below to verify the session status within the time limit or wait to see it expire.</p>
    <a href="check_status.jsp" style="display: inline-block; padding: 10px; background: #3498db; color: white; text-decoration: none; border-radius: 5px;">Check Session Status</a>
</body>
</html>