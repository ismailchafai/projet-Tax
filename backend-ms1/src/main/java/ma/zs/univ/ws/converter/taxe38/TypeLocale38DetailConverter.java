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
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.ws.dto.taxe38.TypeLocale38DetailDto;

@Component
public class TypeLocale38DetailConverter {


    public  TypeLocale38DetailConverter() {
    }


    public TypeLocale38Detail toItem(TypeLocale38DetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeLocale38Detail item = new TypeLocale38Detail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public TypeLocale38DetailDto toDto(TypeLocale38Detail item) {
        if (item == null) {
            return null;
        } else {
            TypeLocale38DetailDto dto = new TypeLocale38DetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<TypeLocale38Detail> toItem(List<TypeLocale38DetailDto> dtos) {
        List<TypeLocale38Detail> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (TypeLocale38DetailDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<TypeLocale38DetailDto> toDto(List<TypeLocale38Detail> items) {
        List<TypeLocale38DetailDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (TypeLocale38Detail item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(TypeLocale38DetailDto dto, TypeLocale38Detail t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<TypeLocale38Detail> copy(List<TypeLocale38DetailDto> dtos) {
        List<TypeLocale38Detail> result = new ArrayList<>();
        if (dtos != null) {
            for (TypeLocale38DetailDto dto : dtos) {
                TypeLocale38Detail instance = new TypeLocale38Detail();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
