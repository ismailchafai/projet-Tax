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

import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauAdminService;
import ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauConverter;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDto;
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
@RequestMapping("/api/admin/notificationRetardDeuxiemeNiveau/")
public class NotificationRetardDeuxiemeNiveauRestAdmin {




    @Operation(summary = "Finds a list of all notificationRetardDeuxiemeNiveaus")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> findAll() throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> res = null;
        List<NotificationRetardDeuxiemeNiveau> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardDeuxiemeNiveaus")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> res = null;
        List<NotificationRetardDeuxiemeNiveau> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveau by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> findById(@PathVariable Long id) {
        NotificationRetardDeuxiemeNiveau t = service.findById(id);
        if (t != null) {
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveau by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> findByCode(@PathVariable String code) {
	    NotificationRetardDeuxiemeNiveau t = service.findByReferenceEntity(new NotificationRetardDeuxiemeNiveau(code));
        if (t != null) {
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  notificationRetardDeuxiemeNiveau")
    @PostMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> save(@RequestBody NotificationRetardDeuxiemeNiveauDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            NotificationRetardDeuxiemeNiveau myT = converter.toItem(dto);
            NotificationRetardDeuxiemeNiveau t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                NotificationRetardDeuxiemeNiveauDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  notificationRetardDeuxiemeNiveau")
    @PutMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> update(@RequestBody NotificationRetardDeuxiemeNiveauDto dto) throws Exception {
        ResponseEntity<NotificationRetardDeuxiemeNiveauDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            NotificationRetardDeuxiemeNiveau t = service.findById(dto.getId());
            converter.copy(dto,t);
            NotificationRetardDeuxiemeNiveau updated = service.update(t);
            NotificationRetardDeuxiemeNiveauDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of notificationRetardDeuxiemeNiveau")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> delete(@RequestBody List<NotificationRetardDeuxiemeNiveauDto> dtos) throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<NotificationRetardDeuxiemeNiveau> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveau")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> delete(@RequestBody NotificationRetardDeuxiemeNiveauDto dto) throws Exception {
		ResponseEntity<NotificationRetardDeuxiemeNiveauDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            NotificationRetardDeuxiemeNiveau t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveau")
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
    @Operation(summary = "Delete multiple notificationRetardDeuxiemeNiveaus by ids")
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



    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveau and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDto> findWithAssociatedLists(@PathVariable Long id) {
        NotificationRetardDeuxiemeNiveau loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        NotificationRetardDeuxiemeNiveauDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds notificationRetardDeuxiemeNiveaus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> findByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDto>> res = null;
        List<NotificationRetardDeuxiemeNiveau> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated notificationRetardDeuxiemeNiveaus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        List<NotificationRetardDeuxiemeNiveau> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets notificationRetardDeuxiemeNiveau data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardDeuxiemeNiveauCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<NotificationRetardDeuxiemeNiveauDto> findDtos(List<NotificationRetardDeuxiemeNiveau> list){
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<NotificationRetardDeuxiemeNiveauDto> getDtoResponseEntity(NotificationRetardDeuxiemeNiveauDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private NotificationRetardDeuxiemeNiveauAdminService service;
    @Autowired private NotificationRetardDeuxiemeNiveauConverter converter;





}
