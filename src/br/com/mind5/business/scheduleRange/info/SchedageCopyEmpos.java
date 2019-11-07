package br.com.mind5.business.scheduleRange.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedageCopyEmpos extends InfoCopierTemplate<SchedageInfo, EmposInfo> {
	
	public SchedageCopyEmpos() {
		super();
	}
	
	
	
	@Override protected SchedageInfo makeCopyHook(EmposInfo source) {
		SchedageInfo result = new SchedageInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		result.dateValidFrom = LocalDate.now();
		result.dateValidTo = LocalDate.of(9999, 12, 1);
		result.timeValidFrom = LocalTime.now();
		result.timeValidTo = LocalTime.of(23, 59, 59);
		
		
		return result;
	}
}
