import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeLocale38DetailDto} from './TypeLocale38Detail.model';
import {CategorieLocaleDto} from './CategorieLocale.model';

export class TauxTaxe38Dto extends BaseDto{

    public code: string;

    public montantParMetreCarre: null | number;

   public dateMin: Date;

   public dateMax: Date;

    public pourcentagePremierRetard: null | number;

    public pourcentageAutreMoisRetard: null | number;

    public typeLocale38Detail: TypeLocale38DetailDto ;
    public categorieLocale: CategorieLocaleDto ;
    

    constructor() {
        super();

        this.code = '';
        this.montantParMetreCarre = null;
        this.dateMin = null;
        this.dateMax = null;
        this.pourcentagePremierRetard = null;
        this.pourcentageAutreMoisRetard = null;
        this.typeLocale38Detail = new TypeLocale38DetailDto() ;
        this.categorieLocale = new CategorieLocaleDto() ;

        }

}
