package ma.zs.univ.bean.core.taxe38;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "taxe38_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taxe38_detail_seq",sequenceName="taxe38_detail_seq",allocationSize=1, initialValue = 1)
public class Taxe38Detail  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal montantParMetreCarre = BigDecimal.ZERO;
    private BigDecimal montantBase = BigDecimal.ZERO;
    private BigDecimal montantRetardPremierMois = BigDecimal.ZERO;
    private BigDecimal montantRetardAutreMois = BigDecimal.ZERO;

    private Locale38Detail locale38Detail ;
    private TauxTaxe38 tauxTaxe38 ;
    private Taxe38 taxe38 ;


    public Taxe38Detail(){
        super();
    }

    public Taxe38Detail(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public Taxe38Detail(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="taxe38_detail_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locale38_detail")
    public Locale38Detail getLocale38Detail(){
        return this.locale38Detail;
    }
    public void setLocale38Detail(Locale38Detail locale38Detail){
        this.locale38Detail = locale38Detail;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taux_taxe38")
    public TauxTaxe38 getTauxTaxe38(){
        return this.tauxTaxe38;
    }
    public void setTauxTaxe38(TauxTaxe38 tauxTaxe38){
        this.tauxTaxe38 = tauxTaxe38;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxe38")
    public Taxe38 getTaxe38(){
        return this.taxe38;
    }
    public void setTaxe38(Taxe38 taxe38){
        this.taxe38 = taxe38;
    }
    public BigDecimal getMontantBase(){
        return this.montantBase;
    }
    public void setMontantBase(BigDecimal montantBase){
        this.montantBase = montantBase;
    }
    public BigDecimal getMontantRetardPremierMois(){
        return this.montantRetardPremierMois;
    }
    public void setMontantRetardPremierMois(BigDecimal montantRetardPremierMois){
        this.montantRetardPremierMois = montantRetardPremierMois;
    }
    public BigDecimal getMontantRetardAutreMois(){
        return this.montantRetardAutreMois;
    }
    public void setMontantRetardAutreMois(BigDecimal montantRetardAutreMois){
        this.montantRetardAutreMois = montantRetardAutreMois;
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
        Taxe38Detail taxe38Detail = (Taxe38Detail) o;
        return id != null && id.equals(taxe38Detail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

