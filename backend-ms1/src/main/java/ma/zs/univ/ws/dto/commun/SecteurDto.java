package  ma.zs.univ.ws.dto.commun;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecteurDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;

    private VilleDto ville ;



    public SecteurDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    public VilleDto getVille(){
        return this.ville;
    }

    public void setVille(VilleDto ville){
        this.ville = ville;
    }






}
