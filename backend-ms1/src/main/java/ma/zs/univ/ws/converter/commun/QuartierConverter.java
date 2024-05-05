package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.univ.ws.converter.commun.SecteurConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.ws.dto.commun.QuartierDto;

@Component
public class QuartierConverter {

    @Autowired
    private SecteurConverter secteurConverter ;
    private boolean secteur;

    public  QuartierConverter() {
        initObject(true);
    }


    public Quartier toItem(QuartierDto dto) {
        if (dto == null) {
            return null;
        } else {
        Quartier item = new Quartier();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.secteur && dto.getSecteur()!=null)
                item.setSecteur(secteurConverter.toItem(dto.getSecteur())) ;




        return item;
        }
    }


    public QuartierDto toDto(Quartier item) {
        if (item == null) {
            return null;
        } else {
            QuartierDto dto = new QuartierDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.secteur && item.getSecteur()!=null) {
                dto.setSecteur(secteurConverter.toDto(item.getSecteur())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.secteur = value;
    }
	
    public List<Quartier> toItem(List<QuartierDto> dtos) {
        List<Quartier> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (QuartierDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<QuartierDto> toDto(List<Quartier> items) {
        List<QuartierDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Quartier item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(QuartierDto dto, Quartier t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getSecteur() != null)
        secteurConverter.copy(dto.getSecteur(), t.getSecteur());
    }

    public List<Quartier> copy(List<QuartierDto> dtos) {
        List<Quartier> result = new ArrayList<>();
        if (dtos != null) {
            for (QuartierDto dto : dtos) {
                Quartier instance = new Quartier();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public SecteurConverter getSecteurConverter(){
        return this.secteurConverter;
    }
    public void setSecteurConverter(SecteurConverter secteurConverter ){
        this.secteurConverter = secteurConverter;
    }
    public boolean  isSecteur(){
        return this.secteur;
    }
    public void  setSecteur(boolean secteur){
        this.secteur = secteur;
    }
}
