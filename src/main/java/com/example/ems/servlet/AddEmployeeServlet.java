package com.example.ems.servlet;

import com.example.ems.dao.EmployeeDAO;
import com.example.ems.model.Employee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
    private final EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String dept = req.getParameter("department");
        double salary = 0;
        try { salary = Double.parseDouble(req.getParameter("salary")); } catch (Exception ex) {}
        Employee e = new Employee(name, email, dept, salary);
        dao.add(e);
        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}
