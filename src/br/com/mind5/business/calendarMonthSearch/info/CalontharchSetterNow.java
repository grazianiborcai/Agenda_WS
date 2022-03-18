package br.com.mind5.business.calendarMonthSearch.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CalontharchSetterNow extends InfoSetterTemplate<CalontharchInfo> {
	
	@Override protected CalontharchInfo setAttrHook(CalontharchInfo recordInfo) {
		CalontharchInfo result = new CalontharchInfo();
		
		result.calmonth = getNow();
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
	
	
	
	private String getNow() {
		LocalDate now = DefaultValue.localDateNow();
		LocalDate lastYear = now.minusYears(1);
		
		return getYear(lastYear) + getMonth(lastYear);
	}
	
	
	
	private String getYear(LocalDate date) {
		DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");
		return date.format(formatterYear);
	}
	
	
	
	private String getMonth(LocalDate date) {
		DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
		return date.format(formatterMonth);
	}
}
