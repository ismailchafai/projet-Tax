package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface Taxe38DetailAdminService {



    List<Taxe38Detail> findByLocale38DetailId(Long id);
    int deleteByLocale38DetailId(Long id);
    long countByLocale38DetailCode(String code);
    List<Taxe38Detail> findByTauxTaxe38Id(Long id);
    int deleteByTauxTaxe38Id(Long id);
    long countByTauxTaxe38Code(String code);
    List<Taxe38Detail> findByTaxe38Id(Long id);
    int deleteByTaxe38Id(Long id);
    long countByTaxe38Code(String code);




	Taxe38Detail create(Taxe38Detail t);

    Taxe38Detail update(Taxe38Detail t);

    List<Taxe38Detail> update(List<Taxe38Detail> ts,boolean createIfNotExist);

    Taxe38Detail findById(Long id);

    Taxe38Detail findOrSave(Taxe38Detail t);

    Taxe38Detail findByReferenceEntity(Taxe38Detail t);

    Taxe38Detail findWithAssociatedLists(Long id);

    List<Taxe38Detail> findAllOptimized();

    List<Taxe38Detail> findAll();

    List<Taxe38Detail> findByCriteria(Taxe38DetailCriteria criteria);

    List<Taxe38Detail> findPaginatedByCriteria(Taxe38DetailCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(Taxe38DetailCriteria criteria);

    List<Taxe38Detail> delete(List<Taxe38Detail> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Taxe38Detail>> getToBeSavedAndToBeDeleted(List<Taxe38Detail> oldList, List<Taxe38Detail> newList);

    List<Taxe38Detail> importData(List<Taxe38Detail> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Taxe38Detail> importExcel(MultipartFile file);

}
