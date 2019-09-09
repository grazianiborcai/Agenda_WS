package br.com.gda.business.scheduleWeekData.info;


import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.info.InfoCopierTemplate;

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
