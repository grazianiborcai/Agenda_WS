package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedmonSetterNext extends InfoSetterTemplate<SchedmonInfo> {
	
	@Override protected SchedmonInfo setAttrHook(SchedmonInfo recordInfo) {
		if (recordInfo.month >= 12) 
			return addYearMonth(recordInfo);
		
		return addMonth(recordInfo);
	}
	
	
	
	private SchedmonInfo addYearMonth(SchedmonInfo recordInfo) {
		recordInfo.month = 1;
		recordInfo.year = recordInfo.year + 1;

		return recordInfo;
	}
	
	
	
	private SchedmonInfo addMonth(SchedmonInfo recordInfo) {
		recordInfo.month = recordInfo.month + 1;

		return recordInfo;
	}
}
