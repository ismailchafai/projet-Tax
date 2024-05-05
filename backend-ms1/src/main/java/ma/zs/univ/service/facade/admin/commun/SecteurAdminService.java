package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface SecteurAdminService {



    List<Secteur> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleCode(String code);




	Secteur create(Secteur t);

    Secteur update(Secteur t);

    List<Secteur> update(List<Secteur> ts,boolean createIfNotExist);

    Secteur findById(Long id);

    Secteur findOrSave(Secteur t);

    Secteur findByReferenceEntity(Secteur t);

    Secteur findWithAssociatedLists(Long id);

    List<Secteur> findAllOptimized();

    List<Secteur> findAll();

    List<Secteur> findByCriteria(SecteurCriteria criteria);

    List<Secteur> findPaginatedByCriteria(SecteurCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(SecteurCriteria criteria);

    List<Secteur> delete(List<Secteur> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<Secteur>> getToBeSavedAndToBeDeleted(List<Secteur> oldList, List<Secteur> newList);

    List<Secteur> importData(List<Secteur> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<Secteur> importExcel(MultipartFile file);

}
