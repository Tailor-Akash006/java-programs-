<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Status Check</title></head>
<body style="font-family: Arial; padding: 40px;">
    <h1>Session Status Verification</h1>
    <hr>
    <%
        String name = (String) session.getAttribute("user_name");
        String time = (String) session.getAttribute("user_time");

        if (name == null) {
    %>
            <div style="color: white; background: #e74c3c; padding: 20px; border-radius: 5px;">
                <h2>SESSION EXPIRED</h2>
                <p>The time limit has passed. Data has been cleared from the server.</p>
                <a href="index.jsp" style="color: white;">Try Again</a>
            </div>
    <%
        } else {
    %>
            <div style="color: white; background: #27ae60; padding: 20px; border-radius: 5px;">
                <h2>SESSION ACTIVE</h2>
                <p>Welcome back, <b><%= name %></b>!</p>
                <p>This session was configured for <%= time %> minute(s).</p>
                <a href="check_status.jsp" style="color: white;">Refresh to Keep Alive</a>
            </div>
    <%
        }
    %>
</body>
</html>