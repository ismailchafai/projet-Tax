package  ma.zs.univ.dao.criteria.core.commun;


import ma.zs.univ.dao.criteria.core.taxe38.CategorieLocaleCriteria;

import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class LocaleCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String complementAdresse;
    private String complementAdresseLike;

    private RueCriteria rue ;
    private List<RueCriteria> rues ;
    private RedevableCriteria redevable ;
    private List<RedevableCriteria> redevables ;
    private CategorieLocaleCriteria categorieLocale ;
    private List<CategorieLocaleCriteria> categorieLocales ;


    public LocaleCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getComplementAdresse(){
        return this.complementAdresse;
    }
    public void setComplementAdresse(String complementAdresse){
        this.complementAdresse = complementAdresse;
    }
    public String getComplementAdresseLike(){
        return this.complementAdresseLike;
    }
    public void setComplementAdresseLike(String complementAdresseLike){
        this.complementAdresseLike = complementAdresseLike;
    }


    public RueCriteria getRue(){
        return this.rue;
    }

    public void setRue(RueCriteria rue){
        this.rue = rue;
    }
    public List<RueCriteria> getRues(){
        return this.rues;
    }

    public void setRues(List<RueCriteria> rues){
        this.rues = rues;
    }
    public RedevableCriteria getRedevable(){
        return this.redevable;
    }

    public void setRedevable(RedevableCriteria redevable){
        this.redevable = redevable;
    }
    public List<RedevableCriteria> getRedevables(){
        return this.redevables;
    }

    public void setRedevables(List<RedevableCriteria> redevables){
        this.redevables = redevables;
    }
    public CategorieLocaleCriteria getCategorieLocale(){
        return this.categorieLocale;
    }

    public void setCategorieLocale(CategorieLocaleCriteria categorieLocale){
        this.categorieLocale = categorieLocale;
    }
    public List<CategorieLocaleCriteria> getCategorieLocales(){
        return this.categorieLocales;
    }

    public void setCategorieLocales(List<CategorieLocaleCriteria> categorieLocales){
        this.categorieLocales = categorieLocales;
    }
}
