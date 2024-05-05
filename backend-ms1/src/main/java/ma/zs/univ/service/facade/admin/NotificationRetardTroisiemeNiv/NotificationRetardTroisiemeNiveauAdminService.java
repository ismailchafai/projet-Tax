package ma.zs.univ.service.facade.admin.NotificationRetardTroisiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface NotificationRetardTroisiemeNiveauAdminService {



    List<NotificationRetardTroisiemeNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardTroisiemeNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<NotificationRetardTroisiemeNiveau> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);




	NotificationRetardTroisiemeNiveau create(NotificationRetardTroisiemeNiveau t);

    NotificationRetardTroisiemeNiveau update(NotificationRetardTroisiemeNiveau t);

    List<NotificationRetardTroisiemeNiveau> update(List<NotificationRetardTroisiemeNiveau> ts,boolean createIfNotExist);

    NotificationRetardTroisiemeNiveau findById(Long id);

    NotificationRetardTroisiemeNiveau findOrSave(NotificationRetardTroisiemeNiveau t);

    NotificationRetardTroisiemeNiveau findByReferenceEntity(NotificationRetardTroisiemeNiveau t);

    NotificationRetardTroisiemeNiveau findWithAssociatedLists(Long id);

    List<NotificationRetardTroisiemeNiveau> findAllOptimized();

    List<NotificationRetardTroisiemeNiveau> findAll();

    List<NotificationRetardTroisiemeNiveau> findByCriteria(NotificationRetardTroisiemeNiveauCriteria criteria);

    List<NotificationRetardTroisiemeNiveau> findPaginatedByCriteria(NotificationRetardTroisiemeNiveauCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(NotificationRetardTroisiemeNiveauCriteria criteria);

    List<NotificationRetardTroisiemeNiveau> delete(List<NotificationRetardTroisiemeNiveau> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<NotificationRetardTroisiemeNiveau>> getToBeSavedAndToBeDeleted(List<NotificationRetardTroisiemeNiveau> oldList, List<NotificationRetardTroisiemeNiveau> newList);

    List<NotificationRetardTroisiemeNiveau> importData(List<NotificationRetardTroisiemeNiveau> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<NotificationRetardTroisiemeNiveau> importExcel(MultipartFile file);

}
