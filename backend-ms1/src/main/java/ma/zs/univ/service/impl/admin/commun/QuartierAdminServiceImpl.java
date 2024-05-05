package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.dao.facade.core.commun.QuartierDao;
import ma.zs.univ.dao.specification.core.commun.QuartierSpecification;
import ma.zs.univ.service.facade.admin.commun.QuartierAdminService;
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

import ma.zs.univ.service.facade.admin.commun.SecteurAdminService ;
import ma.zs.univ.bean.core.commun.Secteur ;

import java.util.List;
@Service
public class QuartierAdminServiceImpl implements QuartierAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Quartier update(Quartier t) {
        Quartier loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Quartier.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Quartier findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Quartier findOrSave(Quartier t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Quartier result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Quartier> importData(List<Quartier> items) {
        List<Quartier> list = new ArrayList<>();
        for (Quartier t : items) {
            Quartier founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Quartier> findAll() {
        return dao.findAll();
    }

    public List<Quartier> findByCriteria(QuartierCriteria criteria) {
        List<Quartier> content = null;
        if (criteria != null) {
            QuartierSpecification mySpecification = constructSpecification(criteria);
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


    private QuartierSpecification constructSpecification(QuartierCriteria criteria) {
        QuartierSpecification mySpecification =  (QuartierSpecification) RefelexivityUtil.constructObjectUsingOneParam(QuartierSpecification.class, criteria);
        return mySpecification;
    }

    public List<Quartier> findPaginatedByCriteria(QuartierCriteria criteria, int page, int pageSize, String order, String sortField) {
        QuartierSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(QuartierCriteria criteria) {
        QuartierSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Quartier> findBySecteurId(Long id){
        return dao.findBySecteurId(id);
    }
    public int deleteBySecteurId(Long id){
        return dao.deleteBySecteurId(id);
    }
    public long countBySecteurCode(String code){
        return dao.countBySecteurCode(code);
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
    public int delete(Quartier t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Quartier> delete(List<Quartier> list) {
		List<Quartier> result = new ArrayList();
        if (list != null) {
            for (Quartier t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Quartier create(Quartier t) {
        Quartier loaded = findByReferenceEntity(t);
        Quartier saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Quartier> create(List<Quartier> ts) {
        List<Quartier> result = new ArrayList<>();
        if (ts != null) {
            for (Quartier t : ts) {
				Quartier created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Quartier findWithAssociatedLists(Long id){
        Quartier result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Quartier> update(List<Quartier> ts, boolean createIfNotExist) {
        List<Quartier> result = new ArrayList<>();
        if (ts != null) {
            for (Quartier t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Quartier loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Quartier findByReferenceEntity(Quartier t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Quartier t){
        if( t != null) {
            t.setSecteur(secteurService.findOrSave(t.getSecteur()));
        }
    }



    public List<Quartier> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Quartier>> getToBeSavedAndToBeDeleted(List<Quartier> oldList, List<Quartier> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Quartier> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private SecteurAdminService secteurService ;

    private @Autowired QuartierDao dao;


}
