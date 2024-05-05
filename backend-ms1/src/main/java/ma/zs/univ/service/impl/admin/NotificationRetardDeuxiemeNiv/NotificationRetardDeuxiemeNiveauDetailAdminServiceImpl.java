package ma.zs.univ.service.impl.admin.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailDao;
import ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailSpecification;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailAdminService;
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

import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService ;
import ma.zs.univ.bean.core.taxe38.Trim ;

import java.util.List;
@Service
public class NotificationRetardDeuxiemeNiveauDetailAdminServiceImpl implements NotificationRetardDeuxiemeNiveauDetailAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardDeuxiemeNiveauDetail update(NotificationRetardDeuxiemeNiveauDetail t) {
        NotificationRetardDeuxiemeNiveauDetail loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{NotificationRetardDeuxiemeNiveauDetail.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public NotificationRetardDeuxiemeNiveauDetail findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public NotificationRetardDeuxiemeNiveauDetail findOrSave(NotificationRetardDeuxiemeNiveauDetail t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            NotificationRetardDeuxiemeNiveauDetail result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<NotificationRetardDeuxiemeNiveauDetail> importData(List<NotificationRetardDeuxiemeNiveauDetail> items) {
        List<NotificationRetardDeuxiemeNiveauDetail> list = new ArrayList<>();
        for (NotificationRetardDeuxiemeNiveauDetail t : items) {
            NotificationRetardDeuxiemeNiveauDetail founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<NotificationRetardDeuxiemeNiveauDetail> findAll() {
        return dao.findAll();
    }

    public List<NotificationRetardDeuxiemeNiveauDetail> findByCriteria(NotificationRetardDeuxiemeNiveauDetailCriteria criteria) {
        List<NotificationRetardDeuxiemeNiveauDetail> content = null;
        if (criteria != null) {
            NotificationRetardDeuxiemeNiveauDetailSpecification mySpecification = constructSpecification(criteria);
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


    private NotificationRetardDeuxiemeNiveauDetailSpecification constructSpecification(NotificationRetardDeuxiemeNiveauDetailCriteria criteria) {
        NotificationRetardDeuxiemeNiveauDetailSpecification mySpecification =  (NotificationRetardDeuxiemeNiveauDetailSpecification) RefelexivityUtil.constructObjectUsingOneParam(NotificationRetardDeuxiemeNiveauDetailSpecification.class, criteria);
        return mySpecification;
    }

    public List<NotificationRetardDeuxiemeNiveauDetail> findPaginatedByCriteria(NotificationRetardDeuxiemeNiveauDetailCriteria criteria, int page, int pageSize, String order, String sortField) {
        NotificationRetardDeuxiemeNiveauDetailSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(NotificationRetardDeuxiemeNiveauDetailCriteria criteria) {
        NotificationRetardDeuxiemeNiveauDetailSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<NotificationRetardDeuxiemeNiveauDetail> findByTrimId(Long id){
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
    public int delete(NotificationRetardDeuxiemeNiveauDetail t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveauDetail> delete(List<NotificationRetardDeuxiemeNiveauDetail> list) {
		List<NotificationRetardDeuxiemeNiveauDetail> result = new ArrayList();
        if (list != null) {
            for (NotificationRetardDeuxiemeNiveauDetail t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardDeuxiemeNiveauDetail create(NotificationRetardDeuxiemeNiveauDetail t) {
        NotificationRetardDeuxiemeNiveauDetail loaded = findByReferenceEntity(t);
        NotificationRetardDeuxiemeNiveauDetail saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveauDetail> create(List<NotificationRetardDeuxiemeNiveauDetail> ts) {
        List<NotificationRetardDeuxiemeNiveauDetail> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardDeuxiemeNiveauDetail t : ts) {
				NotificationRetardDeuxiemeNiveauDetail created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public NotificationRetardDeuxiemeNiveauDetail findWithAssociatedLists(Long id){
        NotificationRetardDeuxiemeNiveauDetail result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveauDetail> update(List<NotificationRetardDeuxiemeNiveauDetail> ts, boolean createIfNotExist) {
        List<NotificationRetardDeuxiemeNiveauDetail> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardDeuxiemeNiveauDetail t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    NotificationRetardDeuxiemeNiveauDetail loadedItem = dao.findById(t.getId()).orElse(null);
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





    public NotificationRetardDeuxiemeNiveauDetail findByReferenceEntity(NotificationRetardDeuxiemeNiveauDetail t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardDeuxiemeNiveauDetail t){
        if( t != null) {
            t.setTrim(trimService.findOrSave(t.getTrim()));
        }
    }



    public List<NotificationRetardDeuxiemeNiveauDetail> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<NotificationRetardDeuxiemeNiveauDetail>> getToBeSavedAndToBeDeleted(List<NotificationRetardDeuxiemeNiveauDetail> oldList, List<NotificationRetardDeuxiemeNiveauDetail> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<NotificationRetardDeuxiemeNiveauDetail> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private TrimAdminService trimService ;

    private @Autowired NotificationRetardDeuxiemeNiveauDetailDao dao;


}
