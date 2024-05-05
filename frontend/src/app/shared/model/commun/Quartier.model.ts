import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SecteurDto} from './Secteur.model';

export class QuartierDto extends BaseDto{

    public code: string;

    public libelle: string;

    public secteur: SecteurDto ;
    

    constructor() {
        super();

        this.code = '';
        this.libelle = '';
        this.secteur = new SecteurDto() ;

        }

}
