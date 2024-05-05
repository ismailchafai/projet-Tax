package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.dao.criteria.core.taxe38.CategorieLocaleCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface CategorieLocaleAdminService {







	CategorieLocale create(CategorieLocale t);

    CategorieLocale update(CategorieLocale t);

    List<CategorieLocale> update(List<CategorieLocale> ts,boolean createIfNotExist);

    CategorieLocale findById(Long id);

    CategorieLocale findOrSave(CategorieLocale t);

    CategorieLocale findByReferenceEntity(CategorieLocale t);

    CategorieLocale findWithAssociatedLists(Long id);

    List<CategorieLocale> findAllOptimized();

    List<CategorieLocale> findAll();

    List<CategorieLocale> findByCriteria(CategorieLocaleCriteria criteria);

    List<CategorieLocale> findPaginatedByCriteria(CategorieLocaleCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(CategorieLocaleCriteria criteria);

    List<CategorieLocale> delete(List<CategorieLocale> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<CategorieLocale>> getToBeSavedAndToBeDeleted(List<CategorieLocale> oldList, List<CategorieLocale> newList);

    List<CategorieLocale> importData(List<CategorieLocale> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<CategorieLocale> importExcel(MultipartFile file);

}
