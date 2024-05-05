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

import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.dao.criteria.core.taxe38.CategorieLocaleCriteria;
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService;
import ma.zs.univ.ws.converter.taxe38.CategorieLocaleConverter;
import ma.zs.univ.ws.dto.taxe38.CategorieLocaleDto;
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
@RequestMapping("/api/admin/categorieLocale/")
public class CategorieLocaleRestAdmin {




    @Operation(summary = "Finds a list of all categorieLocales")
    @GetMapping("")
    public ResponseEntity<List<CategorieLocaleDto>> findAll() throws Exception {
        ResponseEntity<List<CategorieLocaleDto>> res = null;
        List<CategorieLocale> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<CategorieLocaleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all categorieLocales")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieLocaleDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<CategorieLocaleDto>> res = null;
        List<CategorieLocale> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<CategorieLocaleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a categorieLocale by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieLocaleDto> findById(@PathVariable Long id) {
        CategorieLocale t = service.findById(id);
        if (t != null) {
            CategorieLocaleDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a categorieLocale by code")
    @GetMapping("code/{code}")
    public ResponseEntity<CategorieLocaleDto> findByCode(@PathVariable String code) {
	    CategorieLocale t = service.findByReferenceEntity(new CategorieLocale(code));
        if (t != null) {
            CategorieLocaleDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  categorieLocale")
    @PostMapping("")
    public ResponseEntity<CategorieLocaleDto> save(@RequestBody CategorieLocaleDto dto) throws Exception {
        if(dto!=null){
            CategorieLocale myT = converter.toItem(dto);
            CategorieLocale t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                CategorieLocaleDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  categorieLocale")
    @PutMapping("")
    public ResponseEntity<CategorieLocaleDto> update(@RequestBody CategorieLocaleDto dto) throws Exception {
        ResponseEntity<CategorieLocaleDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            CategorieLocale t = service.findById(dto.getId());
            converter.copy(dto,t);
            CategorieLocale updated = service.update(t);
            CategorieLocaleDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of categorieLocale")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieLocaleDto>> delete(@RequestBody List<CategorieLocaleDto> dtos) throws Exception {
        ResponseEntity<List<CategorieLocaleDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<CategorieLocale> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified categorieLocale")
    @DeleteMapping("")
    public ResponseEntity<CategorieLocaleDto> delete(@RequestBody CategorieLocaleDto dto) throws Exception {
		ResponseEntity<CategorieLocaleDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            CategorieLocale t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified categorieLocale")
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
    @Operation(summary = "Delete multiple categorieLocales by ids")
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



    @Operation(summary = "Finds a categorieLocale and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<CategorieLocaleDto> findWithAssociatedLists(@PathVariable Long id) {
        CategorieLocale loaded =  service.findWithAssociatedLists(id);
        CategorieLocaleDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds categorieLocales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieLocaleDto>> findByCriteria(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        ResponseEntity<List<CategorieLocaleDto>> res = null;
        List<CategorieLocale> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<CategorieLocaleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated categorieLocales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        List<CategorieLocale> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<CategorieLocaleDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets categorieLocale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieLocaleCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<CategorieLocaleDto> findDtos(List<CategorieLocale> list){
        List<CategorieLocaleDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<CategorieLocaleDto> getDtoResponseEntity(CategorieLocaleDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private CategorieLocaleAdminService service;
    @Autowired private CategorieLocaleConverter converter;





}
