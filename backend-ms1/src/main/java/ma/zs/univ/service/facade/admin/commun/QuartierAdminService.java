package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface QuartierAdminService {



    List<Quartier> findBySecteurId(Long id);
    int deleteBySecteurId(Long id);
    long countBySecteurCode(String code);




	Quartier create(Quartier t);

    Quartier update(Quartier t);

    List<Quartier> update(List<Quartier> ts,boolean createIfNotExist);

    Quartier findById(Long id);

    Quartier findOrSave(Quartier t);

    Quartier findByReferenceEntity(Quartier t);

    Quartier findWithAssociatedLists(Long id);

    List<Quartier> findAllOptimized();

    List<Quartier> findAll();

    List<Quartier> findByCriteria(QuartierCriteria criteria);

    List<Quartier> findPaginatedByCriteria(QuartierCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(QuartierCriteria criteria);

    List<Quartier> delete(List<Quartier> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Quartier>> getToBeSavedAndToBeDeleted(List<Quartier> oldList, List<Quartier> newList);

    List<Quartier> importData(List<Quartier> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Quartier> importExcel(MultipartFile file);

}
