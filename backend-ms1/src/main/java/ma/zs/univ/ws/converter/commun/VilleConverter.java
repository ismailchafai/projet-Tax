package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Ville;
import ma.zs.univ.ws.dto.commun.VilleDto;

@Component
public class VilleConverter {


    public  VilleConverter() {
    }


    public Ville toItem(VilleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Ville item = new Ville();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public VilleDto toDto(Ville item) {
        if (item == null) {
            return null;
        } else {
            VilleDto dto = new VilleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<Ville> toItem(List<VilleDto> dtos) {
        List<Ville> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (VilleDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<VilleDto> toDto(List<Ville> items) {
        List<VilleDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Ville item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(VilleDto dto, Ville t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<Ville> copy(List<VilleDto> dtos) {
        List<Ville> result = new ArrayList<>();
        if (dtos != null) {
            for (VilleDto dto : dtos) {
                Ville instance = new Ville();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
