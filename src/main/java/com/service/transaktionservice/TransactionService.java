package com.service.transaktionservice;

import org.hibernate.Session;

public interface TransactionService<T> {
	T execute(Session session);
}
