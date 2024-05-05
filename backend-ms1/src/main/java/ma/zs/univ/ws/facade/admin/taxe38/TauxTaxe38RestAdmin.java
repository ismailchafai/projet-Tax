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

import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.service.facade.admin.taxe38.TauxTaxe38AdminService;
import ma.zs.univ.ws.converter.taxe38.TauxTaxe38Converter;
import ma.zs.univ.ws.dto.taxe38.TauxTaxe38Dto;
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
@RequestMapping("/api/admin/tauxTaxe38/")
public class TauxTaxe38RestAdmin {




    @Operation(summary = "Finds a list of all tauxTaxe38s")
    @GetMapping("")
    public ResponseEntity<List<TauxTaxe38Dto>> findAll() throws Exception {
        ResponseEntity<List<TauxTaxe38Dto>> res = null;
        List<TauxTaxe38> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<TauxTaxe38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all tauxTaxe38s")
    @GetMapping("optimized")
    public ResponseEntity<List<TauxTaxe38Dto>> findAllOptimized() throws Exception {
        ResponseEntity<List<TauxTaxe38Dto>> res = null;
        List<TauxTaxe38> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<TauxTaxe38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a tauxTaxe38 by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TauxTaxe38Dto> findById(@PathVariable Long id) {
        TauxTaxe38 t = service.findById(id);
        if (t != null) {
            converter.init(true);
            TauxTaxe38Dto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a tauxTaxe38 by code")
    @GetMapping("code/{code}")
    public ResponseEntity<TauxTaxe38Dto> findByCode(@PathVariable String code) {
	    TauxTaxe38 t = service.findByReferenceEntity(new TauxTaxe38(code));
        if (t != null) {
            converter.init(true);
            TauxTaxe38Dto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  tauxTaxe38")
    @PostMapping("")
    public ResponseEntity<TauxTaxe38Dto> save(@RequestBody TauxTaxe38Dto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            TauxTaxe38 myT = converter.toItem(dto);
            TauxTaxe38 t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                TauxTaxe38Dto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  tauxTaxe38")
    @PutMapping("")
    public ResponseEntity<TauxTaxe38Dto> update(@RequestBody TauxTaxe38Dto dto) throws Exception {
        ResponseEntity<TauxTaxe38Dto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            TauxTaxe38 t = service.findById(dto.getId());
            converter.copy(dto,t);
            TauxTaxe38 updated = service.update(t);
            TauxTaxe38Dto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of tauxTaxe38")
    @PostMapping("multiple")
    public ResponseEntity<List<TauxTaxe38Dto>> delete(@RequestBody List<TauxTaxe38Dto> dtos) throws Exception {
        ResponseEntity<List<TauxTaxe38Dto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<TauxTaxe38> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified tauxTaxe38")
    @DeleteMapping("")
    public ResponseEntity<TauxTaxe38Dto> delete(@RequestBody TauxTaxe38Dto dto) throws Exception {
		ResponseEntity<TauxTaxe38Dto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            TauxTaxe38 t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified tauxTaxe38")
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
    @Operation(summary = "Delete multiple tauxTaxe38s by ids")
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
    public List<TauxTaxe38Dto> findByTypeLocale38DetailId(@PathVariable Long id){
        return findDtos(service.findByTypeLocale38DetailId(id));
    }
    @Operation(summary = "delete by typeLocale38Detail id")
    @DeleteMapping("typeLocale38Detail/id/{id}")
    public int deleteByTypeLocale38DetailId(@PathVariable Long id){
        return service.deleteByTypeLocale38DetailId(id);
    }
    @Operation(summary = "find by categorieLocale id")
    @GetMapping("categorieLocale/id/{id}")
    public List<TauxTaxe38Dto> findByCategorieLocaleId(@PathVariable Long id){
        return findDtos(service.findByCategorieLocaleId(id));
    }
    @Operation(summary = "delete by categorieLocale id")
    @DeleteMapping("categorieLocale/id/{id}")
    public int deleteByCategorieLocaleId(@PathVariable Long id){
        return service.deleteByCategorieLocaleId(id);
    }

    @Operation(summary = "Finds a tauxTaxe38 and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TauxTaxe38Dto> findWithAssociatedLists(@PathVariable Long id) {
        TauxTaxe38 loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        TauxTaxe38Dto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds tauxTaxe38s by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TauxTaxe38Dto>> findByCriteria(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        ResponseEntity<List<TauxTaxe38Dto>> res = null;
        List<TauxTaxe38> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<TauxTaxe38Dto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated tauxTaxe38s by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        List<TauxTaxe38> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<TauxTaxe38Dto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets tauxTaxe38 data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TauxTaxe38Criteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<TauxTaxe38Dto> findDtos(List<TauxTaxe38> list){
        converter.initObject(true);
        List<TauxTaxe38Dto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<TauxTaxe38Dto> getDtoResponseEntity(TauxTaxe38Dto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private TauxTaxe38AdminService service;
    @Autowired private TauxTaxe38Converter converter;





}
