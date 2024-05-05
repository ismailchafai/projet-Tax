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

import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.dao.criteria.core.taxe38.TrimCriteria;
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService;
import ma.zs.univ.ws.converter.taxe38.TrimConverter;
import ma.zs.univ.ws.dto.taxe38.TrimDto;
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
@RequestMapping("/api/admin/trim/")
public class TrimRestAdmin {




    @Operation(summary = "Finds a list of all trims")
    @GetMapping("")
    public ResponseEntity<List<TrimDto>> findAll() throws Exception {
        ResponseEntity<List<TrimDto>> res = null;
        List<Trim> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TrimDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }


    @Operation(summary = "Finds a trim by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TrimDto> findById(@PathVariable Long id) {
        Trim t = service.findById(id);
        if (t != null) {
            TrimDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Saves the specified  trim")
    @PostMapping("")
    public ResponseEntity<TrimDto> save(@RequestBody TrimDto dto) throws Exception {
        if(dto!=null){
            Trim myT = converter.toItem(dto);
            Trim t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                TrimDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  trim")
    @PutMapping("")
    public ResponseEntity<TrimDto> update(@RequestBody TrimDto dto) throws Exception {
        ResponseEntity<TrimDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            Trim t = service.findById(dto.getId());
            converter.copy(dto,t);
            Trim updated = service.update(t);
            TrimDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of trim")
    @PostMapping("multiple")
    public ResponseEntity<List<TrimDto>> delete(@RequestBody List<TrimDto> dtos) throws Exception {
        ResponseEntity<List<TrimDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<Trim> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified trim")
    @DeleteMapping("")
    public ResponseEntity<TrimDto> delete(@RequestBody TrimDto dto) throws Exception {
		ResponseEntity<TrimDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            Trim t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified trim")
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
    @Operation(summary = "Delete multiple trims by ids")
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



    @Operation(summary = "Finds a trim and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TrimDto> findWithAssociatedLists(@PathVariable Long id) {
        Trim loaded =  service.findWithAssociatedLists(id);
        TrimDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds trims by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TrimDto>> findByCriteria(@RequestBody TrimCriteria criteria) throws Exception {
        ResponseEntity<List<TrimDto>> res = null;
        List<Trim> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TrimDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated trims by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TrimCriteria criteria) throws Exception {
        List<Trim> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<TrimDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets trim data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TrimCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<TrimDto> findDtos(List<Trim> list){
        List<TrimDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<TrimDto> getDtoResponseEntity(TrimDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private TrimAdminService service;
    @Autowired private TrimConverter converter;





}
