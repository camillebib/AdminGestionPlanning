package com.filrouge.admingestionplanning.servlet;

import com.filrouge.admingestionplanning.dao.entities.User;
import com.filrouge.admingestionplanning.dao.factory.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user-list")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User connectedUser = (User) req.getSession().getAttribute("user");
        if (connectedUser == null || connectedUser.getType() == 0){
            resp.sendRedirect("login.jsp");
            return;
        }
        UserDAO dao = new UserDAO();
        List<User> userList = dao.getAll();

        req.setAttribute("users", userList);
        req.getRequestDispatcher("/user-list.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    }
}
