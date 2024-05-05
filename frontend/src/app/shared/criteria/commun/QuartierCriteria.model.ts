import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {SecteurCriteria} from './SecteurCriteria.model';

export class QuartierCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public secteur: SecteurCriteria ;
  public secteurs: Array<SecteurCriteria> ;

}
