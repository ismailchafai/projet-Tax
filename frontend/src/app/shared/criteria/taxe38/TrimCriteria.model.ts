import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class TrimCriteria  extends BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
     public numero: number;
     public numeroMin: number;
     public numeroMax: number;

}
