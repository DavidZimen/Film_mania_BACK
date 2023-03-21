package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.daoImpl;

import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.DirectorDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class DirectorDaoImpl implements DirectorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Director getDirectorOfFilm(Long filmId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Director> cq = cb.createQuery(Director.class);
        Root<Director> director = cq.from(Director.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Director> subqueryDirector = subquery.from(Director.class);
        Join<Director, Film> subqueryFilm = subqueryDirector.join("films");

        subquery.select(subqueryDirector.get("id")).where(cb.equal(subqueryFilm.get("id"), filmId));

        Predicate filmIdPredicate = cb.in(director.get("id")).value(subquery);
        cq.where(filmIdPredicate);

        TypedQuery<Director> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public List<Director> searchDirectors(String query) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Director> cq = cb.createQuery(Director.class);
        Root<Director> director = cq.from(Director.class);

        cq.select(director)
                .where(
                        cb.like(
                                cb.upper(director.get("name")),
                                "%" + query.toUpperCase() + "%"
                        )
                );

        return em.createQuery(cq).getResultList();
    }
}
