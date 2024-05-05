package  ma.zs.univ.ws.facade.admin.NotificationRetardDeuxiemeNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38AdminService;
import ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Converter;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Dto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/notificationRetardDeuxiemeNiveauDetailType38/")
public class NotificationRetardDeuxiemeNiveauDetailType38RestAdmin {




    @Operation(summary = "Finds a list of all notificationRetardDeuxiemeNiveauDetailType38s")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> findAll() throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> res = null;
        List<NotificationRetardDeuxiemeNiveauDetailType38> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardDeuxiemeNiveauDetailType38s")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> findAllOptimized() throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> res = null;
        List<NotificationRetardDeuxiemeNiveauDetailType38> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetailType38 by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> findById(@PathVariable Long id) {
        NotificationRetardDeuxiemeNiveauDetailType38 t = service.findById(id);
        if (t != null) {
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDetailType38Dto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetailType38 by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> findByCode(@PathVariable String code) {
	    NotificationRetardDeuxiemeNiveauDetailType38 t = service.findByReferenceEntity(new NotificationRetardDeuxiemeNiveauDetailType38(code));
        if (t != null) {
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDetailType38Dto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  notificationRetardDeuxiemeNiveauDetailType38")
    @PostMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> save(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Dto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDetailType38 myT = converter.toItem(dto);
            NotificationRetardDeuxiemeNiveauDetailType38 t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                NotificationRetardDeuxiemeNiveauDetailType38Dto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  notificationRetardDeuxiemeNiveauDetailType38")
    @PutMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> update(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Dto dto) throws Exception {
        ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            NotificationRetardDeuxiemeNiveauDetailType38 t = service.findById(dto.getId());
            converter.copy(dto,t);
            NotificationRetardDeuxiemeNiveauDetailType38 updated = service.update(t);
            NotificationRetardDeuxiemeNiveauDetailType38Dto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of notificationRetardDeuxiemeNiveauDetailType38")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> delete(@RequestBody List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos) throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<NotificationRetardDeuxiemeNiveauDetailType38> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetailType38")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> delete(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Dto dto) throws Exception {
		ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            NotificationRetardDeuxiemeNiveauDetailType38 t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetailType38")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        ResponseEntity<Long> res;
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        if (id != null) {
            boolean resultDelete = service.deleteById(id);
            if (resultDelete) {
                status = HttpStatus.OK;
            }
        }
        res = new ResponseEntity<>(id, status);
        return res;
    }
    @Operation(summary = "Delete multiple notificationRetardDeuxiemeNiveauDetailType38s by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        ResponseEntity<List<Long>> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (ids != null) {
            service.deleteByIdIn(ids);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(ids, status);
        return res;
     }


    @Operation(summary = "find by typeLocale38 id")
    @GetMapping("typeLocale38/id/{id}")
    public List<NotificationRetardDeuxiemeNiveauDetailType38Dto> findByTypeLocale38Id(@PathVariable Long id){
        return findDtos(service.findByTypeLocale38Id(id));
    }
    @Operation(summary = "delete by typeLocale38 id")
    @DeleteMapping("typeLocale38/id/{id}")
    public int deleteByTypeLocale38Id(@PathVariable Long id){
        return service.deleteByTypeLocale38Id(id);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetailType38 and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> findWithAssociatedLists(@PathVariable Long id) {
        NotificationRetardDeuxiemeNiveauDetailType38 loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        NotificationRetardDeuxiemeNiveauDetailType38Dto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds notificationRetardDeuxiemeNiveauDetailType38s by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> findByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailType38Dto>> res = null;
        List<NotificationRetardDeuxiemeNiveauDetailType38> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated notificationRetardDeuxiemeNiveauDetailType38s by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        List<NotificationRetardDeuxiemeNiveauDetailType38> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets notificationRetardDeuxiemeNiveauDetailType38 data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardDeuxiemeNiveauDetailType38Criteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<NotificationRetardDeuxiemeNiveauDetailType38Dto> findDtos(List<NotificationRetardDeuxiemeNiveauDetailType38> list){
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<NotificationRetardDeuxiemeNiveauDetailType38Dto> getDtoResponseEntity(NotificationRetardDeuxiemeNiveauDetailType38Dto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private NotificationRetardDeuxiemeNiveauDetailType38AdminService service;
    @Autowired private NotificationRetardDeuxiemeNiveauDetailType38Converter converter;





}
