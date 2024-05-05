package ma.zs.univ.service.impl.admin.NotificationRetardTroisiemeNiv;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.dao.facade.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauDao;
import ma.zs.univ.dao.specification.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauSpecification;
import ma.zs.univ.service.facade.admin.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauAdminService;
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
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService ;
import ma.zs.univ.bean.core.taxe38.Trim ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;

import java.util.List;
@Service
public class NotificationRetardTroisiemeNiveauAdminServiceImpl implements NotificationRetardTroisiemeNiveauAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardTroisiemeNiveau update(NotificationRetardTroisiemeNiveau t) {
        NotificationRetardTroisiemeNiveau loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{NotificationRetardTroisiemeNiveau.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public NotificationRetardTroisiemeNiveau findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public NotificationRetardTroisiemeNiveau findOrSave(NotificationRetardTroisiemeNiveau t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            NotificationRetardTroisiemeNiveau result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<NotificationRetardTroisiemeNiveau> importData(List<NotificationRetardTroisiemeNiveau> items) {
        List<NotificationRetardTroisiemeNiveau> list = new ArrayList<>();
        for (NotificationRetardTroisiemeNiveau t : items) {
            NotificationRetardTroisiemeNiveau founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<NotificationRetardTroisiemeNiveau> findAll() {
        return dao.findAll();
    }

    public List<NotificationRetardTroisiemeNiveau> findByCriteria(NotificationRetardTroisiemeNiveauCriteria criteria) {
        List<NotificationRetardTroisiemeNiveau> content = null;
        if (criteria != null) {
            NotificationRetardTroisiemeNiveauSpecification mySpecification = constructSpecification(criteria);
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


    private NotificationRetardTroisiemeNiveauSpecification constructSpecification(NotificationRetardTroisiemeNiveauCriteria criteria) {
        NotificationRetardTroisiemeNiveauSpecification mySpecification =  (NotificationRetardTroisiemeNiveauSpecification) RefelexivityUtil.constructObjectUsingOneParam(NotificationRetardTroisiemeNiveauSpecification.class, criteria);
        return mySpecification;
    }

    public List<NotificationRetardTroisiemeNiveau> findPaginatedByCriteria(NotificationRetardTroisiemeNiveauCriteria criteria, int page, int pageSize, String order, String sortField) {
        NotificationRetardTroisiemeNiveauSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(NotificationRetardTroisiemeNiveauCriteria criteria) {
        NotificationRetardTroisiemeNiveauSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<NotificationRetardTroisiemeNiveau> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<NotificationRetardTroisiemeNiveau> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }
    public List<NotificationRetardTroisiemeNiveau> findByTrimId(Long id){
        return dao.findByTrimId(id);
    }
    public int deleteByTrimId(Long id){
        return dao.deleteByTrimId(id);
    }
    public long countByTrimId(Long id){
        return dao.countByTrimId(id);
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
    public int delete(NotificationRetardTroisiemeNiveau t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardTroisiemeNiveau> delete(List<NotificationRetardTroisiemeNiveau> list) {
		List<NotificationRetardTroisiemeNiveau> result = new ArrayList();
        if (list != null) {
            for (NotificationRetardTroisiemeNiveau t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardTroisiemeNiveau create(NotificationRetardTroisiemeNiveau t) {
        NotificationRetardTroisiemeNiveau loaded = findByReferenceEntity(t);
        NotificationRetardTroisiemeNiveau saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardTroisiemeNiveau> create(List<NotificationRetardTroisiemeNiveau> ts) {
        List<NotificationRetardTroisiemeNiveau> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardTroisiemeNiveau t : ts) {
				NotificationRetardTroisiemeNiveau created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public NotificationRetardTroisiemeNiveau findWithAssociatedLists(Long id){
        NotificationRetardTroisiemeNiveau result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardTroisiemeNiveau> update(List<NotificationRetardTroisiemeNiveau> ts, boolean createIfNotExist) {
        List<NotificationRetardTroisiemeNiveau> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardTroisiemeNiveau t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    NotificationRetardTroisiemeNiveau loadedItem = dao.findById(t.getId()).orElse(null);
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





    public NotificationRetardTroisiemeNiveau findByReferenceEntity(NotificationRetardTroisiemeNiveau t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardTroisiemeNiveau t){
        if( t != null) {
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
            t.setTrim(trimService.findOrSave(t.getTrim()));
        }
    }



    public List<NotificationRetardTroisiemeNiveau> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<NotificationRetardTroisiemeNiveau>> getToBeSavedAndToBeDeleted(List<NotificationRetardTroisiemeNiveau> oldList, List<NotificationRetardTroisiemeNiveau> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<NotificationRetardTroisiemeNiveau> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private TrimAdminService trimService ;
    @Autowired
    private RedevableAdminService redevableService ;

    private @Autowired NotificationRetardTroisiemeNiveauDao dao;


}
