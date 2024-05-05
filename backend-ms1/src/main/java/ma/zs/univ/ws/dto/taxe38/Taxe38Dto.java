package  ma.zs.univ.ws.dto.taxe38;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.univ.ws.dto.commun.LocaleDto;
import ma.zs.univ.ws.dto.commun.RedevableDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Taxe38Dto  extends AuditBaseDto {

    private String code  ;
    private Integer anne  = 0 ;
    private String datePresentaion ;
    private Integer nombreMoisRetard  = 0 ;
    private BigDecimal montantBase  ;
    private BigDecimal montantRetardPremeirMois  ;
    private BigDecimal montantTotal  ;

    private RedevableDto redevable ;
    private LocaleDto locale ;
    private TrimDto trim ;

    private List<Taxe38DetailDto> taxe38Details ;


    public Taxe38Dto(){
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
    public Integer getAnne(){
        return this.anne;
    }
    public void setAnne(Integer anne){
        this.anne = anne;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePresentaion(){
        return this.datePresentaion;
    }
    public void setDatePresentaion(String datePresentaion){
        this.datePresentaion = datePresentaion;
    }

    @Log
    public Integer getNombreMoisRetard(){
        return this.nombreMoisRetard;
    }
    public void setNombreMoisRetard(Integer nombreMoisRetard){
        this.nombreMoisRetard = nombreMoisRetard;
    }

    @Log
    public BigDecimal getMontantBase(){
        return this.montantBase;
    }
    public void setMontantBase(BigDecimal montantBase){
        this.montantBase = montantBase;
    }

    @Log
    public BigDecimal getMontantRetardPremeirMois(){
        return this.montantRetardPremeirMois;
    }
    public void setMontantRetardPremeirMois(BigDecimal montantRetardPremeirMois){
        this.montantRetardPremeirMois = montantRetardPremeirMois;
    }

    @Log
    public BigDecimal getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal){
        this.montantTotal = montantTotal;
    }


    public RedevableDto getRedevable(){
        return this.redevable;
    }

    public void setRedevable(RedevableDto redevable){
        this.redevable = redevable;
    }
    public LocaleDto getLocale(){
        return this.locale;
    }

    public void setLocale(LocaleDto locale){
        this.locale = locale;
    }
    public TrimDto getTrim(){
        return this.trim;
    }

    public void setTrim(TrimDto trim){
        this.trim = trim;
    }



    public List<Taxe38DetailDto> getTaxe38Details(){
        return this.taxe38Details;
    }

    public void setTaxe38Details(List<Taxe38DetailDto> taxe38Details){
        this.taxe38Details = taxe38Details;
    }



}
