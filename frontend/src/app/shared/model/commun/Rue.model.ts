import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {QuartierDto} from './Quartier.model';

export class RueDto extends BaseDto{

    public code: string;

    public libelle: string;

    public quartier: QuartierDto ;
    

    constructor() {
        super();

        this.code = '';
        this.libelle = '';

        }

}
