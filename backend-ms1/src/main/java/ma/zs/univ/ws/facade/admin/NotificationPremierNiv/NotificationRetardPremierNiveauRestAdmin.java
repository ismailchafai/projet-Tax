package  ma.zs.univ.ws.facade.admin.NotificationPremierNiv;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.service.facade.admin.NotificationPremierNiv.NotificationRetardPremierNiveauAdminService;
import ma.zs.univ.ws.converter.NotificationPremierNiv.NotificationRetardPremierNiveauConverter;
import ma.zs.univ.ws.dto.NotificationPremierNiv.NotificationRetardPremierNiveauDto;
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
@RequestMapping("/api/admin/notificationRetardPremierNiveau/")
public class NotificationRetardPremierNiveauRestAdmin {




    @Operation(summary = "Finds a list of all notificationRetardPremierNiveaus")
    @GetMapping("")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> findAll() throws Exception {
        ResponseEntity<List<NotificationRetardPremierNiveauDto>> res = null;
        List<NotificationRetardPremierNiveau> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<NotificationRetardPremierNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all notificationRetardPremierNiveaus")
    @GetMapping("optimized")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<NotificationRetardPremierNiveauDto>> res = null;
        List<NotificationRetardPremierNiveau> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardPremierNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a notificationRetardPremierNiveau by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationRetardPremierNiveauDto> findById(@PathVariable Long id) {
        NotificationRetardPremierNiveau t = service.findById(id);
        if (t != null) {
            converter.init(true);
            NotificationRetardPremierNiveauDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a notificationRetardPremierNiveau by code")
    @GetMapping("code/{code}")
    public ResponseEntity<NotificationRetardPremierNiveauDto> findByCode(@PathVariable String code) {
	    NotificationRetardPremierNiveau t = service.findByReferenceEntity(new NotificationRetardPremierNiveau(code));
        if (t != null) {
            converter.init(true);
            NotificationRetardPremierNiveauDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  notificationRetardPremierNiveau")
    @PostMapping("")
    public ResponseEntity<NotificationRetardPremierNiveauDto> save(@RequestBody NotificationRetardPremierNiveauDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            NotificationRetardPremierNiveau myT = converter.toItem(dto);
            NotificationRetardPremierNiveau t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                NotificationRetardPremierNiveauDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  notificationRetardPremierNiveau")
    @PutMapping("")
    public ResponseEntity<NotificationRetardPremierNiveauDto> update(@RequestBody NotificationRetardPremierNiveauDto dto) throws Exception {
        ResponseEntity<NotificationRetardPremierNiveauDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            NotificationRetardPremierNiveau t = service.findById(dto.getId());
            converter.copy(dto,t);
            NotificationRetardPremierNiveau updated = service.update(t);
            NotificationRetardPremierNiveauDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of notificationRetardPremierNiveau")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> delete(@RequestBody List<NotificationRetardPremierNiveauDto> dtos) throws Exception {
        ResponseEntity<List<NotificationRetardPremierNiveauDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<NotificationRetardPremierNiveau> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified notificationRetardPremierNiveau")
    @DeleteMapping("")
    public ResponseEntity<NotificationRetardPremierNiveauDto> delete(@RequestBody NotificationRetardPremierNiveauDto dto) throws Exception {
		ResponseEntity<NotificationRetardPremierNiveauDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            NotificationRetardPremierNiveau t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified notificationRetardPremierNiveau")
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
    @Operation(summary = "Delete multiple notificationRetardPremierNiveaus by ids")
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



    @Operation(summary = "Finds a notificationRetardPremierNiveau and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<NotificationRetardPremierNiveauDto> findWithAssociatedLists(@PathVariable Long id) {
        NotificationRetardPremierNiveau loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        NotificationRetardPremierNiveauDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds notificationRetardPremierNiveaus by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationRetardPremierNiveauDto>> findByCriteria(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        ResponseEntity<List<NotificationRetardPremierNiveauDto>> res = null;
        List<NotificationRetardPremierNiveau> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<NotificationRetardPremierNiveauDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated notificationRetardPremierNiveaus by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        List<NotificationRetardPremierNiveau> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<NotificationRetardPremierNiveauDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets notificationRetardPremierNiveau data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationRetardPremierNiveauCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<NotificationRetardPremierNiveauDto> findDtos(List<NotificationRetardPremierNiveau> list){
        converter.initObject(true);
        List<NotificationRetardPremierNiveauDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<NotificationRetardPremierNiveauDto> getDtoResponseEntity(NotificationRetardPremierNiveauDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private NotificationRetardPremierNiveauAdminService service;
    @Autowired private NotificationRetardPremierNiveauConverter converter;





}
