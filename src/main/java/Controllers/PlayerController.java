package Controllers;

import Models.Player;
import Service.PlayerService;
import com.example.csa_lr_1.HelloServlet;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/players")
public class PlayerController extends HelloServlet {
    @EJB
    private PlayerService playerService;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<Player> players = playerService.getAll();
        request.setAttribute("playersList", players);
        try {
            getServletContext().getRequestDispatcher("/players.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        int id_team = Integer.parseInt(request.getParameter("id_team"));

        Player newplayer = new Player();
        newplayer.setFirst_name(first_name);
        newplayer.setLast_name(last_name);
        newplayer.setId_team(id_team);
        playerService.save(newplayer);
        doGet(request, response);
    }
}
