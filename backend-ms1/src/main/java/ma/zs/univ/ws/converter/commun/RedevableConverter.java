package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.ws.dto.commun.RedevableDto;

@Component
public class RedevableConverter {


    public  RedevableConverter() {
    }


    public Redevable toItem(RedevableDto dto) {
        if (dto == null) {
            return null;
        } else {
        Redevable item = new Redevable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            item.setCredentialsNonExpired(dto.getCredentialsNonExpired());
            item.setEnabled(dto.getEnabled());
            item.setAccountNonExpired(dto.getAccountNonExpired());
            item.setAccountNonLocked(dto.getAccountNonLocked());
            item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());


            //item.setRoles(dto.getRoles());

        return item;
        }
    }


    public RedevableDto toDto(Redevable item) {
        if (item == null) {
            return null;
        } else {
            RedevableDto dto = new RedevableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getCredentialsNonExpired()))
                dto.setCredentialsNonExpired(item.getCredentialsNonExpired());
            if(StringUtil.isNotEmpty(item.getEnabled()))
                dto.setEnabled(item.getEnabled());
            if(StringUtil.isNotEmpty(item.getAccountNonExpired()))
                dto.setAccountNonExpired(item.getAccountNonExpired());
            if(StringUtil.isNotEmpty(item.getAccountNonLocked()))
                dto.setAccountNonLocked(item.getAccountNonLocked());
            if(StringUtil.isNotEmpty(item.getPasswordChanged()))
                dto.setPasswordChanged(item.getPasswordChanged());
            if(StringUtil.isNotEmpty(item.getUsername()))
                dto.setUsername(item.getUsername());
            if(StringUtil.isNotEmpty(item.getPassword()))
                dto.setPassword(item.getPassword());


        return dto;
        }
    }


	
    public List<Redevable> toItem(List<RedevableDto> dtos) {
        List<Redevable> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (RedevableDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<RedevableDto> toDto(List<Redevable> items) {
        List<RedevableDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (Redevable item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(RedevableDto dto, Redevable t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<Redevable> copy(List<RedevableDto> dtos) {
        List<Redevable> result = new ArrayList<>();
        if (dtos != null) {
            for (RedevableDto dto : dtos) {
                Redevable instance = new Redevable();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
