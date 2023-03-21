package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.FilmDao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FilmDaoImpl implements FilmDao {

    @Autowired
    private EntityManager em;

    @Override
    public List<Film> searchFilms(String query) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> film = cq.from(Film.class);

        cq.select(film)
                .where(
                        cb.like(
                                cb.upper(film.get("title")),
                                "%" + query.toUpperCase() + "%"
                        )
                );

        return em.createQuery(cq).getResultList();
    }
}
