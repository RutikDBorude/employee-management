<%@ page import="com.example.ems.model.Employee" %>
<%
  Employee emp = (Employee) request.getAttribute("employee");
  boolean edit = emp != null;
%>
<!doctype html>
<html>
<head><title><%= edit ? "Edit" : "Add" %> Employee</title></head>
<body>
<h2><%= edit ? "Edit" : "Add New" %> Employee</h2>
<form method="post" action="<%= edit ? "edit" : "add" %>">
  <% if(edit) { %>
    <input type="hidden" name="id" value="<%= emp.getId() %>"/>
  <% } %>
  Name: <input type="text" name="name" value="<%= edit ? emp.getName() : "" %>" required/><br/>
  Email: <input type="email" name="email" value="<%= edit ? emp.getEmail() : "" %>" required/><br/>
  Department: <input type="text" name="department" value="<%= edit ? emp.getDepartment() : "" %>"/><br/>
  Salary: <input type="number" step="0.01" name="salary" value="<%= edit ? emp.getSalary() : "" %>" required/><br/>
  <button type="submit"><%= edit ? "Update" : "Add" %></button>
</form>
<a href="employees">Back to list</a>
</body>
</html>
