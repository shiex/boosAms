package com.xbb.web.base.restful;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractGenericApi
{
	// httpReq : 请求对象
	public HttpServletRequest httpReq;
	// httpResp : 应答对象
	public HttpServletResponse httpResp;

	// charset： 字符编码
	public String charset ; 
	public int debug = 1; // 用于取代 enableErrorLog
	public BaseGenericService.ConfigItem config; // af-service.xml里的配置
	
	// 子类应重写这个方法 , strReq 是请求数据 (可能为null), 应返回一段数据, 可以为null
	public abstract String execute(String strReq) throws Exception;
	
	
	
}
