package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.dao.facade.core.taxe38.TauxTaxe38Dao;
import ma.zs.univ.dao.specification.core.taxe38.TauxTaxe38Specification;
import ma.zs.univ.service.facade.admin.taxe38.TauxTaxe38AdminService;
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
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService ;
import ma.zs.univ.bean.core.taxe38.CategorieLocale ;

import java.util.List;
@Service
public class TauxTaxe38AdminServiceImpl implements TauxTaxe38AdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TauxTaxe38 update(TauxTaxe38 t) {
        TauxTaxe38 loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{TauxTaxe38.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public TauxTaxe38 findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public TauxTaxe38 findOrSave(TauxTaxe38 t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            TauxTaxe38 result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<TauxTaxe38> importData(List<TauxTaxe38> items) {
        List<TauxTaxe38> list = new ArrayList<>();
        for (TauxTaxe38 t : items) {
            TauxTaxe38 founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<TauxTaxe38> findAll() {
        return dao.findAll();
    }

    public List<TauxTaxe38> findByCriteria(TauxTaxe38Criteria criteria) {
        List<TauxTaxe38> content = null;
        if (criteria != null) {
            TauxTaxe38Specification mySpecification = constructSpecification(criteria);
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


    private TauxTaxe38Specification constructSpecification(TauxTaxe38Criteria criteria) {
        TauxTaxe38Specification mySpecification =  (TauxTaxe38Specification) RefelexivityUtil.constructObjectUsingOneParam(TauxTaxe38Specification.class, criteria);
        return mySpecification;
    }

    public List<TauxTaxe38> findPaginatedByCriteria(TauxTaxe38Criteria criteria, int page, int pageSize, String order, String sortField) {
        TauxTaxe38Specification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(TauxTaxe38Criteria criteria) {
        TauxTaxe38Specification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<TauxTaxe38> findByTypeLocale38DetailId(Long id){
        return dao.findByTypeLocale38DetailId(id);
    }
    public int deleteByTypeLocale38DetailId(Long id){
        return dao.deleteByTypeLocale38DetailId(id);
    }
    public long countByTypeLocale38DetailCode(String code){
        return dao.countByTypeLocale38DetailCode(code);
    }
    public List<TauxTaxe38> findByCategorieLocaleId(Long id){
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
    public int delete(TauxTaxe38 t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TauxTaxe38> delete(List<TauxTaxe38> list) {
		List<TauxTaxe38> result = new ArrayList();
        if (list != null) {
            for (TauxTaxe38 t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TauxTaxe38 create(TauxTaxe38 t) {
        TauxTaxe38 loaded = findByReferenceEntity(t);
        TauxTaxe38 saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TauxTaxe38> create(List<TauxTaxe38> ts) {
        List<TauxTaxe38> result = new ArrayList<>();
        if (ts != null) {
            for (TauxTaxe38 t : ts) {
				TauxTaxe38 created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public TauxTaxe38 findWithAssociatedLists(Long id){
        TauxTaxe38 result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TauxTaxe38> update(List<TauxTaxe38> ts, boolean createIfNotExist) {
        List<TauxTaxe38> result = new ArrayList<>();
        if (ts != null) {
            for (TauxTaxe38 t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    TauxTaxe38 loadedItem = dao.findById(t.getId()).orElse(null);
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





    public TauxTaxe38 findByReferenceEntity(TauxTaxe38 t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(TauxTaxe38 t){
        if( t != null) {
            t.setTypeLocale38Detail(typeLocale38DetailService.findOrSave(t.getTypeLocale38Detail()));
            t.setCategorieLocale(categorieLocaleService.findOrSave(t.getCategorieLocale()));
        }
    }



    public List<TauxTaxe38> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<TauxTaxe38>> getToBeSavedAndToBeDeleted(List<TauxTaxe38> oldList, List<TauxTaxe38> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<TauxTaxe38> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private TypeLocale38DetailAdminService typeLocale38DetailService ;
    @Autowired
    private CategorieLocaleAdminService categorieLocaleService ;

    private @Autowired TauxTaxe38Dao dao;


}
