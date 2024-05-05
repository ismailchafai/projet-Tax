import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {Taxe38Dto} from './Taxe38.model';
import {Locale38DetailDto} from './Locale38Detail.model';
import {TauxTaxe38Dto} from './TauxTaxe38.model';

export class Taxe38DetailDto extends BaseDto{

    public code: string;

    public montantParMetreCarre: null | number;

    public montantBase: null | number;

    public montantRetardPremierMois: null | number;

    public montantRetardAutreMois: null | number;

    public locale38Detail: Locale38DetailDto ;
    public tauxTaxe38: TauxTaxe38Dto ;
    public taxe38: Taxe38Dto ;
    

    constructor() {
        super();

        this.code = '';
        this.montantParMetreCarre = null;
        this.montantBase = null;
        this.montantRetardPremierMois = null;
        this.montantRetardAutreMois = null;
        this.locale38Detail = new Locale38DetailDto() ;

        }

}
