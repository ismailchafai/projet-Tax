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

import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38DetailAdminService;
import ma.zs.univ.ws.converter.taxe38.Taxe38DetailConverter;
import ma.zs.univ.ws.dto.taxe38.Taxe38DetailDto;
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
@RequestMapping("/api/admin/taxe38Detail/")
public class Taxe38DetailRestAdmin {




    @Operation(summary = "Finds a list of all taxe38Details")
    @GetMapping("")
    public ResponseEntity<List<Taxe38DetailDto>> findAll() throws Exception {
        ResponseEntity<List<Taxe38DetailDto>> res = null;
        List<Taxe38Detail> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<Taxe38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all taxe38Details")
    @GetMapping("optimized")
    public ResponseEntity<List<Taxe38DetailDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<Taxe38DetailDto>> res = null;
        List<Taxe38Detail> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<Taxe38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a taxe38Detail by id")
    @GetMapping("id/{id}")
    public ResponseEntity<Taxe38DetailDto> findById(@PathVariable Long id) {
        Taxe38Detail t = service.findById(id);
        if (t != null) {
            converter.init(true);
            Taxe38DetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a taxe38Detail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<Taxe38DetailDto> findByCode(@PathVariable String code) {
	    Taxe38Detail t = service.findByReferenceEntity(new Taxe38Detail(code));
        if (t != null) {
            converter.init(true);
            Taxe38DetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  taxe38Detail")
    @PostMapping("")
    public ResponseEntity<Taxe38DetailDto> save(@RequestBody Taxe38DetailDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Taxe38Detail myT = converter.toItem(dto);
            Taxe38Detail t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                Taxe38DetailDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  taxe38Detail")
    @PutMapping("")
    public ResponseEntity<Taxe38DetailDto> update(@RequestBody Taxe38DetailDto dto) throws Exception {
        ResponseEntity<Taxe38DetailDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Taxe38Detail t = service.findById(dto.getId());
            converter.copy(dto,t);
            Taxe38Detail updated = service.update(t);
            Taxe38DetailDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of taxe38Detail")
    @PostMapping("multiple")
    public ResponseEntity<List<Taxe38DetailDto>> delete(@RequestBody List<Taxe38DetailDto> dtos) throws Exception {
        ResponseEntity<List<Taxe38DetailDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Taxe38Detail> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified taxe38Detail")
    @DeleteMapping("")
    public ResponseEntity<Taxe38DetailDto> delete(@RequestBody Taxe38DetailDto dto) throws Exception {
		ResponseEntity<Taxe38DetailDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Taxe38Detail t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified taxe38Detail")
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
    @Operation(summary = "Delete multiple taxe38Details by ids")
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


    @Operation(summary = "find by locale38Detail id")
    @GetMapping("locale38Detail/id/{id}")
    public List<Taxe38DetailDto> findByLocale38DetailId(@PathVariable Long id){
        return findDtos(service.findByLocale38DetailId(id));
    }
    @Operation(summary = "delete by locale38Detail id")
    @DeleteMapping("locale38Detail/id/{id}")
    public int deleteByLocale38DetailId(@PathVariable Long id){
        return service.deleteByLocale38DetailId(id);
    }

    @Operation(summary = "Finds a taxe38Detail and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<Taxe38DetailDto> findWithAssociatedLists(@PathVariable Long id) {
        Taxe38Detail loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        Taxe38DetailDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds taxe38Details by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<Taxe38DetailDto>> findByCriteria(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        ResponseEntity<List<Taxe38DetailDto>> res = null;
        List<Taxe38Detail> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<Taxe38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated taxe38Details by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        List<Taxe38Detail> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<Taxe38DetailDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets taxe38Detail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody Taxe38DetailCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<Taxe38DetailDto> findDtos(List<Taxe38Detail> list){
        converter.initObject(true);
        List<Taxe38DetailDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<Taxe38DetailDto> getDtoResponseEntity(Taxe38DetailDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private Taxe38DetailAdminService service;
    @Autowired private Taxe38DetailConverter converter;





}
