package ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface NotificationRetardDeuxiemeNiveauDetailType38AdminService {



    List<NotificationRetardDeuxiemeNiveauDetailType38> findByTypeLocale38Id(Long id);
    int deleteByTypeLocale38Id(Long id);
    long countByTypeLocale38Code(String code);




	NotificationRetardDeuxiemeNiveauDetailType38 create(NotificationRetardDeuxiemeNiveauDetailType38 t);

    NotificationRetardDeuxiemeNiveauDetailType38 update(NotificationRetardDeuxiemeNiveauDetailType38 t);

    List<NotificationRetardDeuxiemeNiveauDetailType38> update(List<NotificationRetardDeuxiemeNiveauDetailType38> ts,boolean createIfNotExist);

    NotificationRetardDeuxiemeNiveauDetailType38 findById(Long id);

    NotificationRetardDeuxiemeNiveauDetailType38 findOrSave(NotificationRetardDeuxiemeNiveauDetailType38 t);

    NotificationRetardDeuxiemeNiveauDetailType38 findByReferenceEntity(NotificationRetardDeuxiemeNiveauDetailType38 t);

    NotificationRetardDeuxiemeNiveauDetailType38 findWithAssociatedLists(Long id);

    List<NotificationRetardDeuxiemeNiveauDetailType38> findAllOptimized();

    List<NotificationRetardDeuxiemeNiveauDetailType38> findAll();

    List<NotificationRetardDeuxiemeNiveauDetailType38> findByCriteria(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria);

    List<NotificationRetardDeuxiemeNiveauDetailType38> findPaginatedByCriteria(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria);

    List<NotificationRetardDeuxiemeNiveauDetailType38> delete(List<NotificationRetardDeuxiemeNiveauDetailType38> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<NotificationRetardDeuxiemeNiveauDetailType38>> getToBeSavedAndToBeDeleted(List<NotificationRetardDeuxiemeNiveauDetailType38> oldList, List<NotificationRetardDeuxiemeNiveauDetailType38> newList);

    List<NotificationRetardDeuxiemeNiveauDetailType38> importData(List<NotificationRetardDeuxiemeNiveauDetailType38> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<NotificationRetardDeuxiemeNiveauDetailType38> importExcel(MultipartFile file);

}
