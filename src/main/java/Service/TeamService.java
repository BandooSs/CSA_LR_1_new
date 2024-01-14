package Service;

import Models.Player;
import Models.Team;
import Repo.PlayerRepository;
import Repo.TeamRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class TeamService {
    @EJB
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.getAll();
    }
    public void save(Team newTeam) {
        teamRepository.save(newTeam);
    }
}
