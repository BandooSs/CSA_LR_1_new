<%@ page import="java.util.List" %>
<%@ page import="Models.Player" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Players</title>
</head>
<body>
<h1><%= "The players page:" %></h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Team ID</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Player> playersList = (List<Player>)request.getAttribute("playersList");
        for (Player player : playersList) {
    %>
    <tr>
        <td><%= player.getId_player() %></td>
        <td><%= player.getFirst_name() %></td>
        <td><%= player.getLast_name() %></td>
        <td><%= player.getId_team() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<form action="players" method="post">
    <label for="first_name">first_name:</label>
    <input type="text" id="first_name" name="first_name" required>
    <br>
    <label for="last_name">last_name:</label>
    <input type="text" id="last_name" name="last_name" required>
    <br>
    <label for="id_team">id_team:</label>
    <input type="number" id="id_team" name="id_team" required>
    <br>
    <input type="submit" value="Add Player">
</form>
</body>
</html>
