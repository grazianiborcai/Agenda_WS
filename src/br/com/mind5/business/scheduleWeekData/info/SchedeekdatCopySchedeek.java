package br.com.mind5.business.scheduleWeekData.info;


import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedeekdatCopySchedeek extends InfoCopierTemplate<SchedeekdatInfo, SchedeekInfo> {
	
	public SchedeekdatCopySchedeek() {
		super();
	}
	
	
	
	@Override protected SchedeekdatInfo makeCopyHook(SchedeekInfo source) {
			SchedeekdatInfo result = new SchedeekdatInfo();
			
			result.codOwner = source.codOwner;
			result.codStore = source.codStore;
			result.codStore = source.codStore;
			result.weekYear = source.weekYear;
			result.codLanguage = source.codLanguage;
			result.username = source.username;
		
		return result;
	}
}
