package br.com.mind5.business.scheduleYearData.info;


import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedyeratCopySchedyear extends InfoCopierTemplate<SchedyeratInfo, SchedyearInfo> {
	
	public SchedyeratCopySchedyear() {
		super();
	}
	
	
	
	@Override protected SchedyeratInfo makeCopyHook(SchedyearInfo source) {
			SchedyeratInfo result = new SchedyeratInfo();
			result.codOwner = source.codOwner;
			result.codStore = source.codStore;
			result.year = source.year;
			result.codLanguage = source.codLanguage;
			result.username = source.username;
		
		return result;
	}
}
