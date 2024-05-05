package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface TauxTaxe38AdminService {



    List<TauxTaxe38> findByTypeLocale38DetailId(Long id);
    int deleteByTypeLocale38DetailId(Long id);
    long countByTypeLocale38DetailCode(String code);
    List<TauxTaxe38> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);




	TauxTaxe38 create(TauxTaxe38 t);

    TauxTaxe38 update(TauxTaxe38 t);

    List<TauxTaxe38> update(List<TauxTaxe38> ts,boolean createIfNotExist);

    TauxTaxe38 findById(Long id);

    TauxTaxe38 findOrSave(TauxTaxe38 t);

    TauxTaxe38 findByReferenceEntity(TauxTaxe38 t);

    TauxTaxe38 findWithAssociatedLists(Long id);

    List<TauxTaxe38> findAllOptimized();

    List<TauxTaxe38> findAll();

    List<TauxTaxe38> findByCriteria(TauxTaxe38Criteria criteria);

    List<TauxTaxe38> findPaginatedByCriteria(TauxTaxe38Criteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(TauxTaxe38Criteria criteria);

    List<TauxTaxe38> delete(List<TauxTaxe38> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<TauxTaxe38>> getToBeSavedAndToBeDeleted(List<TauxTaxe38> oldList, List<TauxTaxe38> newList);

    List<TauxTaxe38> importData(List<TauxTaxe38> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<TauxTaxe38> importExcel(MultipartFile file);

}
