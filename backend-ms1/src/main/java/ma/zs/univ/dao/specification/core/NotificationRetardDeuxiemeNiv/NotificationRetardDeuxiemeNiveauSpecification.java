package  ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv;

import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class NotificationRetardDeuxiemeNiveauSpecification extends  AbstractSpecification<NotificationRetardDeuxiemeNiveauCriteria, NotificationRetardDeuxiemeNiveau>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateInt("anne", criteria.getAnne(), criteria.getAnneMin(), criteria.getAnneMax());
        addPredicateBigDecimal("montantBase", criteria.getMontantBase(), criteria.getMontantBaseMin(), criteria.getMontantBaseMax());
        addPredicateBigDecimal("montantRetardPremierMois", criteria.getMontantRetardPremierMois(), criteria.getMontantRetardPremierMoisMin(), criteria.getMontantRetardPremierMoisMax());
        addPredicateBigDecimal("montantRetardAutreMois", criteria.getMontantRetardAutreMois(), criteria.getMontantRetardAutreMoisMin(), criteria.getMontantRetardAutreMoisMax());
        addPredicateBigDecimal("montantTotal", criteria.getMontantTotal(), criteria.getMontantTotalMin(), criteria.getMontantTotalMax());
        addPredicateFk("locale","id", criteria.getLocale()==null?null:criteria.getLocale().getId());
        addPredicateFk("locale","id", criteria.getLocales());
        addPredicateFk("locale","code", criteria.getLocale()==null?null:criteria.getLocale().getCode());
        addPredicateFk("redevable","id", criteria.getRedevable()==null?null:criteria.getRedevable().getId());
        addPredicateFk("redevable","id", criteria.getRedevables());
    }

    public NotificationRetardDeuxiemeNiveauSpecification(NotificationRetardDeuxiemeNiveauCriteria criteria) {
        super(criteria);
    }

    public NotificationRetardDeuxiemeNiveauSpecification(NotificationRetardDeuxiemeNiveauCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
