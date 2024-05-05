package ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv;

import java.util.Objects;





import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.bean.core.commun.Redevable;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "notification_retard_troisieme_niveau")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="notification_retard_troisieme_niveau_seq",sequenceName="notification_retard_troisieme_niveau_seq",allocationSize=1, initialValue = 1)
public class NotificationRetardTroisiemeNiveau  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String code;
    private Integer anne = 0;

    private Locale locale ;
    private Redevable redevable ;
    private Trim trim ;


    public NotificationRetardTroisiemeNiveau(){
        super();
    }

    public NotificationRetardTroisiemeNiveau(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public NotificationRetardTroisiemeNiveau(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="notification_retard_troisieme_niveau_seq")
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
    @JoinColumn(name = "locale")
    public Locale getLocale(){
        return this.locale;
    }
    public void setLocale(Locale locale){
        this.locale = locale;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "redevable")
    public Redevable getRedevable(){
        return this.redevable;
    }
    public void setRedevable(Redevable redevable){
        this.redevable = redevable;
    }
    public Integer getAnne(){
        return this.anne;
    }
    public void setAnne(Integer anne){
        this.anne = anne;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trim")
    public Trim getTrim(){
        return this.trim;
    }
    public void setTrim(Trim trim){
        this.trim = trim;
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
        NotificationRetardTroisiemeNiveau notificationRetardTroisiemeNiveau = (NotificationRetardTroisiemeNiveau) o;
        return id != null && id.equals(notificationRetardTroisiemeNiveau.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

