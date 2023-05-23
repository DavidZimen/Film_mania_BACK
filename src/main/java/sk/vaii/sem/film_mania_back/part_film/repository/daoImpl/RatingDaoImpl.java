package sk.vaii.sem.film_mania_back.part_film.repository.daoImpl;

import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;
import sk.vaii.sem.film_mania_back.part_film.entity.Film;
import sk.vaii.sem.film_mania_back.part_film.entity.Rating;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.RatingDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatingDaoImpl implements RatingDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Rating> getRatingsOfFilm(Long filmId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Rating> cq = cb.createQuery(Rating.class);
        Root<Rating> rating = cq.from(Rating.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Rating> ratingSubquery = subquery.from(Rating.class);
        Join<Film, Rating> subqueryFilm = ratingSubquery.join("film");

        subquery.select(ratingSubquery.get("id")).where(cb.equal(subqueryFilm.get("id"), filmId));

        Predicate filmIdPredicate = cb.in(rating.get("id")).value(subquery);
        cq.where(filmIdPredicate);

        TypedQuery<Rating> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Optional<Rating> getRatingOfUserToTheFilm(Long userId, Long filmId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Rating> cq = cb.createQuery(Rating.class);
        Root<Rating> fromRating = cq.from(Rating.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Rating> ratingSubquery = subquery.from(Rating.class);

        Join<Film, Rating> filmRating = ratingSubquery.join("film");
        Join<Rating, AppUser> userRating = ratingSubquery.join("appUser");

        List<Predicate> conditions = new ArrayList<>();
        conditions.add(cb.equal(filmRating.get("id"), filmId));
        conditions.add(cb.equal(userRating.get("id"), userId));

        subquery.select(ratingSubquery.get("id")).where(conditions.toArray(new Predicate[] {}));

        Predicate condition = cb.in(fromRating.get("id")).value(subquery);
        cq.where(condition);

        TypedQuery<Rating> query = em.createQuery(cq);
        return query.getResultList().stream().findFirst();
    }
}
