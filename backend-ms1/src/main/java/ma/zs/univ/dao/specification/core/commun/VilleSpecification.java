package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.VilleCriteria;
import ma.zs.univ.bean.core.commun.Ville;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class VilleSpecification extends  AbstractSpecification<VilleCriteria, Ville>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public VilleSpecification(VilleCriteria criteria) {
        super(criteria);
    }

    public VilleSpecification(VilleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
