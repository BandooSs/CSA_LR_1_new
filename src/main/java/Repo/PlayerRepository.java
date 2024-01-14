package Repo;

import Models.Player;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Stateless
@RequiredArgsConstructor
public class PlayerRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Player> getAll() {
        return em.createQuery(
                        "select p from Player p",
                        Player.class)
                .getResultList();
    }

    public void  save(Player player){
        em.persist(player);
        em.flush();
    }
}
