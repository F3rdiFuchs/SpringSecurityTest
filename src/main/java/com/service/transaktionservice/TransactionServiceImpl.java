package com.service.transaktionservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public <T> T doInTransaktion(TransactionService<T> dataObject)
	{
		Transaction tx = null;
		Session session = null;
		T data;
		
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		
		
			data = dataObject.execute(session);
			tx.commit();
		
		session.close();
		return data;
	}
}
