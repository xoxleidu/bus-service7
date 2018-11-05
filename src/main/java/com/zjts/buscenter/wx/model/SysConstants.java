package com.zjts.buscenter.wx.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统配置静态全局类
 * @author liutaok
 * @since 2014-03-25
 */
public final class SysConstants {
	
	public static final String EXT_SUCCESS="success"; //ext成功返回结果
	public static final String EXT_FAILURE="failure"; //ext失败返回结果
	public static final String EXT_TRUE="true"; //ext成功返回结果
	public static final String EXT_false="false"; //ext失败返回结果
	
	
	public static final String SYS_LOGIN="login";  //定义登录行为
	public static final String SYS_LOGOUT="logout";  //定义退出行为
	
	public static final int PAGE_CURRENT_PAGE= 0 ; //当前页默认数
	public static final int PAGE_PAGE_SIZE= 20; //系统默认列表显示分页条数
	
	public static final int DEFAULT_SUCCESS_STATUS=0; //系统成功默认返回状态;ajax是否成功的标志 0-成功 1-失败 2-权限不足*/
	
	public static final String SYS_HOSTNAME="HOST"; //系统home定义

	//角色等级
	public static enum ROLE_LEVEL{
		SYSTEM_ADMIN("1"),
		CITY_USER("10"),
		COUNTY_USER("20"),
		POLICE_USER("30");
		String level;
		private ROLE_LEVEL(String level){
			this.level = level;
		}
		public String getLevel() {
			return level;
		}
		
	}
	
	// 性别
	public static final Map<Integer, String> SEX_TYPE = new HashMap<Integer, String>(){
		{
			put(1,"男");
			put(2,"女");
		}
	};
	// 有无预防接种证
	public static final Map<Integer, String> HAS_VACCINATION = new HashMap<Integer, String>(){
		{
			put(1,"有");
			put(2,"无");
		}
	};
	
	// 是否在居住地上学
	public static final Map<Integer, String> IS_INSCHOOL = new HashMap<Integer, String>(){
		{
			put(1,"是");
			put(2,"否");
		}
	};	
	
	//是否有节育避孕报告单 1表示是  2表示否
	public static final Map<Integer, String> RK_CARD_FLAG = new HashMap<Integer, String>(){
		{
			put(1,"是");
			put(2,"否");
		}
	};
	
	//是否生育子女 1表示是 2表示否
	public static final Map<Integer, String> RK_CHILDBEARING_FLAG = new HashMap<Integer, String>(){
		{
			put(1,"是");
			put(2,"否");
		}
	};
	//是否有独生子女证 1表示是 2表示否
	public static final Map<Integer, String> RK_SINGLETON_FLAG = new HashMap<Integer, String>(){
		{
			put(1,"是");
			put(2,"否");
		}
	};
	
	
	// 公告结束标记
	public static final Map<Integer, String> NOTIFY_END_FLAG = new HashMap<Integer, String>(){
		{
			put(0,"未结束");
			put(1,"已结束");
		}
	};
	
	//公告查收标记
	public static final Map<Integer,String> NOTIFY_CHECK_FLAG = new HashMap<Integer,String>(){
		{
			put(0,"未查收");
			put(1,"已查收");
		}
	};
		
	//公告结束标记
	public static enum NOTIFY_END_FLAG_ENUM {
		/**
		 * 未结束
		 */
		UNEND(0),
		/**
		 * 已结束
		 */
		END(1);
		private Integer value;
		private NOTIFY_END_FLAG_ENUM(Integer value){
			this.value = value;
		}
		
		public Integer getValue(){
			return this.value;
		}
	}
	
	//公告查收标记 0表示未查收 1表示查收
	public static enum NOTIFY_CHECK_FLAG_ENUM {
		/**
		 * 未查收
		 */
		UNCHECK(0),
		/**
		 * 已查收
		 */
		CHECKED(1);
		private Integer value;
		private NOTIFY_CHECK_FLAG_ENUM(Integer value){
			this.value = value;
		}
		
		public Integer getValue(){
			return this.value;
		}
	}
	
	//首页线性图展示月份
	public static final Map<Integer,String> CHART_MONTH = new HashMap<Integer,String>(){{
    	put(0,"一月");
    	put(1,"二月");
    	put(2,"三月");
    	put(3,"四月");
    	put(4,"五月");
    	put(5,"六月");
    	put(6,"七月");
    	put(7,"八月");
    	put(8,"九月");
    	put(9,"十月");
    	put(10,"十一月");
    	put(11,"十二月");
    }};
}
