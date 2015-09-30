package com.configuration;

import org.hibernate.dialect.MySQLDialect;

public class MyMySQLDialect extends MySQLDialect {

	public MyMySQLDialect() {
		super();
		registerKeyword("group");
	}
}
