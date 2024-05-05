package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface Locale38DetailAdminService {



    List<Locale38Detail> findByTypeLocale38DetailId(Long id);
    int deleteByTypeLocale38DetailId(Long id);
    long countByTypeLocale38DetailCode(String code);




	Locale38Detail create(Locale38Detail t);

    Locale38Detail update(Locale38Detail t);

    List<Locale38Detail> update(List<Locale38Detail> ts,boolean createIfNotExist);

    Locale38Detail findById(Long id);

    Locale38Detail findOrSave(Locale38Detail t);

    Locale38Detail findByReferenceEntity(Locale38Detail t);

    Locale38Detail findWithAssociatedLists(Long id);

    List<Locale38Detail> findAllOptimized();

    List<Locale38Detail> findAll();

    List<Locale38Detail> findByCriteria(Locale38DetailCriteria criteria);

    List<Locale38Detail> findPaginatedByCriteria(Locale38DetailCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(Locale38DetailCriteria criteria);

    List<Locale38Detail> delete(List<Locale38Detail> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Locale38Detail>> getToBeSavedAndToBeDeleted(List<Locale38Detail> oldList, List<Locale38Detail> newList);

    List<Locale38Detail> importData(List<Locale38Detail> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Locale38Detail> importExcel(MultipartFile file);

}
