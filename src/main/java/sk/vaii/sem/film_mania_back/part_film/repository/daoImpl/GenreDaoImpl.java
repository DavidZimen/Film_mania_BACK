package sk.vaii.sem.film_mania_back.part_film.repository.daoImpl;

import sk.vaii.sem.film_mania_back.part_film.entity.Film;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.GenreDao;
import sk.vaii.sem.film_mania_back.part_film.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genre> getGenresOfFilm(Long filmId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Genre> cq = cb.createQuery(Genre.class);
        Root<Genre> genre = cq.from(Genre.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Genre> subqueryGenre = subquery.from(Genre.class);
        Join<Genre, Film> subqueryFilm = subqueryGenre.join("films");

        subquery.select(subqueryGenre.get("id")).where(cb.equal(subqueryFilm.get("id"), filmId));

        Predicate filmIdPredicate = cb.in(genre.get("id")).value(subquery);
        cq.where(filmIdPredicate);

        TypedQuery<Genre> query = em.createQuery(cq);
        return query.getResultList();
    }
}
