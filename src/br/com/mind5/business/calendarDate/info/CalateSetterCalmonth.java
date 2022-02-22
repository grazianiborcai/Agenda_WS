package br.com.mind5.business.calendarDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CalateSetterCalmonth extends InfoSetterTemplate<CalateInfo> {
	
	@Override protected CalateInfo setAttrHook(CalateInfo recordInfo) {
		recordInfo.calmonth = yearToString(recordInfo.year) + monthToString(recordInfo.month);
		return recordInfo;
	}
	
	
	
	private String yearToString(int year) {
		return Integer.toString(year);
	}
	
	
	
	private String monthToString(int month) {
		String strMonth = Integer.toString(month);
		
		if (strMonth.length() == 2)
			return strMonth;
		
		return addPadding(strMonth);
	}
	
	
	
	private String addPadding(String month) {
		return '0' + month;
	}
}
