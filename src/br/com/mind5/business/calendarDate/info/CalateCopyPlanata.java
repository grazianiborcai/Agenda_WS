package br.com.mind5.business.calendarDate.info;


import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class CalateCopyPlanata extends InfoCopierTemplate<CalateInfo, PlanataInfo>{
	
	public CalateCopyPlanata() {
		super();
	}
	
	
	
	@Override protected CalateInfo makeCopyHook(PlanataInfo source) {
		CalateInfo result = new CalateInfo();
		
		result.date = source.date;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
