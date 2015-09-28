package com.model.group;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.user.AbstractUserDAO;

@Repository("groupDAO")
public class GroupDAOImpl extends AbstractUserDAO<Integer, Group> implements GroupDAO{

	@SuppressWarnings("unchecked")
	public List<Group> findAll() {
		Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<Group>)crit.list();
	}

	public Group findByType(String type) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Group) crit.uniqueResult();
	}

	public Group findById(int id) {
		return getByKey(id);
	}
}
