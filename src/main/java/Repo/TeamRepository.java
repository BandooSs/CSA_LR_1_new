package Repo;

import Models.Player;
import Models.Team;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Stateless
@RequiredArgsConstructor
public class TeamRepository {
    @PersistenceContext
    private EntityManager em;
    public List<Team> getAll() {
        return em.createQuery(
                        "select t from Team t",
                        Team.class)
                .getResultList();
    }

    public void  save(Team newTeam){
        em.persist(newTeam);
        em.flush();
    }
}
