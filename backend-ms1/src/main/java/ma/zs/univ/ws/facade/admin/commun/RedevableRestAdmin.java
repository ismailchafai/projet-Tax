package  ma.zs.univ.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService;
import ma.zs.univ.ws.converter.commun.RedevableConverter;
import ma.zs.univ.ws.dto.commun.RedevableDto;
import ma.zs.univ.zynerator.controller.AbstractController;
import ma.zs.univ.zynerator.dto.AuditEntityDto;
import ma.zs.univ.zynerator.util.PaginatedList;


import ma.zs.univ.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.univ.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.univ.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/redevable/")
public class RedevableRestAdmin {




    @Operation(summary = "Finds a list of all redevables")
    @GetMapping("")
    public ResponseEntity<List<RedevableDto>> findAll() throws Exception {
        ResponseEntity<List<RedevableDto>> res = null;
        List<Redevable> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RedevableDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }


    @Operation(summary = "Finds a redevable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RedevableDto> findById(@PathVariable Long id) {
        Redevable t = service.findById(id);
        if (t != null) {
            RedevableDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Saves the specified  redevable")
    @PostMapping("")
    public ResponseEntity<RedevableDto> save(@RequestBody RedevableDto dto) throws Exception {
        if(dto!=null){
            Redevable myT = converter.toItem(dto);
            Redevable t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                RedevableDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  redevable")
    @PutMapping("")
    public ResponseEntity<RedevableDto> update(@RequestBody RedevableDto dto) throws Exception {
        ResponseEntity<RedevableDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Redevable t = service.findById(dto.getId());
            converter.copy(dto,t);
            Redevable updated = service.update(t);
            RedevableDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of redevable")
    @PostMapping("multiple")
    public ResponseEntity<List<RedevableDto>> delete(@RequestBody List<RedevableDto> dtos) throws Exception {
        ResponseEntity<List<RedevableDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<Redevable> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified redevable")
    @DeleteMapping("")
    public ResponseEntity<RedevableDto> delete(@RequestBody RedevableDto dto) throws Exception {
		ResponseEntity<RedevableDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            Redevable t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified redevable")
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
    @Operation(summary = "Delete multiple redevables by ids")
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



    @Operation(summary = "Finds a redevable and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<RedevableDto> findWithAssociatedLists(@PathVariable Long id) {
        Redevable loaded =  service.findWithAssociatedLists(id);
        RedevableDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds redevables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RedevableDto>> findByCriteria(@RequestBody RedevableCriteria criteria) throws Exception {
        ResponseEntity<List<RedevableDto>> res = null;
        List<Redevable> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<RedevableDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated redevables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RedevableCriteria criteria) throws Exception {
        List<Redevable> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<RedevableDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets redevable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RedevableCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<RedevableDto> findDtos(List<Redevable> list){
        List<RedevableDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<RedevableDto> getDtoResponseEntity(RedevableDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }

    @Autowired private RedevableAdminService service;
    @Autowired private RedevableConverter converter;





}
