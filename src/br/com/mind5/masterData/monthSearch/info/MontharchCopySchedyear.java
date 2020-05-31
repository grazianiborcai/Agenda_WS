package br.com.mind5.masterData.monthSearch.info;


import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class MontharchCopySchedyear extends InfoCopierTemplate<MontharchInfo, SchedyearInfo> {
	
	public MontharchCopySchedyear() {
		super();
	}
	
	
	
	@Override protected MontharchInfo makeCopyHook(SchedyearInfo source) {
		MontharchInfo result = new MontharchInfo();
		
		result.codLanguage = source.codLanguage;		
		
		return result;
	}
}
