package br.com.mind5.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class TimezoneUtil {
	
	public static LocalDateTime utcToTimezone(LocalDateTime time, ZoneId zoneTo, Class<?> callerClazz) {
		checkArgument(time, zoneTo, callerClazz);		
		return tryToConvertTimezone(time, ZoneOffset.UTC, zoneTo, callerClazz);
	}
	
	
	
	public static LocalDateTime timezoneToUtc(LocalDateTime time, ZoneId zoneFrom, Class<?> callerClazz) {
		checkArgument(time, zoneFrom, callerClazz);		
		return tryToConvertTimezone(time, zoneFrom, ZoneOffset.UTC, callerClazz);
	}
	
	
	
	private static LocalDateTime tryToConvertTimezone(LocalDateTime time, ZoneId zoneFrom, ZoneId zoneTo, Class<?> callerClazz) {
		try {
			return convertTimezone(time, zoneFrom, zoneTo, callerClazz);
		
		} catch (Exception e) {
			logException(e, callerClazz);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private static LocalDateTime convertTimezone(LocalDateTime time, ZoneId zoneFrom, ZoneId zoneTo, Class<?> callerClazz) {
		ZonedDateTime timeFrom = time.atZone(zoneFrom);			
		ZonedDateTime timeTo = timeFrom.withZoneSameInstant(zoneTo);
		
        return timeTo.toLocalDateTime();
	}
	
	
	
	private static void checkArgument(LocalDateTime time, ZoneId zone, Class<?> callerClazz) {
		if (callerClazz == null) {
			logException(new NullPointerException("callerClazz" + SystemMessage.NULL_ARGUMENT), TimezoneUtil.class);
			throw new NullPointerException("callerClazz" + SystemMessage.NULL_ARGUMENT);
		}
		

		if (time == null) {
			logException(new NullPointerException("time" + SystemMessage.NULL_ARGUMENT), callerClazz);
			throw new NullPointerException("time" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (zone == null) {
			logException(new NullPointerException("zone" + SystemMessage.NULL_ARGUMENT), callerClazz);
			throw new NullPointerException("zone" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private static void logException(Exception e, Class<?> callerClazz) {
		 Class<?> clazz = callerClazz;
		 
		 if (clazz == null)
			 clazz = CloneUtil.class;
		
		SystemLog.logError(clazz, e);
	}
}
