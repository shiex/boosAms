package com.xbb.web.base.exception;

public class RestfulException extends WebException
{
	public RestfulException()
	{		
	}
	public RestfulException(int error, String reason)
	{
		super(error, reason);
	}
}
