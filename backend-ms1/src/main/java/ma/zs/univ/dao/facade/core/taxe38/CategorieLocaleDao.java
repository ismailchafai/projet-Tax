package ma.zs.univ.dao.facade.core.taxe38;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import java.util.List;


@Repository
public interface CategorieLocaleDao extends AbstractRepository<CategorieLocale,Long>  {
    CategorieLocale findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CategorieLocale(item.id,item.code) FROM CategorieLocale item")
    List<CategorieLocale> findAllOptimized();

}
