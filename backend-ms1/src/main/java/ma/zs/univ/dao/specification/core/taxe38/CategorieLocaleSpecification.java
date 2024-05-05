package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.CategorieLocaleCriteria;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class CategorieLocaleSpecification extends  AbstractSpecification<CategorieLocaleCriteria, CategorieLocale>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public CategorieLocaleSpecification(CategorieLocaleCriteria criteria) {
        super(criteria);
    }

    public CategorieLocaleSpecification(CategorieLocaleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
