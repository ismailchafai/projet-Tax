package ma.zs.univ.dao.facade.core.NotificationPremierNiv;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import java.util.List;


@Repository
public interface NotificationRetardPremierNiveauDao extends AbstractRepository<NotificationRetardPremierNiveau,Long>  {
    NotificationRetardPremierNiveau findByCode(String code);
    int deleteByCode(String code);

    List<NotificationRetardPremierNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardPremierNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);

    @Query("SELECT NEW NotificationRetardPremierNiveau(item.id,item.code) FROM NotificationRetardPremierNiveau item")
    List<NotificationRetardPremierNiveau> findAllOptimized();

}
