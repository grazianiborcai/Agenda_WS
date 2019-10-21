package br.com.mind5.business.scheduleWeekData.info;


import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedeekdatCopySchedeek extends InfoCopierTemplate<SchedeekdatInfo, SchedeekInfo>{
	
	public SchedeekdatCopySchedeek() {
		super();
	}
	
	
	
	@Override protected SchedeekdatInfo makeCopyHook(SchedeekInfo source) {
			SchedeekdatInfo result = new SchedeekdatInfo();
			result.codOwner = source.codOwner;
			result.codStore = source.codStore;
			result.codEmployee = source.codEmployee;
			result.codCustomer = source.codCustomer;
			result.codStore = source.codStore;
			result.year = source.year;
			result.month = source.month;
			result.weekMonth = source.weekMonth;
			result.codLanguage = source.codLanguage;
			result.username = source.username;
		
		return result;
	}
}
