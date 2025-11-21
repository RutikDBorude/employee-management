package com.example.ems.servlet;

import com.example.ems.dao.EmployeeDAO;
import com.example.ems.model.Employee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee e = dao.getById(id);
        req.setAttribute("employee", e);
        req.getRequestDispatcher("/employee-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee e = new Employee();
        e.setId(id);
        e.setName(req.getParameter("name"));
        e.setEmail(req.getParameter("email"));
        e.setDepartment(req.getParameter("department"));
        try { e.setSalary(Double.parseDouble(req.getParameter("salary"))); } catch(Exception ex) {}
        dao.update(e);
        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}
