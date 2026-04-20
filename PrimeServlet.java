package com.lab;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String input = request.getParameter("num");

        try {
            // 1. Validate if input is a number
            int n = Integer.parseInt(input);

            // 2. Validate if number is positive (Handling Invalid Input with Error Code)
            if (n < 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Negative numbers cannot be prime.");
                return;
            }

            // 3. Logic for Prime Number
            boolean isPrime = true;
            if (n <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // 4. Output the Result
            out.println("<html><body>");
            out.println("<h3>Result for Number: " + n + "</h3>");
            if (isPrime) {
                out.println("<h2 style='color:green;'>It is a Prime Number!</h2>");
            } else {
                out.println("<h2 style='color:red;'>It is NOT a Prime Number.</h2>");
            }
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            // Send Error Code 400 for non-numeric input
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input! Please enter a valid integer.");
        }
    }
}