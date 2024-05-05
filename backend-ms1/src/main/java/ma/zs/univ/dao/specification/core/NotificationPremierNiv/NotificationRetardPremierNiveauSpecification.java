package  ma.zs.univ.dao.specification.core.NotificationPremierNiv;

import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class NotificationRetardPremierNiveauSpecification extends  AbstractSpecification<NotificationRetardPremierNiveauCriteria, NotificationRetardPremierNiveau>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateInt("anne", criteria.getAnne(), criteria.getAnneMin(), criteria.getAnneMax());
        addPredicateBigDecimal("montantBase", criteria.getMontantBase(), criteria.getMontantBaseMin(), criteria.getMontantBaseMax());
        addPredicateFk("locale","id", criteria.getLocale()==null?null:criteria.getLocale().getId());
        addPredicateFk("locale","id", criteria.getLocales());
        addPredicateFk("locale","code", criteria.getLocale()==null?null:criteria.getLocale().getCode());
        addPredicateFk("redevable","id", criteria.getRedevable()==null?null:criteria.getRedevable().getId());
        addPredicateFk("redevable","id", criteria.getRedevables());
    }

    public NotificationRetardPremierNiveauSpecification(NotificationRetardPremierNiveauCriteria criteria) {
        super(criteria);
    }

    public NotificationRetardPremierNiveauSpecification(NotificationRetardPremierNiveauCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
