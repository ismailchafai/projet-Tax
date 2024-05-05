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

import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;
import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService;
import ma.zs.univ.ws.converter.taxe38.TypeLocale38DetailConverter;
import ma.zs.univ.ws.dto.taxe38.TypeLocale38DetailDto;
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
@RequestMapping("/api/admin/typeLocale38Detail/")
public class TypeLocale38DetailRestAdmin {




    @Operation(summary = "Finds a list of all typeLocale38Details")
    @GetMapping("")
    public ResponseEntity<List<TypeLocale38DetailDto>> findAll() throws Exception {
        ResponseEntity<List<TypeLocale38DetailDto>> res = null;
        List<TypeLocale38Detail> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeLocale38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all typeLocale38Details")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeLocale38DetailDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<TypeLocale38DetailDto>> res = null;
        List<TypeLocale38Detail> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeLocale38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a typeLocale38Detail by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeLocale38DetailDto> findById(@PathVariable Long id) {
        TypeLocale38Detail t = service.findById(id);
        if (t != null) {
            TypeLocale38DetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a typeLocale38Detail by code")
    @GetMapping("code/{code}")
    public ResponseEntity<TypeLocale38DetailDto> findByCode(@PathVariable String code) {
	    TypeLocale38Detail t = service.findByReferenceEntity(new TypeLocale38Detail(code));
        if (t != null) {
            TypeLocale38DetailDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  typeLocale38Detail")
    @PostMapping("")
    public ResponseEntity<TypeLocale38DetailDto> save(@RequestBody TypeLocale38DetailDto dto) throws Exception {
        if(dto!=null){
            TypeLocale38Detail myT = converter.toItem(dto);
            TypeLocale38Detail t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                TypeLocale38DetailDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  typeLocale38Detail")
    @PutMapping("")
    public ResponseEntity<TypeLocale38DetailDto> update(@RequestBody TypeLocale38DetailDto dto) throws Exception {
        ResponseEntity<TypeLocale38DetailDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            TypeLocale38Detail t = service.findById(dto.getId());
            converter.copy(dto,t);
            TypeLocale38Detail updated = service.update(t);
            TypeLocale38DetailDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of typeLocale38Detail")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeLocale38DetailDto>> delete(@RequestBody List<TypeLocale38DetailDto> dtos) throws Exception {
        ResponseEntity<List<TypeLocale38DetailDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<TypeLocale38Detail> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified typeLocale38Detail")
    @DeleteMapping("")
    public ResponseEntity<TypeLocale38DetailDto> delete(@RequestBody TypeLocale38DetailDto dto) throws Exception {
		ResponseEntity<TypeLocale38DetailDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            TypeLocale38Detail t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified typeLocale38Detail")
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
    @Operation(summary = "Delete multiple typeLocale38Details by ids")
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



    @Operation(summary = "Finds a typeLocale38Detail and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TypeLocale38DetailDto> findWithAssociatedLists(@PathVariable Long id) {
        TypeLocale38Detail loaded =  service.findWithAssociatedLists(id);
        TypeLocale38DetailDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds typeLocale38Details by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeLocale38DetailDto>> findByCriteria(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        ResponseEntity<List<TypeLocale38DetailDto>> res = null;
        List<TypeLocale38Detail> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypeLocale38DetailDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated typeLocale38Details by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        List<TypeLocale38Detail> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<TypeLocale38DetailDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets typeLocale38Detail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeLocale38DetailCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<TypeLocale38DetailDto> findDtos(List<TypeLocale38Detail> list){
        List<TypeLocale38DetailDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<TypeLocale38DetailDto> getDtoResponseEntity(TypeLocale38DetailDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private TypeLocale38DetailAdminService service;
    @Autowired private TypeLocale38DetailConverter converter;





}
