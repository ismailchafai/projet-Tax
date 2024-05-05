package  ma.zs.univ.dao.criteria.core.taxe38;



import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class Taxe38DetailCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String montantParMetreCarre;
    private String montantParMetreCarreMin;
    private String montantParMetreCarreMax;
    private String montantBase;
    private String montantBaseMin;
    private String montantBaseMax;
    private String montantRetardPremierMois;
    private String montantRetardPremierMoisMin;
    private String montantRetardPremierMoisMax;
    private String montantRetardAutreMois;
    private String montantRetardAutreMoisMin;
    private String montantRetardAutreMoisMax;

    private Locale38DetailCriteria locale38Detail ;
    private List<Locale38DetailCriteria> locale38Details ;
    private TauxTaxe38Criteria tauxTaxe38 ;
    private List<TauxTaxe38Criteria> tauxTaxe38s ;
    private Taxe38Criteria taxe38 ;
    private List<Taxe38Criteria> taxe38s ;


    public Taxe38DetailCriteria(){}

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

    public String getMontantParMetreCarre(){
        return this.montantParMetreCarre;
    }
    public void setMontantParMetreCarre(String montantParMetreCarre){
        this.montantParMetreCarre = montantParMetreCarre;
    }   
    public String getMontantParMetreCarreMin(){
        return this.montantParMetreCarreMin;
    }
    public void setMontantParMetreCarreMin(String montantParMetreCarreMin){
        this.montantParMetreCarreMin = montantParMetreCarreMin;
    }
    public String getMontantParMetreCarreMax(){
        return this.montantParMetreCarreMax;
    }
    public void setMontantParMetreCarreMax(String montantParMetreCarreMax){
        this.montantParMetreCarreMax = montantParMetreCarreMax;
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
      

    public Locale38DetailCriteria getLocale38Detail(){
        return this.locale38Detail;
    }

    public void setLocale38Detail(Locale38DetailCriteria locale38Detail){
        this.locale38Detail = locale38Detail;
    }
    public List<Locale38DetailCriteria> getLocale38Details(){
        return this.locale38Details;
    }

    public void setLocale38Details(List<Locale38DetailCriteria> locale38Details){
        this.locale38Details = locale38Details;
    }
    public TauxTaxe38Criteria getTauxTaxe38(){
        return this.tauxTaxe38;
    }

    public void setTauxTaxe38(TauxTaxe38Criteria tauxTaxe38){
        this.tauxTaxe38 = tauxTaxe38;
    }
    public List<TauxTaxe38Criteria> getTauxTaxe38s(){
        return this.tauxTaxe38s;
    }

    public void setTauxTaxe38s(List<TauxTaxe38Criteria> tauxTaxe38s){
        this.tauxTaxe38s = tauxTaxe38s;
    }
    public Taxe38Criteria getTaxe38(){
        return this.taxe38;
    }

    public void setTaxe38(Taxe38Criteria taxe38){
        this.taxe38 = taxe38;
    }
    public List<Taxe38Criteria> getTaxe38s(){
        return this.taxe38s;
    }

    public void setTaxe38s(List<Taxe38Criteria> taxe38s){
        this.taxe38s = taxe38s;
    }
}
