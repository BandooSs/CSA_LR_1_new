<%@ page import="java.util.List" %>
<%@ page import="Models.Team" %>

Created by IntelliJ IDEA.
  User: nikit
  Date: 07.01.2024
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Teams</title>
</head>
<body>
<h1><%= "The teams page:" %>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>City Name</th>

        </tr>
        </thead>
        <tbody>
        <%
            List<Team> teamList = (List<Team>)request.getAttribute("teamsList");
            for (Team team : teamList) {
        %>
        <tr>
            <td><%= team.getId_team() %></td>
            <td><%= team.getFirst_name() %></td>
            <td><%= team.getCity_name() %></td>

        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <form action="teams" method="post">
        <label for="first_name">first_name:</label>
        <input type="text" id="first_name" name="first_name" required>
        <br>
        <label for="city_name">city_name:</label>
        <input type="text" id="city_name" name="city_name" required>
        <br>
        <input type="submit" value="Add Team">
    </form>
</body>
</html>
