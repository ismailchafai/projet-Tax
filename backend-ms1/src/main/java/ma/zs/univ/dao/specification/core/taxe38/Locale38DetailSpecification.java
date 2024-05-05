package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class Locale38DetailSpecification extends  AbstractSpecification<Locale38DetailCriteria, Locale38Detail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("superficie", criteria.getSuperficie(), criteria.getSuperficieMin(), criteria.getSuperficieMax());
        addPredicateBool("active", criteria.getActive());
        addPredicateFk("typeLocale38Detail","id", criteria.getTypeLocale38Detail()==null?null:criteria.getTypeLocale38Detail().getId());
        addPredicateFk("typeLocale38Detail","id", criteria.getTypeLocale38Details());
        addPredicateFk("typeLocale38Detail","code", criteria.getTypeLocale38Detail()==null?null:criteria.getTypeLocale38Detail().getCode());
    }

    public Locale38DetailSpecification(Locale38DetailCriteria criteria) {
        super(criteria);
    }

    public Locale38DetailSpecification(Locale38DetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
