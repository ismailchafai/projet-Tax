package  ma.zs.univ.ws.dto.NotificationPremierNiv;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.univ.ws.dto.commun.LocaleDto;
import ma.zs.univ.ws.dto.commun.RedevableDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRetardPremierNiveauDto  extends AuditBaseDto {

    private String code  ;
    private Integer anne  = 0 ;
    private BigDecimal montantBase  ;

    private LocaleDto locale ;
    private RedevableDto redevable ;



    public NotificationRetardPremierNiveauDto(){
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
    public BigDecimal getMontantBase(){
        return this.montantBase;
    }
    public void setMontantBase(BigDecimal montantBase){
        this.montantBase = montantBase;
    }


    public LocaleDto getLocale(){
        return this.locale;
    }

    public void setLocale(LocaleDto locale){
        this.locale = locale;
    }
    public RedevableDto getRedevable(){
        return this.redevable;
    }

    public void setRedevable(RedevableDto redevable){
        this.redevable = redevable;
    }






}
