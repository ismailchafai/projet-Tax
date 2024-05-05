package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class TauxTaxe38Specification extends  AbstractSpecification<TauxTaxe38Criteria, TauxTaxe38>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montantParMetreCarre", criteria.getMontantParMetreCarre(), criteria.getMontantParMetreCarreMin(), criteria.getMontantParMetreCarreMax());
        addPredicate("dateMin", criteria.getDateMin(), criteria.getDateMinFrom(), criteria.getDateMinTo());
        addPredicate("dateMax", criteria.getDateMax(), criteria.getDateMaxFrom(), criteria.getDateMaxTo());
        addPredicateBigDecimal("pourcentagePremierRetard", criteria.getPourcentagePremierRetard(), criteria.getPourcentagePremierRetardMin(), criteria.getPourcentagePremierRetardMax());
        addPredicateBigDecimal("pourcentageAutreMoisRetard", criteria.getPourcentageAutreMoisRetard(), criteria.getPourcentageAutreMoisRetardMin(), criteria.getPourcentageAutreMoisRetardMax());
        addPredicateFk("typeLocale38Detail","id", criteria.getTypeLocale38Detail()==null?null:criteria.getTypeLocale38Detail().getId());
        addPredicateFk("typeLocale38Detail","id", criteria.getTypeLocale38Details());
        addPredicateFk("typeLocale38Detail","code", criteria.getTypeLocale38Detail()==null?null:criteria.getTypeLocale38Detail().getCode());
        addPredicateFk("categorieLocale","id", criteria.getCategorieLocale()==null?null:criteria.getCategorieLocale().getId());
        addPredicateFk("categorieLocale","id", criteria.getCategorieLocales());
        addPredicateFk("categorieLocale","code", criteria.getCategorieLocale()==null?null:criteria.getCategorieLocale().getCode());
    }

    public TauxTaxe38Specification(TauxTaxe38Criteria criteria) {
        super(criteria);
    }

    public TauxTaxe38Specification(TauxTaxe38Criteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
