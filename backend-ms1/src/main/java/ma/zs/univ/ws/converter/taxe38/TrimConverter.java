package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.ws.dto.taxe38.TrimDto;

@Component
public class TrimConverter {


    public  TrimConverter() {
    }


    public Trim toItem(TrimDto dto) {
        if (dto == null) {
            return null;
        } else {
        Trim item = new Trim();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getNumero()))
                item.setNumero(dto.getNumero());



        return item;
        }
    }


    public TrimDto toDto(Trim item) {
        if (item == null) {
            return null;
        } else {
            TrimDto dto = new TrimDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getNumero()))
                dto.setNumero(item.getNumero());


        return dto;
        }
    }


	
    public List<Trim> toItem(List<TrimDto> dtos) {
        List<Trim> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (TrimDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<TrimDto> toDto(List<Trim> items) {
        List<TrimDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Trim item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(TrimDto dto, Trim t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<Trim> copy(List<TrimDto> dtos) {
        List<Trim> result = new ArrayList<>();
        if (dtos != null) {
            for (TrimDto dto : dtos) {
                Trim instance = new Trim();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
