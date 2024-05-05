package ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface NotificationRetardDeuxiemeNiveauDetailAdminService {



    List<NotificationRetardDeuxiemeNiveauDetail> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);




	NotificationRetardDeuxiemeNiveauDetail create(NotificationRetardDeuxiemeNiveauDetail t);

    NotificationRetardDeuxiemeNiveauDetail update(NotificationRetardDeuxiemeNiveauDetail t);

    List<NotificationRetardDeuxiemeNiveauDetail> update(List<NotificationRetardDeuxiemeNiveauDetail> ts,boolean createIfNotExist);

    NotificationRetardDeuxiemeNiveauDetail findById(Long id);

    NotificationRetardDeuxiemeNiveauDetail findOrSave(NotificationRetardDeuxiemeNiveauDetail t);

    NotificationRetardDeuxiemeNiveauDetail findByReferenceEntity(NotificationRetardDeuxiemeNiveauDetail t);

    NotificationRetardDeuxiemeNiveauDetail findWithAssociatedLists(Long id);

    List<NotificationRetardDeuxiemeNiveauDetail> findAllOptimized();

    List<NotificationRetardDeuxiemeNiveauDetail> findAll();

    List<NotificationRetardDeuxiemeNiveauDetail> findByCriteria(NotificationRetardDeuxiemeNiveauDetailCriteria criteria);

    List<NotificationRetardDeuxiemeNiveauDetail> findPaginatedByCriteria(NotificationRetardDeuxiemeNiveauDetailCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(NotificationRetardDeuxiemeNiveauDetailCriteria criteria);

    List<NotificationRetardDeuxiemeNiveauDetail> delete(List<NotificationRetardDeuxiemeNiveauDetail> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<NotificationRetardDeuxiemeNiveauDetail>> getToBeSavedAndToBeDeleted(List<NotificationRetardDeuxiemeNiveauDetail> oldList, List<NotificationRetardDeuxiemeNiveauDetail> newList);

    List<NotificationRetardDeuxiemeNiveauDetail> importData(List<NotificationRetardDeuxiemeNiveauDetail> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<NotificationRetardDeuxiemeNiveauDetail> importExcel(MultipartFile file);

}
