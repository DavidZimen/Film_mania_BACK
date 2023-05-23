package sk.vaii.sem.film_mania_back.part_security.repository.daoImpl;

import sk.vaii.sem.film_mania_back.part_security.repository.dao.RoleDao;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;
import sk.vaii.sem.film_mania_back.part_security.entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);

        Root<Role> role = cq.from(Role.class);
        Predicate roleNamePredicate = cb.equal(role.get("name"), name);
        cq.where(roleNamePredicate);

        TypedQuery<Role> query = em.createQuery(cq);
        return query.getResultList()
                .stream().findFirst().orElse(null);
    }

    @Override
    public Role findUserRole(Long userId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> role = cq.from(Role.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Role> subqueryRole = subquery.from(Role.class);
        Join<AppUser, Role> subqueryAppUser = subqueryRole.join("appUsers");

        subquery.select(subqueryRole.get("id")).where(cb.equal(subqueryAppUser.get("id"), userId));

        Predicate userIdPredicate = cb.in(role.get("id")).value(subquery);
        cq.where(userIdPredicate);

        TypedQuery<Role> query = em.createQuery(cq);
        return query.getResultList()
                .stream().findFirst().orElse(null);
    }
}
