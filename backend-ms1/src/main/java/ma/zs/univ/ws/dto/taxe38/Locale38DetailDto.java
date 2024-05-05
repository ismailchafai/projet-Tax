package  ma.zs.univ.ws.dto.taxe38;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class Locale38DetailDto  extends AuditBaseDto {

    private String code  ;
    private BigDecimal superficie  ;
    private Boolean active  ;

    private TypeLocale38DetailDto typeLocale38Detail ;



    public Locale38DetailDto(){
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
    public BigDecimal getSuperficie(){
        return this.superficie;
    }
    public void setSuperficie(BigDecimal superficie){
        this.superficie = superficie;
    }

    @Log
    public Boolean getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }


    public TypeLocale38DetailDto getTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }

    public void setTypeLocale38Detail(TypeLocale38DetailDto typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }






}
