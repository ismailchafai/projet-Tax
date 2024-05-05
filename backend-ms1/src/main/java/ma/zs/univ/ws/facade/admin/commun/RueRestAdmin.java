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

import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.dao.criteria.core.commun.RueCriteria;
import ma.zs.univ.service.facade.admin.commun.RueAdminService;
import ma.zs.univ.ws.converter.commun.RueConverter;
import ma.zs.univ.ws.dto.commun.RueDto;
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
@RequestMapping("/api/admin/rue/")
public class RueRestAdmin {




    @Operation(summary = "Finds a list of all rues")
    @GetMapping("")
    public ResponseEntity<List<RueDto>> findAll() throws Exception {
        ResponseEntity<List<RueDto>> res = null;
        List<Rue> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<RueDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all rues")
    @GetMapping("optimized")
    public ResponseEntity<List<RueDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<RueDto>> res = null;
        List<Rue> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<RueDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a rue by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RueDto> findById(@PathVariable Long id) {
        Rue t = service.findById(id);
        if (t != null) {
            converter.init(true);
            RueDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a rue by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<RueDto> findByLibelle(@PathVariable String libelle) {
	    Rue t = service.findByReferenceEntity(new Rue(libelle));
        if (t != null) {
            converter.init(true);
            RueDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  rue")
    @PostMapping("")
    public ResponseEntity<RueDto> save(@RequestBody RueDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Rue myT = converter.toItem(dto);
            Rue t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                RueDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  rue")
    @PutMapping("")
    public ResponseEntity<RueDto> update(@RequestBody RueDto dto) throws Exception {
        ResponseEntity<RueDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Rue t = service.findById(dto.getId());
            converter.copy(dto,t);
            Rue updated = service.update(t);
            RueDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of rue")
    @PostMapping("multiple")
    public ResponseEntity<List<RueDto>> delete(@RequestBody List<RueDto> dtos) throws Exception {
        ResponseEntity<List<RueDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Rue> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified rue")
    @DeleteMapping("")
    public ResponseEntity<RueDto> delete(@RequestBody RueDto dto) throws Exception {
		ResponseEntity<RueDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Rue t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified rue")
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
    @Operation(summary = "Delete multiple rues by ids")
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



    @Operation(summary = "Finds a rue and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<RueDto> findWithAssociatedLists(@PathVariable Long id) {
        Rue loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        RueDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds rues by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RueDto>> findByCriteria(@RequestBody RueCriteria criteria) throws Exception {
        ResponseEntity<List<RueDto>> res = null;
        List<Rue> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<RueDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated rues by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RueCriteria criteria) throws Exception {
        List<Rue> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<RueDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets rue data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RueCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<RueDto> findDtos(List<Rue> list){
        converter.initObject(true);
        List<RueDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<RueDto> getDtoResponseEntity(RueDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private RueAdminService service;
    @Autowired private RueConverter converter;





}
