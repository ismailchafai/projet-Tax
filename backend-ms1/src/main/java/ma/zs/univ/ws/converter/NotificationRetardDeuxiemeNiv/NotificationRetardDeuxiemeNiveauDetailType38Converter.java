package  ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv;

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
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Dto;

@Component
public class NotificationRetardDeuxiemeNiveauDetailType38Converter {

    @Autowired
    private TypeLocale38DetailConverter typeLocale38DetailConverter ;
    private boolean typeLocale38;

    public  NotificationRetardDeuxiemeNiveauDetailType38Converter() {
        initObject(true);
    }


    public NotificationRetardDeuxiemeNiveauDetailType38 toItem(NotificationRetardDeuxiemeNiveauDetailType38Dto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationRetardDeuxiemeNiveauDetailType38 item = new NotificationRetardDeuxiemeNiveauDetailType38();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(StringUtil.isNotEmpty(dto.getMontantRetardPremierMois()))
                item.setMontantRetardPremierMois(dto.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(dto.getMontantRetardAutreMois()))
                item.setMontantRetardAutreMois(dto.getMontantRetardAutreMois());
            if(StringUtil.isNotEmpty(dto.getMontantTotal()))
                item.setMontantTotal(dto.getMontantTotal());
            if(this.typeLocale38 && dto.getTypeLocale38()!=null)
                item.setTypeLocale38(typeLocale38DetailConverter.toItem(dto.getTypeLocale38())) ;




        return item;
        }
    }


    public NotificationRetardDeuxiemeNiveauDetailType38Dto toDto(NotificationRetardDeuxiemeNiveauDetailType38 item) {
        if (item == null) {
            return null;
        } else {
            NotificationRetardDeuxiemeNiveauDetailType38Dto dto = new NotificationRetardDeuxiemeNiveauDetailType38Dto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
            if(StringUtil.isNotEmpty(item.getMontantRetardPremierMois()))
                dto.setMontantRetardPremierMois(item.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(item.getMontantRetardAutreMois()))
                dto.setMontantRetardAutreMois(item.getMontantRetardAutreMois());
            if(StringUtil.isNotEmpty(item.getMontantTotal()))
                dto.setMontantTotal(item.getMontantTotal());
            if(this.typeLocale38 && item.getTypeLocale38()!=null) {
                dto.setTypeLocale38(typeLocale38DetailConverter.toDto(item.getTypeLocale38())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.typeLocale38 = value;
    }
	
    public List<NotificationRetardDeuxiemeNiveauDetailType38> toItem(List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos) {
        List<NotificationRetardDeuxiemeNiveauDetailType38> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (NotificationRetardDeuxiemeNiveauDetailType38Dto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<NotificationRetardDeuxiemeNiveauDetailType38Dto> toDto(List<NotificationRetardDeuxiemeNiveauDetailType38> items) {
        List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (NotificationRetardDeuxiemeNiveauDetailType38 item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(NotificationRetardDeuxiemeNiveauDetailType38Dto dto, NotificationRetardDeuxiemeNiveauDetailType38 t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getTypeLocale38() != null)
        typeLocale38DetailConverter.copy(dto.getTypeLocale38(), t.getTypeLocale38());
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> copy(List<NotificationRetardDeuxiemeNiveauDetailType38Dto> dtos) {
        List<NotificationRetardDeuxiemeNiveauDetailType38> result = new ArrayList<>();
        if (dtos != null) {
            for (NotificationRetardDeuxiemeNiveauDetailType38Dto dto : dtos) {
                NotificationRetardDeuxiemeNiveauDetailType38 instance = new NotificationRetardDeuxiemeNiveauDetailType38();
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
    public boolean  isTypeLocale38(){
        return this.typeLocale38;
    }
    public void  setTypeLocale38(boolean typeLocale38){
        this.typeLocale38 = typeLocale38;
    }
}
