package ma.zs.univ.service.impl.admin.NotificationPremierNiv;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.dao.facade.core.NotificationPremierNiv.NotificationRetardPremierNiveauDao;
import ma.zs.univ.dao.specification.core.NotificationPremierNiv.NotificationRetardPremierNiveauSpecification;
import ma.zs.univ.service.facade.admin.NotificationPremierNiv.NotificationRetardPremierNiveauAdminService;
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
public class NotificationRetardPremierNiveauAdminServiceImpl implements NotificationRetardPremierNiveauAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardPremierNiveau update(NotificationRetardPremierNiveau t) {
        NotificationRetardPremierNiveau loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{NotificationRetardPremierNiveau.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public NotificationRetardPremierNiveau findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public NotificationRetardPremierNiveau findOrSave(NotificationRetardPremierNiveau t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            NotificationRetardPremierNiveau result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<NotificationRetardPremierNiveau> importData(List<NotificationRetardPremierNiveau> items) {
        List<NotificationRetardPremierNiveau> list = new ArrayList<>();
        for (NotificationRetardPremierNiveau t : items) {
            NotificationRetardPremierNiveau founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<NotificationRetardPremierNiveau> findAll() {
        return dao.findAll();
    }

    public List<NotificationRetardPremierNiveau> findByCriteria(NotificationRetardPremierNiveauCriteria criteria) {
        List<NotificationRetardPremierNiveau> content = null;
        if (criteria != null) {
            NotificationRetardPremierNiveauSpecification mySpecification = constructSpecification(criteria);
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


    private NotificationRetardPremierNiveauSpecification constructSpecification(NotificationRetardPremierNiveauCriteria criteria) {
        NotificationRetardPremierNiveauSpecification mySpecification =  (NotificationRetardPremierNiveauSpecification) RefelexivityUtil.constructObjectUsingOneParam(NotificationRetardPremierNiveauSpecification.class, criteria);
        return mySpecification;
    }

    public List<NotificationRetardPremierNiveau> findPaginatedByCriteria(NotificationRetardPremierNiveauCriteria criteria, int page, int pageSize, String order, String sortField) {
        NotificationRetardPremierNiveauSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(NotificationRetardPremierNiveauCriteria criteria) {
        NotificationRetardPremierNiveauSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<NotificationRetardPremierNiveau> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<NotificationRetardPremierNiveau> findByRedevableId(Long id){
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
    public int delete(NotificationRetardPremierNiveau t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardPremierNiveau> delete(List<NotificationRetardPremierNiveau> list) {
		List<NotificationRetardPremierNiveau> result = new ArrayList();
        if (list != null) {
            for (NotificationRetardPremierNiveau t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardPremierNiveau create(NotificationRetardPremierNiveau t) {
        NotificationRetardPremierNiveau loaded = findByReferenceEntity(t);
        NotificationRetardPremierNiveau saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardPremierNiveau> create(List<NotificationRetardPremierNiveau> ts) {
        List<NotificationRetardPremierNiveau> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardPremierNiveau t : ts) {
				NotificationRetardPremierNiveau created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public NotificationRetardPremierNiveau findWithAssociatedLists(Long id){
        NotificationRetardPremierNiveau result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardPremierNiveau> update(List<NotificationRetardPremierNiveau> ts, boolean createIfNotExist) {
        List<NotificationRetardPremierNiveau> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardPremierNiveau t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    NotificationRetardPremierNiveau loadedItem = dao.findById(t.getId()).orElse(null);
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





    public NotificationRetardPremierNiveau findByReferenceEntity(NotificationRetardPremierNiveau t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardPremierNiveau t){
        if( t != null) {
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
        }
    }



    public List<NotificationRetardPremierNiveau> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<NotificationRetardPremierNiveau>> getToBeSavedAndToBeDeleted(List<NotificationRetardPremierNiveau> oldList, List<NotificationRetardPremierNiveau> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<NotificationRetardPremierNiveau> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private RedevableAdminService redevableService ;

    private @Autowired NotificationRetardPremierNiveauDao dao;


}
