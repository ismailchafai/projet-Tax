import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeLocale38DetailDto} from '../taxe38/TypeLocale38Detail.model';

export class NotificationRetardDeuxiemeNiveauDetailType38Dto extends BaseDto{

    public code: string;

    public montantBase: null | number;

    public montantRetardPremierMois: null | number;

    public montantRetardAutreMois: null | number;

    public montantTotal: null | number;

    public typeLocale38: TypeLocale38DetailDto ;
    

    constructor() {
        super();

        this.code = '';
        this.montantBase = null;
        this.montantRetardPremierMois = null;
        this.montantRetardAutreMois = null;
        this.montantTotal = null;
        this.typeLocale38 = new TypeLocale38DetailDto() ;

        }

}
