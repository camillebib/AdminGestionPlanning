package com.filrouge.admingestionplanning.servlet;

import com.filrouge.admingestionplanning.dao.entities.ERole;
import com.filrouge.admingestionplanning.dao.entities.Role;
import com.filrouge.admingestionplanning.dao.entities.User;
import com.filrouge.admingestionplanning.dao.factory.Dao;
import com.filrouge.admingestionplanning.dao.factory.UserDAO;
import com.filrouge.admingestionplanning.security.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        Set<Role> role = new HashSet<>();
        role.add(ERole.getRoleById(1L));

        User user = new User(pseudo, email, nom, prenom, hashed, "", role);
        Dao<User> userDao = new UserDAO();

        if (userDao.get(pseudo).isEmpty()){
            userDao.create(user);

            resp.sendRedirect(req.getContextPath() + "/sign-in-success.jsp");
        }else{
            throw new ServletException("User already exists");
        }

    }

}
