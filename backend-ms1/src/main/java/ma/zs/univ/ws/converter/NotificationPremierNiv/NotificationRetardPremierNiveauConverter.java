package  ma.zs.univ.ws.converter.NotificationPremierNiv;

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
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.ws.dto.NotificationPremierNiv.NotificationRetardPremierNiveauDto;

@Component
public class NotificationRetardPremierNiveauConverter {

    @Autowired
    private LocaleConverter localeConverter ;
    @Autowired
    private RedevableConverter redevableConverter ;
    private boolean locale;
    private boolean redevable;

    public  NotificationRetardPremierNiveauConverter() {
        initObject(true);
    }


    public NotificationRetardPremierNiveau toItem(NotificationRetardPremierNiveauDto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationRetardPremierNiveau item = new NotificationRetardPremierNiveau();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAnne()))
                item.setAnne(dto.getAnne());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(this.locale && dto.getLocale()!=null)
                item.setLocale(localeConverter.toItem(dto.getLocale())) ;

            if(this.redevable && dto.getRedevable()!=null)
                item.setRedevable(redevableConverter.toItem(dto.getRedevable())) ;




        return item;
        }
    }


    public NotificationRetardPremierNiveauDto toDto(NotificationRetardPremierNiveau item) {
        if (item == null) {
            return null;
        } else {
            NotificationRetardPremierNiveauDto dto = new NotificationRetardPremierNiveauDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAnne()))
                dto.setAnne(item.getAnne());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
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
	
    public List<NotificationRetardPremierNiveau> toItem(List<NotificationRetardPremierNiveauDto> dtos) {
        List<NotificationRetardPremierNiveau> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (NotificationRetardPremierNiveauDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<NotificationRetardPremierNiveauDto> toDto(List<NotificationRetardPremierNiveau> items) {
        List<NotificationRetardPremierNiveauDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (NotificationRetardPremierNiveau item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(NotificationRetardPremierNiveauDto dto, NotificationRetardPremierNiveau t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getLocale() != null)
        localeConverter.copy(dto.getLocale(), t.getLocale());
        if (dto.getRedevable() != null)
        redevableConverter.copy(dto.getRedevable(), t.getRedevable());
    }

    public List<NotificationRetardPremierNiveau> copy(List<NotificationRetardPremierNiveauDto> dtos) {
        List<NotificationRetardPremierNiveau> result = new ArrayList<>();
        if (dtos != null) {
            for (NotificationRetardPremierNiveauDto dto : dtos) {
                NotificationRetardPremierNiveau instance = new NotificationRetardPremierNiveau();
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
