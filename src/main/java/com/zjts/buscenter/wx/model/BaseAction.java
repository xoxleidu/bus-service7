package com.zjts.buscenter.wx.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.zjts.buscenter.wx.util.DoubleTypeAdapter;
import com.zjts.buscenter.wx.util.TimestampTypeAdapter;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Map;

/**
 * action的Base基类
 * 
 * @author liutaok
 * @since 2014-03-25
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware
{
	/** serialVersionUID **/
	private static final long serialVersionUID = 4446523818897848988L;
	/** 通用日志对象 **/
	protected Logger logger = Logger.getLogger( this.getClass() );
	/** request对象 */
	protected HttpServletRequest request;
	/** response对象 */
	protected HttpServletResponse response;
	/** 当前页对象 */
	protected int currentPage = SysConstants.PAGE_CURRENT_PAGE;
	/** 当前页数量对象 */
	protected int pageSize = SysConstants.PAGE_PAGE_SIZE;

	protected Long msgCode;
	/** 返回页面的信息 */
	protected String messageInfo;
	/** ajax是否成功的标志 0-成功 1-失败 2-权限不足 */
	protected int isSuccess = SysConstants.DEFAULT_SUCCESS_STATUS;
	/** 返回的页面名称 */
	protected String resultJsp;
	/** 列表页的地址 **/
	protected String listUrl;
	/** 模块名称 */
	protected String moduleName;

	/**
	 * 分页查询开始计算的值(EXTJS分页专用)
	 */
	private int start;

	/**
	 * 分页查询每页显示的值(EXTJS分页专用)
	 */
	private int limit;

	/** 页面返回的id的数组 */
	protected String[] ids;


	/**
	 * 
	 * Spring 反射机制 WebApplicationContext 容器中获得service
	 * 
	 * @param String
	 *            id
	 * 
	 * @return Object
	 */
	protected Object getBean( String id )
	{
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext( ServletActionContext.getServletContext() );

		return ctx.getBean( id );
	}


	/**
	 * 根据start,limit值获得当前页
	 */
	protected int getCurrentPage( int start , int limit )
	{
		if (start <= 0) { return 1; }
		if (start == limit) { return 2; }
		return ( start / limit ) + 1;
	}


	/**
	 * 
	 * 防止乱码问题
	 * 
	 * @param
	 * 
	 * @return
	 */
	protected void setResponseUTF8( HttpServletResponse response )
	{
		// --------解决中文乱码问题-----------//
		response.setHeader( "Cache-Control", "no-cache" );
		response.setContentType( "text/html;charset=UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
	}


	/**
	 * 
	 * @param message
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	protected String printExtPrintOut( String message , boolean flag , JSONObject jsonObject ) throws Exception
	{
		if (flag)
		{
			jsonObject.put( SysConstants.EXT_SUCCESS, SysConstants.EXT_TRUE );

		}
		else
		{
			jsonObject.put( SysConstants.EXT_FAILURE, SysConstants.EXT_TRUE );
		}

		this.setResponseUTF8( response );
		this.setExtPrintOut( response, jsonObject, message );

		return null;
	}


	/**
	 * 
	 * EXT对象输出
	 * 
	 * @param
	 * 
	 * @return
	 */
	protected void setExtPrintOut(HttpServletResponse response , JSONObject jsonObject , String message ) throws Exception
	{
		PrintWriter out = response.getWriter();
		if (message != null && !message.equals( "" ))
		{
			jsonObject.put( "message", message );
		}
		out.println( jsonObject.toString() );
		out.flush();
		out.close();
	}


	/**
	 * 
	 * EXT对象输出
	 * 
	 * @param
	 * 
	 * @return
	 */
	public boolean writeResponse( String str )
	{
		boolean ret = true;
		try
		{
			str = str.replace( "\\r", "" );
			str = str.replace( "null", "\"\"" );
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType( "text/html;charset=utf-8" );
			PrintWriter pw = response.getWriter();
			pw.print( str );
			pw.close();
		}
		catch ( Exception e )
		{
			ret = false;
			e.printStackTrace();
		}
		return ret;
	}


	/**
	 * 
	 * 以流的形式获取请求参数
	 * 
	 * @param request
	 * 
	 * @return
	 */
	protected String getParameterString( HttpServletRequest request )
	{

		String x = "";

		try
		{

			InputStreamReader reader = new InputStreamReader( request.getInputStream(), "UTF-8" );

			char[] buff = new char[1024];

			int length = 0;

			while ( ( length = reader.read( buff ) ) != -1 )
			{

				x = new String( buff, 0, length );

			}

		}
		catch ( Exception e )
		{

			e.printStackTrace();

			logger.error( "获取请求参数报错！" );

		}

		return x;

	}


	/**
	 * 对象转JSON输出到WEB
	 */
	public String outResultToJson( Object obj ) throws IOException
	{
		response = ServletActionContext.getResponse();
		setResponseUTF8( response );
		PrintWriter out = response.getWriter();
		// Gson gson = new Gson();
		// out.println(gson.toJson(obj));

		Gson gson = new GsonBuilder()
			.serializeNulls()
			.registerTypeAdapter( Timestamp.class, new TimestampTypeAdapter() ).setDateFormat( "yyyy-MM-dd HH:mm:ss" )
			.registerTypeAdapter( Double.class, new DoubleTypeAdapter() )
			.create();		
		out.println( gson.toJson( obj ) );

		out.flush();
		out.close();
		
		return null;
	}
	
	
	/**
	 * 对象转JSON输出到WEB
	 */
	public String outResultAppData( Object obj ) throws IOException
	{
		response = ServletActionContext.getResponse();
		response.setHeader( "Cache-Control", "no-cache" );
		response.setContentType( "application/json;charset=UTF-8" );
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();

		Gson gson = new GsonBuilder()
			.serializeNulls()
			.registerTypeAdapter( Timestamp.class, new TimestampTypeAdapter() ).setDateFormat( "yyyy-MM-dd HH:mm:ss" )
			.registerTypeAdapter( Double.class, new DoubleTypeAdapter() )
			.create();		
		out.println( gson.toJson( obj ) );

		out.flush();
		out.close();
		
		return null;
	}	


	public void setSession( Map<String , Object> arg0 )
	{
	}


	public void setServletRequest( HttpServletRequest request )
	{

		this.request = request;

	}


	public void setServletResponse( HttpServletResponse response )
	{

		this.response = response;

	}


	public Integer getCurrentPage()
	{

		return currentPage;

	}


	public void setCurrentPage( Integer currentPage )
	{

		this.currentPage = currentPage;

	}


	public Integer getPageSize()
	{

		return pageSize;

	}


	public void setPageSize( Integer pageSize )
	{

		this.pageSize = pageSize;

	}


	public String getMessageInfo()
	{

		return messageInfo;

	}


	public void setMessageInfo( String messageInfo )
	{

		this.messageInfo = messageInfo;

	}


	public int getIsSuccess()
	{

		return isSuccess;

	}


	public void setIsSuccess( int isSuccess )
	{

		this.isSuccess = isSuccess;

	}


	public String getResultJsp()
	{

		return resultJsp;

	}


	public void setResultJsp( String resultJsp )
	{

		this.resultJsp = resultJsp;

	}


	public Long getMsgCode()
	{

		return msgCode;

	}


	public void setMsgCode( Long msgCode )
	{

		this.msgCode = msgCode;

	}


	public String[] getIds()
	{

		return ids;

	}


	public void setIds( String[] ids )
	{

		this.ids = ids;

	}


	public String getModuleName()
	{

		return moduleName;

	}


	public void setModuleName( String moduleName )
	{

		this.moduleName = moduleName;

	}


	public Logger getLogger()
	{

		return logger;

	}


	public void setLogger( Logger logger )
	{

		this.logger = logger;

	}


	public String getListUrl()
	{

		return listUrl;

	}


	public void setListUrl( String listUrl )
	{

		this.listUrl = listUrl;

	}


	public int getStart()
	{
		return start;
	}


	public void setStart( int start )
	{
		this.start = start;
	}


	public int getLimit()
	{
		return limit;
	}


	public void setLimit( int limit )
	{
		this.limit = limit;
	}

}
