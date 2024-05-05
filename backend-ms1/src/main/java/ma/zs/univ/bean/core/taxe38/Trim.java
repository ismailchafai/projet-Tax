package ma.zs.univ.bean.core.taxe38;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trim")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="trim_seq",sequenceName="trim_seq",allocationSize=1, initialValue = 1)
public class Trim  extends BaseEntity     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    private Integer numero = 0;



    public Trim(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="trim_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public Integer getNumero(){
        return this.numero;
    }
    public void setNumero(Integer numero){
        this.numero = numero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trim trim = (Trim) o;
        return id != null && id.equals(trim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

