package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Rue;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.Rue;
import java.util.List;


@Repository
public interface RueDao extends AbstractRepository<Rue,Long>  {
    Rue findByCode(String code);
    int deleteByCode(String code);

    List<Rue> findByQuartierId(Long id);
    int deleteByQuartierId(Long id);
    long countByQuartierCode(String code);

    @Query("SELECT NEW Rue(item.id,item.libelle) FROM Rue item")
    List<Rue> findAllOptimized();

}
