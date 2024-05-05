package  ma.zs.univ.ws.dto.commun;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.univ.ws.dto.taxe38.CategorieLocaleDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocaleDto  extends AuditBaseDto {

    private String code  ;
    private String complementAdresse  ;

    private RueDto rue ;
    private RedevableDto redevable ;
    private CategorieLocaleDto categorieLocale ;



    public LocaleDto(){
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
    public String getComplementAdresse(){
        return this.complementAdresse;
    }
    public void setComplementAdresse(String complementAdresse){
        this.complementAdresse = complementAdresse;
    }


    public RueDto getRue(){
        return this.rue;
    }

    public void setRue(RueDto rue){
        this.rue = rue;
    }
    public RedevableDto getRedevable(){
        return this.redevable;
    }

    public void setRedevable(RedevableDto redevable){
        this.redevable = redevable;
    }
    public CategorieLocaleDto getCategorieLocale(){
        return this.categorieLocale;
    }

    public void setCategorieLocale(CategorieLocaleDto categorieLocale){
        this.categorieLocale = categorieLocale;
    }






}
