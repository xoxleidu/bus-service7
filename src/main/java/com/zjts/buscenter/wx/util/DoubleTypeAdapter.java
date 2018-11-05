package com.zjts.buscenter.wx.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Gson的时间戳类型的转换形式
 * 
 * @author JieTian
 * 
 */
public class DoubleTypeAdapter implements JsonSerializer<Double>, JsonDeserializer<Double>
{
	private final DecimalFormat decimalFormat = new DecimalFormat("0.00");


	public JsonElement serialize(Double src , Type arg1 , JsonSerializationContext arg2 )
	{	
		try
		{
			String doubleString = decimalFormat.format( src );
			return new JsonPrimitive( doubleString );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		
		return new JsonPrimitive( "" );
		
		
	}


	public Double deserialize(JsonElement json , Type typeOfT , JsonDeserializationContext context ) throws JsonParseException
	{
		if (!( json instanceof JsonPrimitive)) { throw new JsonParseException( "The date should be a string value" ); }

		try
		{
			Double d = decimalFormat.parse( json.getAsString() ).doubleValue();
			return d;
		}
		catch ( ParseException e )
		{
			throw new JsonParseException( e );
		}
	}

}
