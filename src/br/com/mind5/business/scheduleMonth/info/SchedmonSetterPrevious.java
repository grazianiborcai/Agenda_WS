package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedmonSetterPrevious extends InfoSetterTemplate<SchedmonInfo> {
	
	@Override protected SchedmonInfo setAttrHook(SchedmonInfo recordInfo) {
		if (recordInfo.month <= 1) 
			return subtractYearMonth(recordInfo);
		
		return subtractMonth(recordInfo);
	}
	
	
	
	private SchedmonInfo subtractYearMonth(SchedmonInfo recordInfo) {
		recordInfo.month = 12;
		recordInfo.year = recordInfo.year - 1;

		return recordInfo;
	}
	
	
	
	private SchedmonInfo subtractMonth(SchedmonInfo recordInfo) {
		recordInfo.month = recordInfo.month - 1;

		return recordInfo;
	}
}
