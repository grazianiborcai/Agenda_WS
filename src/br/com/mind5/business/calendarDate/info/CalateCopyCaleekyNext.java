package br.com.mind5.business.calendarDate.info;


import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CalateCopyCaleekyNext extends InfoCopierTemplate<CalateInfo, CaleekyInfo> {
	
	public CalateCopyCaleekyNext() {
		super();
	}
	
	
	
	@Override protected CalateInfo makeCopyHook(CaleekyInfo source) {
		CalateInfo result = new CalateInfo();
		
		result.date = source.dateWeekEnd;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
