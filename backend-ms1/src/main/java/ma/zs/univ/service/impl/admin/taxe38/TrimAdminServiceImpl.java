package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.dao.criteria.core.taxe38.TrimCriteria;
import ma.zs.univ.dao.facade.core.taxe38.TrimDao;
import ma.zs.univ.dao.specification.core.taxe38.TrimSpecification;
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService;
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
public class TrimAdminServiceImpl implements TrimAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Trim update(Trim t) {
        Trim loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Trim.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Trim findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Trim findOrSave(Trim t) {
        if (t != null) {
            Trim result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Trim> importData(List<Trim> items) {
        List<Trim> list = new ArrayList<>();
        for (Trim t : items) {
            Trim founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Trim> findAll() {
        return dao.findAll();
    }

    public List<Trim> findByCriteria(TrimCriteria criteria) {
        List<Trim> content = null;
        if (criteria != null) {
            TrimSpecification mySpecification = constructSpecification(criteria);
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


    private TrimSpecification constructSpecification(TrimCriteria criteria) {
        TrimSpecification mySpecification =  (TrimSpecification) RefelexivityUtil.constructObjectUsingOneParam(TrimSpecification.class, criteria);
        return mySpecification;
    }

    public List<Trim> findPaginatedByCriteria(TrimCriteria criteria, int page, int pageSize, String order, String sortField) {
        TrimSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(TrimCriteria criteria) {
        TrimSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(Trim t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Trim> delete(List<Trim> list) {
		List<Trim> result = new ArrayList();
        if (list != null) {
            for (Trim t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Trim create(Trim t) {
        Trim loaded = findByReferenceEntity(t);
        Trim saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Trim> create(List<Trim> ts) {
        List<Trim> result = new ArrayList<>();
        if (ts != null) {
            for (Trim t : ts) {
				Trim created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Trim findWithAssociatedLists(Long id){
        Trim result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Trim> update(List<Trim> ts, boolean createIfNotExist) {
        List<Trim> result = new ArrayList<>();
        if (ts != null) {
            for (Trim t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Trim loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Trim findByReferenceEntity(Trim t) {
        return t == null || t.getId() == null ? null : findById(t.getId());
    }



    public List<Trim> findAllOptimized() {
        return dao.findAll();
    }

    @Override
    public List<List<Trim>> getToBeSavedAndToBeDeleted(List<Trim> oldList, List<Trim> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Trim> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired TrimDao dao;


}
