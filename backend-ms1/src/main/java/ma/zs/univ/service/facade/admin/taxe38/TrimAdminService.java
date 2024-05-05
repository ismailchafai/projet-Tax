package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.dao.criteria.core.taxe38.TrimCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface TrimAdminService {







	Trim create(Trim t);

    Trim update(Trim t);

    List<Trim> update(List<Trim> ts,boolean createIfNotExist);

    Trim findById(Long id);

    Trim findOrSave(Trim t);

    Trim findByReferenceEntity(Trim t);

    Trim findWithAssociatedLists(Long id);

    List<Trim> findAllOptimized();

    List<Trim> findAll();

    List<Trim> findByCriteria(TrimCriteria criteria);

    List<Trim> findPaginatedByCriteria(TrimCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(TrimCriteria criteria);

    List<Trim> delete(List<Trim> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Trim>> getToBeSavedAndToBeDeleted(List<Trim> oldList, List<Trim> newList);

    List<Trim> importData(List<Trim> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Trim> importExcel(MultipartFile file);

}
