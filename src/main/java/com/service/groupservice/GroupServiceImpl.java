package com.service.groupservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.group.Group;
import com.model.group.GroupDAO;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService{
	GroupDAO groupDAO;
	public List<Group> findAll() {
		return groupDAO.findAll();
	}

	public Group findByType(String type) {
		return groupDAO.findByType(type);
	}

	public Group findById(int id) {
		return groupDAO.findById(id);
	}
}
