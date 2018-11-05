package com.zjts.buscenter.wx.model;

public class MessageReturn
{
	private String code = "200";
	private String message = "";
	private Integer pageCount = 0;
	private String sessionId = "";
	
	// 用户等级名称
	private String levelName = "";
	private Double experCount = 0.00 ;
	private Integer expright = 0 ;
	private Object charge = new Object() ;
	
	private Double myPointCount = 0.00 ;
	
	private String loginPhone = "";
	private String address = "";
	

	
	private String nikeName = "";
	private String defaultAddr = "";

	private Object body = new Object();
	private Object slaveBody = new Object();


	public String getCode()
	{
		return code;
	}


	public void setCode( String code )
	{
		this.code = code;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage( String message )
	{
		this.message = message;
	}


	public Object getBody()
	{
		return body;
	}


	public void setBody( Object body )
	{
		this.body = body;
	}


	public Integer getPageCount()
	{
		return pageCount;
	}


	public void setPageCount( Integer pageCount )
	{
		this.pageCount = pageCount;
	}


	public Object getSlaveBody()
	{
		return slaveBody;
	}


	public void setSlaveBody( Object slaveBody )
	{
		this.slaveBody = slaveBody;
	}


	public String getSessionId()
	{
		return sessionId;
	}


	public void setSessionId( String sessionId )
	{
		this.sessionId = sessionId;
	}


	public String getNikeName()
	{
		return nikeName;
	}


	public void setNikeName( String nikeName )
	{
		this.nikeName = nikeName;
	}


	public String getDefaultAddr()
	{
		return defaultAddr;
	}


	public void setDefaultAddr( String defaultAddr )
	{
		this.defaultAddr = defaultAddr;
	}



	public String getLevelName()
	{
		return levelName;
	}


	public void setLevelName( String levelName )
	{
		this.levelName = levelName;
	}


	public Double getExperCount()
	{
		return experCount;
	}


	public void setExperCount( Double experCount )
	{
		this.experCount = experCount;
	}

		


	public Object getCharge()
	{
		return charge;
	}


	public void setCharge( Object charge )
	{
		this.charge = charge;
	}


	public Double getMyPointCount()
	{
		return myPointCount;
	}


	public void setMyPointCount( Double myPointCount )
	{
		this.myPointCount = myPointCount;
	}


	public Integer getExpright()
	{
		return expright;
	}


	public void setExpright( Integer expright )
	{
		this.expright = expright;
	}


	public String getLoginPhone()
	{
		return loginPhone;
	}


	public void setLoginPhone( String loginPhone )
	{
		this.loginPhone = loginPhone;
	}


	public String getAddress()
	{
		return address;
	}


	public void setAddress( String address )
	{
		this.address = address;
	}




	
	
	
	

}
