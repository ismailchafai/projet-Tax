import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {LocaleDto} from '../commun/Locale.model';
import {RedevableDto} from '../commun/Redevable.model';

export class NotificationRetardPremierNiveauDto extends BaseDto{

    public code: string;

    public anne: null | number;

    public montantBase: null | number;

    public locale: LocaleDto ;
    public redevable: RedevableDto ;
    

    constructor() {
        super();

        this.code = '';
        this.anne = null;
        this.montantBase = null;

        }

}
