package com.example.app.servlet;

import com.example.app.dao.UserDao;  // This line is required to use UserDao
import com.example.app.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private UserDao userDao = new UserDao(); // Initializes UserDao for database operations

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userDao.saveUser(user); // Call saveUser method from UserDao to save the user data
        response.sendRedirect("index.jsp");
    }
}

