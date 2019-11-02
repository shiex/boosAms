package com.xbb.web.base.exception;

public class WebException extends Exception
{
	public int error;
	public String reason;
	
	public WebException()
	{		
	}
	public WebException(int error, String reason)
	{
		this.error = error;
		this.reason = reason;
	}
	@Override
	public String getMessage()
	{
		return reason + "(" + error + ")";
	}
	
	
}
