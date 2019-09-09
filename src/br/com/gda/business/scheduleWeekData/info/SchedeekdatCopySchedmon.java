package br.com.gda.business.scheduleWeekData.info;


import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.info.InfoCopierTemplate;

final class SchedeekdatCopySchedmon extends InfoCopierTemplate<SchedeekdatInfo, SchedmonInfo>{
	
	public SchedeekdatCopySchedmon() {
		super();
	}
	
	
	
	@Override protected SchedeekdatInfo makeCopyHook(SchedmonInfo source) {
			SchedeekdatInfo result = new SchedeekdatInfo();
			result.codOwner = source.codOwner;
			result.codStore = source.codStore;
			result.codEmployee = source.codEmployee;
			result.codStore = source.codStore;
			result.year = source.year;
			result.month = source.month;
			result.codLanguage = source.codLanguage;
			result.username = source.username;
		
		return result;
	}
}
