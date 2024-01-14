package Controllers;

import Models.Player;
import Models.Team;
import Service.PlayerService;
import Service.TeamService;
import com.example.csa_lr_1.HelloServlet;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/teams")
public class TeamController extends HelloServlet {
    @EJB
    private TeamService teamService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<Team> teams = teamService.getAll();
        request.setAttribute("teamsList", teams);
        try {
           getServletContext().getRequestDispatcher("/teams.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String first_name = request.getParameter("first_name");
        String city_name = request.getParameter("city_name");
        int id_team = Integer.parseInt(request.getParameter("id_team"));

        Team newTeam = new Team();
        newTeam.setFirst_name(first_name);
        newTeam.setCity_name(city_name);
        newTeam.setId_team((long) id_team);
        teamService.save(newTeam);
        doGet(request, response);
    }


}
