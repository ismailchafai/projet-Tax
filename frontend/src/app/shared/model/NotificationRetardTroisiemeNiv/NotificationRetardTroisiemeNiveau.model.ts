import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {LocaleDto} from '../commun/Locale.model';
import {TrimDto} from '../taxe38/Trim.model';
import {RedevableDto} from '../commun/Redevable.model';

export class NotificationRetardTroisiemeNiveauDto extends BaseDto{

    public code: string;

    public anne: null | number;

    public locale: LocaleDto ;
    public redevable: RedevableDto ;
    public trim: TrimDto ;
    

    constructor() {
        super();

        this.code = '';
        this.anne = null;
        this.locale = new LocaleDto() ;
        this.redevable = new RedevableDto() ;
        this.trim = new TrimDto() ;

        }

}
