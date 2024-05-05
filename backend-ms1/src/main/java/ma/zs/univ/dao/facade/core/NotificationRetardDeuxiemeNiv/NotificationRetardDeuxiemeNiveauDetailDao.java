package ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import java.util.List;


@Repository
public interface NotificationRetardDeuxiemeNiveauDetailDao extends AbstractRepository<NotificationRetardDeuxiemeNiveauDetail,Long>  {
    NotificationRetardDeuxiemeNiveauDetail findByCode(String code);
    int deleteByCode(String code);

    List<NotificationRetardDeuxiemeNiveauDetail> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);

    @Query("SELECT NEW NotificationRetardDeuxiemeNiveauDetail(item.id,item.code) FROM NotificationRetardDeuxiemeNiveauDetail item")
    List<NotificationRetardDeuxiemeNiveauDetail> findAllOptimized();

}
