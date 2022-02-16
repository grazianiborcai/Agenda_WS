package br.com.mind5.business.calendarDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CalateSetterYearMonthKey extends InfoSetterTemplate<CalateInfo> {
	
	@Override protected CalateInfo setAttrHook(CalateInfo recordInfo) {
		CalateInfo result = new CalateInfo();
		
		result.year 		= recordInfo.year;
		result.month 		= recordInfo.month;
		result.username 	= recordInfo.username;
		result.codLanguage 	= recordInfo.codLanguage;

		return result;
	}
}
