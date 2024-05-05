package ma.zs.univ.dao.facade.core.taxe38;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import java.util.List;


@Repository
public interface Taxe38DetailDao extends AbstractRepository<Taxe38Detail,Long>  {
    Taxe38Detail findByCode(String code);
    int deleteByCode(String code);

    List<Taxe38Detail> findByLocale38DetailId(Long id);
    int deleteByLocale38DetailId(Long id);
    long countByLocale38DetailCode(String code);
    List<Taxe38Detail> findByTauxTaxe38Id(Long id);
    int deleteByTauxTaxe38Id(Long id);
    long countByTauxTaxe38Code(String code);
    List<Taxe38Detail> findByTaxe38Id(Long id);
    int deleteByTaxe38Id(Long id);
    long countByTaxe38Code(String code);

    @Query("SELECT NEW Taxe38Detail(item.id,item.code) FROM Taxe38Detail item")
    List<Taxe38Detail> findAllOptimized();

}
