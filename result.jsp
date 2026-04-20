<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result Display</title>
    <style>
        .res-box { width: 400px; margin: 50px auto; border: 1px solid #000; padding: 20px; font-family: sans-serif; }
        .pass { color: green; font-weight: bold; }
        .fail { color: red; font-weight: bold; }
    </style>
</head>
<body>
    <div class="res-box">
        <h2>Student Marksheet</h2>
        <hr>
        <p><b>Roll No:</b> <%= request.getAttribute("rollno") %></p>
        <p><b>Name:</b> <%= request.getAttribute("name") %></p>
        <p><b>Average Marks:</b> <%= request.getAttribute("avg") %>%</p>
        
        <p><b>Final Status:</b> 
            <span class="<%= request.getAttribute("result").equals("PASS") ? "pass" : "fail" %>">
                <%= request.getAttribute("result") %>
            </span>
        </p>
        <hr>
        <a href="index.jsp">Calculate Another Result</a>
    </div>
</body>
</html>