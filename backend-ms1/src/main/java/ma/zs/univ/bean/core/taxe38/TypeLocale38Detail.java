package ma.zs.univ.bean.core.taxe38;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_locale38_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_locale38_detail_seq",sequenceName="type_locale38_detail_seq",allocationSize=1, initialValue = 1)
public class TypeLocale38Detail  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;



    public TypeLocale38Detail(){
        super();
    }

    public TypeLocale38Detail(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public TypeLocale38Detail(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_locale38_detail_seq")
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
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
        TypeLocale38Detail typeLocale38Detail = (TypeLocale38Detail) o;
        return id != null && id.equals(typeLocale38Detail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

