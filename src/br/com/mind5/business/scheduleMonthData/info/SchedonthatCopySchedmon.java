package br.com.mind5.business.scheduleMonthData.info;


import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedonthatCopySchedmon extends InfoCopierTemplate<SchedonthatInfo, SchedmonInfo>{
	
	public SchedonthatCopySchedmon() {
		super();
	}
	
	
	
	@Override protected SchedonthatInfo makeCopyHook(SchedmonInfo source) {
			SchedonthatInfo result = new SchedonthatInfo();
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
