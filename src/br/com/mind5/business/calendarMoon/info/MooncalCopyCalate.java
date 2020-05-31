package br.com.mind5.business.calendarMoon.info;


import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MooncalCopyCalate extends InfoCopierTemplate<MooncalInfo, CalateInfo> {
	
	public MooncalCopyCalate() {
		super();
	}
	
	
	
	@Override protected MooncalInfo makeCopyHook(CalateInfo source) {
		MooncalInfo result = new MooncalInfo();
		
		result.moonDate = source.date;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
