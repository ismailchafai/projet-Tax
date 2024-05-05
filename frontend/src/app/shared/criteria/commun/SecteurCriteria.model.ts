import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {VilleCriteria} from './VilleCriteria.model';

export class SecteurCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public ville: VilleCriteria ;
  public villes: Array<VilleCriteria> ;

}
