import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {LocaleCriteria} from '../commun/LocaleCriteria.model';
import {TrimCriteria} from './TrimCriteria.model';
import {Taxe38DetailCriteria} from './Taxe38DetailCriteria.model';
import {RedevableCriteria} from '../commun/RedevableCriteria.model';

export class Taxe38Criteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public anne: number;
     public anneMin: number;
     public anneMax: number;
    public datePresentaion: Date;
    public datePresentaionFrom: Date;
    public datePresentaionTo: Date;
     public nombreMoisRetard: number;
     public nombreMoisRetardMin: number;
     public nombreMoisRetardMax: number;
     public montantBase: number;
     public montantBaseMin: number;
     public montantBaseMax: number;
     public montantRetardPremeirMois: number;
     public montantRetardPremeirMoisMin: number;
     public montantRetardPremeirMoisMax: number;
     public montantTotal: number;
     public montantTotalMin: number;
     public montantTotalMax: number;
  public redevable: RedevableCriteria ;
  public redevables: Array<RedevableCriteria> ;
  public locale: LocaleCriteria ;
  public locales: Array<LocaleCriteria> ;
  public trim: TrimCriteria ;
  public trims: Array<TrimCriteria> ;
      public taxe38Details: Array<Taxe38DetailCriteria>;

}
