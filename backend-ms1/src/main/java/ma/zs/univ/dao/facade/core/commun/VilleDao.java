package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Ville;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.Ville;
import java.util.List;


@Repository
public interface VilleDao extends AbstractRepository<Ville,Long>  {
    Ville findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Ville(item.id,item.libelle) FROM Ville item")
    List<Ville> findAllOptimized();

}
