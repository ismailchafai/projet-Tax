package  ma.zs.univ.ws.facade.admin.taxe38;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38AdminService;
import ma.zs.univ.ws.converter.taxe38.Taxe38Converter;
import ma.zs.univ.ws.dto.taxe38.Taxe38Dto;
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
@RequestMapping("/api/admin/taxe38/")
public class Taxe38RestAdmin {




    @Operation(summary = "Finds a list of all taxe38s")
    @GetMapping("")
    public ResponseEntity<List<Taxe38Dto>> findAll() throws Exception {
        ResponseEntity<List<Taxe38Dto>> res = null;
        List<Taxe38> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initList(false);
            converter.initObject(true);
        List<Taxe38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all taxe38s")
    @GetMapping("optimized")
    public ResponseEntity<List<Taxe38Dto>> findAllOptimized() throws Exception {
        ResponseEntity<List<Taxe38Dto>> res = null;
        List<Taxe38> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initList(false);
        converter.initObject(true);
        List<Taxe38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a taxe38 by id")
    @GetMapping("id/{id}")
    public ResponseEntity<Taxe38Dto> findById(@PathVariable Long id) {
        Taxe38 t = service.findById(id);
        if (t != null) {
            converter.init(true);
            Taxe38Dto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a taxe38 by code")
    @GetMapping("code/{code}")
    public ResponseEntity<Taxe38Dto> findByCode(@PathVariable String code) {
	    Taxe38 t = service.findByReferenceEntity(new Taxe38(code));
        if (t != null) {
            converter.init(true);
            Taxe38Dto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  taxe38")
    @PostMapping("")
    public ResponseEntity<Taxe38Dto> save(@RequestBody Taxe38Dto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Taxe38 myT = converter.toItem(dto);
            Taxe38 t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                Taxe38Dto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  taxe38")
    @PutMapping("")
    public ResponseEntity<Taxe38Dto> update(@RequestBody Taxe38Dto dto) throws Exception {
        ResponseEntity<Taxe38Dto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Taxe38 t = service.findById(dto.getId());
            converter.copy(dto,t);
            Taxe38 updated = service.update(t);
            Taxe38Dto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of taxe38")
    @PostMapping("multiple")
    public ResponseEntity<List<Taxe38Dto>> delete(@RequestBody List<Taxe38Dto> dtos) throws Exception {
        ResponseEntity<List<Taxe38Dto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Taxe38> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified taxe38")
    @DeleteMapping("")
    public ResponseEntity<Taxe38Dto> delete(@RequestBody Taxe38Dto dto) throws Exception {
		ResponseEntity<Taxe38Dto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Taxe38 t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified taxe38")
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
    @Operation(summary = "Delete multiple taxe38s by ids")
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


    @Operation(summary = "find by redevable id")
    @GetMapping("redevable/id/{id}")
    public List<Taxe38Dto> findByRedevableId(@PathVariable Long id){
        return findDtos(service.findByRedevableId(id));
    }
    @Operation(summary = "delete by redevable id")
    @DeleteMapping("redevable/id/{id}")
    public int deleteByRedevableId(@PathVariable Long id){
        return service.deleteByRedevableId(id);
    }
    @Operation(summary = "find by locale id")
    @GetMapping("locale/id/{id}")
    public List<Taxe38Dto> findByLocaleId(@PathVariable Long id){
        return findDtos(service.findByLocaleId(id));
    }
    @Operation(summary = "delete by locale id")
    @DeleteMapping("locale/id/{id}")
    public int deleteByLocaleId(@PathVariable Long id){
        return service.deleteByLocaleId(id);
    }
    @Operation(summary = "find by trim id")
    @GetMapping("trim/id/{id}")
    public List<Taxe38Dto> findByTrimId(@PathVariable Long id){
        return findDtos(service.findByTrimId(id));
    }
    @Operation(summary = "delete by trim id")
    @DeleteMapping("trim/id/{id}")
    public int deleteByTrimId(@PathVariable Long id){
        return service.deleteByTrimId(id);
    }

    @Operation(summary = "Finds a taxe38 and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<Taxe38Dto> findWithAssociatedLists(@PathVariable Long id) {
        Taxe38 loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        Taxe38Dto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds taxe38s by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<Taxe38Dto>> findByCriteria(@RequestBody Taxe38Criteria criteria) throws Exception {
        ResponseEntity<List<Taxe38Dto>> res = null;
        List<Taxe38> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initList(false);
        converter.initObject(true);
        List<Taxe38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated taxe38s by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody Taxe38Criteria criteria) throws Exception {
        List<Taxe38> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initList(false);
        converter.initObject(true);
        List<Taxe38Dto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets taxe38 data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody Taxe38Criteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<Taxe38Dto> findDtos(List<Taxe38> list){
        converter.initList(false);
        converter.initObject(true);
        List<Taxe38Dto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<Taxe38Dto> getDtoResponseEntity(Taxe38Dto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private Taxe38AdminService service;
    @Autowired private Taxe38Converter converter;





}
