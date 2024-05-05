package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.taxe38.Taxe38Converter;
import ma.zs.univ.ws.converter.taxe38.Locale38DetailConverter;
import ma.zs.univ.ws.converter.taxe38.TauxTaxe38Converter;

import ma.zs.univ.bean.core.taxe38.Taxe38;


import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.ws.dto.taxe38.Taxe38DetailDto;

@Component
public class Taxe38DetailConverter {

    @Autowired
    private Taxe38Converter taxe38Converter ;
    @Autowired
    private Locale38DetailConverter locale38DetailConverter ;
    @Autowired
    private TauxTaxe38Converter tauxTaxe38Converter ;
    private boolean locale38Detail;
    private boolean tauxTaxe38;
    private boolean taxe38;

    public  Taxe38DetailConverter() {
        initObject(true);
    }


    public Taxe38Detail toItem(Taxe38DetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        Taxe38Detail item = new Taxe38Detail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getMontantParMetreCarre()))
                item.setMontantParMetreCarre(dto.getMontantParMetreCarre());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(StringUtil.isNotEmpty(dto.getMontantRetardPremierMois()))
                item.setMontantRetardPremierMois(dto.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(dto.getMontantRetardAutreMois()))
                item.setMontantRetardAutreMois(dto.getMontantRetardAutreMois());
            if(this.locale38Detail && dto.getLocale38Detail()!=null)
                item.setLocale38Detail(locale38DetailConverter.toItem(dto.getLocale38Detail())) ;

            if(this.tauxTaxe38 && dto.getTauxTaxe38()!=null)
                item.setTauxTaxe38(tauxTaxe38Converter.toItem(dto.getTauxTaxe38())) ;

            if(dto.getTaxe38() != null && dto.getTaxe38().getId() != null){
                item.setTaxe38(new Taxe38());
                item.getTaxe38().setId(dto.getTaxe38().getId());
                item.getTaxe38().setCode(dto.getTaxe38().getCode());
            }




        return item;
        }
    }


    public Taxe38DetailDto toDto(Taxe38Detail item) {
        if (item == null) {
            return null;
        } else {
            Taxe38DetailDto dto = new Taxe38DetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getMontantParMetreCarre()))
                dto.setMontantParMetreCarre(item.getMontantParMetreCarre());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
            if(StringUtil.isNotEmpty(item.getMontantRetardPremierMois()))
                dto.setMontantRetardPremierMois(item.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(item.getMontantRetardAutreMois()))
                dto.setMontantRetardAutreMois(item.getMontantRetardAutreMois());
            if(this.locale38Detail && item.getLocale38Detail()!=null) {
                dto.setLocale38Detail(locale38DetailConverter.toDto(item.getLocale38Detail())) ;

            }
            if(this.tauxTaxe38 && item.getTauxTaxe38()!=null) {
                dto.setTauxTaxe38(tauxTaxe38Converter.toDto(item.getTauxTaxe38())) ;

            }
            if(this.taxe38 && item.getTaxe38()!=null) {
                dto.setTaxe38(taxe38Converter.toDto(item.getTaxe38())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.locale38Detail = value;
        this.tauxTaxe38 = value;
        this.taxe38 = value;
    }
	
    public List<Taxe38Detail> toItem(List<Taxe38DetailDto> dtos) {
        List<Taxe38Detail> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (Taxe38DetailDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<Taxe38DetailDto> toDto(List<Taxe38Detail> items) {
        List<Taxe38DetailDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Taxe38Detail item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(Taxe38DetailDto dto, Taxe38Detail t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getLocale38Detail() != null)
        locale38DetailConverter.copy(dto.getLocale38Detail(), t.getLocale38Detail());
        if (dto.getTauxTaxe38() != null)
        tauxTaxe38Converter.copy(dto.getTauxTaxe38(), t.getTauxTaxe38());
        if (dto.getTaxe38() != null)
        taxe38Converter.copy(dto.getTaxe38(), t.getTaxe38());
    }

    public List<Taxe38Detail> copy(List<Taxe38DetailDto> dtos) {
        List<Taxe38Detail> result = new ArrayList<>();
        if (dtos != null) {
            for (Taxe38DetailDto dto : dtos) {
                Taxe38Detail instance = new Taxe38Detail();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public Taxe38Converter getTaxe38Converter(){
        return this.taxe38Converter;
    }
    public void setTaxe38Converter(Taxe38Converter taxe38Converter ){
        this.taxe38Converter = taxe38Converter;
    }
    public Locale38DetailConverter getLocale38DetailConverter(){
        return this.locale38DetailConverter;
    }
    public void setLocale38DetailConverter(Locale38DetailConverter locale38DetailConverter ){
        this.locale38DetailConverter = locale38DetailConverter;
    }
    public TauxTaxe38Converter getTauxTaxe38Converter(){
        return this.tauxTaxe38Converter;
    }
    public void setTauxTaxe38Converter(TauxTaxe38Converter tauxTaxe38Converter ){
        this.tauxTaxe38Converter = tauxTaxe38Converter;
    }
    public boolean  isLocale38Detail(){
        return this.locale38Detail;
    }
    public void  setLocale38Detail(boolean locale38Detail){
        this.locale38Detail = locale38Detail;
    }
    public boolean  isTauxTaxe38(){
        return this.tauxTaxe38;
    }
    public void  setTauxTaxe38(boolean tauxTaxe38){
        this.tauxTaxe38 = tauxTaxe38;
    }
    public boolean  isTaxe38(){
        return this.taxe38;
    }
    public void  setTaxe38(boolean taxe38){
        this.taxe38 = taxe38;
    }
}
