package br.com.mind5.business.calendarMonthSearch.info;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.info.InfoSetterTemplate;

public final class CalontharchSetterLtm extends InfoSetterTemplate<CalontharchInfo> {
	
	@Override protected CalontharchInfo setAttrHook(CalontharchInfo recordInfo) {
		CalontharchInfo result = new CalontharchInfo();
		
		result.calmonthBegin = recordInfo.calmonthBegin;
		result.calmonthEnd = getEnd(result.calmonthBegin);
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
	
	
	
	private String getEnd(String calmonthBegin) {		
		LocalDate begin = toLocalDate(calmonthBegin);
		LocalDate end = begin.minusMonths(11);
		
		return getYear(end) + getMonth(end);
	}
	
	
	
	private LocalDate toLocalDate(String calmonth) {
		int year = Integer.valueOf(calmonth.substring(0, 4));
		int month = Integer.valueOf(calmonth.substring(4, 6));
		int day = 1;
		
		return LocalDate.of(year, month, day);
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
