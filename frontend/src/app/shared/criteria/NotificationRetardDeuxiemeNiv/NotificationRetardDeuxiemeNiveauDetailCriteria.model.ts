import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TrimCriteria} from '../taxe38/TrimCriteria.model';

export class NotificationRetardDeuxiemeNiveauDetailCriteria  extends BaseCriteria  {

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
  public trim: TrimCriteria ;
  public trims: Array<TrimCriteria> ;

}
