package com.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.model.group.Group;
import com.service.groupservice.GroupService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Group>{
	
	@Autowired
    GroupService groupService;
	
	public Group convert(Object element) {
		Integer id = Integer.parseInt((String)element);
        Group profile= groupService.findById(id);
        return profile;
	}
}
