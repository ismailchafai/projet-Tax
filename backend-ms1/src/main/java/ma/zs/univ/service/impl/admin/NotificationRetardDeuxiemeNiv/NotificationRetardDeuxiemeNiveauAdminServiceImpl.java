package ma.zs.univ.service.impl.admin.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDao;
import ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauSpecification;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import ma.zs.univ.zynerator.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.univ.service.facade.admin.commun.LocaleAdminService ;
import ma.zs.univ.bean.core.commun.Locale ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;

import java.util.List;
@Service
public class NotificationRetardDeuxiemeNiveauAdminServiceImpl implements NotificationRetardDeuxiemeNiveauAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardDeuxiemeNiveau update(NotificationRetardDeuxiemeNiveau t) {
        NotificationRetardDeuxiemeNiveau loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{NotificationRetardDeuxiemeNiveau.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public NotificationRetardDeuxiemeNiveau findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public NotificationRetardDeuxiemeNiveau findOrSave(NotificationRetardDeuxiemeNiveau t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            NotificationRetardDeuxiemeNiveau result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<NotificationRetardDeuxiemeNiveau> importData(List<NotificationRetardDeuxiemeNiveau> items) {
        List<NotificationRetardDeuxiemeNiveau> list = new ArrayList<>();
        for (NotificationRetardDeuxiemeNiveau t : items) {
            NotificationRetardDeuxiemeNiveau founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<NotificationRetardDeuxiemeNiveau> findAll() {
        return dao.findAll();
    }

    public List<NotificationRetardDeuxiemeNiveau> findByCriteria(NotificationRetardDeuxiemeNiveauCriteria criteria) {
        List<NotificationRetardDeuxiemeNiveau> content = null;
        if (criteria != null) {
            NotificationRetardDeuxiemeNiveauSpecification mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }


    private NotificationRetardDeuxiemeNiveauSpecification constructSpecification(NotificationRetardDeuxiemeNiveauCriteria criteria) {
        NotificationRetardDeuxiemeNiveauSpecification mySpecification =  (NotificationRetardDeuxiemeNiveauSpecification) RefelexivityUtil.constructObjectUsingOneParam(NotificationRetardDeuxiemeNiveauSpecification.class, criteria);
        return mySpecification;
    }

    public List<NotificationRetardDeuxiemeNiveau> findPaginatedByCriteria(NotificationRetardDeuxiemeNiveauCriteria criteria, int page, int pageSize, String order, String sortField) {
        NotificationRetardDeuxiemeNiveauSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(NotificationRetardDeuxiemeNiveauCriteria criteria) {
        NotificationRetardDeuxiemeNiveauSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<NotificationRetardDeuxiemeNiveau> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<NotificationRetardDeuxiemeNiveau> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }

	public boolean deleteById(Long id) {
        boolean condition = deleteByIdCheckCondition(id);
        if (condition) {
            dao.deleteById(id);
        }
        return condition;
    }

    public boolean deleteByIdCheckCondition(Long id) {
        return true;
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int delete(NotificationRetardDeuxiemeNiveau t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveau> delete(List<NotificationRetardDeuxiemeNiveau> list) {
		List<NotificationRetardDeuxiemeNiveau> result = new ArrayList();
        if (list != null) {
            for (NotificationRetardDeuxiemeNiveau t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardDeuxiemeNiveau create(NotificationRetardDeuxiemeNiveau t) {
        NotificationRetardDeuxiemeNiveau loaded = findByReferenceEntity(t);
        NotificationRetardDeuxiemeNiveau saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveau> create(List<NotificationRetardDeuxiemeNiveau> ts) {
        List<NotificationRetardDeuxiemeNiveau> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardDeuxiemeNiveau t : ts) {
				NotificationRetardDeuxiemeNiveau created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public NotificationRetardDeuxiemeNiveau findWithAssociatedLists(Long id){
        NotificationRetardDeuxiemeNiveau result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveau> update(List<NotificationRetardDeuxiemeNiveau> ts, boolean createIfNotExist) {
        List<NotificationRetardDeuxiemeNiveau> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardDeuxiemeNiveau t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    NotificationRetardDeuxiemeNiveau loadedItem = dao.findById(t.getId()).orElse(null);
                    if (createIfNotExist && (t.getId() == null || loadedItem == null)) {
                        dao.save(t);
                    } else if (t.getId() != null && loadedItem != null) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }





    public NotificationRetardDeuxiemeNiveau findByReferenceEntity(NotificationRetardDeuxiemeNiveau t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardDeuxiemeNiveau t){
        if( t != null) {
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
        }
    }



    public List<NotificationRetardDeuxiemeNiveau> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<NotificationRetardDeuxiemeNiveau>> getToBeSavedAndToBeDeleted(List<NotificationRetardDeuxiemeNiveau> oldList, List<NotificationRetardDeuxiemeNiveau> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<NotificationRetardDeuxiemeNiveau> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private RedevableAdminService redevableService ;

    private @Autowired NotificationRetardDeuxiemeNiveauDao dao;


}
