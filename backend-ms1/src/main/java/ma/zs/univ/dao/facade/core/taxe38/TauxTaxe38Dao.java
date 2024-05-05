package ma.zs.univ.dao.facade.core.taxe38;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import java.util.List;


@Repository
public interface TauxTaxe38Dao extends AbstractRepository<TauxTaxe38,Long>  {
    TauxTaxe38 findByCode(String code);
    int deleteByCode(String code);

    List<TauxTaxe38> findByTypeLocale38DetailId(Long id);
    int deleteByTypeLocale38DetailId(Long id);
    long countByTypeLocale38DetailCode(String code);
    List<TauxTaxe38> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);

    @Query("SELECT NEW TauxTaxe38(item.id,item.code) FROM TauxTaxe38 item")
    List<TauxTaxe38> findAllOptimized();

}
