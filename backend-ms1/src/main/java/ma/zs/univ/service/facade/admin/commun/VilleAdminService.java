package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Ville;
import ma.zs.univ.dao.criteria.core.commun.VilleCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface VilleAdminService {







	Ville create(Ville t);

    Ville update(Ville t);

    List<Ville> update(List<Ville> ts,boolean createIfNotExist);

    Ville findById(Long id);

    Ville findOrSave(Ville t);

    Ville findByReferenceEntity(Ville t);

    Ville findWithAssociatedLists(Long id);

    List<Ville> findAllOptimized();

    List<Ville> findAll();

    List<Ville> findByCriteria(VilleCriteria criteria);

    List<Ville> findPaginatedByCriteria(VilleCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(VilleCriteria criteria);

    List<Ville> delete(List<Ville> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Ville>> getToBeSavedAndToBeDeleted(List<Ville> oldList, List<Ville> newList);

    List<Ville> importData(List<Ville> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Ville> importExcel(MultipartFile file);

}
