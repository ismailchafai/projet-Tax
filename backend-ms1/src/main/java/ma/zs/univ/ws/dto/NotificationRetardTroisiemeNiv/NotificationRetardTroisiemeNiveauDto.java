package  ma.zs.univ.ws.dto.NotificationRetardTroisiemeNiv;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.univ.ws.dto.commun.LocaleDto;
import ma.zs.univ.ws.dto.taxe38.TrimDto;
import ma.zs.univ.ws.dto.commun.RedevableDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRetardTroisiemeNiveauDto  extends AuditBaseDto {

    private String code  ;
    private Integer anne  = 0 ;

    private LocaleDto locale ;
    private RedevableDto redevable ;
    private TrimDto trim ;



    public NotificationRetardTroisiemeNiveauDto(){
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
    public TrimDto getTrim(){
        return this.trim;
    }

    public void setTrim(TrimDto trim){
        this.trim = trim;
    }






}
