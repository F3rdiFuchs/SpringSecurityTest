package com.service.groupservice;

import java.util.List;

import com.model.group.Group;

public interface GroupService {
	List<Group> findAll();
	Group findByType(String type);
	Group findById(int id);
}
