package Service;

import Models.Player;
import Repo.PlayerRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class PlayerService {
    @EJB
    private PlayerRepository playerRepository;
    public List<Player> getAll() {
        return playerRepository.getAll();
    }
    public void save(Player newPlayer) {
        playerRepository.save(newPlayer);
    }
}
