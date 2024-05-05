package ma.zs.univ.dao.facade.core.taxe38;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import java.util.List;


@Repository
public interface Locale38DetailDao extends AbstractRepository<Locale38Detail,Long>  {
    Locale38Detail findByCode(String code);
    int deleteByCode(String code);

    List<Locale38Detail> findByTypeLocale38DetailId(Long id);
    int deleteByTypeLocale38DetailId(Long id);
    long countByTypeLocale38DetailCode(String code);

    @Query("SELECT NEW Locale38Detail(item.id,item.code) FROM Locale38Detail item")
    List<Locale38Detail> findAllOptimized();

}
