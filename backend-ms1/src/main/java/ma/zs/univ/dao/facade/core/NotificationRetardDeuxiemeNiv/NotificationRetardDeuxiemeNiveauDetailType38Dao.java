package ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import java.util.List;


@Repository
public interface NotificationRetardDeuxiemeNiveauDetailType38Dao extends AbstractRepository<NotificationRetardDeuxiemeNiveauDetailType38,Long>  {
    NotificationRetardDeuxiemeNiveauDetailType38 findByCode(String code);
    int deleteByCode(String code);

    List<NotificationRetardDeuxiemeNiveauDetailType38> findByTypeLocale38Id(Long id);
    int deleteByTypeLocale38Id(Long id);
    long countByTypeLocale38Code(String code);

    @Query("SELECT NEW NotificationRetardDeuxiemeNiveauDetailType38(item.id,item.code) FROM NotificationRetardDeuxiemeNiveauDetailType38 item")
    List<NotificationRetardDeuxiemeNiveauDetailType38> findAllOptimized();

}
