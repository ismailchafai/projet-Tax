package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Secteur;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.Secteur;
import java.util.List;


@Repository
public interface SecteurDao extends AbstractRepository<Secteur,Long>  {
    Secteur findByCode(String code);
    int deleteByCode(String code);

    List<Secteur> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleCode(String code);

    @Query("SELECT NEW Secteur(item.id,item.libelle) FROM Secteur item")
    List<Secteur> findAllOptimized();

}
