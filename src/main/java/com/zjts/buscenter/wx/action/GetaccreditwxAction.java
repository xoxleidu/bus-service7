package com.zjts.buscenter.wx.action;

import com.zjts.buscenter.wx.model.BaseAction;
import com.zjts.buscenter.wx.model.MessageReturn;
import com.zjts.buscenter.wx.util.JSONUtils;
import com.zjts.buscenter.wx.util.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetaccreditwxAction extends BaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//记得和黄哥要  这个是注册微信小程序的时候自带的固定请求属性值
	private static final String APPID = "wxa6a5d1b15d843974";  //车管所
	private static final String SECRET = "5e42b34fdeb6316bec350baf400027cb";   //车管所


	private static final List<String> PLMS = new ArrayList<String>();
	static
	{
		PLMS.add( "android" );
		PLMS.add( "ios" );
		PLMS.add( "wx" );
	}
	
	public String execute() throws Exception
	{
		String method = request.getParameter( "method" );

		MessageReturn mr = new MessageReturn();
		

		String plm = request.getParameter( "plm" );
		if (StringUtils.isEmpty( plm ) || !PLMS.contains( plm.toLowerCase() ))
		
		{ 
			
			
			mr.setCode( "400" );
			mr.setMessage( "参数异常，获取平台参数失败" );
			return outResultAppData( mr );
		}
		
		if (!StringUtils.isEmpty( method )) // 获得不到domethod参数直接返回
		{
			if ("wxaccredit".equalsIgnoreCase( method ))
			{
				String code = request.getParameter( "code" );
				//String code = request.getParameter( "phone" );
				//String code = "071KICav19Zuab0Q1G9v1LwAav1KICaK";
				if (!StringUtils.checkStringArrayEmpty( new String[] {code} ))
				{

					mr.setCode( "400" );
					mr.setMessage( "参数异常，获取code失败" );
					return outResultAppData( mr );
					
				}
				//微信的接口
				 String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+
						 "&secret="+SECRET+"&js_code="+ code +"&grant_type=authorization_code";
				 RestTemplate restTemplate = new RestTemplate();
				 //进行网络请求,访问url接口
			     ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
				 //根据返回值进行后续操作 
			     if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK)
			        {
			    	 	String sessionData = responseEntity.getBody();

			    	 	//最后要返回一个自定义的登录态,用来做后续数据传输的验证
			    	 	String openid = null;
			    	 	String session_key = null;
			    	 	String errmsg = null;
			    	 	String errcode = null;
			    	 	HashMap hmp = JSONUtils.toHashMap(sessionData);
			    	 	if(hmp.get("errmsg")!=null)
			    	 	{
				    	 	errmsg = hmp.get("errmsg").toString();
			    	 	}
			    	 	if(hmp.get("errcode")!=null)
			    	 	{
				    	 	errcode = hmp.get("errcode").toString();
			    	 	}
			    	 	if(hmp.get("openid")!=null)
			    	 	{
				    	 	openid =  hmp.get("openid").toString();
			    	 	}
			    	 	if(hmp.get("session_key")!=null)
			    	 	{
				    	 	session_key = hmp.get("session_key").toString();
			    	 	}

			    	 	if(openid ==null || session_key ==null)
			    	 	{
			    			mr.setCode( "400" );
			    			mr.setMessage( "微信参数异常，获取微信平台授权失败:"+errcode+errmsg );
			    			return outResultAppData( mr );
			    	 	}else
			    	 	{
				    	 	Map  rm = new HashMap();
							rm.put("openid", openid);
							rm.put("session_key", session_key);
							mr.setCode( "200" );
							mr.setMessage( "获取微信session成功" );
							mr.setBody( rm );
							return outResultAppData( mr );
			    	 	}
			        }
				
			}
		}	
		
		return null;
	}

}
