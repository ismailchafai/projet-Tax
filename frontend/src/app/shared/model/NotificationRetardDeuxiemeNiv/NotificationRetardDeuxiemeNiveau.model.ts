import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {LocaleDto} from '../commun/Locale.model';
import {RedevableDto} from '../commun/Redevable.model';

export class NotificationRetardDeuxiemeNiveauDto extends BaseDto{

    public code: string;

    public anne: null | number;

    public montantBase: null | number;

    public montantRetardPremierMois: null | number;

    public montantRetardAutreMois: null | number;

    public montantTotal: null | number;

    public locale: LocaleDto ;
    public redevable: RedevableDto ;
    

    constructor() {
        super();

        this.code = '';
        this.anne = null;
        this.montantBase = null;
        this.montantRetardPremierMois = null;
        this.montantRetardAutreMois = null;
        this.montantTotal = null;

        }

}
