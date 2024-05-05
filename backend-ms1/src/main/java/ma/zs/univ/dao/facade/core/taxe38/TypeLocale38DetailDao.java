package ma.zs.univ.dao.facade.core.taxe38;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import java.util.List;


@Repository
public interface TypeLocale38DetailDao extends AbstractRepository<TypeLocale38Detail,Long>  {
    TypeLocale38Detail findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeLocale38Detail(item.id,item.code) FROM TypeLocale38Detail item")
    List<TypeLocale38Detail> findAllOptimized();

}
