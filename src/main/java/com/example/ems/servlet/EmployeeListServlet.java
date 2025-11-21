package com.example.ems.servlet;

import com.example.ems.dao.EmployeeDAO;
import com.example.ems.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = dao.getAll();
        req.setAttribute("employees", list);
        req.getRequestDispatcher("/employee-list.jsp").forward(req, resp);
    }
}
