package ma.zs.univ.bean.core.commun;

import java.util.Objects;





import ma.zs.univ.bean.core.taxe38.CategorieLocale;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "locale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="locale_seq",sequenceName="locale_seq",allocationSize=1, initialValue = 1)
public class Locale  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String complementAdresse;

    private Rue rue ;
    private Redevable redevable ;
    private CategorieLocale categorieLocale ;


    public Locale(){
        super();
    }

    public Locale(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public Locale(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="locale_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getComplementAdresse(){
        return this.complementAdresse;
    }
    public void setComplementAdresse(String complementAdresse){
        this.complementAdresse = complementAdresse;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rue")
    public Rue getRue(){
        return this.rue;
    }
    public void setRue(Rue rue){
        this.rue = rue;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "redevable")
    public Redevable getRedevable(){
        return this.redevable;
    }
    public void setRedevable(Redevable redevable){
        this.redevable = redevable;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_locale")
    public CategorieLocale getCategorieLocale(){
        return this.categorieLocale;
    }
    public void setCategorieLocale(CategorieLocale categorieLocale){
        this.categorieLocale = categorieLocale;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locale locale = (Locale) o;
        return id != null && id.equals(locale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

