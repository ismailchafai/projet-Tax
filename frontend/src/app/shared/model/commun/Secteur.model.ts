import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {VilleDto} from './Ville.model';

export class SecteurDto extends BaseDto{

    public code: string;

    public libelle: string;

    public ville: VilleDto ;
    

    constructor() {
        super();

        this.code = '';
        this.libelle = '';
        this.ville = new VilleDto() ;

        }

}
