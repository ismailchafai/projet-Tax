import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {Taxe38Criteria} from './Taxe38Criteria.model';
import {Locale38DetailCriteria} from './Locale38DetailCriteria.model';
import {TauxTaxe38Criteria} from './TauxTaxe38Criteria.model';

export class Taxe38DetailCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public montantParMetreCarre: number;
     public montantParMetreCarreMin: number;
     public montantParMetreCarreMax: number;
     public montantBase: number;
     public montantBaseMin: number;
     public montantBaseMax: number;
     public montantRetardPremierMois: number;
     public montantRetardPremierMoisMin: number;
     public montantRetardPremierMoisMax: number;
     public montantRetardAutreMois: number;
     public montantRetardAutreMoisMin: number;
     public montantRetardAutreMoisMax: number;
  public locale38Detail: Locale38DetailCriteria ;
  public locale38Details: Array<Locale38DetailCriteria> ;

}
