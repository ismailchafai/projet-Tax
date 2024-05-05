package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class TypeLocale38DetailSpecification extends  AbstractSpecification<TypeLocale38DetailCriteria, TypeLocale38Detail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeLocale38DetailSpecification(TypeLocale38DetailCriteria criteria) {
        super(criteria);
    }

    public TypeLocale38DetailSpecification(TypeLocale38DetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
