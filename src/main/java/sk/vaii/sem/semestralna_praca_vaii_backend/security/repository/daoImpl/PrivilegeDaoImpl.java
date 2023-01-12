package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.daoImpl;

import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Privilege;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao.PrivilegeDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class PrivilegeDaoImpl implements PrivilegeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Privilege findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Privilege> cq = cb.createQuery(Privilege.class);

        Root<Privilege> privilege = cq.from(Privilege.class);
        Predicate roleNamePredicate = cb.equal(privilege.get("name"), name);
        cq.where(roleNamePredicate);

        TypedQuery<Privilege> query = em.createQuery(cq);
        return query.getResultList()
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Privilege> getPrivilegesOfRole(Long roleId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Privilege> cq = cb.createQuery(Privilege.class);
        Root<Privilege> privilege = cq.from(Privilege.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<Privilege> subqueryPrivilege = subquery.from(Privilege.class);
        Join<Role, Privilege> subqueryRole = subqueryPrivilege.join("roles");

        subquery.select(subqueryPrivilege.get("id")).where(cb.equal(subqueryRole.get("id"), roleId));

        Predicate roleIdPredicate = cb.in(privilege.get("id")).value(subquery);
        cq.where(roleIdPredicate);

        TypedQuery<Privilege> query = em.createQuery(cq);
        return query.getResultList();
    }
}
