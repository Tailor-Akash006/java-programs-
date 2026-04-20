package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processUser")
public class UserDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Retrieve parameters
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        String message;
        
        // 2. Simple Validation
        if (username == null || username.trim().isEmpty()) {
            message = "Error: Username is required";
        } else {
            message = "User data processed successfully";
            
            // 3. Set Attributes for the JSP
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("designation", designation);
        }
        
        request.setAttribute("message", message);

        // 4. Forward to result.jsp (URL stays /processUser)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect GET requests back to the form
        response.sendRedirect("index.jsp");
    }
}