import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {LocaleCriteria} from '../commun/LocaleCriteria.model';
import {TrimCriteria} from '../taxe38/TrimCriteria.model';
import {RedevableCriteria} from '../commun/RedevableCriteria.model';

export class NotificationRetardTroisiemeNiveauCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public anne: number;
     public anneMin: number;
     public anneMax: number;
  public locale: LocaleCriteria ;
  public locales: Array<LocaleCriteria> ;
  public redevable: RedevableCriteria ;
  public redevables: Array<RedevableCriteria> ;
  public trim: TrimCriteria ;
  public trims: Array<TrimCriteria> ;

}
