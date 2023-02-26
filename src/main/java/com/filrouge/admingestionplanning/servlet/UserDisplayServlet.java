package com.filrouge.admingestionplanning.servlet;

import com.filrouge.admingestionplanning.dao.entities.ERole;
import com.filrouge.admingestionplanning.dao.entities.Role;
import com.filrouge.admingestionplanning.dao.entities.User;
import com.filrouge.admingestionplanning.dao.factory.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/user-details")
public class UserDisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user-details.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String idStr = req.getParameter("idUser");
        User connectedUser = (User) req.getSession().getAttribute("user");
        List<Long> listIdRoleUser = connectedUser.getRoles().stream().map(Role::getId).collect(Collectors.toList());
        boolean canAccess = listIdRoleUser.contains(ERole.ROLE_ADMIN.getId());

        try {
            Long id = Long.parseLong(idStr);
            UserDAO dao = new UserDAO();
            Optional<User> userOptional = dao.get(id);

            if (userOptional.isPresent()) {
                req.setAttribute("canAccess", canAccess);
                req.setAttribute("user", userOptional.get());
                req.getRequestDispatcher("/user-details.jsp").forward(req, resp);
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }
}
