package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class QuartierSpecification extends  AbstractSpecification<QuartierCriteria, Quartier>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("secteur","id", criteria.getSecteur()==null?null:criteria.getSecteur().getId());
        addPredicateFk("secteur","id", criteria.getSecteurs());
        addPredicateFk("secteur","code", criteria.getSecteur()==null?null:criteria.getSecteur().getCode());
    }

    public QuartierSpecification(QuartierCriteria criteria) {
        super(criteria);
    }

    public QuartierSpecification(QuartierCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
