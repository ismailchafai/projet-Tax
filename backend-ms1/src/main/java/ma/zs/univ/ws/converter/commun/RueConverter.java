package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.commun.QuartierConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.ws.dto.commun.RueDto;

@Component
public class RueConverter {

    @Autowired
    private QuartierConverter quartierConverter ;
    private boolean quartier;

    public  RueConverter() {
        initObject(true);
    }


    public Rue toItem(RueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Rue item = new Rue();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.quartier && dto.getQuartier()!=null)
                item.setQuartier(quartierConverter.toItem(dto.getQuartier())) ;




        return item;
        }
    }


    public RueDto toDto(Rue item) {
        if (item == null) {
            return null;
        } else {
            RueDto dto = new RueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.quartier && item.getQuartier()!=null) {
                dto.setQuartier(quartierConverter.toDto(item.getQuartier())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.quartier = value;
    }
	
    public List<Rue> toItem(List<RueDto> dtos) {
        List<Rue> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (RueDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<RueDto> toDto(List<Rue> items) {
        List<RueDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Rue item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(RueDto dto, Rue t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getQuartier() != null)
        quartierConverter.copy(dto.getQuartier(), t.getQuartier());
    }

    public List<Rue> copy(List<RueDto> dtos) {
        List<Rue> result = new ArrayList<>();
        if (dtos != null) {
            for (RueDto dto : dtos) {
                Rue instance = new Rue();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public QuartierConverter getQuartierConverter(){
        return this.quartierConverter;
    }
    public void setQuartierConverter(QuartierConverter quartierConverter ){
        this.quartierConverter = quartierConverter;
    }
    public boolean  isQuartier(){
        return this.quartier;
    }
    public void  setQuartier(boolean quartier){
        this.quartier = quartier;
    }
}
