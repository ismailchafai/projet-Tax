package ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv;

import java.util.Objects;





import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;
import java.math.BigDecimal;

@Entity
@Table(name = "notification_retard_deuxieme_niveau_detail_type38")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="notification_retard_deuxieme_niveau_detail_type38_seq",sequenceName="notification_retard_deuxieme_niveau_detail_type38_seq",allocationSize=1, initialValue = 1)
public class NotificationRetardDeuxiemeNiveauDetailType38  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    private BigDecimal montantBase = BigDecimal.ZERO;
    private BigDecimal montantRetardPremierMois = BigDecimal.ZERO;
    private BigDecimal montantRetardAutreMois = BigDecimal.ZERO;
    private BigDecimal montantTotal = BigDecimal.ZERO;

    private TypeLocale38Detail typeLocale38 ;


    public NotificationRetardDeuxiemeNiveauDetailType38(){
        super();
    }

    public NotificationRetardDeuxiemeNiveauDetailType38(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public NotificationRetardDeuxiemeNiveauDetailType38(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="notification_retard_deuxieme_niveau_detail_type38_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_locale38")
    public TypeLocale38Detail getTypeLocale38(){
        return this.typeLocale38;
    }
    public void setTypeLocale38(TypeLocale38Detail typeLocale38){
        this.typeLocale38 = typeLocale38;
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
    public BigDecimal getMontantTotal(){
        return this.montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal){
        this.montantTotal = montantTotal;
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
        NotificationRetardDeuxiemeNiveauDetailType38 notificationRetardDeuxiemeNiveauDetailType38 = (NotificationRetardDeuxiemeNiveauDetailType38) o;
        return id != null && id.equals(notificationRetardDeuxiemeNiveauDetailType38.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

