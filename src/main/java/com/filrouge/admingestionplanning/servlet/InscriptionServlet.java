package com.filrouge.admingestionplanning.servlet;

import com.filrouge.admingestionplanning.dao.entities.User;
import com.filrouge.admingestionplanning.dao.factory.Dao;
import com.filrouge.admingestionplanning.dao.factory.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String name = request.getParameter("name");
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String image = request.getParameter("image");
        String pseudo = request.getParameter("pseudo");
        String type = request.getParameter("type");

        UserDAO userdao = new UserDAO();
        User user = new User(name, firstName, email, password, image, pseudo, type);
        userdao.create(user);

        resp.sendRedirect(request.getContextPath() + "/home");
    }
}
