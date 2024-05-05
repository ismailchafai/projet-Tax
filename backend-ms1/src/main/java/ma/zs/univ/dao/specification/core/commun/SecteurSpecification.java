package  ma.zs.univ.dao.specification.core.commun;

import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class SecteurSpecification extends  AbstractSpecification<SecteurCriteria, Secteur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateFk("ville","id", criteria.getVille()==null?null:criteria.getVille().getId());
        addPredicateFk("ville","id", criteria.getVilles());
        addPredicateFk("ville","code", criteria.getVille()==null?null:criteria.getVille().getCode());
    }

    public SecteurSpecification(SecteurCriteria criteria) {
        super(criteria);
    }

    public SecteurSpecification(SecteurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
