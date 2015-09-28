package com.model.group;

import java.util.List;

public interface GroupDAO {
	List<Group> findAll();
	Group findByType(String type);
	Group findById(int id);
}
