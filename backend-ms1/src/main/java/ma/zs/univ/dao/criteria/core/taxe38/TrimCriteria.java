package  ma.zs.univ.dao.criteria.core.taxe38;



import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class TrimCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String numero;
    private String numeroMin;
    private String numeroMax;



    public TrimCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getNumero(){
        return this.numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }   
    public String getNumeroMin(){
        return this.numeroMin;
    }
    public void setNumeroMin(String numeroMin){
        this.numeroMin = numeroMin;
    }
    public String getNumeroMax(){
        return this.numeroMax;
    }
    public void setNumeroMax(String numeroMax){
        this.numeroMax = numeroMax;
    }
      

}
