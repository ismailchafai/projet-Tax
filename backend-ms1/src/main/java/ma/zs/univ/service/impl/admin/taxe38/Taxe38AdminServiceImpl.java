package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.dao.facade.core.taxe38.Taxe38Dao;
import ma.zs.univ.dao.specification.core.taxe38.Taxe38Specification;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38AdminService;
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
import ma.zs.univ.service.facade.admin.taxe38.Taxe38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;

import java.util.List;
@Service
public class Taxe38AdminServiceImpl implements Taxe38AdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Taxe38 update(Taxe38 t) {
        Taxe38 loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Taxe38.class.getSimpleName(), t.getId().toString()});
        } else {
            updateWithAssociatedLists(t);
            dao.save(t);
            return loadedItem;
        }
    }

    public Taxe38 findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Taxe38 findOrSave(Taxe38 t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Taxe38 result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Taxe38> importData(List<Taxe38> items) {
        List<Taxe38> list = new ArrayList<>();
        for (Taxe38 t : items) {
            Taxe38 founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Taxe38> findAll() {
        return dao.findAll();
    }

    public List<Taxe38> findByCriteria(Taxe38Criteria criteria) {
        List<Taxe38> content = null;
        if (criteria != null) {
            Taxe38Specification mySpecification = constructSpecification(criteria);
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


    private Taxe38Specification constructSpecification(Taxe38Criteria criteria) {
        Taxe38Specification mySpecification =  (Taxe38Specification) RefelexivityUtil.constructObjectUsingOneParam(Taxe38Specification.class, criteria);
        return mySpecification;
    }

    public List<Taxe38> findPaginatedByCriteria(Taxe38Criteria criteria, int page, int pageSize, String order, String sortField) {
        Taxe38Specification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(Taxe38Criteria criteria) {
        Taxe38Specification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Taxe38> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }
    public List<Taxe38> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<Taxe38> findByTrimId(Long id){
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
            deleteAssociatedLists(id);
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
    public int delete(Taxe38 t) {
        int result = 0;
        if (t != null) {
            deleteAssociatedLists(t.getId());
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        taxe38DetailService.deleteByTaxe38Id(id);
    }




    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Taxe38> delete(List<Taxe38> list) {
		List<Taxe38> result = new ArrayList();
        if (list != null) {
            for (Taxe38 t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Taxe38 create(Taxe38 t) {
        Taxe38 loaded = findByReferenceEntity(t);
        Taxe38 saved;
        if (loaded == null) {
            saved = dao.save(t);
            if (t.getTaxe38Details() != null) {
                t.getTaxe38Details().forEach(element-> {
                    element.setTaxe38(saved);
                    taxe38DetailService.create(element);
                });
            }
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Taxe38> create(List<Taxe38> ts) {
        List<Taxe38> result = new ArrayList<>();
        if (ts != null) {
            for (Taxe38 t : ts) {
				Taxe38 created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Taxe38 findWithAssociatedLists(Long id){
        Taxe38 result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setTaxe38Details(taxe38DetailService.findByTaxe38Id(id));
        }
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Taxe38> update(List<Taxe38> ts, boolean createIfNotExist) {
        List<Taxe38> result = new ArrayList<>();
        if (ts != null) {
            for (Taxe38 t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Taxe38 loadedItem = dao.findById(t.getId()).orElse(null);
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

    public void updateWithAssociatedLists(Taxe38 taxe38){
    if(taxe38 !=null && taxe38.getId() != null){
        List<List<Taxe38Detail>> resultTaxe38Details= taxe38DetailService.getToBeSavedAndToBeDeleted(taxe38DetailService.findByTaxe38Id(taxe38.getId()),taxe38.getTaxe38Details());
            taxe38DetailService.delete(resultTaxe38Details.get(1));
        ListUtil.emptyIfNull(resultTaxe38Details.get(0)).forEach(e -> e.setTaxe38(taxe38));
        taxe38DetailService.update(resultTaxe38Details.get(0),true);
        }
    }




    public Taxe38 findByReferenceEntity(Taxe38 t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Taxe38 t){
        if( t != null) {
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setTrim(trimService.findOrSave(t.getTrim()));
        }
    }



    public List<Taxe38> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Taxe38>> getToBeSavedAndToBeDeleted(List<Taxe38> oldList, List<Taxe38> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Taxe38> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private TrimAdminService trimService ;
    @Autowired
    private Taxe38DetailAdminService taxe38DetailService ;
    @Autowired
    private RedevableAdminService redevableService ;

    private @Autowired Taxe38Dao dao;


}
