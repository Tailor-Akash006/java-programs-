<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Mark Entry</title>
    <style>
        body { font-family: Arial; background-color: #f4f4f4; padding: 20px; }
        .form-container { background: white; padding: 25px; width: 400px; margin: auto; border-radius: 8px; box-shadow: 0px 0px 10px #ccc; }
        input { width: 90%; padding: 8px; margin: 10px 0; }
        label { font-weight: bold; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Student Result Portal</h2>
        <form action="ResultServlet" method="POST">
            <label>Roll No:</label>
            <input type="text" name="rollno" required>
            
            <label>Student Name:</label>
            <input type="text" name="sname" required>
            
            <label>Marks (0-100):</label>
            <input type="number" name="sub1" placeholder="Subject 1" min="0" max="100" required>
            <input type="number" name="sub2" placeholder="Subject 2" min="0" max="100" required>
            <input type="number" name="sub3" placeholder="Subject 3" min="0" max="100" required>
            <input type="number" name="sub4" placeholder="Subject 4" min="0" max="100" required>
            <input type="number" name="sub5" placeholder="Subject 5" min="0" max="100" required>
            
            <input type="submit" value="Calculate Result" style="background: #28a745; color: white; border: none; cursor: pointer;">
        </form>
    </div>
</body>
</html>