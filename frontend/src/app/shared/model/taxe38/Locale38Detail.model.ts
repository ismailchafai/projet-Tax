import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeLocale38DetailDto} from './TypeLocale38Detail.model';

export class Locale38DetailDto extends BaseDto{

    public code: string;

    public superficie: null | number;

   public active: null | boolean;

    public typeLocale38Detail: TypeLocale38DetailDto ;
    

    constructor() {
        super();

        this.code = '';
        this.superficie = null;
        this.active = null;
        this.typeLocale38Detail = new TypeLocale38DetailDto() ;

        }

}
