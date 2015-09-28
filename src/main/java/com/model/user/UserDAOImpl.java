package com.model.user;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl extends AbstractUserDAO<Integer, User> implements UserDAO {
	
	public User findById(final int userId) {
		return getByKey(userId);
	}

	public User findByUsername(final String userName) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", userName));
        return (User) crit.uniqueResult();
	}
}
