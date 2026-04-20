<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Check Session Status</title>
</head>
<body>
    <h1>Session Value Verification</h1>
    <%
        // Retrieve value from session
        String name = (String) session.getAttribute("user");
        
        if(name == null) {
            out.print("<h2 style='color:red;'>Sorry, the session has ended (Expired).</h2>");
            out.print("<a href='index.html'>Go back to Login</a>");
        } else {
            out.print("<h2 style='color:green;'>Hello " + name + "!</h2>");
            out.print("<p>The session is still active.</p>");
            out.print("<a href='second.jsp'>Refresh to check again</a>");
        }
    %>
</body>
</html>