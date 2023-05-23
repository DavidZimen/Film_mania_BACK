package sk.vaii.sem.film_mania_back.part_film.repository.daoImpl;

import sk.vaii.sem.film_mania_back.part_film.entity.Film;
import sk.vaii.sem.film_mania_back.part_film.entity.FilmPartImage;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.FilmPartImageDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Optional;

public class FilmPartImageDaoImpl implements FilmPartImageDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<FilmPartImage> getImageOfFilm(Long filmId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FilmPartImage> cq = cb.createQuery(FilmPartImage.class);
        Root<FilmPartImage> image = cq.from(FilmPartImage.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<FilmPartImage> subqueryImage = subquery.from(FilmPartImage.class);
        Join<FilmPartImage, Film> subqueryFilm = subqueryImage.join("film");

        subquery.select(subqueryImage.get("id")).where(cb.equal(subqueryFilm.get("id"), filmId));

        Predicate filmIdPredicate = cb.in(image.get("id")).value(subquery);
        cq.where(filmIdPredicate);

        TypedQuery<FilmPartImage> query = em.createQuery(cq);
        return query.getResultList().stream().findFirst();
    }
}
