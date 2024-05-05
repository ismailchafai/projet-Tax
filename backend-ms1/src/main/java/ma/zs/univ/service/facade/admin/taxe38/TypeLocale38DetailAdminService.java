package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface TypeLocale38DetailAdminService {







	TypeLocale38Detail create(TypeLocale38Detail t);

    TypeLocale38Detail update(TypeLocale38Detail t);

    List<TypeLocale38Detail> update(List<TypeLocale38Detail> ts,boolean createIfNotExist);

    TypeLocale38Detail findById(Long id);

    TypeLocale38Detail findOrSave(TypeLocale38Detail t);

    TypeLocale38Detail findByReferenceEntity(TypeLocale38Detail t);

    TypeLocale38Detail findWithAssociatedLists(Long id);

    List<TypeLocale38Detail> findAllOptimized();

    List<TypeLocale38Detail> findAll();

    List<TypeLocale38Detail> findByCriteria(TypeLocale38DetailCriteria criteria);

    List<TypeLocale38Detail> findPaginatedByCriteria(TypeLocale38DetailCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(TypeLocale38DetailCriteria criteria);

    List<TypeLocale38Detail> delete(List<TypeLocale38Detail> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<TypeLocale38Detail>> getToBeSavedAndToBeDeleted(List<TypeLocale38Detail> oldList, List<TypeLocale38Detail> newList);

    List<TypeLocale38Detail> importData(List<TypeLocale38Detail> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<TypeLocale38Detail> importExcel(MultipartFile file);

}
