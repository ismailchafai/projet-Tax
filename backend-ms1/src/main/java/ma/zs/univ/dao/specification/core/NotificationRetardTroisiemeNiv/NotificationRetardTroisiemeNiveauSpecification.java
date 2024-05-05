package  ma.zs.univ.dao.specification.core.NotificationRetardTroisiemeNiv;

import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class NotificationRetardTroisiemeNiveauSpecification extends  AbstractSpecification<NotificationRetardTroisiemeNiveauCriteria, NotificationRetardTroisiemeNiveau>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateInt("anne", criteria.getAnne(), criteria.getAnneMin(), criteria.getAnneMax());
        addPredicateFk("locale","id", criteria.getLocale()==null?null:criteria.getLocale().getId());
        addPredicateFk("locale","id", criteria.getLocales());
        addPredicateFk("locale","code", criteria.getLocale()==null?null:criteria.getLocale().getCode());
        addPredicateFk("redevable","id", criteria.getRedevable()==null?null:criteria.getRedevable().getId());
        addPredicateFk("redevable","id", criteria.getRedevables());
        addPredicateFk("trim","id", criteria.getTrim()==null?null:criteria.getTrim().getId());
        addPredicateFk("trim","id", criteria.getTrims());
    }

    public NotificationRetardTroisiemeNiveauSpecification(NotificationRetardTroisiemeNiveauCriteria criteria) {
        super(criteria);
    }

    public NotificationRetardTroisiemeNiveauSpecification(NotificationRetardTroisiemeNiveauCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
