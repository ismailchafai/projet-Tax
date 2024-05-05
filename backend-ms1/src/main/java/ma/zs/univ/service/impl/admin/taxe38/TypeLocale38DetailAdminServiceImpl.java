package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;
import ma.zs.univ.dao.facade.core.taxe38.TypeLocale38DetailDao;
import ma.zs.univ.dao.specification.core.taxe38.TypeLocale38DetailSpecification;
import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService;
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
public class TypeLocale38DetailAdminServiceImpl implements TypeLocale38DetailAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypeLocale38Detail update(TypeLocale38Detail t) {
        TypeLocale38Detail loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{TypeLocale38Detail.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public TypeLocale38Detail findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public TypeLocale38Detail findOrSave(TypeLocale38Detail t) {
        if (t != null) {
            TypeLocale38Detail result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<TypeLocale38Detail> importData(List<TypeLocale38Detail> items) {
        List<TypeLocale38Detail> list = new ArrayList<>();
        for (TypeLocale38Detail t : items) {
            TypeLocale38Detail founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<TypeLocale38Detail> findAll() {
        return dao.findAll();
    }

    public List<TypeLocale38Detail> findByCriteria(TypeLocale38DetailCriteria criteria) {
        List<TypeLocale38Detail> content = null;
        if (criteria != null) {
            TypeLocale38DetailSpecification mySpecification = constructSpecification(criteria);
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


    private TypeLocale38DetailSpecification constructSpecification(TypeLocale38DetailCriteria criteria) {
        TypeLocale38DetailSpecification mySpecification =  (TypeLocale38DetailSpecification) RefelexivityUtil.constructObjectUsingOneParam(TypeLocale38DetailSpecification.class, criteria);
        return mySpecification;
    }

    public List<TypeLocale38Detail> findPaginatedByCriteria(TypeLocale38DetailCriteria criteria, int page, int pageSize, String order, String sortField) {
        TypeLocale38DetailSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(TypeLocale38DetailCriteria criteria) {
        TypeLocale38DetailSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(TypeLocale38Detail t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeLocale38Detail> delete(List<TypeLocale38Detail> list) {
		List<TypeLocale38Detail> result = new ArrayList();
        if (list != null) {
            for (TypeLocale38Detail t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypeLocale38Detail create(TypeLocale38Detail t) {
        TypeLocale38Detail loaded = findByReferenceEntity(t);
        TypeLocale38Detail saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeLocale38Detail> create(List<TypeLocale38Detail> ts) {
        List<TypeLocale38Detail> result = new ArrayList<>();
        if (ts != null) {
            for (TypeLocale38Detail t : ts) {
				TypeLocale38Detail created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public TypeLocale38Detail findWithAssociatedLists(Long id){
        TypeLocale38Detail result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypeLocale38Detail> update(List<TypeLocale38Detail> ts, boolean createIfNotExist) {
        List<TypeLocale38Detail> result = new ArrayList<>();
        if (ts != null) {
            for (TypeLocale38Detail t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    TypeLocale38Detail loadedItem = dao.findById(t.getId()).orElse(null);
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





    public TypeLocale38Detail findByReferenceEntity(TypeLocale38Detail t){
        return t==null? null : dao.findByCode(t.getCode());
    }



    public List<TypeLocale38Detail> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<TypeLocale38Detail>> getToBeSavedAndToBeDeleted(List<TypeLocale38Detail> oldList, List<TypeLocale38Detail> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<TypeLocale38Detail> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired TypeLocale38DetailDao dao;


}
