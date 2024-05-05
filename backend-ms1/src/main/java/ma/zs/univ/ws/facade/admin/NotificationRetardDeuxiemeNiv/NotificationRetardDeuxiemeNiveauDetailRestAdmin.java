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

import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailAdminService;
import ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailConverter;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailDto;
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
@RequestMapping("/api/admin/notificationRetardDeuxiemeNiveauDetail/")
public class NotificationRetardDeuxiemeNiveauDetailRestAdmin {




    @Operation(summary = "Finds a list of all notificationRetardDeuxiemeNiveauDetails")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> findAll() throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> res = null;
        List<NotificationRetardDeuxiemeNiveauDetail> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardDeuxiemeNiveauDetails")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> res = null;
        List<NotificationRetardDeuxiemeNiveauDetail> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetail by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> findById(@PathVariable Long id) {
        NotificationRetardDeuxiemeNiveauDetail t = service.findById(id);
        if (t != null) {
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> findByCode(@PathVariable String code) {
	    NotificationRetardDeuxiemeNiveauDetail t = service.findByReferenceEntity(new NotificationRetardDeuxiemeNiveauDetail(code));
        if (t != null) {
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  notificationRetardDeuxiemeNiveauDetail")
    @PostMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> save(@RequestBody NotificationRetardDeuxiemeNiveauDetailDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            NotificationRetardDeuxiemeNiveauDetail myT = converter.toItem(dto);
            NotificationRetardDeuxiemeNiveauDetail t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                NotificationRetardDeuxiemeNiveauDetailDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  notificationRetardDeuxiemeNiveauDetail")
    @PutMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> update(@RequestBody NotificationRetardDeuxiemeNiveauDetailDto dto) throws Exception {
        ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            NotificationRetardDeuxiemeNiveauDetail t = service.findById(dto.getId());
            converter.copy(dto,t);
            NotificationRetardDeuxiemeNiveauDetail updated = service.update(t);
            NotificationRetardDeuxiemeNiveauDetailDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of notificationRetardDeuxiemeNiveauDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> delete(@RequestBody List<NotificationRetardDeuxiemeNiveauDetailDto> dtos) throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<NotificationRetardDeuxiemeNiveauDetail> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetail")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> delete(@RequestBody NotificationRetardDeuxiemeNiveauDetailDto dto) throws Exception {
		ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            NotificationRetardDeuxiemeNiveauDetail t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified notificationRetardDeuxiemeNiveauDetail")
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
    @Operation(summary = "Delete multiple notificationRetardDeuxiemeNiveauDetails by ids")
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


    @Operation(summary = "find by trim id")
    @GetMapping("trim/id/{id}")
    public List<NotificationRetardDeuxiemeNiveauDetailDto> findByTrimId(@PathVariable Long id){
        return findDtos(service.findByTrimId(id));
    }
    @Operation(summary = "delete by trim id")
    @DeleteMapping("trim/id/{id}")
    public int deleteByTrimId(@PathVariable Long id){
        return service.deleteByTrimId(id);
    }

    @Operation(summary = "Finds a notificationRetardDeuxiemeNiveauDetail and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> findWithAssociatedLists(@PathVariable Long id) {
        NotificationRetardDeuxiemeNiveauDetail loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        NotificationRetardDeuxiemeNiveauDetailDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds notificationRetardDeuxiemeNiveauDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> findByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        ResponseEntity<List<NotificationRetardDeuxiemeNiveauDetailDto>> res = null;
        List<NotificationRetardDeuxiemeNiveauDetail> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated notificationRetardDeuxiemeNiveauDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        List<NotificationRetardDeuxiemeNiveauDetail> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets notificationRetardDeuxiemeNiveauDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardDeuxiemeNiveauDetailCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<NotificationRetardDeuxiemeNiveauDetailDto> findDtos(List<NotificationRetardDeuxiemeNiveauDetail> list){
        converter.initObject(true);
        List<NotificationRetardDeuxiemeNiveauDetailDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<NotificationRetardDeuxiemeNiveauDetailDto> getDtoResponseEntity(NotificationRetardDeuxiemeNiveauDetailDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private NotificationRetardDeuxiemeNiveauDetailAdminService service;
    @Autowired private NotificationRetardDeuxiemeNiveauDetailConverter converter;





}
