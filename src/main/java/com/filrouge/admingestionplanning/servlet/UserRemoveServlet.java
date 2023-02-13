package com.ajc.pastries.servlet;

import com.filrouge.admingestionplanning.dao.entities.User;
import com.filrouge.admingestionplanning.dao.factory.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/remove-user")
public class UserRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/remove-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String idStr = req.getParameter("idUser");

        try {
            Long id = Long.parseLong(idStr);
            UserDAO dao = new UserDAO();
            Optional<User> user = dao.get(id);

            if (user.isPresent()) {
                dao.delete(user.get());
                resp.sendRedirect(req.getContextPath() + "/user-list");
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

    }
}
