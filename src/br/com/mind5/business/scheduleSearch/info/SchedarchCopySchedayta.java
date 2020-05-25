package br.com.mind5.business.scheduleSearch.info;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedarchCopySchedayta extends InfoCopierTemplate<SchedarchInfo, SchedaytaInfo> {
	
	public SchedarchCopySchedayta() {
		super();
	}
	
	
	
	@Override protected SchedarchInfo makeCopyHook(SchedaytaInfo source) {
		SchedarchInfo result = new SchedarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.date = source.date;
		result.username = source.username;	
		result.codLanguage = source.codLanguage;	
		
		return result;
	}
}
