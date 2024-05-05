package  ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.commun.LocaleConverter;
import ma.zs.univ.ws.converter.commun.RedevableConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDto;

@Component
public class NotificationRetardDeuxiemeNiveauConverter {

    @Autowired
    private LocaleConverter localeConverter ;
    @Autowired
    private RedevableConverter redevableConverter ;
    private boolean locale;
    private boolean redevable;

    public  NotificationRetardDeuxiemeNiveauConverter() {
        initObject(true);
    }


    public NotificationRetardDeuxiemeNiveau toItem(NotificationRetardDeuxiemeNiveauDto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationRetardDeuxiemeNiveau item = new NotificationRetardDeuxiemeNiveau();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAnne()))
                item.setAnne(dto.getAnne());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(StringUtil.isNotEmpty(dto.getMontantRetardPremierMois()))
                item.setMontantRetardPremierMois(dto.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(dto.getMontantRetardAutreMois()))
                item.setMontantRetardAutreMois(dto.getMontantRetardAutreMois());
            if(StringUtil.isNotEmpty(dto.getMontantTotal()))
                item.setMontantTotal(dto.getMontantTotal());
            if(this.locale && dto.getLocale()!=null)
                item.setLocale(localeConverter.toItem(dto.getLocale())) ;

            if(this.redevable && dto.getRedevable()!=null)
                item.setRedevable(redevableConverter.toItem(dto.getRedevable())) ;




        return item;
        }
    }


    public NotificationRetardDeuxiemeNiveauDto toDto(NotificationRetardDeuxiemeNiveau item) {
        if (item == null) {
            return null;
        } else {
            NotificationRetardDeuxiemeNiveauDto dto = new NotificationRetardDeuxiemeNiveauDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAnne()))
                dto.setAnne(item.getAnne());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
            if(StringUtil.isNotEmpty(item.getMontantRetardPremierMois()))
                dto.setMontantRetardPremierMois(item.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(item.getMontantRetardAutreMois()))
                dto.setMontantRetardAutreMois(item.getMontantRetardAutreMois());
            if(StringUtil.isNotEmpty(item.getMontantTotal()))
                dto.setMontantTotal(item.getMontantTotal());
            if(this.locale && item.getLocale()!=null) {
                dto.setLocale(localeConverter.toDto(item.getLocale())) ;

            }
            if(this.redevable && item.getRedevable()!=null) {
                dto.setRedevable(redevableConverter.toDto(item.getRedevable())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.locale = value;
        this.redevable = value;
    }
	
    public List<NotificationRetardDeuxiemeNiveau> toItem(List<NotificationRetardDeuxiemeNiveauDto> dtos) {
        List<NotificationRetardDeuxiemeNiveau> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (NotificationRetardDeuxiemeNiveauDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<NotificationRetardDeuxiemeNiveauDto> toDto(List<NotificationRetardDeuxiemeNiveau> items) {
        List<NotificationRetardDeuxiemeNiveauDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (NotificationRetardDeuxiemeNiveau item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(NotificationRetardDeuxiemeNiveauDto dto, NotificationRetardDeuxiemeNiveau t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getLocale() != null)
        localeConverter.copy(dto.getLocale(), t.getLocale());
        if (dto.getRedevable() != null)
        redevableConverter.copy(dto.getRedevable(), t.getRedevable());
    }

    public List<NotificationRetardDeuxiemeNiveau> copy(List<NotificationRetardDeuxiemeNiveauDto> dtos) {
        List<NotificationRetardDeuxiemeNiveau> result = new ArrayList<>();
        if (dtos != null) {
            for (NotificationRetardDeuxiemeNiveauDto dto : dtos) {
                NotificationRetardDeuxiemeNiveau instance = new NotificationRetardDeuxiemeNiveau();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public LocaleConverter getLocaleConverter(){
        return this.localeConverter;
    }
    public void setLocaleConverter(LocaleConverter localeConverter ){
        this.localeConverter = localeConverter;
    }
    public RedevableConverter getRedevableConverter(){
        return this.redevableConverter;
    }
    public void setRedevableConverter(RedevableConverter redevableConverter ){
        this.redevableConverter = redevableConverter;
    }
    public boolean  isLocale(){
        return this.locale;
    }
    public void  setLocale(boolean locale){
        this.locale = locale;
    }
    public boolean  isRedevable(){
        return this.redevable;
    }
    public void  setRedevable(boolean redevable){
        this.redevable = redevable;
    }
}
