package  ma.zs.univ.ws.facade.admin.NotificationRetardTroisiemeNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.service.facade.admin.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauAdminService;
import ma.zs.univ.ws.converter.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauConverter;
import ma.zs.univ.ws.dto.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauDto;
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
@RequestMapping("/api/admin/notificationRetardTroisiemeNiveau/")
public class NotificationRetardTroisiemeNiveauRestAdmin {




    @Operation(summary = "Finds a list of all notificationRetardTroisiemeNiveaus")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> findAll() throws Exception {
        ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> res = null;
        List<NotificationRetardTroisiemeNiveau> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<NotificationRetardTroisiemeNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardTroisiemeNiveaus")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> res = null;
        List<NotificationRetardTroisiemeNiveau> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardTroisiemeNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a notificationRetardTroisiemeNiveau by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> findById(@PathVariable Long id) {
        NotificationRetardTroisiemeNiveau t = service.findById(id);
        if (t != null) {
            converter.init(true);
            NotificationRetardTroisiemeNiveauDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a notificationRetardTroisiemeNiveau by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> findByCode(@PathVariable String code) {
	    NotificationRetardTroisiemeNiveau t = service.findByReferenceEntity(new NotificationRetardTroisiemeNiveau(code));
        if (t != null) {
            converter.init(true);
            NotificationRetardTroisiemeNiveauDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  notificationRetardTroisiemeNiveau")
    @PostMapping("")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> save(@RequestBody NotificationRetardTroisiemeNiveauDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            NotificationRetardTroisiemeNiveau myT = converter.toItem(dto);
            NotificationRetardTroisiemeNiveau t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                NotificationRetardTroisiemeNiveauDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  notificationRetardTroisiemeNiveau")
    @PutMapping("")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> update(@RequestBody NotificationRetardTroisiemeNiveauDto dto) throws Exception {
        ResponseEntity<NotificationRetardTroisiemeNiveauDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            NotificationRetardTroisiemeNiveau t = service.findById(dto.getId());
            converter.copy(dto,t);
            NotificationRetardTroisiemeNiveau updated = service.update(t);
            NotificationRetardTroisiemeNiveauDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of notificationRetardTroisiemeNiveau")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> delete(@RequestBody List<NotificationRetardTroisiemeNiveauDto> dtos) throws Exception {
        ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<NotificationRetardTroisiemeNiveau> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified notificationRetardTroisiemeNiveau")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> delete(@RequestBody NotificationRetardTroisiemeNiveauDto dto) throws Exception {
		ResponseEntity<NotificationRetardTroisiemeNiveauDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            NotificationRetardTroisiemeNiveau t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified notificationRetardTroisiemeNiveau")
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
    @Operation(summary = "Delete multiple notificationRetardTroisiemeNiveaus by ids")
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


    @Operation(summary = "find by locale id")
    @GetMapping("locale/id/{id}")
    public List<NotificationRetardTroisiemeNiveauDto> findByLocaleId(@PathVariable Long id){
        return findDtos(service.findByLocaleId(id));
    }
    @Operation(summary = "delete by locale id")
    @DeleteMapping("locale/id/{id}")
    public int deleteByLocaleId(@PathVariable Long id){
        return service.deleteByLocaleId(id);
    }
    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<NotificationRetardTroisiemeNiveauDto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }
    @Operation(summary = "find by trim id")
    @GetMapping("trim/id/{id}")
    public List<NotificationRetardTroisiemeNiveauDto> findByTrimId(@PathVariable Long id){
        return findDtos(service.findByTrimId(id));
    }
    @Operation(summary = "delete by trim id")
    @DeleteMapping("trim/id/{id}")
    public int deleteByTrimId(@PathVariable Long id){
        return service.deleteByTrimId(id);
    }

    @Operation(summary = "Finds a notificationRetardTroisiemeNiveau and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<NotificationRetardTroisiemeNiveauDto> findWithAssociatedLists(@PathVariable Long id) {
        NotificationRetardTroisiemeNiveau loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        NotificationRetardTroisiemeNiveauDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds notificationRetardTroisiemeNiveaus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> findByCriteria(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        ResponseEntity<List<NotificationRetardTroisiemeNiveauDto>> res = null;
        List<NotificationRetardTroisiemeNiveau> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardTroisiemeNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated notificationRetardTroisiemeNiveaus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        List<NotificationRetardTroisiemeNiveau> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<NotificationRetardTroisiemeNiveauDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets notificationRetardTroisiemeNiveau data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardTroisiemeNiveauCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<NotificationRetardTroisiemeNiveauDto> findDtos(List<NotificationRetardTroisiemeNiveau> list){
        converter.initObject(true);
        List<NotificationRetardTroisiemeNiveauDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<NotificationRetardTroisiemeNiveauDto> getDtoResponseEntity(NotificationRetardTroisiemeNiveauDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private NotificationRetardTroisiemeNiveauAdminService service;
    @Autowired private NotificationRetardTroisiemeNiveauConverter converter;





}
