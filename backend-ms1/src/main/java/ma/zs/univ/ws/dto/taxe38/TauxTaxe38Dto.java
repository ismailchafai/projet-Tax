package  ma.zs.univ.ws.dto.taxe38;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class TauxTaxe38Dto  extends AuditBaseDto {

    private String code  ;
    private BigDecimal montantParMetreCarre  ;
    private String dateMin ;
    private String dateMax ;
    private BigDecimal pourcentagePremierRetard  ;
    private BigDecimal pourcentageAutreMoisRetard  ;

    private TypeLocale38DetailDto typeLocale38Detail ;
    private CategorieLocaleDto categorieLocale ;



    public TauxTaxe38Dto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public BigDecimal getMontantParMetreCarre(){
        return this.montantParMetreCarre;
    }
    public void setMontantParMetreCarre(BigDecimal montantParMetreCarre){
        this.montantParMetreCarre = montantParMetreCarre;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateMin(){
        return this.dateMin;
    }
    public void setDateMin(String dateMin){
        this.dateMin = dateMin;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateMax(){
        return this.dateMax;
    }
    public void setDateMax(String dateMax){
        this.dateMax = dateMax;
    }

    @Log
    public BigDecimal getPourcentagePremierRetard(){
        return this.pourcentagePremierRetard;
    }
    public void setPourcentagePremierRetard(BigDecimal pourcentagePremierRetard){
        this.pourcentagePremierRetard = pourcentagePremierRetard;
    }

    @Log
    public BigDecimal getPourcentageAutreMoisRetard(){
        return this.pourcentageAutreMoisRetard;
    }
    public void setPourcentageAutreMoisRetard(BigDecimal pourcentageAutreMoisRetard){
        this.pourcentageAutreMoisRetard = pourcentageAutreMoisRetard;
    }


    public TypeLocale38DetailDto getTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }

    public void setTypeLocale38Detail(TypeLocale38DetailDto typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }
    public CategorieLocaleDto getCategorieLocale(){
        return this.categorieLocale;
    }

    public void setCategorieLocale(CategorieLocaleDto categorieLocale){
        this.categorieLocale = categorieLocale;
    }






}
