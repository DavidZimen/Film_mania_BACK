package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.daoImpl;

import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.ActorDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class ActorDaoImpl implements ActorDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Actor> getActorsOfFilm(Long filmId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> actor = cq.from(Actor.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Actor> subqueryActor = subquery.from(Actor.class);
        Join<Actor, Film> subqueryFilm = subqueryActor.join("films");

        subquery.select(subqueryActor.get("id")).where(cb.equal(subqueryFilm.get("id"), filmId));

        Predicate filmIdPredicate = cb.in(actor.get("id")).value(subquery);
        cq.where(filmIdPredicate);

        TypedQuery<Actor> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Actor> searchActors(String query) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> actor = cq.from(Actor.class);

        cq.select(actor)
                .where(
                        cb.like(
                                cb.upper(actor.get("name")),
                                "%" + query.toUpperCase() + "%"
                        )
                );

        return em.createQuery(cq).getResultList();
    }
}
