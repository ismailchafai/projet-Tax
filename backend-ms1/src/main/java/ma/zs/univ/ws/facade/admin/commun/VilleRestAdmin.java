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

import ma.zs.univ.bean.core.commun.Ville;
import ma.zs.univ.dao.criteria.core.commun.VilleCriteria;
import ma.zs.univ.service.facade.admin.commun.VilleAdminService;
import ma.zs.univ.ws.converter.commun.VilleConverter;
import ma.zs.univ.ws.dto.commun.VilleDto;
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
@RequestMapping("/api/admin/ville/")
public class VilleRestAdmin {




    @Operation(summary = "Finds a list of all villes")
    @GetMapping("")
    public ResponseEntity<List<VilleDto>> findAll() throws Exception {
        ResponseEntity<List<VilleDto>> res = null;
        List<Ville> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<VilleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all villes")
    @GetMapping("optimized")
    public ResponseEntity<List<VilleDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<VilleDto>> res = null;
        List<Ville> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<VilleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a ville by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VilleDto> findById(@PathVariable Long id) {
        Ville t = service.findById(id);
        if (t != null) {
            VilleDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a ville by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<VilleDto> findByLibelle(@PathVariable String libelle) {
	    Ville t = service.findByReferenceEntity(new Ville(libelle));
        if (t != null) {
            VilleDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  ville")
    @PostMapping("")
    public ResponseEntity<VilleDto> save(@RequestBody VilleDto dto) throws Exception {
        if(dto!=null){
            Ville myT = converter.toItem(dto);
            Ville t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                VilleDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  ville")
    @PutMapping("")
    public ResponseEntity<VilleDto> update(@RequestBody VilleDto dto) throws Exception {
        ResponseEntity<VilleDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Ville t = service.findById(dto.getId());
            converter.copy(dto,t);
            Ville updated = service.update(t);
            VilleDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of ville")
    @PostMapping("multiple")
    public ResponseEntity<List<VilleDto>> delete(@RequestBody List<VilleDto> dtos) throws Exception {
        ResponseEntity<List<VilleDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<Ville> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified ville")
    @DeleteMapping("")
    public ResponseEntity<VilleDto> delete(@RequestBody VilleDto dto) throws Exception {
		ResponseEntity<VilleDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            Ville t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified ville")
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
    @Operation(summary = "Delete multiple villes by ids")
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



    @Operation(summary = "Finds a ville and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<VilleDto> findWithAssociatedLists(@PathVariable Long id) {
        Ville loaded =  service.findWithAssociatedLists(id);
        VilleDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds villes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VilleDto>> findByCriteria(@RequestBody VilleCriteria criteria) throws Exception {
        ResponseEntity<List<VilleDto>> res = null;
        List<Ville> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<VilleDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated villes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VilleCriteria criteria) throws Exception {
        List<Ville> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<VilleDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets ville data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VilleCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<VilleDto> findDtos(List<Ville> list){
        List<VilleDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<VilleDto> getDtoResponseEntity(VilleDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private VilleAdminService service;
    @Autowired private VilleConverter converter;





}
