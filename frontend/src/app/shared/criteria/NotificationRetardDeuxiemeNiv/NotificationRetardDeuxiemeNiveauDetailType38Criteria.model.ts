import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TypeLocale38DetailCriteria} from '../taxe38/TypeLocale38DetailCriteria.model';

export class NotificationRetardDeuxiemeNiveauDetailType38Criteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public montantBase: number;
     public montantBaseMin: number;
     public montantBaseMax: number;
     public montantRetardPremierMois: number;
     public montantRetardPremierMoisMin: number;
     public montantRetardPremierMoisMax: number;
     public montantRetardAutreMois: number;
     public montantRetardAutreMoisMin: number;
     public montantRetardAutreMoisMax: number;
     public montantTotal: number;
     public montantTotalMin: number;
     public montantTotalMax: number;
  public typeLocale38: TypeLocale38DetailCriteria ;
  public typeLocale38s: Array<TypeLocale38DetailCriteria> ;

}
