package  ma.zs.univ.ws.dto.taxe38;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class Taxe38DetailDto  extends AuditBaseDto {

    private String code  ;
    private BigDecimal montantParMetreCarre  ;
    private BigDecimal montantBase  ;
    private BigDecimal montantRetardPremierMois  ;
    private BigDecimal montantRetardAutreMois  ;

    private Locale38DetailDto locale38Detail ;
    private TauxTaxe38Dto tauxTaxe38 ;
    private Taxe38Dto taxe38 ;



    public Taxe38DetailDto(){
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
    public BigDecimal getMontantBase(){
        return this.montantBase;
    }
    public void setMontantBase(BigDecimal montantBase){
        this.montantBase = montantBase;
    }

    @Log
    public BigDecimal getMontantRetardPremierMois(){
        return this.montantRetardPremierMois;
    }
    public void setMontantRetardPremierMois(BigDecimal montantRetardPremierMois){
        this.montantRetardPremierMois = montantRetardPremierMois;
    }

    @Log
    public BigDecimal getMontantRetardAutreMois(){
        return this.montantRetardAutreMois;
    }
    public void setMontantRetardAutreMois(BigDecimal montantRetardAutreMois){
        this.montantRetardAutreMois = montantRetardAutreMois;
    }


    public Locale38DetailDto getLocale38Detail(){
        return this.locale38Detail;
    }

    public void setLocale38Detail(Locale38DetailDto locale38Detail){
        this.locale38Detail = locale38Detail;
    }
    public TauxTaxe38Dto getTauxTaxe38(){
        return this.tauxTaxe38;
    }

    public void setTauxTaxe38(TauxTaxe38Dto tauxTaxe38){
        this.tauxTaxe38 = tauxTaxe38;
    }
    public Taxe38Dto getTaxe38(){
        return this.taxe38;
    }

    public void setTaxe38(Taxe38Dto taxe38){
        this.taxe38 = taxe38;
    }






}
