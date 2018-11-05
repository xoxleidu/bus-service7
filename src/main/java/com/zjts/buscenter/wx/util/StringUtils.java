package com.zjts.buscenter.wx.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	/**
	 * 是否有中文字符
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasCn(String s) {
		if (s == null) {
			return false;
		}
		return countCn(s) > s.length();
	}
	
	/**
	 * 判断字符是否为空 为空返回true否则返回false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNull(String s) {
		if (null == s || "".equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得字符。符合中文习惯。
	 * 
	 * @param s
	 * @param length
	 * @return
	 */
	public static String getCn(String s, int len) {
		if (s == null) {
			return s;
		}
		int sl = s.length();
		if (sl <= len) {
			return s;
		}
		// 留出一个位置用于…
		len -= 1;
		int maxCount = len * 2;
		int count = 0;
		int i = 0;
		while (count < maxCount && i < sl) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
			i++;
		}
		if (count > maxCount) {
			i--;
		}
		return s.substring(0, i) + "…";
	}

	/**
	 * 计算GBK编码的字符串的字节数
	 * 
	 * @param s
	 * @return
	 */
	public static int countCn(String s) {
		if (s == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		return count;
	}

	/**
	 * 文本转html
	 * 
	 * @param txt
	 * @return
	 */
	public static String txt2htm(String txt) {
		if (StringUtils.isBlank(txt)) {
			return txt;
		}
		StringBuilder bld = new StringBuilder();
		char c;
		for (int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			switch (c) {
			case '&':
				bld.append("&amp;");
				break;
			case '<':
				bld.append("&lt;");
				break;
			case '>':
				bld.append("&gt;");
				break;
			case '"':
				bld.append("&quot;");
				break;
			case ' ':
				bld.append("&nbsp;");
				break;
			case '\n':
				bld.append("<br/>");
				break;
			default:
				bld.append(c);
				break;
			}
		}
		return bld.toString();
	}

	/**
	 * html转文本
	 * 
	 * @param htm
	 * @return
	 */
	public static String htm2txt(String htm) {
		if (htm == null) {
			return htm;
		}
		htm = htm.replace("&amp;", "&");
		htm = htm.replace("&lt;", "<");
		htm = htm.replace("&gt;", ">");
		htm = htm.replace("&quot;", "\"");
		htm = htm.replace("&nbsp;", "");
		//htm = htm.replace("<br/>", "\n");
		return htm;
	}

	
	
	public static void main(String[] args) {
		String ss = htm2txt("         1");
		System.out.println(ss);
	}
	
	
	/**
	 * 判断URL是否正确
	 * 
	 * @param str
	 * @param num
	 * @return
	 */
	public static boolean isUrl(String str, int num) {
		boolean temp = false;
		try {
			URL url = new URL(str);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(num);
			conn.setReadTimeout(num);
			int state = conn.getResponseCode();
			if (state == 200) {
				temp = true;
			} else {
				temp = false;
			}
		} catch (IOException e) {
			temp = false;
		}
		return temp;
	}
	
	
	/**
	 * 全角-->半角
	 * 
	 * @param qjStr
	 * @return
	 */
	public String Q2B(String qjStr) {
		String outStr = "";
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < qjStr.length(); i++) {
			try {
				Tstr = qjStr.substring(i, i + 1);
				b = Tstr.getBytes("unicode");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (b[3] == -1) {
				b[2] = (byte) (b[2] + 32);
				b[3] = 0;
				try {
					outStr = outStr + new String(b, "unicode");
				} catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else
				outStr = outStr + Tstr;
		}
		return outStr;
	}

	public static final char[] N62_CHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };
	public static final char[] N36_CHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };

	private static StringBuilder longToNBuf(long l, char[] chars) {
		int upgrade = chars.length;
		StringBuilder result = new StringBuilder();
		int last;
		while (l > 0) {
			last = (int) (l % upgrade);
			result.append(chars[last]);
			l /= upgrade;
		}
		return result;
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l
	 * @return
	 */
	public static String longToN62(long l) {
		return longToNBuf(l, N62_CHARS).reverse().toString();
	}

	public static String longToN36(long l) {
		return longToNBuf(l, N36_CHARS).reverse().toString();
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l
	 * @param length
	 *            如N62不足length长度，则补足0。
	 * @return
	 */
	public static String longToN62(long l, int length) {
		StringBuilder sb = longToNBuf(l, N62_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	public static String longToN36(long l, int length) {
		StringBuilder sb = longToNBuf(l, N36_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}
	
	
	public static String formatString(String target,String splitStr){
		String temp="";
		if(!isNull(target) && target.indexOf(";") > -1){
			String[] ss = target.split(";");
			for(int i =0;i<ss.length;i++){
				temp +=ss[i]+splitStr;
			}
		}
		return temp;
	}
	
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Integer str2Int(String str)
	{
		Integer n = null;
		if(StringUtils.isEmpty( str ))
		{
			return n;
		}
		
		try
		{
			n = Integer.parseInt( str );
		}
		catch ( Exception e )
		{
			
		}
		
		return n;
		
	}
	
	
	public static Double str2Double(String str)
	{
		Double d = null;
		if(StringUtils.isEmpty( str ))
		{
			return d;
		}
		
		try
		{
			d = Double.parseDouble( str );
		}
		catch ( Exception e )
		{
			// TODO: handle exception
		}
		
		return d;
	}
	
	
	/**
	 * 将字符串数组转化为整数数组
	 * @param strArray
	 * @return 如果字符串数组为空 返回null; 如果字符串数组中有转换失败的返回null
	 */
	public static Integer[] strArray2InArray(String[] strArray)
	{
		Integer[] array = null;
		if(!checkStringArrayEmpty(strArray))
		{
			return array;
		}
		
		
		array = new Integer[strArray.length];
		
		for(int i = 0; i<strArray.length; i++)
		{
			Integer iInt = str2Int(strArray[i]);
			if(null == iInt)
			{
				array = null;
				break;
			}
			
			array[i] = iInt;
		}
				
		return array;
		
	}
	
	
	/**
	 * 字符串转日期类
	 * @param timeStr
	 * @param pattern
	 * @return
	 */
	public static Date str2UtilDate(String timeStr,String pattern)
	{
		Date date = null;
		if(isEmpty( timeStr ))
		{
			return date;
		}
		
		if(isEmpty( pattern ))
		{
			pattern = "yyyy-MM-dd";
		}
		
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			date = sdf.parse( timeStr );
		}
		catch ( Exception e )
		{
			
		}
		
		return date;
	}
	
	
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Short str2Short(String str)
	{
		Short st = null;
		if(StringUtils.isEmpty( str ))
		{
			return st;
		}
		
		try
		{
			st = Short.valueOf( str );
		}
		catch ( Exception e )
		{
			
		}
		
		return st;
		
	}	
	

	/**
	 * N62转换成整数
	 * 
	 * @param n62
	 * @return
	 */
	public static long n62ToLong(String n62) {
		return nToLong(n62, N62_CHARS);
	}

	public static long n36ToLong(String n36) {
		return nToLong(n36, N36_CHARS);
	}

	private static long nToLong(String s, char[] chars) {
		char[] nc = s.toCharArray();
		long result = 0;
		long pow = 1;
		for (int i = nc.length - 1; i >= 0; i--, pow *= chars.length) {
			int n = findNIndex(nc[i], chars);
			result += n * pow;
		}
		return result;
	}

	private static int findNIndex(char c, char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				return i;
			}
		}
		throw new RuntimeException("N62(N36)非法字符：" + c);
	}
	
	
	/**
	 * 检测所给的字符串数组中的字符串是否为空。 如果全都不为空，通过检测返回true，否则返回false
	 * 
	 * @param strArray
	 * @return
	 */
	public static boolean checkStringArrayEmpty( String[] strArray )
	{
		boolean flag = true;
		if (strArray != null && strArray.length != 0)
		{
			for (int i = 0; i < strArray.length; i++)
			{
				String str = strArray[i];
				if (isEmpty( str ))
				{
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	
	/**
	 * 检测所给的字符串数组中的字符串是否不都为空。
	 * 如果数组中有一个字符串不为空，则返回为true, 否则返回false
	 * 
	 * @param strArray
	 * @return true, 数组中有一个字符串不为空; false字符串都为空
	 */
	public static boolean checkStringArrayNotAllEmpty(String[] strArray)
	{
		boolean flag = false;
		if(strArray != null && strArray.length != 0)
		{
			for(int i = 0; i< strArray.length; i++)
			{
				String str = strArray[i];
				if(isNotEmpty( str ))
				{
					flag = true;
					break;
				}
			}
		}
		
		return flag;
	}

	
}
