package ma.zs.univ.dao.facade.core.taxe38;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import java.util.List;


@Repository
public interface Taxe38Dao extends AbstractRepository<Taxe38,Long>  {
    Taxe38 findByCode(String code);
    int deleteByCode(String code);

    List<Taxe38> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<Taxe38> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<Taxe38> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);

    @Query("SELECT NEW Taxe38(item.id,item.code) FROM Taxe38 item")
    List<Taxe38> findAllOptimized();

}
