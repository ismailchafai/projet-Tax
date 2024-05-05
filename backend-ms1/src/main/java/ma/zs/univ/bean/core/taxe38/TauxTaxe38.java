package ma.zs.univ.bean.core.taxe38;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "taux_taxe38")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taux_taxe38_seq",sequenceName="taux_taxe38_seq",allocationSize=1, initialValue = 1)
public class TauxTaxe38  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal montantParMetreCarre = BigDecimal.ZERO;
    private LocalDateTime dateMin ;
    private LocalDateTime dateMax ;
    private BigDecimal pourcentagePremierRetard = BigDecimal.ZERO;
    private BigDecimal pourcentageAutreMoisRetard = BigDecimal.ZERO;

    private TypeLocale38Detail typeLocale38Detail ;
    private CategorieLocale categorieLocale ;


    public TauxTaxe38(){
        super();
    }

    public TauxTaxe38(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public TauxTaxe38(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="taux_taxe38_seq")
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
    public BigDecimal getMontantParMetreCarre(){
        return this.montantParMetreCarre;
    }
    public void setMontantParMetreCarre(BigDecimal montantParMetreCarre){
        this.montantParMetreCarre = montantParMetreCarre;
    }
    public LocalDateTime getDateMin(){
        return this.dateMin;
    }
    public void setDateMin(LocalDateTime dateMin){
        this.dateMin = dateMin;
    }
    public LocalDateTime getDateMax(){
        return this.dateMax;
    }
    public void setDateMax(LocalDateTime dateMax){
        this.dateMax = dateMax;
    }
    public BigDecimal getPourcentagePremierRetard(){
        return this.pourcentagePremierRetard;
    }
    public void setPourcentagePremierRetard(BigDecimal pourcentagePremierRetard){
        this.pourcentagePremierRetard = pourcentagePremierRetard;
    }
    public BigDecimal getPourcentageAutreMoisRetard(){
        return this.pourcentageAutreMoisRetard;
    }
    public void setPourcentageAutreMoisRetard(BigDecimal pourcentageAutreMoisRetard){
        this.pourcentageAutreMoisRetard = pourcentageAutreMoisRetard;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_locale38_detail")
    public TypeLocale38Detail getTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }
    public void setTypeLocale38Detail(TypeLocale38Detail typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
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
        TauxTaxe38 tauxTaxe38 = (TauxTaxe38) o;
        return id != null && id.equals(tauxTaxe38.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

