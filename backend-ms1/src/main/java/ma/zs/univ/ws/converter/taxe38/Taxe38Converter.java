package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;
import ma.zs.univ.zynerator.util.ListUtil;

import ma.zs.univ.ws.converter.commun.LocaleConverter;
import ma.zs.univ.ws.converter.taxe38.TrimConverter;
import ma.zs.univ.ws.converter.taxe38.Taxe38DetailConverter;
import ma.zs.univ.ws.converter.taxe38.Locale38DetailConverter;
import ma.zs.univ.ws.converter.commun.RedevableConverter;
import ma.zs.univ.ws.converter.taxe38.TauxTaxe38Converter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.ws.dto.taxe38.Taxe38Dto;

@Component
public class Taxe38Converter {

    @Autowired
    private LocaleConverter localeConverter ;
    @Autowired
    private TrimConverter trimConverter ;
    @Autowired
    private Taxe38DetailConverter taxe38DetailConverter ;
    @Autowired
    private Locale38DetailConverter locale38DetailConverter ;
    @Autowired
    private RedevableConverter redevableConverter ;
    @Autowired
    private TauxTaxe38Converter tauxTaxe38Converter ;
    private boolean redevable;
    private boolean locale;
    private boolean trim;
    private boolean taxe38Details;

    public  Taxe38Converter() {
        init(true);
    }


    public Taxe38 toItem(Taxe38Dto dto) {
        if (dto == null) {
            return null;
        } else {
        Taxe38 item = new Taxe38();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAnne()))
                item.setAnne(dto.getAnne());
            if(StringUtil.isNotEmpty(dto.getDatePresentaion()))
                item.setDatePresentaion(DateUtil.stringEnToDate(dto.getDatePresentaion()));
            if(StringUtil.isNotEmpty(dto.getNombreMoisRetard()))
                item.setNombreMoisRetard(dto.getNombreMoisRetard());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(StringUtil.isNotEmpty(dto.getMontantRetardPremeirMois()))
                item.setMontantRetardPremeirMois(dto.getMontantRetardPremeirMois());
            if(StringUtil.isNotEmpty(dto.getMontantTotal()))
                item.setMontantTotal(dto.getMontantTotal());
            if(this.redevable && dto.getRedevable()!=null)
                item.setRedevable(redevableConverter.toItem(dto.getRedevable())) ;

            if(this.locale && dto.getLocale()!=null)
                item.setLocale(localeConverter.toItem(dto.getLocale())) ;

            if(this.trim && dto.getTrim()!=null)
                item.setTrim(trimConverter.toItem(dto.getTrim())) ;


            if(this.taxe38Details && ListUtil.isNotEmpty(dto.getTaxe38Details()))
                item.setTaxe38Details(taxe38DetailConverter.toItem(dto.getTaxe38Details()));


        return item;
        }
    }


    public Taxe38Dto toDto(Taxe38 item) {
        if (item == null) {
            return null;
        } else {
            Taxe38Dto dto = new Taxe38Dto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAnne()))
                dto.setAnne(item.getAnne());
            if(item.getDatePresentaion()!=null)
                dto.setDatePresentaion(DateUtil.dateTimeToString(item.getDatePresentaion()));
            if(StringUtil.isNotEmpty(item.getNombreMoisRetard()))
                dto.setNombreMoisRetard(item.getNombreMoisRetard());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
            if(StringUtil.isNotEmpty(item.getMontantRetardPremeirMois()))
                dto.setMontantRetardPremeirMois(item.getMontantRetardPremeirMois());
            if(StringUtil.isNotEmpty(item.getMontantTotal()))
                dto.setMontantTotal(item.getMontantTotal());
            if(this.redevable && item.getRedevable()!=null) {
                dto.setRedevable(redevableConverter.toDto(item.getRedevable())) ;

            }
            if(this.locale && item.getLocale()!=null) {
                dto.setLocale(localeConverter.toDto(item.getLocale())) ;

            }
            if(this.trim && item.getTrim()!=null) {
                dto.setTrim(trimConverter.toDto(item.getTrim())) ;

            }
        if(this.taxe38Details && ListUtil.isNotEmpty(item.getTaxe38Details())){
            taxe38DetailConverter.init(true);
            taxe38DetailConverter.setTaxe38(false);
            dto.setTaxe38Details(taxe38DetailConverter.toDto(item.getTaxe38Details()));
            taxe38DetailConverter.setTaxe38(true);

        }


        return dto;
        }
    }

    public void init(boolean value) {
        initList(value);
    }

    public void initList(boolean value) {
        this.taxe38Details = value;
    }
    public void initObject(boolean value) {
        this.redevable = value;
        this.locale = value;
        this.trim = value;
    }
	
    public List<Taxe38> toItem(List<Taxe38Dto> dtos) {
        List<Taxe38> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (Taxe38Dto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<Taxe38Dto> toDto(List<Taxe38> items) {
        List<Taxe38Dto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Taxe38 item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(Taxe38Dto dto, Taxe38 t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getRedevable() != null)
        redevableConverter.copy(dto.getRedevable(), t.getRedevable());
        if (dto.getLocale() != null)
        localeConverter.copy(dto.getLocale(), t.getLocale());
        if (dto.getTrim() != null)
        trimConverter.copy(dto.getTrim(), t.getTrim());
        if (dto.getTaxe38Details() != null)
            t.setTaxe38Details(taxe38DetailConverter.copy(dto.getTaxe38Details()));
    }

    public List<Taxe38> copy(List<Taxe38Dto> dtos) {
        List<Taxe38> result = new ArrayList<>();
        if (dtos != null) {
            for (Taxe38Dto dto : dtos) {
                Taxe38 instance = new Taxe38();
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
    public TrimConverter getTrimConverter(){
        return this.trimConverter;
    }
    public void setTrimConverter(TrimConverter trimConverter ){
        this.trimConverter = trimConverter;
    }
    public Taxe38DetailConverter getTaxe38DetailConverter(){
        return this.taxe38DetailConverter;
    }
    public void setTaxe38DetailConverter(Taxe38DetailConverter taxe38DetailConverter ){
        this.taxe38DetailConverter = taxe38DetailConverter;
    }
    public Locale38DetailConverter getLocale38DetailConverter(){
        return this.locale38DetailConverter;
    }
    public void setLocale38DetailConverter(Locale38DetailConverter locale38DetailConverter ){
        this.locale38DetailConverter = locale38DetailConverter;
    }
    public RedevableConverter getRedevableConverter(){
        return this.redevableConverter;
    }
    public void setRedevableConverter(RedevableConverter redevableConverter ){
        this.redevableConverter = redevableConverter;
    }
    public TauxTaxe38Converter getTauxTaxe38Converter(){
        return this.tauxTaxe38Converter;
    }
    public void setTauxTaxe38Converter(TauxTaxe38Converter tauxTaxe38Converter ){
        this.tauxTaxe38Converter = tauxTaxe38Converter;
    }
    public boolean  isRedevable(){
        return this.redevable;
    }
    public void  setRedevable(boolean redevable){
        this.redevable = redevable;
    }
    public boolean  isLocale(){
        return this.locale;
    }
    public void  setLocale(boolean locale){
        this.locale = locale;
    }
    public boolean  isTrim(){
        return this.trim;
    }
    public void  setTrim(boolean trim){
        this.trim = trim;
    }
    public boolean  isTaxe38Details(){
        return this.taxe38Details ;
    }
    public void  setTaxe38Details(boolean taxe38Details ){
        this.taxe38Details  = taxe38Details ;
    }
}
