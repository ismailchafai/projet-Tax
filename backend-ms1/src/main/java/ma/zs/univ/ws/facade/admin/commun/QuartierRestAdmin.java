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

import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.service.facade.admin.commun.QuartierAdminService;
import ma.zs.univ.ws.converter.commun.QuartierConverter;
import ma.zs.univ.ws.dto.commun.QuartierDto;
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
@RequestMapping("/api/admin/quartier/")
public class QuartierRestAdmin {




    @Operation(summary = "Finds a list of all quartiers")
    @GetMapping("")
    public ResponseEntity<List<QuartierDto>> findAll() throws Exception {
        ResponseEntity<List<QuartierDto>> res = null;
        List<Quartier> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<QuartierDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all quartiers")
    @GetMapping("optimized")
    public ResponseEntity<List<QuartierDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<QuartierDto>> res = null;
        List<Quartier> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<QuartierDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a quartier by id")
    @GetMapping("id/{id}")
    public ResponseEntity<QuartierDto> findById(@PathVariable Long id) {
        Quartier t = service.findById(id);
        if (t != null) {
            converter.init(true);
            QuartierDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a quartier by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<QuartierDto> findByLibelle(@PathVariable String libelle) {
	    Quartier t = service.findByReferenceEntity(new Quartier(libelle));
        if (t != null) {
            converter.init(true);
            QuartierDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  quartier")
    @PostMapping("")
    public ResponseEntity<QuartierDto> save(@RequestBody QuartierDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Quartier myT = converter.toItem(dto);
            Quartier t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                QuartierDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  quartier")
    @PutMapping("")
    public ResponseEntity<QuartierDto> update(@RequestBody QuartierDto dto) throws Exception {
        ResponseEntity<QuartierDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Quartier t = service.findById(dto.getId());
            converter.copy(dto,t);
            Quartier updated = service.update(t);
            QuartierDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of quartier")
    @PostMapping("multiple")
    public ResponseEntity<List<QuartierDto>> delete(@RequestBody List<QuartierDto> dtos) throws Exception {
        ResponseEntity<List<QuartierDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<Quartier> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified quartier")
    @DeleteMapping("")
    public ResponseEntity<QuartierDto> delete(@RequestBody QuartierDto dto) throws Exception {
		ResponseEntity<QuartierDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            Quartier t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified quartier")
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
    @Operation(summary = "Delete multiple quartiers by ids")
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


    @Operation(summary = "find by secteur id")
    @GetMapping("secteur/id/{id}")
    public List<QuartierDto> findBySecteurId(@PathVariable Long id){
        return findDtos(service.findBySecteurId(id));
    }
    @Operation(summary = "delete by secteur id")
    @DeleteMapping("secteur/id/{id}")
    public int deleteBySecteurId(@PathVariable Long id){
        return service.deleteBySecteurId(id);
    }

    @Operation(summary = "Finds a quartier and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<QuartierDto> findWithAssociatedLists(@PathVariable Long id) {
        Quartier loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        QuartierDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds quartiers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<QuartierDto>> findByCriteria(@RequestBody QuartierCriteria criteria) throws Exception {
        ResponseEntity<List<QuartierDto>> res = null;
        List<Quartier> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<QuartierDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated quartiers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody QuartierCriteria criteria) throws Exception {
        List<Quartier> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<QuartierDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets quartier data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody QuartierCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<QuartierDto> findDtos(List<Quartier> list){
        converter.initObject(true);
        List<QuartierDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<QuartierDto> getDtoResponseEntity(QuartierDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private QuartierAdminService service;
    @Autowired private QuartierConverter converter;





}
