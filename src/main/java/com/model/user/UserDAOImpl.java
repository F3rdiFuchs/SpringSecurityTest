package com.model.user;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.service.transaktionservice.TransactionService;
import com.service.transaktionservice.TransactionServiceImpl;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	private TransactionServiceImpl transactionService;
	
	public User findById(final int userid) {
		return transactionService.doInTransaktion(new TransactionService<User>() {
						public User execute(Session session) {
						User user = null;
						user = (User) session.get(User.class, userid);
						return user;
					}
			});
	}

	public User findByUsername(final String userName) {
		return transactionService.doInTransaktion(new TransactionService<User>() {
						
						public User execute(Session session) {
						User user = null;
						user = (User) session.createQuery("FROM User WHERE username= :uname").setParameter("uname", userName).uniqueResult();
						return user;
					}
			});
	}
}
