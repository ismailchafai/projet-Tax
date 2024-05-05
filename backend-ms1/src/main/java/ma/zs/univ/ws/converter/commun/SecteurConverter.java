package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.commun.VilleConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.ws.dto.commun.SecteurDto;

@Component
public class SecteurConverter {

    @Autowired
    private VilleConverter villeConverter ;
    private boolean ville;

    public  SecteurConverter() {
        initObject(true);
    }


    public Secteur toItem(SecteurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Secteur item = new Secteur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.ville && dto.getVille()!=null)
                item.setVille(villeConverter.toItem(dto.getVille())) ;




        return item;
        }
    }


    public SecteurDto toDto(Secteur item) {
        if (item == null) {
            return null;
        } else {
            SecteurDto dto = new SecteurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.ville && item.getVille()!=null) {
                dto.setVille(villeConverter.toDto(item.getVille())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.ville = value;
    }
	
    public List<Secteur> toItem(List<SecteurDto> dtos) {
        List<Secteur> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (SecteurDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<SecteurDto> toDto(List<Secteur> items) {
        List<SecteurDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Secteur item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(SecteurDto dto, Secteur t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getVille() != null)
        villeConverter.copy(dto.getVille(), t.getVille());
    }

    public List<Secteur> copy(List<SecteurDto> dtos) {
        List<Secteur> result = new ArrayList<>();
        if (dtos != null) {
            for (SecteurDto dto : dtos) {
                Secteur instance = new Secteur();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public VilleConverter getVilleConverter(){
        return this.villeConverter;
    }
    public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
    }
    public boolean  isVille(){
        return this.ville;
    }
    public void  setVille(boolean ville){
        this.ville = ville;
    }
}
