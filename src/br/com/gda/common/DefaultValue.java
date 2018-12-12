package br.com.gda.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.helper.RecordMode;

public final class DefaultValue {
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
	
	
	
	public static int decimalPlace() {
		return 2;
	}
	
	
	
	public static String codCurrency() {
		return "BRL";
	}
	
	
	
	public static LocalDate dateNow() {
		return dateTimeNow().toLocalDate();
	}
	
	
	
	public static LocalTime timeNow() {
		return dateTimeNow().toLocalTime();
	}
	
	
	
	public static LocalDateTime dateTimeNow() {
		ZonedDateTime nowUtc = ZonedDateTime.now(ZoneOffset.UTC);
		return nowUtc.toLocalDateTime();
	}
	
	
	
	public static String recordMode() {
		return RecordMode.RECORD_OK;
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
}
