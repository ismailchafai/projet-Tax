package  ma.zs.univ.dao.specification.core.taxe38;

import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class Taxe38DetailSpecification extends  AbstractSpecification<Taxe38DetailCriteria, Taxe38Detail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montantParMetreCarre", criteria.getMontantParMetreCarre(), criteria.getMontantParMetreCarreMin(), criteria.getMontantParMetreCarreMax());
        addPredicateBigDecimal("montantBase", criteria.getMontantBase(), criteria.getMontantBaseMin(), criteria.getMontantBaseMax());
        addPredicateBigDecimal("montantRetardPremierMois", criteria.getMontantRetardPremierMois(), criteria.getMontantRetardPremierMoisMin(), criteria.getMontantRetardPremierMoisMax());
        addPredicateBigDecimal("montantRetardAutreMois", criteria.getMontantRetardAutreMois(), criteria.getMontantRetardAutreMoisMin(), criteria.getMontantRetardAutreMoisMax());
        addPredicateFk("locale38Detail","id", criteria.getLocale38Detail()==null?null:criteria.getLocale38Detail().getId());
        addPredicateFk("locale38Detail","id", criteria.getLocale38Details());
        addPredicateFk("locale38Detail","code", criteria.getLocale38Detail()==null?null:criteria.getLocale38Detail().getCode());
        addPredicateFk("tauxTaxe38","id", criteria.getTauxTaxe38()==null?null:criteria.getTauxTaxe38().getId());
        addPredicateFk("tauxTaxe38","id", criteria.getTauxTaxe38s());
        addPredicateFk("tauxTaxe38","code", criteria.getTauxTaxe38()==null?null:criteria.getTauxTaxe38().getCode());
        addPredicateFk("taxe38","id", criteria.getTaxe38()==null?null:criteria.getTaxe38().getId());
        addPredicateFk("taxe38","id", criteria.getTaxe38s());
        addPredicateFk("taxe38","code", criteria.getTaxe38()==null?null:criteria.getTaxe38().getCode());
    }

    public Taxe38DetailSpecification(Taxe38DetailCriteria criteria) {
        super(criteria);
    }

    public Taxe38DetailSpecification(Taxe38DetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
