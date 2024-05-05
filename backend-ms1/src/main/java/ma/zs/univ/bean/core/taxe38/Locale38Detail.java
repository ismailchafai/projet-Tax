package ma.zs.univ.bean.core.taxe38;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "locale38_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="locale38_detail_seq",sequenceName="locale38_detail_seq",allocationSize=1, initialValue = 1)
public class Locale38Detail  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal superficie = BigDecimal.ZERO;
    @Column(columnDefinition = "boolean default false")
    private Boolean active = false;

    private TypeLocale38Detail typeLocale38Detail ;


    public Locale38Detail(){
        super();
    }

    public Locale38Detail(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public Locale38Detail(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="locale38_detail_seq")
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
    public BigDecimal getSuperficie(){
        return this.superficie;
    }
    public void setSuperficie(BigDecimal superficie){
        this.superficie = superficie;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_locale38_detail")
    public TypeLocale38Detail getTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }
    public void setTypeLocale38Detail(TypeLocale38Detail typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }
    public Boolean  getActive(){
        return this.active;
    }
    public void setActive(Boolean active){
        this.active = active;
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
        Locale38Detail locale38Detail = (Locale38Detail) o;
        return id != null && id.equals(locale38Detail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

