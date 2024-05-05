package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.dao.facade.core.commun.LocaleDao;
import ma.zs.univ.dao.specification.core.commun.LocaleSpecification;
import ma.zs.univ.service.facade.admin.commun.LocaleAdminService;
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

import ma.zs.univ.service.facade.admin.commun.RueAdminService ;
import ma.zs.univ.bean.core.commun.Rue ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService ;
import ma.zs.univ.bean.core.taxe38.CategorieLocale ;

import java.util.List;
@Service
public class LocaleAdminServiceImpl implements LocaleAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Locale update(Locale t) {
        Locale loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Locale.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Locale findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Locale findOrSave(Locale t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Locale result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Locale> importData(List<Locale> items) {
        List<Locale> list = new ArrayList<>();
        for (Locale t : items) {
            Locale founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Locale> findAll() {
        return dao.findAll();
    }

    public List<Locale> findByCriteria(LocaleCriteria criteria) {
        List<Locale> content = null;
        if (criteria != null) {
            LocaleSpecification mySpecification = constructSpecification(criteria);
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


    private LocaleSpecification constructSpecification(LocaleCriteria criteria) {
        LocaleSpecification mySpecification =  (LocaleSpecification) RefelexivityUtil.constructObjectUsingOneParam(LocaleSpecification.class, criteria);
        return mySpecification;
    }

    public List<Locale> findPaginatedByCriteria(LocaleCriteria criteria, int page, int pageSize, String order, String sortField) {
        LocaleSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(LocaleCriteria criteria) {
        LocaleSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Locale> findByRueId(Long id){
        return dao.findByRueId(id);
    }
    public int deleteByRueId(Long id){
        return dao.deleteByRueId(id);
    }
    public long countByRueCode(String code){
        return dao.countByRueCode(code);
    }
    public List<Locale> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }
    public List<Locale> findByCategorieLocaleId(Long id){
        return dao.findByCategorieLocaleId(id);
    }
    public int deleteByCategorieLocaleId(Long id){
        return dao.deleteByCategorieLocaleId(id);
    }
    public long countByCategorieLocaleCode(String code){
        return dao.countByCategorieLocaleCode(code);
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
    public int delete(Locale t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Locale> delete(List<Locale> list) {
		List<Locale> result = new ArrayList();
        if (list != null) {
            for (Locale t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Locale create(Locale t) {
        Locale loaded = findByReferenceEntity(t);
        Locale saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Locale> create(List<Locale> ts) {
        List<Locale> result = new ArrayList<>();
        if (ts != null) {
            for (Locale t : ts) {
				Locale created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Locale findWithAssociatedLists(Long id){
        Locale result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Locale> update(List<Locale> ts, boolean createIfNotExist) {
        List<Locale> result = new ArrayList<>();
        if (ts != null) {
            for (Locale t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Locale loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Locale findByReferenceEntity(Locale t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Locale t){
        if( t != null) {
            t.setRue(rueService.findOrSave(t.getRue()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
            t.setCategorieLocale(categorieLocaleService.findOrSave(t.getCategorieLocale()));
        }
    }



    public List<Locale> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Locale>> getToBeSavedAndToBeDeleted(List<Locale> oldList, List<Locale> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Locale> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private RueAdminService rueService ;
    @Autowired
    private RedevableAdminService redevableService ;
    @Autowired
    private CategorieLocaleAdminService categorieLocaleService ;

    private @Autowired LocaleDao dao;


}
