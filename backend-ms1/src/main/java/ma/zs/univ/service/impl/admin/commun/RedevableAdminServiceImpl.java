package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.dao.facade.core.commun.RedevableDao;
import ma.zs.univ.dao.specification.core.commun.RedevableSpecification;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService;
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


import java.time.LocalDateTime;
import ma.zs.univ.zynerator.security.service.facade.UserService;
import ma.zs.univ.zynerator.security.service.facade.RoleService;
import ma.zs.univ.zynerator.security.service.facade.RoleUserService;
import ma.zs.univ.zynerator.security.bean.Role;
import ma.zs.univ.zynerator.security.bean.RoleUser;
import ma.zs.univ.zynerator.security.common.AuthoritiesConstants;
import ma.zs.univ.zynerator.security.service.facade.ModelPermissionUserService;
import java.util.Collection;
import java.util.List;
@Service
public class RedevableAdminServiceImpl implements RedevableAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Redevable update(Redevable t) {
        Redevable loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Redevable.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Redevable findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Redevable findOrSave(Redevable t) {
        if (t != null) {
            Redevable result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Redevable> importData(List<Redevable> items) {
        List<Redevable> list = new ArrayList<>();
        for (Redevable t : items) {
            Redevable founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Redevable> findAll() {
        return dao.findAll();
    }

    public List<Redevable> findByCriteria(RedevableCriteria criteria) {
        List<Redevable> content = null;
        if (criteria != null) {
            RedevableSpecification mySpecification = constructSpecification(criteria);
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


    private RedevableSpecification constructSpecification(RedevableCriteria criteria) {
        RedevableSpecification mySpecification =  (RedevableSpecification) RefelexivityUtil.constructObjectUsingOneParam(RedevableSpecification.class, criteria);
        return mySpecification;
    }

    public List<Redevable> findPaginatedByCriteria(RedevableCriteria criteria, int page, int pageSize, String order, String sortField) {
        RedevableSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(RedevableCriteria criteria) {
        RedevableSpecification mySpecification = constructSpecification(criteria);
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
    public int delete(Redevable t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Redevable> delete(List<Redevable> list) {
		List<Redevable> result = new ArrayList();
        if (list != null) {
            for (Redevable t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }


	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Redevable> create(List<Redevable> ts) {
        List<Redevable> result = new ArrayList<>();
        if (ts != null) {
            for (Redevable t : ts) {
				Redevable created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Redevable findWithAssociatedLists(Long id){
        Redevable result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Redevable> update(List<Redevable> ts, boolean createIfNotExist) {
        List<Redevable> result = new ArrayList<>();
        if (ts != null) {
            for (Redevable t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Redevable loadedItem = dao.findById(t.getId()).orElse(null);
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





    public Redevable findByReferenceEntity(Redevable t) {
        return t == null || t.getId() == null ? null : findById(t.getId());
    }



    public List<Redevable> findAllOptimized() {
        return dao.findAll();
    }

    @Override
    public List<List<Redevable>> getToBeSavedAndToBeDeleted(List<Redevable> oldList, List<Redevable> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Redevable> importExcel(MultipartFile file) {
        return null;
    }


    @Override
    public Redevable create(Redevable t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);

        Role role = new Role();
        role.setAuthority(AuthoritiesConstants.ADMIN);
        role.setCreatedAt(LocalDateTime.now());
        Role myRole = roleService.create(role);
        RoleUser roleUser = new RoleUser();
        roleUser.setRole(myRole);
        if (t.getRoleUsers() == null)
        t.setRoleUsers(new ArrayList<>());

        t.getRoleUsers().add(roleUser);
        if (t.getModelPermissionUsers() == null)
        t.setModelPermissionUsers(new ArrayList<>());

        t.setModelPermissionUsers(modelPermissionUserService.initModelPermissionUser());

        Redevable mySaved = dao.save(t);

        if (t.getModelPermissionUsers() != null) {
            t.getModelPermissionUsers().forEach(e -> {
                e.setUser(mySaved);
                modelPermissionUserService.create(e);
            });
        }
        if (t.getRoleUsers() != null) {
            t.getRoleUsers().forEach(element-> {
                element.setUser(mySaved);
                roleUserService.create(element);
            });
        }

        return mySaved;
     }

    public Redevable findByUsername(String username){
        return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
        return userService.changePassword(username, newPassword);
    }





    private @Autowired UserService userService;
    private @Autowired RoleService roleService;
    private @Autowired ModelPermissionUserService modelPermissionUserService;
    private @Autowired RoleUserService roleUserService;


    private @Autowired RedevableDao dao;


}
