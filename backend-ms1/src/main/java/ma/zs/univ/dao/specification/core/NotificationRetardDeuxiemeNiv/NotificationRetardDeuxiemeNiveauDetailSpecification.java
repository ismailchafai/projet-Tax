package  ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv;

import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class NotificationRetardDeuxiemeNiveauDetailSpecification extends  AbstractSpecification<NotificationRetardDeuxiemeNiveauDetailCriteria, NotificationRetardDeuxiemeNiveauDetail>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateBigDecimal("montantBase", criteria.getMontantBase(), criteria.getMontantBaseMin(), criteria.getMontantBaseMax());
        addPredicateBigDecimal("montantRetardPremierMois", criteria.getMontantRetardPremierMois(), criteria.getMontantRetardPremierMoisMin(), criteria.getMontantRetardPremierMoisMax());
        addPredicateBigDecimal("montantRetardAutreMois", criteria.getMontantRetardAutreMois(), criteria.getMontantRetardAutreMoisMin(), criteria.getMontantRetardAutreMoisMax());
        addPredicateBigDecimal("montantTotal", criteria.getMontantTotal(), criteria.getMontantTotalMin(), criteria.getMontantTotalMax());
        addPredicateFk("trim","id", criteria.getTrim()==null?null:criteria.getTrim().getId());
        addPredicateFk("trim","id", criteria.getTrims());
    }

    public NotificationRetardDeuxiemeNiveauDetailSpecification(NotificationRetardDeuxiemeNiveauDetailCriteria criteria) {
        super(criteria);
    }

    public NotificationRetardDeuxiemeNiveauDetailSpecification(NotificationRetardDeuxiemeNiveauDetailCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
