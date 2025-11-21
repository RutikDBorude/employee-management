<%@ page import="java.util.List" %>
<%@ page import="com.example.ems.model.Employee" %>
<%
  List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<!doctype html>
<html>
<head><title>Employees</title></head>
<body>
<h2>Employee List</h2>
<a href="employee-form.jsp">Add New Employee</a>
<table border="1" cellpadding="6" style="margin-top:10px;">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Dept</th><th>Salary</th><th>Actions</th></tr>
<% if(employees != null) { for(Employee e : employees) { %>
  <tr>
    <td><%=e.getId()%></td>
    <td><%=e.getName()%></td>
    <td><%=e.getEmail()%></td>
    <td><%=e.getDepartment()%></td>
    <td><%=e.getSalary()%></td>
    <td>
      <a href="edit?id=<%=e.getId()%>">Edit</a> |
      <a href="delete?id=<%=e.getId()%>" onclick="return confirm('Delete?')">Delete</a>
    </td>
  </tr>
<% }} %>
</table>
</body>
</html>
