import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {RueCriteria} from './RueCriteria.model';
import {RedevableCriteria} from './RedevableCriteria.model';
import {CategorieLocaleCriteria} from '../taxe38/CategorieLocaleCriteria.model';

export class LocaleCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public complementAdresse: string;
    public complementAdresseLike: string;
  public rue: RueCriteria ;
  public rues: Array<RueCriteria> ;
  public categorieLocale: CategorieLocaleCriteria ;
  public categorieLocales: Array<CategorieLocaleCriteria> ;

}
