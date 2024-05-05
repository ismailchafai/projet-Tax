package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.dao.facade.core.commun.SecteurDao;
import ma.zs.univ.dao.specification.core.commun.SecteurSpecification;
import ma.zs.univ.service.facade.admin.commun.SecteurAdminService;
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

import ma.zs.univ.service.facade.admin.commun.VilleAdminService ;
import ma.zs.univ.bean.core.commun.Ville ;

import java.util.List;
@Service
public class SecteurAdminServiceImpl implements SecteurAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Secteur update(Secteur t) {
        Secteur loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Secteur.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Secteur findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Secteur findOrSave(Secteur t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Secteur result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Secteur> importData(List<Secteur> items) {
        List<Secteur> list = new ArrayList<>();
        for (Secteur t : items) {
            Secteur founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Secteur> findAll() {
        return dao.findAll();
    }

    public List<Secteur> findByCriteria(SecteurCriteria criteria) {
        List<Secteur> content = null;
        if (criteria != null) {
            SecteurSpecification mySpecification = constructSpecification(criteria);
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


    private SecteurSpecification constructSpecification(SecteurCriteria criteria) {
        SecteurSpecification mySpecification =  (SecteurSpecification) RefelexivityUtil.constructObjectUsingOneParam(SecteurSpecification.class, criteria);
        return mySpecification;
    }

    public List<Secteur> findPaginatedByCriteria(SecteurCriteria criteria, int page, int pageSize, String order, String sortField) {
        SecteurSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(SecteurCriteria criteria) {
        SecteurSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Secteur> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }
    public long countByVilleCode(String code){
        return dao.countByVilleCode(code);
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
    public int delete(Secteur t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Secteur> delete(List<Secteur> list) {
		List<Secteur> result = new ArrayList();
        if (list != null) {
            for (Secteur t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Secteur create(Secteur t) {
        Secteur loaded = findByReferenceEntity(t);
        Secteur saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Secteur> create(List<Secteur> ts) {
        List<Secteur> result = new ArrayList<>();
        if (ts != null) {
            for (Secteur t : ts) {
				Secteur created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Secteur findWithAssociatedLists(Long id){
        Secteur result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Secteur> update(List<Secteur> ts, boolean createIfNotExist) {
        List<Secteur> result = new ArrayList<>();
        if (ts != null) {
            for (Secteur t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Secteur loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Secteur findByReferenceEntity(Secteur t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Secteur t){
        if( t != null) {
            t.setVille(villeService.findOrSave(t.getVille()));
        }
    }



    public List<Secteur> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Secteur>> getToBeSavedAndToBeDeleted(List<Secteur> oldList, List<Secteur> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Secteur> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private VilleAdminService villeService ;

    private @Autowired SecteurDao dao;


}
