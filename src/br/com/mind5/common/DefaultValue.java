package br.com.mind5.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mind5.business.masterData.info.common.Environ;
import br.com.mind5.business.masterData.info.common.RecordMode;


public final class DefaultValue {
	private static final ZoneOffset TIME_ZONE = ZoneOffset.UTC;
	
	
	public static int number() {
		return -1;
	}
	
	
	
	public static boolean boole() {
		return false;
	}
	
	
	
	public static char character() {
		return Character.MIN_VALUE;
	}
	
	
	
	public static String language() {
		return "PT";
	}
	
	
	
	public static String country() {
		return "BR";
	}
	
	
	
	public static int decimalPlace() {	//TODO: Remover
		return 2;
	}
	
	
	
	public static String codCurrency() {
		return "BRL";
	}
	
	
	
	public static Date dateNow() {
		LocalDateTime now = localDateTimeNow();		
		return Date.from(now.atZone(TIME_ZONE).toInstant());
	}
	
	
	
	public static LocalDate localDateNow() {
		return localDateTimeNow().toLocalDate();
	}
	
	
	
	public static LocalTime localTimeNow() {
		return localDateTimeNow().toLocalTime();
	}
	
	
	
	public static LocalDateTime localDateTimeNow() {
		ZonedDateTime nowUtc = ZonedDateTime.now(TIME_ZONE);
		return nowUtc.toLocalDateTime();
	}
	
	
	
	public static String recordMode() {
		return RecordMode.OK.getCodRecordMode();
	}
	
	
	
	public static int gender() {
		return 1;
	}
	
	
	
	public static <T> T object() {
		return null;
	}
	
	
	
	public static <T> List<T> list() {
		return new ArrayList<>();
	}	
	
	
	
	public static String getCodEnvironment() {
		return Environ.SANDBOX.getCodEnviron();
	}
}
