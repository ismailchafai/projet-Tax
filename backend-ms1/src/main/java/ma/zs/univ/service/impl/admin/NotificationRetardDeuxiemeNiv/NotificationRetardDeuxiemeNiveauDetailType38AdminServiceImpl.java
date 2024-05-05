package ma.zs.univ.service.impl.admin.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Dao;
import ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Specification;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38AdminService;
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

import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail ;

import java.util.List;
@Service
public class NotificationRetardDeuxiemeNiveauDetailType38AdminServiceImpl implements NotificationRetardDeuxiemeNiveauDetailType38AdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardDeuxiemeNiveauDetailType38 update(NotificationRetardDeuxiemeNiveauDetailType38 t) {
        NotificationRetardDeuxiemeNiveauDetailType38 loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{NotificationRetardDeuxiemeNiveauDetailType38.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public NotificationRetardDeuxiemeNiveauDetailType38 findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public NotificationRetardDeuxiemeNiveauDetailType38 findOrSave(NotificationRetardDeuxiemeNiveauDetailType38 t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            NotificationRetardDeuxiemeNiveauDetailType38 result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<NotificationRetardDeuxiemeNiveauDetailType38> importData(List<NotificationRetardDeuxiemeNiveauDetailType38> items) {
        List<NotificationRetardDeuxiemeNiveauDetailType38> list = new ArrayList<>();
        for (NotificationRetardDeuxiemeNiveauDetailType38 t : items) {
            NotificationRetardDeuxiemeNiveauDetailType38 founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> findAll() {
        return dao.findAll();
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> findByCriteria(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) {
        List<NotificationRetardDeuxiemeNiveauDetailType38> content = null;
        if (criteria != null) {
            NotificationRetardDeuxiemeNiveauDetailType38Specification mySpecification = constructSpecification(criteria);
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


    private NotificationRetardDeuxiemeNiveauDetailType38Specification constructSpecification(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) {
        NotificationRetardDeuxiemeNiveauDetailType38Specification mySpecification =  (NotificationRetardDeuxiemeNiveauDetailType38Specification) RefelexivityUtil.constructObjectUsingOneParam(NotificationRetardDeuxiemeNiveauDetailType38Specification.class, criteria);
        return mySpecification;
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> findPaginatedByCriteria(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria, int page, int pageSize, String order, String sortField) {
        NotificationRetardDeuxiemeNiveauDetailType38Specification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) {
        NotificationRetardDeuxiemeNiveauDetailType38Specification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> findByTypeLocale38Id(Long id){
        return dao.findByTypeLocale38Id(id);
    }
    public int deleteByTypeLocale38Id(Long id){
        return dao.deleteByTypeLocale38Id(id);
    }
    public long countByTypeLocale38Code(String code){
        return dao.countByTypeLocale38Code(code);
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
    public int delete(NotificationRetardDeuxiemeNiveauDetailType38 t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveauDetailType38> delete(List<NotificationRetardDeuxiemeNiveauDetailType38> list) {
		List<NotificationRetardDeuxiemeNiveauDetailType38> result = new ArrayList();
        if (list != null) {
            for (NotificationRetardDeuxiemeNiveauDetailType38 t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public NotificationRetardDeuxiemeNiveauDetailType38 create(NotificationRetardDeuxiemeNiveauDetailType38 t) {
        NotificationRetardDeuxiemeNiveauDetailType38 loaded = findByReferenceEntity(t);
        NotificationRetardDeuxiemeNiveauDetailType38 saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveauDetailType38> create(List<NotificationRetardDeuxiemeNiveauDetailType38> ts) {
        List<NotificationRetardDeuxiemeNiveauDetailType38> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardDeuxiemeNiveauDetailType38 t : ts) {
				NotificationRetardDeuxiemeNiveauDetailType38 created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public NotificationRetardDeuxiemeNiveauDetailType38 findWithAssociatedLists(Long id){
        NotificationRetardDeuxiemeNiveauDetailType38 result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<NotificationRetardDeuxiemeNiveauDetailType38> update(List<NotificationRetardDeuxiemeNiveauDetailType38> ts, boolean createIfNotExist) {
        List<NotificationRetardDeuxiemeNiveauDetailType38> result = new ArrayList<>();
        if (ts != null) {
            for (NotificationRetardDeuxiemeNiveauDetailType38 t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    NotificationRetardDeuxiemeNiveauDetailType38 loadedItem = dao.findById(t.getId()).orElse(null);
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





    public NotificationRetardDeuxiemeNiveauDetailType38 findByReferenceEntity(NotificationRetardDeuxiemeNiveauDetailType38 t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardDeuxiemeNiveauDetailType38 t){
        if( t != null) {
            t.setTypeLocale38(typeLocale38DetailService.findOrSave(t.getTypeLocale38()));
        }
    }



    public List<NotificationRetardDeuxiemeNiveauDetailType38> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<NotificationRetardDeuxiemeNiveauDetailType38>> getToBeSavedAndToBeDeleted(List<NotificationRetardDeuxiemeNiveauDetailType38> oldList, List<NotificationRetardDeuxiemeNiveauDetailType38> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<NotificationRetardDeuxiemeNiveauDetailType38> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private TypeLocale38DetailAdminService typeLocale38DetailService ;

    private @Autowired NotificationRetardDeuxiemeNiveauDetailType38Dao dao;


}
