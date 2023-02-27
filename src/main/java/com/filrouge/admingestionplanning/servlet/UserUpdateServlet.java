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
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/update-user")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/update-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        User connectedUser = (User) req.getSession().getAttribute("user");
        List<Long> listIdRoleUser = connectedUser.getRoles().stream().map(Role::getId).collect(Collectors.toList());
        boolean canAccess = listIdRoleUser.contains(ERole.ROLE_ADMIN.getId());

        String idStr = req.getParameter("idUser");
        Long id = Long.parseLong(idStr);

        String username = req.getParameter("userPseudo");
        String email = req.getParameter("userEmail");
        String nom = req.getParameter("userNom");
        String prenom = req.getParameter("userPrenom");

        long roleSelect = 1L;
        if (canAccess){
            roleSelect = Long.parseLong(req.getParameter("userType"));
        }

        String password = req.getParameter("userPassword");
        String hashed = null;
        if (password.isEmpty()){
            UserDAO dao = new UserDAO();
            Optional<User> userOptional = dao.get(id);
            if (userOptional.isPresent()){
                hashed = userOptional.get().getPassword();
            }
        }else {
            hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        }

        String img = req.getParameter("userImg");

        Set<Role> role = new HashSet<>();
        role.add(ERole.getRoleById(roleSelect));

        try {
            User user = new User(id, username, email, nom, prenom, hashed, img, role);

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