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
import java.util.Optional;

@WebServlet(urlPatterns = "/update-user")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/update-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String idStr = req.getParameter("idUser");
        String pseudo = req.getParameter("userPseudo");
        String email = req.getParameter("userEmail");
        String nom = req.getParameter("userNom");
        String prenom = req.getParameter("userPrenom");
        String typeStr = req.getParameter("userType");
        String password = req.getParameter("userPassword");
        String img = req.getParameter("userImg");

        try {
            Long id = Long.parseLong(idStr);
            int type = Integer.parseInt(typeStr);
            User user = new User(id, type, pseudo, email, nom, prenom, password, img);
            UserDAO userDao = new UserDAO();

            if (userDao.get(id).isPresent()) {
                userDao.update(user);
                resp.sendRedirect(req.getContextPath() + "/user-list");
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}
