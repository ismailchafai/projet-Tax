package ma.zs.univ.dao.facade.core.NotificationRetardTroisiemeNiv;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import java.util.List;


@Repository
public interface NotificationRetardTroisiemeNiveauDao extends AbstractRepository<NotificationRetardTroisiemeNiveau,Long>  {
    NotificationRetardTroisiemeNiveau findByCode(String code);
    int deleteByCode(String code);

    List<NotificationRetardTroisiemeNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardTroisiemeNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<NotificationRetardTroisiemeNiveau> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);

    @Query("SELECT NEW NotificationRetardTroisiemeNiveau(item.id,item.code) FROM NotificationRetardTroisiemeNiveau item")
    List<NotificationRetardTroisiemeNiveau> findAllOptimized();

}
