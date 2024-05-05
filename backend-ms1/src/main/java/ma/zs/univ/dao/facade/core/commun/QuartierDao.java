package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Quartier;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.Quartier;
import java.util.List;


@Repository
public interface QuartierDao extends AbstractRepository<Quartier,Long>  {
    Quartier findByCode(String code);
    int deleteByCode(String code);

    List<Quartier> findBySecteurId(Long id);
    int deleteBySecteurId(Long id);
    long countBySecteurCode(String code);

    @Query("SELECT NEW Quartier(item.id,item.libelle) FROM Quartier item")
    List<Quartier> findAllOptimized();

}
