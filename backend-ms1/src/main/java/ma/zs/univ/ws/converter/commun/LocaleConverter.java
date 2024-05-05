package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.commun.RueConverter;
import ma.zs.univ.ws.converter.commun.RedevableConverter;
import ma.zs.univ.ws.converter.taxe38.CategorieLocaleConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.ws.dto.commun.LocaleDto;

@Component
public class LocaleConverter {

    @Autowired
    private RueConverter rueConverter ;
    @Autowired
    private RedevableConverter redevableConverter ;
    @Autowired
    private CategorieLocaleConverter categorieLocaleConverter ;
    private boolean rue;
    private boolean redevable;
    private boolean categorieLocale;

    public  LocaleConverter() {
        initObject(true);
    }


    public Locale toItem(LocaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Locale item = new Locale();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getComplementAdresse()))
                item.setComplementAdresse(dto.getComplementAdresse());
            if(this.rue && dto.getRue()!=null)
                item.setRue(rueConverter.toItem(dto.getRue())) ;

            if(this.redevable && dto.getRedevable()!=null)
                item.setRedevable(redevableConverter.toItem(dto.getRedevable())) ;

            if(this.categorieLocale && dto.getCategorieLocale()!=null)
                item.setCategorieLocale(categorieLocaleConverter.toItem(dto.getCategorieLocale())) ;




        return item;
        }
    }


    public LocaleDto toDto(Locale item) {
        if (item == null) {
            return null;
        } else {
            LocaleDto dto = new LocaleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getComplementAdresse()))
                dto.setComplementAdresse(item.getComplementAdresse());
            if(this.rue && item.getRue()!=null) {
                dto.setRue(rueConverter.toDto(item.getRue())) ;

            }
            if(this.redevable && item.getRedevable()!=null) {
                dto.setRedevable(redevableConverter.toDto(item.getRedevable())) ;

            }
            if(this.categorieLocale && item.getCategorieLocale()!=null) {
                dto.setCategorieLocale(categorieLocaleConverter.toDto(item.getCategorieLocale())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.rue = value;
        this.redevable = value;
        this.categorieLocale = value;
    }
	
    public List<Locale> toItem(List<LocaleDto> dtos) {
        List<Locale> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (LocaleDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<LocaleDto> toDto(List<Locale> items) {
        List<LocaleDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Locale item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(LocaleDto dto, Locale t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getRue() != null)
        rueConverter.copy(dto.getRue(), t.getRue());
        if (dto.getRedevable() != null)
        redevableConverter.copy(dto.getRedevable(), t.getRedevable());
        if (dto.getCategorieLocale() != null)
        categorieLocaleConverter.copy(dto.getCategorieLocale(), t.getCategorieLocale());
    }

    public List<Locale> copy(List<LocaleDto> dtos) {
        List<Locale> result = new ArrayList<>();
        if (dtos != null) {
            for (LocaleDto dto : dtos) {
                Locale instance = new Locale();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public RueConverter getRueConverter(){
        return this.rueConverter;
    }
    public void setRueConverter(RueConverter rueConverter ){
        this.rueConverter = rueConverter;
    }
    public RedevableConverter getRedevableConverter(){
        return this.redevableConverter;
    }
    public void setRedevableConverter(RedevableConverter redevableConverter ){
        this.redevableConverter = redevableConverter;
    }
    public CategorieLocaleConverter getCategorieLocaleConverter(){
        return this.categorieLocaleConverter;
    }
    public void setCategorieLocaleConverter(CategorieLocaleConverter categorieLocaleConverter ){
        this.categorieLocaleConverter = categorieLocaleConverter;
    }
    public boolean  isRue(){
        return this.rue;
    }
    public void  setRue(boolean rue){
        this.rue = rue;
    }
    public boolean  isRedevable(){
        return this.redevable;
    }
    public void  setRedevable(boolean redevable){
        this.redevable = redevable;
    }
    public boolean  isCategorieLocale(){
        return this.categorieLocale;
    }
    public void  setCategorieLocale(boolean categorieLocale){
        this.categorieLocale = categorieLocale;
    }
}
