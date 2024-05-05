import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {QuartierCriteria} from './QuartierCriteria.model';

export class RueCriteria  extends BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;

}
