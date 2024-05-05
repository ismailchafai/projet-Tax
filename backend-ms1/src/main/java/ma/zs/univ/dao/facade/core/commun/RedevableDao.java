package ma.zs.univ.dao.facade.core.commun;

import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.commun.Redevable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RedevableDao extends AbstractRepository<Redevable,Long>  {

    Redevable findByUsername(String username);


}
