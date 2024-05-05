import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class TrimDto extends BaseDto{

    public libelle: string;

    public numero: null | number;

    

    constructor() {
        super();

        this.libelle = '';
        this.numero = null;

        }

}
