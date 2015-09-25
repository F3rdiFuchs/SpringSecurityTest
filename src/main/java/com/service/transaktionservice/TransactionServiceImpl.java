package com.service.transaktionservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exception.ExecuteException;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public TransactionServiceImpl() {
	}

	public <T> T doInTransaktion(TransactionService<T> dataObject)
	{
		Transaction tx = null;
		Session session = null;
		T data;
		
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		
		try
		{
			data = dataObject.execute(session);
			tx.commit();
		}
		catch (Exception e)
		{
			tx.rollback();
			throw new ExecuteException();
		}
		session.close();
		return data;
	}
	
}
