package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.RueCriteria;
import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class RueSpecification extends  AbstractSpecification<RueCriteria, Rue>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("quartier","id", criteria.getQuartier()==null?null:criteria.getQuartier().getId());
        addPredicateFk("quartier","id", criteria.getQuartiers());
        addPredicateFk("quartier","code", criteria.getQuartier()==null?null:criteria.getQuartier().getCode());
    }

    public RueSpecification(RueCriteria criteria) {
        super(criteria);
    }

    public RueSpecification(RueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
