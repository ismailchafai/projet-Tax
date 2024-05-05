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

import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.service.facade.admin.taxe38.Locale38DetailAdminService;
import ma.zs.univ.ws.converter.taxe38.Locale38DetailConverter;
import ma.zs.univ.ws.dto.taxe38.Locale38DetailDto;
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
@RequestMapping("/api/admin/locale38Detail/")
public class Locale38DetailRestAdmin {




    @Operation(summary = "Finds a list of all locale38Details")
    @GetMapping("")
    public ResponseEntity<List<Locale38DetailDto>> findAll() throws Exception {
        ResponseEntity<List<Locale38DetailDto>> res = null;
        List<Locale38Detail> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<Locale38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all locale38Details")
    @GetMapping("optimized")
    public ResponseEntity<List<Locale38DetailDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<Locale38DetailDto>> res = null;
        List<Locale38Detail> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<Locale38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a locale38Detail by id")
    @GetMapping("id/{id}")
    public ResponseEntity<Locale38DetailDto> findById(@PathVariable Long id) {
        Locale38Detail t = service.findById(id);
        if (t != null) {
            converter.init(true);
            Locale38DetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a locale38Detail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<Locale38DetailDto> findByCode(@PathVariable String code) {
	    Locale38Detail t = service.findByReferenceEntity(new Locale38Detail(code));
        if (t != null) {
            converter.init(true);
            Locale38DetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  locale38Detail")
    @PostMapping("")
    public ResponseEntity<Locale38DetailDto> save(@RequestBody Locale38DetailDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Locale38Detail myT = converter.toItem(dto);
            Locale38Detail t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                Locale38DetailDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  locale38Detail")
    @PutMapping("")
    public ResponseEntity<Locale38DetailDto> update(@RequestBody Locale38DetailDto dto) throws Exception {
        ResponseEntity<Locale38DetailDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Locale38Detail t = service.findById(dto.getId());
            converter.copy(dto,t);
            Locale38Detail updated = service.update(t);
            Locale38DetailDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of locale38Detail")
    @PostMapping("multiple")
    public ResponseEntity<List<Locale38DetailDto>> delete(@RequestBody List<Locale38DetailDto> dtos) throws Exception {
        ResponseEntity<List<Locale38DetailDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Locale38Detail> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified locale38Detail")
    @DeleteMapping("")
    public ResponseEntity<Locale38DetailDto> delete(@RequestBody Locale38DetailDto dto) throws Exception {
		ResponseEntity<Locale38DetailDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Locale38Detail t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified locale38Detail")
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
    @Operation(summary = "Delete multiple locale38Details by ids")
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


    @Operation(summary = "find by typeLocale38Detail id")
    @GetMapping("typeLocale38Detail/id/{id}")
    public List<Locale38DetailDto> findByTypeLocale38DetailId(@PathVariable Long id){
        return findDtos(service.findByTypeLocale38DetailId(id));
    }
    @Operation(summary = "delete by typeLocale38Detail id")
    @DeleteMapping("typeLocale38Detail/id/{id}")
    public int deleteByTypeLocale38DetailId(@PathVariable Long id){
        return service.deleteByTypeLocale38DetailId(id);
    }

    @Operation(summary = "Finds a locale38Detail and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<Locale38DetailDto> findWithAssociatedLists(@PathVariable Long id) {
        Locale38Detail loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        Locale38DetailDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds locale38Details by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<Locale38DetailDto>> findByCriteria(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        ResponseEntity<List<Locale38DetailDto>> res = null;
        List<Locale38Detail> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<Locale38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated locale38Details by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        List<Locale38Detail> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<Locale38DetailDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets locale38Detail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody Locale38DetailCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<Locale38DetailDto> findDtos(List<Locale38Detail> list){
        converter.initObject(true);
        List<Locale38DetailDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<Locale38DetailDto> getDtoResponseEntity(Locale38DetailDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private Locale38DetailAdminService service;
    @Autowired private Locale38DetailConverter converter;





}
