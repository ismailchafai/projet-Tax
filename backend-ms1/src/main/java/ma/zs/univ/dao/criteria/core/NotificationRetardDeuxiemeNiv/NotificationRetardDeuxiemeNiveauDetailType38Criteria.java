package  ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;

import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class NotificationRetardDeuxiemeNiveauDetailType38Criteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String montantBase;
    private String montantBaseMin;
    private String montantBaseMax;
    private String montantRetardPremierMois;
    private String montantRetardPremierMoisMin;
    private String montantRetardPremierMoisMax;
    private String montantRetardAutreMois;
    private String montantRetardAutreMoisMin;
    private String montantRetardAutreMoisMax;
    private String montantTotal;
    private String montantTotalMin;
    private String montantTotalMax;

    private TypeLocale38DetailCriteria typeLocale38 ;
    private List<TypeLocale38DetailCriteria> typeLocale38s ;


    public NotificationRetardDeuxiemeNiveauDetailType38Criteria(){}

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
      
    public String getMontantRetardPremierMois(){
        return this.montantRetardPremierMois;
    }
    public void setMontantRetardPremierMois(String montantRetardPremierMois){
        this.montantRetardPremierMois = montantRetardPremierMois;
    }   
    public String getMontantRetardPremierMoisMin(){
        return this.montantRetardPremierMoisMin;
    }
    public void setMontantRetardPremierMoisMin(String montantRetardPremierMoisMin){
        this.montantRetardPremierMoisMin = montantRetardPremierMoisMin;
    }
    public String getMontantRetardPremierMoisMax(){
        return this.montantRetardPremierMoisMax;
    }
    public void setMontantRetardPremierMoisMax(String montantRetardPremierMoisMax){
        this.montantRetardPremierMoisMax = montantRetardPremierMoisMax;
    }
      
    public String getMontantRetardAutreMois(){
        return this.montantRetardAutreMois;
    }
    public void setMontantRetardAutreMois(String montantRetardAutreMois){
        this.montantRetardAutreMois = montantRetardAutreMois;
    }   
    public String getMontantRetardAutreMoisMin(){
        return this.montantRetardAutreMoisMin;
    }
    public void setMontantRetardAutreMoisMin(String montantRetardAutreMoisMin){
        this.montantRetardAutreMoisMin = montantRetardAutreMoisMin;
    }
    public String getMontantRetardAutreMoisMax(){
        return this.montantRetardAutreMoisMax;
    }
    public void setMontantRetardAutreMoisMax(String montantRetardAutreMoisMax){
        this.montantRetardAutreMoisMax = montantRetardAutreMoisMax;
    }
      
    public String getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(String montantTotal){
        this.montantTotal = montantTotal;
    }   
    public String getMontantTotalMin(){
        return this.montantTotalMin;
    }
    public void setMontantTotalMin(String montantTotalMin){
        this.montantTotalMin = montantTotalMin;
    }
    public String getMontantTotalMax(){
        return this.montantTotalMax;
    }
    public void setMontantTotalMax(String montantTotalMax){
        this.montantTotalMax = montantTotalMax;
    }
      

    public TypeLocale38DetailCriteria getTypeLocale38(){
        return this.typeLocale38;
    }

    public void setTypeLocale38(TypeLocale38DetailCriteria typeLocale38){
        this.typeLocale38 = typeLocale38;
    }
    public List<TypeLocale38DetailCriteria> getTypeLocale38s(){
        return this.typeLocale38s;
    }

    public void setTypeLocale38s(List<TypeLocale38DetailCriteria> typeLocale38s){
        this.typeLocale38s = typeLocale38s;
    }
}
