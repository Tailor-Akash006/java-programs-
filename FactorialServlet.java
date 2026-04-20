package com.factorial;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            // 1. Get and Validate Input
            String input = request.getParameter("number");
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }
            
            int number = Integer.parseInt(input);

            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }
            if (number > 20) {
                throw new IllegalArgumentException("Number too large (Max allowed is 20)");
            }

            // 2. Calculate Factorial
            long factorial = 1;
            StringBuilder calculation = new StringBuilder("Calculation steps:<br>");
            
            if (number == 0 || number == 1) {
                calculation.append(number).append("! = 1");
            } else {
                calculation.append(number).append("! = ");
                for (int i = number; i >= 1; i--) {
                    factorial *= i;
                    calculation.append(i).append(i > 1 ? " × " : "");
                }
                calculation.append(" = ").append(factorial);
            }

            // 3. Generate HTML Result
            out.println("<html><head><title>Factorial Result</title>");
            out.println("<style>.container { margin: 20px; padding: 20px; width: 500px; " +
                        "border: 1px solid #ccc; border-radius: 5px; font-family: Arial; }</style>");
            out.println("</head><body><div class='container'>");
            out.println("<h2>Result</h2>");
            out.println("<p><b>Number:</b> " + number + "</p>");
            out.println("<p><b>Factorial:</b> " + factorial + "</p>");
            out.println("<p>" + calculation.toString() + "</p>");
            out.println("<br><a href='index.html'>Go Back</a>");
            out.println("</div></body></html>");

        } catch (NumberFormatException e) {
            displayError(out, "Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    private void displayError(PrintWriter out, String message) {
        out.println("<html><body><div style='color: red; margin: 20px;'>");
        out.println("<h2>Input Error</h2><p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</div></body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirecting GET requests to the form page
        response.sendRedirect("index.html");
    }
}