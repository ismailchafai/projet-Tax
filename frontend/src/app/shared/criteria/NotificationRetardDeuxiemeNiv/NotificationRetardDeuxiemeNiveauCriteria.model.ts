import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {LocaleCriteria} from '../commun/LocaleCriteria.model';
import {RedevableCriteria} from '../commun/RedevableCriteria.model';

export class NotificationRetardDeuxiemeNiveauCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public anne: number;
     public anneMin: number;
     public anneMax: number;
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

}
