package ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import java.util.List;


@Repository
public interface NotificationRetardDeuxiemeNiveauDao extends AbstractRepository<NotificationRetardDeuxiemeNiveau,Long>  {
    NotificationRetardDeuxiemeNiveau findByCode(String code);
    int deleteByCode(String code);

    List<NotificationRetardDeuxiemeNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardDeuxiemeNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);

    @Query("SELECT NEW NotificationRetardDeuxiemeNiveau(item.id,item.code) FROM NotificationRetardDeuxiemeNiveau item")
    List<NotificationRetardDeuxiemeNiveau> findAllOptimized();

}
