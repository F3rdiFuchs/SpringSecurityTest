package com.exception;


public class ExecuteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExecuteException()
	{
		super("There is an error in the execute function");
	}
}
