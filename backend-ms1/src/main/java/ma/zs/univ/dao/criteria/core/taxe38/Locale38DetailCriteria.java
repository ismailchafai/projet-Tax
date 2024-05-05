package  ma.zs.univ.dao.criteria.core.taxe38;



import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class Locale38DetailCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String superficie;
    private String superficieMin;
    private String superficieMax;
    private Boolean active;

    private TypeLocale38DetailCriteria typeLocale38Detail ;
    private List<TypeLocale38DetailCriteria> typeLocale38Details ;


    public Locale38DetailCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getSuperficie(){
        return this.superficie;
    }
    public void setSuperficie(String superficie){
        this.superficie = superficie;
    }   
    public String getSuperficieMin(){
        return this.superficieMin;
    }
    public void setSuperficieMin(String superficieMin){
        this.superficieMin = superficieMin;
    }
    public String getSuperficieMax(){
        return this.superficieMax;
    }
    public void setSuperficieMax(String superficieMax){
        this.superficieMax = superficieMax;
    }
      
    public Boolean getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }

    public TypeLocale38DetailCriteria getTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }

    public void setTypeLocale38Detail(TypeLocale38DetailCriteria typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }
    public List<TypeLocale38DetailCriteria> getTypeLocale38Details(){
        return this.typeLocale38Details;
    }

    public void setTypeLocale38Details(List<TypeLocale38DetailCriteria> typeLocale38Details){
        this.typeLocale38Details = typeLocale38Details;
    }
}
