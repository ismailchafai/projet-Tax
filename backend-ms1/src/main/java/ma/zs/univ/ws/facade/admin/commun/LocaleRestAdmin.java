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

import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.service.facade.admin.commun.LocaleAdminService;
import ma.zs.univ.ws.converter.commun.LocaleConverter;
import ma.zs.univ.ws.dto.commun.LocaleDto;
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
@RequestMapping("/api/admin/locale/")
public class LocaleRestAdmin {




    @Operation(summary = "Finds a list of all locales")
    @GetMapping("")
    public ResponseEntity<List<LocaleDto>> findAll() throws Exception {
        ResponseEntity<List<LocaleDto>> res = null;
        List<Locale> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<LocaleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all locales")
    @GetMapping("optimized")
    public ResponseEntity<List<LocaleDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<LocaleDto>> res = null;
        List<Locale> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<LocaleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a locale by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LocaleDto> findById(@PathVariable Long id) {
        Locale t = service.findById(id);
        if (t != null) {
            converter.init(true);
            LocaleDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a locale by code")
    @GetMapping("code/{code}")
    public ResponseEntity<LocaleDto> findByCode(@PathVariable String code) {
	    Locale t = service.findByReferenceEntity(new Locale(code));
        if (t != null) {
            converter.init(true);
            LocaleDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  locale")
    @PostMapping("")
    public ResponseEntity<LocaleDto> save(@RequestBody LocaleDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Locale myT = converter.toItem(dto);
            Locale t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                LocaleDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  locale")
    @PutMapping("")
    public ResponseEntity<LocaleDto> update(@RequestBody LocaleDto dto) throws Exception {
        ResponseEntity<LocaleDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Locale t = service.findById(dto.getId());
            converter.copy(dto,t);
            Locale updated = service.update(t);
            LocaleDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of locale")
    @PostMapping("multiple")
    public ResponseEntity<List<LocaleDto>> delete(@RequestBody List<LocaleDto> dtos) throws Exception {
        ResponseEntity<List<LocaleDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Locale> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified locale")
    @DeleteMapping("")
    public ResponseEntity<LocaleDto> delete(@RequestBody LocaleDto dto) throws Exception {
		ResponseEntity<LocaleDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Locale t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified locale")
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
    @Operation(summary = "Delete multiple locales by ids")
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


    @Operation(summary = "find by rue id")
    @GetMapping("rue/id/{id}")
    public List<LocaleDto> findByRueId(@PathVariable Long id){
        return findDtos(service.findByRueId(id));
    }
    @Operation(summary = "delete by rue id")
    @DeleteMapping("rue/id/{id}")
    public int deleteByRueId(@PathVariable Long id){
        return service.deleteByRueId(id);
    }
    @Operation(summary = "find by categorieLocale id")
    @GetMapping("categorieLocale/id/{id}")
    public List<LocaleDto> findByCategorieLocaleId(@PathVariable Long id){
        return findDtos(service.findByCategorieLocaleId(id));
    }
    @Operation(summary = "delete by categorieLocale id")
    @DeleteMapping("categorieLocale/id/{id}")
    public int deleteByCategorieLocaleId(@PathVariable Long id){
        return service.deleteByCategorieLocaleId(id);
    }

    @Operation(summary = "Finds a locale and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<LocaleDto> findWithAssociatedLists(@PathVariable Long id) {
        Locale loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        LocaleDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds locales by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LocaleDto>> findByCriteria(@RequestBody LocaleCriteria criteria) throws Exception {
        ResponseEntity<List<LocaleDto>> res = null;
        List<Locale> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<LocaleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated locales by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LocaleCriteria criteria) throws Exception {
        List<Locale> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<LocaleDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets locale data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LocaleCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<LocaleDto> findDtos(List<Locale> list){
        converter.initObject(true);
        List<LocaleDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<LocaleDto> getDtoResponseEntity(LocaleDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private LocaleAdminService service;
    @Autowired private LocaleConverter converter;





}
