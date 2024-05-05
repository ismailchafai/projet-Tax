package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class RedevableSpecification extends  AbstractSpecification<RedevableCriteria, Redevable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
    }

    public RedevableSpecification(RedevableCriteria criteria) {
        super(criteria);
    }

    public RedevableSpecification(RedevableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
