package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.dao.criteria.core.commun.RueCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface RueAdminService {



    List<Rue> findByQuartierId(Long id);
    int deleteByQuartierId(Long id);
    long countByQuartierCode(String code);




	Rue create(Rue t);

    Rue update(Rue t);

    List<Rue> update(List<Rue> ts,boolean createIfNotExist);

    Rue findById(Long id);

    Rue findOrSave(Rue t);

    Rue findByReferenceEntity(Rue t);

    Rue findWithAssociatedLists(Long id);

    List<Rue> findAllOptimized();

    List<Rue> findAll();

    List<Rue> findByCriteria(RueCriteria criteria);

    List<Rue> findPaginatedByCriteria(RueCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(RueCriteria criteria);

    List<Rue> delete(List<Rue> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Rue>> getToBeSavedAndToBeDeleted(List<Rue> oldList, List<Rue> newList);

    List<Rue> importData(List<Rue> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Rue> importExcel(MultipartFile file);

}
