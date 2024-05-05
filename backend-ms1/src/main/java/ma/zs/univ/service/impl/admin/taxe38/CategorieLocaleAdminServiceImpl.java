package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.dao.criteria.core.taxe38.CategorieLocaleCriteria;
import ma.zs.univ.dao.facade.core.taxe38.CategorieLocaleDao;
import ma.zs.univ.dao.specification.core.taxe38.CategorieLocaleSpecification;
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService;
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


import java.util.List;
@Service
public class CategorieLocaleAdminServiceImpl implements CategorieLocaleAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CategorieLocale update(CategorieLocale t) {
        CategorieLocale loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{CategorieLocale.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public CategorieLocale findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public CategorieLocale findOrSave(CategorieLocale t) {
        if (t != null) {
            CategorieLocale result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<CategorieLocale> importData(List<CategorieLocale> items) {
        List<CategorieLocale> list = new ArrayList<>();
        for (CategorieLocale t : items) {
            CategorieLocale founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<CategorieLocale> findAll() {
        return dao.findAll();
    }

    public List<CategorieLocale> findByCriteria(CategorieLocaleCriteria criteria) {
        List<CategorieLocale> content = null;
        if (criteria != null) {
            CategorieLocaleSpecification mySpecification = constructSpecification(criteria);
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


    private CategorieLocaleSpecification constructSpecification(CategorieLocaleCriteria criteria) {
        CategorieLocaleSpecification mySpecification =  (CategorieLocaleSpecification) RefelexivityUtil.constructObjectUsingOneParam(CategorieLocaleSpecification.class, criteria);
        return mySpecification;
    }

    public List<CategorieLocale> findPaginatedByCriteria(CategorieLocaleCriteria criteria, int page, int pageSize, String order, String sortField) {
        CategorieLocaleSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(CategorieLocaleCriteria criteria) {
        CategorieLocaleSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
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
    public int delete(CategorieLocale t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<CategorieLocale> delete(List<CategorieLocale> list) {
		List<CategorieLocale> result = new ArrayList();
        if (list != null) {
            for (CategorieLocale t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CategorieLocale create(CategorieLocale t) {
        CategorieLocale loaded = findByReferenceEntity(t);
        CategorieLocale saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<CategorieLocale> create(List<CategorieLocale> ts) {
        List<CategorieLocale> result = new ArrayList<>();
        if (ts != null) {
            for (CategorieLocale t : ts) {
				CategorieLocale created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public CategorieLocale findWithAssociatedLists(Long id){
        CategorieLocale result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<CategorieLocale> update(List<CategorieLocale> ts, boolean createIfNotExist) {
        List<CategorieLocale> result = new ArrayList<>();
        if (ts != null) {
            for (CategorieLocale t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    CategorieLocale loadedItem = dao.findById(t.getId()).orElse(null);
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





    public CategorieLocale findByReferenceEntity(CategorieLocale t){
        return t==null? null : dao.findByCode(t.getCode());
    }



    public List<CategorieLocale> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<CategorieLocale>> getToBeSavedAndToBeDeleted(List<CategorieLocale> oldList, List<CategorieLocale> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<CategorieLocale> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired CategorieLocaleDao dao;


}
