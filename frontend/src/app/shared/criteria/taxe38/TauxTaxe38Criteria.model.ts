import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TypeLocale38DetailCriteria} from './TypeLocale38DetailCriteria.model';
import {CategorieLocaleCriteria} from './CategorieLocaleCriteria.model';

export class TauxTaxe38Criteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
     public montantParMetreCarre: number;
     public montantParMetreCarreMin: number;
     public montantParMetreCarreMax: number;
    public dateMin: Date;
    public dateMinFrom: Date;
    public dateMinTo: Date;
    public dateMax: Date;
    public dateMaxFrom: Date;
    public dateMaxTo: Date;
     public pourcentagePremierRetard: number;
     public pourcentagePremierRetardMin: number;
     public pourcentagePremierRetardMax: number;
     public pourcentageAutreMoisRetard: number;
     public pourcentageAutreMoisRetardMin: number;
     public pourcentageAutreMoisRetardMax: number;
  public typeLocale38Detail: TypeLocale38DetailCriteria ;
  public typeLocale38Details: Array<TypeLocale38DetailCriteria> ;
  public categorieLocale: CategorieLocaleCriteria ;
  public categorieLocales: Array<CategorieLocaleCriteria> ;

}
