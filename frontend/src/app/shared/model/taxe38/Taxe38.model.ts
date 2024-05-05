import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {LocaleDto} from '../commun/Locale.model';
import {TrimDto} from './Trim.model';
import {Taxe38DetailDto} from './Taxe38Detail.model';
import {RedevableDto} from '../commun/Redevable.model';

export class Taxe38Dto extends BaseDto{

    public code: string;

    public anne: null | number;

   public datePresentaion: Date;

    public nombreMoisRetard: null | number;

    public montantBase: null | number;

    public montantRetardPremeirMois: null | number;

    public montantTotal: null | number;

    public redevable: RedevableDto ;
    public locale: LocaleDto ;
    public trim: TrimDto ;
     public taxe38Details: Array<Taxe38DetailDto>;
    

    constructor() {
        super();

        this.code = '';
        this.anne = null;
        this.datePresentaion = null;
        this.nombreMoisRetard = null;
        this.montantBase = null;
        this.montantRetardPremeirMois = null;
        this.montantTotal = null;
        this.redevable = new RedevableDto() ;
        this.locale = new LocaleDto() ;
        this.trim = new TrimDto() ;
        this.taxe38Details = new Array<Taxe38DetailDto>();

        }

}
