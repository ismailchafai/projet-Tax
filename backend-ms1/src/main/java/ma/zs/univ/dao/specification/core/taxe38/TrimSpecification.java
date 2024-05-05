package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.TrimCriteria;
import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class TrimSpecification extends  AbstractSpecification<TrimCriteria, Trim>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateInt("numero", criteria.getNumero(), criteria.getNumeroMin(), criteria.getNumeroMax());
    }

    public TrimSpecification(TrimCriteria criteria) {
        super(criteria);
    }

    public TrimSpecification(TrimCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
