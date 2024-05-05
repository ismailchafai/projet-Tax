package  ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv;

import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class NotificationRetardDeuxiemeNiveauDetailType38Specification extends  AbstractSpecification<NotificationRetardDeuxiemeNiveauDetailType38Criteria, NotificationRetardDeuxiemeNiveauDetailType38>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montantBase", criteria.getMontantBase(), criteria.getMontantBaseMin(), criteria.getMontantBaseMax());
        addPredicateBigDecimal("montantRetardPremierMois", criteria.getMontantRetardPremierMois(), criteria.getMontantRetardPremierMoisMin(), criteria.getMontantRetardPremierMoisMax());
        addPredicateBigDecimal("montantRetardAutreMois", criteria.getMontantRetardAutreMois(), criteria.getMontantRetardAutreMoisMin(), criteria.getMontantRetardAutreMoisMax());
        addPredicateBigDecimal("montantTotal", criteria.getMontantTotal(), criteria.getMontantTotalMin(), criteria.getMontantTotalMax());
        addPredicateFk("typeLocale38","id", criteria.getTypeLocale38()==null?null:criteria.getTypeLocale38().getId());
        addPredicateFk("typeLocale38","id", criteria.getTypeLocale38s());
        addPredicateFk("typeLocale38","code", criteria.getTypeLocale38()==null?null:criteria.getTypeLocale38().getCode());
    }

    public NotificationRetardDeuxiemeNiveauDetailType38Specification(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) {
        super(criteria);
    }

    public NotificationRetardDeuxiemeNiveauDetailType38Specification(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
