package com.zjts.buscenter.wx.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Gson的时间戳类型的转换形式
 * 
 * @author JieTian
 * 
 */
public class TimestampTypeAdapter implements com.google.gson.JsonSerializer<Timestamp>, JsonDeserializer<Timestamp>
{
	private final DateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm" );


	public JsonElement serialize(Timestamp src , Type arg1 , JsonSerializationContext arg2 )
	{	
		try
		{
			String dateFormatAsString = format.format( new Date( src.getTime() ) );
			return new JsonPrimitive( dateFormatAsString );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		
		return new JsonPrimitive( "" );
		
		
	}


	public Timestamp deserialize(JsonElement json , Type typeOfT , JsonDeserializationContext context ) throws JsonParseException
	{
		if (!( json instanceof JsonPrimitive)) { throw new JsonParseException( "The date should be a string value" ); }

		try
		{
			Date date = format.parse( json.getAsString() );
			return new Timestamp( date.getTime() );
		}
		catch ( ParseException e )
		{
			throw new JsonParseException( e );
		}
	}

}
