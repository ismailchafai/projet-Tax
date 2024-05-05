package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.dao.facade.core.taxe38.Taxe38DetailDao;
import ma.zs.univ.dao.specification.core.taxe38.Taxe38DetailSpecification;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38DetailAdminService;
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

import ma.zs.univ.service.facade.admin.taxe38.Taxe38AdminService ;
import ma.zs.univ.bean.core.taxe38.Taxe38 ;
import ma.zs.univ.service.facade.admin.taxe38.Locale38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.Locale38Detail ;
import ma.zs.univ.service.facade.admin.taxe38.TauxTaxe38AdminService ;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38 ;

import java.util.List;
@Service
public class Taxe38DetailAdminServiceImpl implements Taxe38DetailAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Taxe38Detail update(Taxe38Detail t) {
        Taxe38Detail loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Taxe38Detail.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Taxe38Detail findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Taxe38Detail findOrSave(Taxe38Detail t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Taxe38Detail result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Taxe38Detail> importData(List<Taxe38Detail> items) {
        List<Taxe38Detail> list = new ArrayList<>();
        for (Taxe38Detail t : items) {
            Taxe38Detail founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Taxe38Detail> findAll() {
        return dao.findAll();
    }

    public List<Taxe38Detail> findByCriteria(Taxe38DetailCriteria criteria) {
        List<Taxe38Detail> content = null;
        if (criteria != null) {
            Taxe38DetailSpecification mySpecification = constructSpecification(criteria);
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


    private Taxe38DetailSpecification constructSpecification(Taxe38DetailCriteria criteria) {
        Taxe38DetailSpecification mySpecification =  (Taxe38DetailSpecification) RefelexivityUtil.constructObjectUsingOneParam(Taxe38DetailSpecification.class, criteria);
        return mySpecification;
    }

    public List<Taxe38Detail> findPaginatedByCriteria(Taxe38DetailCriteria criteria, int page, int pageSize, String order, String sortField) {
        Taxe38DetailSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(Taxe38DetailCriteria criteria) {
        Taxe38DetailSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Taxe38Detail> findByLocale38DetailId(Long id){
        return dao.findByLocale38DetailId(id);
    }
    public int deleteByLocale38DetailId(Long id){
        return dao.deleteByLocale38DetailId(id);
    }
    public long countByLocale38DetailCode(String code){
        return dao.countByLocale38DetailCode(code);
    }
    public List<Taxe38Detail> findByTauxTaxe38Id(Long id){
        return dao.findByTauxTaxe38Id(id);
    }
    public int deleteByTauxTaxe38Id(Long id){
        return dao.deleteByTauxTaxe38Id(id);
    }
    public long countByTauxTaxe38Code(String code){
        return dao.countByTauxTaxe38Code(code);
    }
    public List<Taxe38Detail> findByTaxe38Id(Long id){
        return dao.findByTaxe38Id(id);
    }
    public int deleteByTaxe38Id(Long id){
        return dao.deleteByTaxe38Id(id);
    }
    public long countByTaxe38Code(String code){
        return dao.countByTaxe38Code(code);
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
    public int delete(Taxe38Detail t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Taxe38Detail> delete(List<Taxe38Detail> list) {
		List<Taxe38Detail> result = new ArrayList();
        if (list != null) {
            for (Taxe38Detail t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Taxe38Detail create(Taxe38Detail t) {
        Taxe38Detail loaded = findByReferenceEntity(t);
        Taxe38Detail saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Taxe38Detail> create(List<Taxe38Detail> ts) {
        List<Taxe38Detail> result = new ArrayList<>();
        if (ts != null) {
            for (Taxe38Detail t : ts) {
				Taxe38Detail created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Taxe38Detail findWithAssociatedLists(Long id){
        Taxe38Detail result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Taxe38Detail> update(List<Taxe38Detail> ts, boolean createIfNotExist) {
        List<Taxe38Detail> result = new ArrayList<>();
        if (ts != null) {
            for (Taxe38Detail t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Taxe38Detail loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Taxe38Detail findByReferenceEntity(Taxe38Detail t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Taxe38Detail t){
        if( t != null) {
            t.setLocale38Detail(locale38DetailService.findOrSave(t.getLocale38Detail()));
            t.setTauxTaxe38(tauxTaxe38Service.findOrSave(t.getTauxTaxe38()));
            t.setTaxe38(taxe38Service.findOrSave(t.getTaxe38()));
        }
    }



    public List<Taxe38Detail> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Taxe38Detail>> getToBeSavedAndToBeDeleted(List<Taxe38Detail> oldList, List<Taxe38Detail> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Taxe38Detail> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private Taxe38AdminService taxe38Service ;
    @Autowired
    private Locale38DetailAdminService locale38DetailService ;
    @Autowired
    private TauxTaxe38AdminService tauxTaxe38Service ;

    private @Autowired Taxe38DetailDao dao;


}
