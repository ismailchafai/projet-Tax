package ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface NotificationRetardDeuxiemeNiveauAdminService {



    List<NotificationRetardDeuxiemeNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardDeuxiemeNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);




	NotificationRetardDeuxiemeNiveau create(NotificationRetardDeuxiemeNiveau t);

    NotificationRetardDeuxiemeNiveau update(NotificationRetardDeuxiemeNiveau t);

    List<NotificationRetardDeuxiemeNiveau> update(List<NotificationRetardDeuxiemeNiveau> ts,boolean createIfNotExist);

    NotificationRetardDeuxiemeNiveau findById(Long id);

    NotificationRetardDeuxiemeNiveau findOrSave(NotificationRetardDeuxiemeNiveau t);

    NotificationRetardDeuxiemeNiveau findByReferenceEntity(NotificationRetardDeuxiemeNiveau t);

    NotificationRetardDeuxiemeNiveau findWithAssociatedLists(Long id);

    List<NotificationRetardDeuxiemeNiveau> findAllOptimized();

    List<NotificationRetardDeuxiemeNiveau> findAll();

    List<NotificationRetardDeuxiemeNiveau> findByCriteria(NotificationRetardDeuxiemeNiveauCriteria criteria);

    List<NotificationRetardDeuxiemeNiveau> findPaginatedByCriteria(NotificationRetardDeuxiemeNiveauCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(NotificationRetardDeuxiemeNiveauCriteria criteria);

    List<NotificationRetardDeuxiemeNiveau> delete(List<NotificationRetardDeuxiemeNiveau> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<NotificationRetardDeuxiemeNiveau>> getToBeSavedAndToBeDeleted(List<NotificationRetardDeuxiemeNiveau> oldList, List<NotificationRetardDeuxiemeNiveau> newList);

    List<NotificationRetardDeuxiemeNiveau> importData(List<NotificationRetardDeuxiemeNiveau> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<NotificationRetardDeuxiemeNiveau> importExcel(MultipartFile file);

}
