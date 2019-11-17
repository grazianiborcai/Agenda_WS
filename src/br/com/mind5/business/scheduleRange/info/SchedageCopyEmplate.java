package br.com.mind5.business.scheduleRange.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedageCopyEmplate extends InfoCopierTemplate<SchedageInfo, EmplateInfo> {
	
	public SchedageCopyEmplate() {
		super();
	}
	
	
	
	@Override protected SchedageInfo makeCopyHook(EmplateInfo source) {
		SchedageInfo result = new SchedageInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		result.dateValidFrom = source.dateValidFrom;
		result.dateValidTo = source.dateValidTo;
		result.timeValidFrom = source.timeValidFrom;
		result.timeValidTo = source.timeValidTo;
		return result;
	}
}
