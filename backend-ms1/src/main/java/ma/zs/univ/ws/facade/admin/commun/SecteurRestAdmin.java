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

import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.service.facade.admin.commun.SecteurAdminService;
import ma.zs.univ.ws.converter.commun.SecteurConverter;
import ma.zs.univ.ws.dto.commun.SecteurDto;
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
@RequestMapping("/api/admin/secteur/")
public class SecteurRestAdmin {




    @Operation(summary = "Finds a list of all secteurs")
    @GetMapping("")
    public ResponseEntity<List<SecteurDto>> findAll() throws Exception {
        ResponseEntity<List<SecteurDto>> res = null;
        List<Secteur> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<SecteurDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all secteurs")
    @GetMapping("optimized")
    public ResponseEntity<List<SecteurDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<SecteurDto>> res = null;
        List<Secteur> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<SecteurDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a secteur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SecteurDto> findById(@PathVariable Long id) {
        Secteur t = service.findById(id);
        if (t != null) {
            converter.init(true);
            SecteurDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a secteur by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<SecteurDto> findByLibelle(@PathVariable String libelle) {
	    Secteur t = service.findByReferenceEntity(new Secteur(libelle));
        if (t != null) {
            converter.init(true);
            SecteurDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  secteur")
    @PostMapping("")
    public ResponseEntity<SecteurDto> save(@RequestBody SecteurDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Secteur myT = converter.toItem(dto);
            Secteur t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                SecteurDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  secteur")
    @PutMapping("")
    public ResponseEntity<SecteurDto> update(@RequestBody SecteurDto dto) throws Exception {
        ResponseEntity<SecteurDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Secteur t = service.findById(dto.getId());
            converter.copy(dto,t);
            Secteur updated = service.update(t);
            SecteurDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of secteur")
    @PostMapping("multiple")
    public ResponseEntity<List<SecteurDto>> delete(@RequestBody List<SecteurDto> dtos) throws Exception {
        ResponseEntity<List<SecteurDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Secteur> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified secteur")
    @DeleteMapping("")
    public ResponseEntity<SecteurDto> delete(@RequestBody SecteurDto dto) throws Exception {
		ResponseEntity<SecteurDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Secteur t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified secteur")
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
    @Operation(summary = "Delete multiple secteurs by ids")
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


    @Operation(summary = "find by ville id")
    @GetMapping("ville/id/{id}")
    public List<SecteurDto> findByVilleId(@PathVariable Long id){
        return findDtos(service.findByVilleId(id));
    }
    @Operation(summary = "delete by ville id")
    @DeleteMapping("ville/id/{id}")
    public int deleteByVilleId(@PathVariable Long id){
        return service.deleteByVilleId(id);
    }

    @Operation(summary = "Finds a secteur and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SecteurDto> findWithAssociatedLists(@PathVariable Long id) {
        Secteur loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        SecteurDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds secteurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SecteurDto>> findByCriteria(@RequestBody SecteurCriteria criteria) throws Exception {
        ResponseEntity<List<SecteurDto>> res = null;
        List<Secteur> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<SecteurDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated secteurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SecteurCriteria criteria) throws Exception {
        List<Secteur> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<SecteurDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets secteur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SecteurCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<SecteurDto> findDtos(List<Secteur> list){
        converter.initObject(true);
        List<SecteurDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<SecteurDto> getDtoResponseEntity(SecteurDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private SecteurAdminService service;
    @Autowired private SecteurConverter converter;





}
