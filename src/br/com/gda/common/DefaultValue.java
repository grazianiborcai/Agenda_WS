package br.com.gda.common;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public final class DefaultValue {
	public static int number() {
		return -1;
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
	
	
	
	public static LocalDateTime now() {
		ZonedDateTime nowUtc = ZonedDateTime.now(ZoneOffset.UTC);
		return nowUtc.toLocalDateTime();
	}
}
