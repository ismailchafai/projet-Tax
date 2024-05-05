package  ma.zs.univ.dao.criteria.core.taxe38;



import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TauxTaxe38Criteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String montantParMetreCarre;
    private String montantParMetreCarreMin;
    private String montantParMetreCarreMax;
    private LocalDateTime dateMin;
    private LocalDateTime dateMinFrom;
    private LocalDateTime dateMinTo;
    private LocalDateTime dateMax;
    private LocalDateTime dateMaxFrom;
    private LocalDateTime dateMaxTo;
    private String pourcentagePremierRetard;
    private String pourcentagePremierRetardMin;
    private String pourcentagePremierRetardMax;
    private String pourcentageAutreMoisRetard;
    private String pourcentageAutreMoisRetardMin;
    private String pourcentageAutreMoisRetardMax;

    private TypeLocale38DetailCriteria typeLocale38Detail ;
    private List<TypeLocale38DetailCriteria> typeLocale38Details ;
    private CategorieLocaleCriteria categorieLocale ;
    private List<CategorieLocaleCriteria> categorieLocales ;


    public TauxTaxe38Criteria(){}

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
      
    public LocalDateTime getDateMin(){
        return this.dateMin;
    }
    public void setDateMin(LocalDateTime dateMin){
        this.dateMin = dateMin;
    }
    public LocalDateTime getDateMinFrom(){
        return this.dateMinFrom;
    }
    public void setDateMinFrom(LocalDateTime dateMinFrom){
        this.dateMinFrom = dateMinFrom;
    }
    public LocalDateTime getDateMinTo(){
        return this.dateMinTo;
    }
    public void setDateMinTo(LocalDateTime dateMinTo){
        this.dateMinTo = dateMinTo;
    }
    public LocalDateTime getDateMax(){
        return this.dateMax;
    }
    public void setDateMax(LocalDateTime dateMax){
        this.dateMax = dateMax;
    }
    public LocalDateTime getDateMaxFrom(){
        return this.dateMaxFrom;
    }
    public void setDateMaxFrom(LocalDateTime dateMaxFrom){
        this.dateMaxFrom = dateMaxFrom;
    }
    public LocalDateTime getDateMaxTo(){
        return this.dateMaxTo;
    }
    public void setDateMaxTo(LocalDateTime dateMaxTo){
        this.dateMaxTo = dateMaxTo;
    }
    public String getPourcentagePremierRetard(){
        return this.pourcentagePremierRetard;
    }
    public void setPourcentagePremierRetard(String pourcentagePremierRetard){
        this.pourcentagePremierRetard = pourcentagePremierRetard;
    }   
    public String getPourcentagePremierRetardMin(){
        return this.pourcentagePremierRetardMin;
    }
    public void setPourcentagePremierRetardMin(String pourcentagePremierRetardMin){
        this.pourcentagePremierRetardMin = pourcentagePremierRetardMin;
    }
    public String getPourcentagePremierRetardMax(){
        return this.pourcentagePremierRetardMax;
    }
    public void setPourcentagePremierRetardMax(String pourcentagePremierRetardMax){
        this.pourcentagePremierRetardMax = pourcentagePremierRetardMax;
    }
      
    public String getPourcentageAutreMoisRetard(){
        return this.pourcentageAutreMoisRetard;
    }
    public void setPourcentageAutreMoisRetard(String pourcentageAutreMoisRetard){
        this.pourcentageAutreMoisRetard = pourcentageAutreMoisRetard;
    }   
    public String getPourcentageAutreMoisRetardMin(){
        return this.pourcentageAutreMoisRetardMin;
    }
    public void setPourcentageAutreMoisRetardMin(String pourcentageAutreMoisRetardMin){
        this.pourcentageAutreMoisRetardMin = pourcentageAutreMoisRetardMin;
    }
    public String getPourcentageAutreMoisRetardMax(){
        return this.pourcentageAutreMoisRetardMax;
    }
    public void setPourcentageAutreMoisRetardMax(String pourcentageAutreMoisRetardMax){
        this.pourcentageAutreMoisRetardMax = pourcentageAutreMoisRetardMax;
    }
      

    public TypeLocale38DetailCriteria getTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }

    public void setTypeLocale38Detail(TypeLocale38DetailCriteria typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }
    public List<TypeLocale38DetailCriteria> getTypeLocale38Details(){
        return this.typeLocale38Details;
    }

    public void setTypeLocale38Details(List<TypeLocale38DetailCriteria> typeLocale38Details){
        this.typeLocale38Details = typeLocale38Details;
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
