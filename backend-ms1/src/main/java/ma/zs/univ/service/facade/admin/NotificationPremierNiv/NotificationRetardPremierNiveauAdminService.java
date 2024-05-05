package ma.zs.univ.service.facade.admin.NotificationPremierNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface NotificationRetardPremierNiveauAdminService {



    List<NotificationRetardPremierNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardPremierNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);




	NotificationRetardPremierNiveau create(NotificationRetardPremierNiveau t);

    NotificationRetardPremierNiveau update(NotificationRetardPremierNiveau t);

    List<NotificationRetardPremierNiveau> update(List<NotificationRetardPremierNiveau> ts,boolean createIfNotExist);

    NotificationRetardPremierNiveau findById(Long id);

    NotificationRetardPremierNiveau findOrSave(NotificationRetardPremierNiveau t);

    NotificationRetardPremierNiveau findByReferenceEntity(NotificationRetardPremierNiveau t);

    NotificationRetardPremierNiveau findWithAssociatedLists(Long id);

    List<NotificationRetardPremierNiveau> findAllOptimized();

    List<NotificationRetardPremierNiveau> findAll();

    List<NotificationRetardPremierNiveau> findByCriteria(NotificationRetardPremierNiveauCriteria criteria);

    List<NotificationRetardPremierNiveau> findPaginatedByCriteria(NotificationRetardPremierNiveauCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(NotificationRetardPremierNiveauCriteria criteria);

    List<NotificationRetardPremierNiveau> delete(List<NotificationRetardPremierNiveau> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<NotificationRetardPremierNiveau>> getToBeSavedAndToBeDeleted(List<NotificationRetardPremierNiveau> oldList, List<NotificationRetardPremierNiveau> newList);

    List<NotificationRetardPremierNiveau> importData(List<NotificationRetardPremierNiveau> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<NotificationRetardPremierNiveau> importExcel(MultipartFile file);

}
