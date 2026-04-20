package com.student;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1. Retrieve Data
            String rollno = request.getParameter("rollno");
            String name = request.getParameter("sname");
            int s1 = Integer.parseInt(request.getParameter("sub1"));
            int s2 = Integer.parseInt(request.getParameter("sub2"));
            int s3 = Integer.parseInt(request.getParameter("sub3"));
            int s4 = Integer.parseInt(request.getParameter("sub4"));
            int s5 = Integer.parseInt(request.getParameter("sub5"));

            // 2. Server-Side Validation
            if(name.trim().isEmpty() || rollno.trim().isEmpty()) {
                throw new Exception("Name and Roll No cannot be empty!");
            }

            // 3. Logic: Calculate Total, Average and Result
            int total = s1 + s2 + s3 + s4 + s5;
            double average = total / 5.0;
            
            // Pass condition: Each subject must be > 40
            String result = (s1 > 40 && s2 > 40 && s3 > 40 && s4 > 40 && s5 > 40) ? "PASS" : "FAIL";

            // 4. Set Attributes for JSP
            request.setAttribute("rollno", rollno);
            request.setAttribute("name", name);
            request.setAttribute("avg", average);
            request.setAttribute("result", result);
            request.setAttribute("marks", new int[]{s1, s2, s3, s4, s5});

            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            response.getWriter().println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
            response.getWriter().println("<a href='index.jsp'>Back</a>");
        }
    }
}