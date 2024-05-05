package  ma.zs.univ.dao.criteria.core.NotificationPremierNiv;


import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;

import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class NotificationRetardPremierNiveauCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String anne;
    private String anneMin;
    private String anneMax;
    private String montantBase;
    private String montantBaseMin;
    private String montantBaseMax;

    private LocaleCriteria locale ;
    private List<LocaleCriteria> locales ;
    private RedevableCriteria redevable ;
    private List<RedevableCriteria> redevables ;


    public NotificationRetardPremierNiveauCriteria(){}

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

    public String getAnne(){
        return this.anne;
    }
    public void setAnne(String anne){
        this.anne = anne;
    }   
    public String getAnneMin(){
        return this.anneMin;
    }
    public void setAnneMin(String anneMin){
        this.anneMin = anneMin;
    }
    public String getAnneMax(){
        return this.anneMax;
    }
    public void setAnneMax(String anneMax){
        this.anneMax = anneMax;
    }
      
    public String getMontantBase(){
        return this.montantBase;
    }
    public void setMontantBase(String montantBase){
        this.montantBase = montantBase;
    }   
    public String getMontantBaseMin(){
        return this.montantBaseMin;
    }
    public void setMontantBaseMin(String montantBaseMin){
        this.montantBaseMin = montantBaseMin;
    }
    public String getMontantBaseMax(){
        return this.montantBaseMax;
    }
    public void setMontantBaseMax(String montantBaseMax){
        this.montantBaseMax = montantBaseMax;
    }
      

    public LocaleCriteria getLocale(){
        return this.locale;
    }

    public void setLocale(LocaleCriteria locale){
        this.locale = locale;
    }
    public List<LocaleCriteria> getLocales(){
        return this.locales;
    }

    public void setLocales(List<LocaleCriteria> locales){
        this.locales = locales;
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
}
