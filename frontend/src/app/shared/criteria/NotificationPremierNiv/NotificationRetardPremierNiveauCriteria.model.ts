import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {LocaleCriteria} from '../commun/LocaleCriteria.model';
import {RedevableCriteria} from '../commun/RedevableCriteria.model';

export class NotificationRetardPremierNiveauCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public anne: number;
     public anneMin: number;
     public anneMax: number;
     public montantBase: number;
     public montantBaseMin: number;
     public montantBaseMax: number;

}
