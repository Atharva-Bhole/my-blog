package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Access the shared user map from RegisterServlet
        Map<String, String> users = RegisterServlet.getUsers();

        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate input
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("message", "Username and password are required.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        synchronized (users) {
            // Authenticate user
            if (users.containsKey(username) && users.get(username).equals(password)) {
                // Create a session and store user information
                HttpSession session = request.getSession();
                session.setAttribute("user", username);

                // Redirect to the blog page
                response.sendRedirect("blog.jsp");
            } else {
                // Send an error message back to the login page
                request.setAttribute("message", "Invalid username or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
