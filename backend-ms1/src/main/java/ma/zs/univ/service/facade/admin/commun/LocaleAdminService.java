package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface LocaleAdminService {



    List<Locale> findByRueId(Long id);
    int deleteByRueId(Long id);
    long countByRueCode(String code);
    List<Locale> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<Locale> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);




	Locale create(Locale t);

    Locale update(Locale t);

    List<Locale> update(List<Locale> ts,boolean createIfNotExist);

    Locale findById(Long id);

    Locale findOrSave(Locale t);

    Locale findByReferenceEntity(Locale t);

    Locale findWithAssociatedLists(Long id);

    List<Locale> findAllOptimized();

    List<Locale> findAll();

    List<Locale> findByCriteria(LocaleCriteria criteria);

    List<Locale> findPaginatedByCriteria(LocaleCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(LocaleCriteria criteria);

    List<Locale> delete(List<Locale> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Locale>> getToBeSavedAndToBeDeleted(List<Locale> oldList, List<Locale> newList);

    List<Locale> importData(List<Locale> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Locale> importExcel(MultipartFile file);

}
