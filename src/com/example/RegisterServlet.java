package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class RegisterServlet extends HttpServlet {
    // Static and thread-safe user map
    private static final Map<String, String> users = Collections.synchronizedMap(new HashMap<>());

    // Getter for shared user data
    public static Map<String, String> getUsers() {
        return users;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate input
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("message", "Username and password are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        synchronized (users) {
            // Check if username already exists
            if (users.containsKey(username)) {
                request.setAttribute("message", "Username already exists. Please choose another.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                // Register the user
                users.put(username, password);
                request.setAttribute("message", "Registration successful! Please log in.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
