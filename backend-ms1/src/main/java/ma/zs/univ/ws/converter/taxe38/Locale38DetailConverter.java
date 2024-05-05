package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.taxe38.TypeLocale38DetailConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.ws.dto.taxe38.Locale38DetailDto;

@Component
public class Locale38DetailConverter {

    @Autowired
    private TypeLocale38DetailConverter typeLocale38DetailConverter ;
    private boolean typeLocale38Detail;

    public  Locale38DetailConverter() {
        initObject(true);
    }


    public Locale38Detail toItem(Locale38DetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        Locale38Detail item = new Locale38Detail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getSuperficie()))
                item.setSuperficie(dto.getSuperficie());
            if(dto.getActive() != null)
                item.setActive(dto.getActive());
            if(this.typeLocale38Detail && dto.getTypeLocale38Detail()!=null)
                item.setTypeLocale38Detail(typeLocale38DetailConverter.toItem(dto.getTypeLocale38Detail())) ;




        return item;
        }
    }


    public Locale38DetailDto toDto(Locale38Detail item) {
        if (item == null) {
            return null;
        } else {
            Locale38DetailDto dto = new Locale38DetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getSuperficie()))
                dto.setSuperficie(item.getSuperficie());
                dto.setActive(item.getActive());
            if(this.typeLocale38Detail && item.getTypeLocale38Detail()!=null) {
                dto.setTypeLocale38Detail(typeLocale38DetailConverter.toDto(item.getTypeLocale38Detail())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.typeLocale38Detail = value;
    }
	
    public List<Locale38Detail> toItem(List<Locale38DetailDto> dtos) {
        List<Locale38Detail> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (Locale38DetailDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<Locale38DetailDto> toDto(List<Locale38Detail> items) {
        List<Locale38DetailDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Locale38Detail item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(Locale38DetailDto dto, Locale38Detail t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getTypeLocale38Detail() != null)
        typeLocale38DetailConverter.copy(dto.getTypeLocale38Detail(), t.getTypeLocale38Detail());
    }

    public List<Locale38Detail> copy(List<Locale38DetailDto> dtos) {
        List<Locale38Detail> result = new ArrayList<>();
        if (dtos != null) {
            for (Locale38DetailDto dto : dtos) {
                Locale38Detail instance = new Locale38Detail();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public TypeLocale38DetailConverter getTypeLocale38DetailConverter(){
        return this.typeLocale38DetailConverter;
    }
    public void setTypeLocale38DetailConverter(TypeLocale38DetailConverter typeLocale38DetailConverter ){
        this.typeLocale38DetailConverter = typeLocale38DetailConverter;
    }
    public boolean  isTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }
    public void  setTypeLocale38Detail(boolean typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }
}
