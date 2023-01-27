package com.filrouge.admingestionplanning.servlet;

import com.filrouge.admingestionplanning.dao.entities.User;
import com.filrouge.admingestionplanning.dao.factory.Dao;
import com.filrouge.admingestionplanning.dao.factory.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/sign-in")
public class signInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.sendRedirect("sign-in.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String pseudo = req.getParameter("userPseudo");
        String email = req.getParameter("userEmail");
        String nom = req.getParameter("userNom");
        String prenom = req.getParameter("userPrenom");
        String password = req.getParameter("userPassword");

        User user = new User(0, pseudo, email, nom, prenom, password, "");
        Dao<User> UserDAO = new UserDAO();
        UserDAO.create(user);

        resp.sendRedirect(req.getContextPath() + "/sign-in-success.jsp");

    }

}
