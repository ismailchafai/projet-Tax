package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class Taxe38Specification extends  AbstractSpecification<Taxe38Criteria, Taxe38>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateInt("anne", criteria.getAnne(), criteria.getAnneMin(), criteria.getAnneMax());
        addPredicate("datePresentaion", criteria.getDatePresentaion(), criteria.getDatePresentaionFrom(), criteria.getDatePresentaionTo());
        addPredicateInt("nombreMoisRetard", criteria.getNombreMoisRetard(), criteria.getNombreMoisRetardMin(), criteria.getNombreMoisRetardMax());
        addPredicateBigDecimal("montantBase", criteria.getMontantBase(), criteria.getMontantBaseMin(), criteria.getMontantBaseMax());
        addPredicateBigDecimal("montantRetardPremeirMois", criteria.getMontantRetardPremeirMois(), criteria.getMontantRetardPremeirMoisMin(), criteria.getMontantRetardPremeirMoisMax());
        addPredicateBigDecimal("montantTotal", criteria.getMontantTotal(), criteria.getMontantTotalMin(), criteria.getMontantTotalMax());
        addPredicateFk("redevable","id", criteria.getRedevable()==null?null:criteria.getRedevable().getId());
        addPredicateFk("redevable","id", criteria.getRedevables());
        addPredicateFk("locale","id", criteria.getLocale()==null?null:criteria.getLocale().getId());
        addPredicateFk("locale","id", criteria.getLocales());
        addPredicateFk("locale","code", criteria.getLocale()==null?null:criteria.getLocale().getCode());
        addPredicateFk("trim","id", criteria.getTrim()==null?null:criteria.getTrim().getId());
        addPredicateFk("trim","id", criteria.getTrims());
    }

    public Taxe38Specification(Taxe38Criteria criteria) {
        super(criteria);
    }

    public Taxe38Specification(Taxe38Criteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
