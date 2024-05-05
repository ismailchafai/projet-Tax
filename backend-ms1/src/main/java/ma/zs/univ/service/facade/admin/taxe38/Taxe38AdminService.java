package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface Taxe38AdminService {



    List<Taxe38> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<Taxe38> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<Taxe38> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);




	Taxe38 create(Taxe38 t);

    Taxe38 update(Taxe38 t);

    List<Taxe38> update(List<Taxe38> ts,boolean createIfNotExist);

    Taxe38 findById(Long id);

    Taxe38 findOrSave(Taxe38 t);

    Taxe38 findByReferenceEntity(Taxe38 t);

    Taxe38 findWithAssociatedLists(Long id);

    List<Taxe38> findAllOptimized();

    List<Taxe38> findAll();

    List<Taxe38> findByCriteria(Taxe38Criteria criteria);

    List<Taxe38> findPaginatedByCriteria(Taxe38Criteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(Taxe38Criteria criteria);

    List<Taxe38> delete(List<Taxe38> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Taxe38>> getToBeSavedAndToBeDeleted(List<Taxe38> oldList, List<Taxe38> newList);

    List<Taxe38> importData(List<Taxe38> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Taxe38> importExcel(MultipartFile file);

}
