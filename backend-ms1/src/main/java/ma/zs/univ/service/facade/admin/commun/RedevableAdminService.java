package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface RedevableAdminService {


    Redevable findByUsername(String username);
    boolean changePassword(String username, String newPassword);





	Redevable create(Redevable t);

    Redevable update(Redevable t);

    List<Redevable> update(List<Redevable> ts,boolean createIfNotExist);

    Redevable findById(Long id);

    Redevable findOrSave(Redevable t);

    Redevable findByReferenceEntity(Redevable t);

    Redevable findWithAssociatedLists(Long id);

    List<Redevable> findAllOptimized();

    List<Redevable> findAll();

    List<Redevable> findByCriteria(RedevableCriteria criteria);

    List<Redevable> findPaginatedByCriteria(RedevableCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(RedevableCriteria criteria);

    List<Redevable> delete(List<Redevable> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Redevable>> getToBeSavedAndToBeDeleted(List<Redevable> oldList, List<Redevable> newList);

    List<Redevable> importData(List<Redevable> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Redevable> importExcel(MultipartFile file);

}
