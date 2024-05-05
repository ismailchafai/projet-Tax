import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TrimDto} from '../taxe38/Trim.model';

export class NotificationRetardDeuxiemeNiveauDetailDto extends BaseDto{

    public code: string;

    public montantBase: null | number;

    public montantRetardPremierMois: null | number;

    public montantRetardAutreMois: null | number;

    public montantTotal: null | number;

    public trim: TrimDto ;
    

    constructor() {
        super();

        this.code = '';
        this.montantBase = null;
        this.montantRetardPremierMois = null;
        this.montantRetardAutreMois = null;
        this.montantTotal = null;
        this.trim = new TrimDto() ;

        }

}
