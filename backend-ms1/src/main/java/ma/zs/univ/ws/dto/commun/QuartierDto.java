package  ma.zs.univ.ws.dto.commun;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuartierDto  extends AuditBaseDto {

    private String code  ;
    private String libelle  ;

    private SecteurDto secteur ;



    public QuartierDto(){
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


    public SecteurDto getSecteur(){
        return this.secteur;
    }

    public void setSecteur(SecteurDto secteur){
        this.secteur = secteur;
    }






}
