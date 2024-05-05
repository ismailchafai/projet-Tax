import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TypeLocale38DetailCriteria} from './TypeLocale38DetailCriteria.model';

export class Locale38DetailCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public superficie: number;
     public superficieMin: number;
     public superficieMax: number;
    public active: null | boolean;
  public typeLocale38Detail: TypeLocale38DetailCriteria ;
  public typeLocale38Details: Array<TypeLocale38DetailCriteria> ;

}
