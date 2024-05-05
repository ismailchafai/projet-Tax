import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {RueDto} from './Rue.model';
import {RedevableDto} from './Redevable.model';
import {CategorieLocaleDto} from '../taxe38/CategorieLocale.model';

export class LocaleDto extends BaseDto{

    public code: string;

    public complementAdresse: string;

    public rue: RueDto ;
    public redevable: RedevableDto ;
    public categorieLocale: CategorieLocaleDto ;
    

    constructor() {
        super();

        this.code = '';
        this.complementAdresse = '';
        this.rue = new RueDto() ;
        this.categorieLocale = new CategorieLocaleDto() ;

        }

}
