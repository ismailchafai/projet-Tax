package ma.zs.univ.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Locale;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.commun.Locale;
import java.util.List;


@Repository
public interface LocaleDao extends AbstractRepository<Locale,Long>  {
    Locale findByCode(String code);
    int deleteByCode(String code);

    List<Locale> findByRueId(Long id);
    int deleteByRueId(Long id);
    long countByRueCode(String code);
    List<Locale> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<Locale> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);

    @Query("SELECT NEW Locale(item.id,item.code) FROM Locale item")
    List<Locale> findAllOptimized();

}
