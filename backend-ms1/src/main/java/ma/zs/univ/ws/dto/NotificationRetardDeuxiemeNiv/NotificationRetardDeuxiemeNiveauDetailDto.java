package  ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.univ.ws.dto.taxe38.TrimDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRetardDeuxiemeNiveauDetailDto  extends AuditBaseDto {

    private String code  ;
    private BigDecimal montantBase  ;
    private BigDecimal montantRetardPremierMois  ;
    private BigDecimal montantRetardAutreMois  ;
    private BigDecimal montantTotal  ;

    private TrimDto trim ;



    public NotificationRetardDeuxiemeNiveauDetailDto(){
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

    @Log
    public BigDecimal getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal){
        this.montantTotal = montantTotal;
    }


    public TrimDto getTrim(){
        return this.trim;
    }

    public void setTrim(TrimDto trim){
        this.trim = trim;
    }






}
