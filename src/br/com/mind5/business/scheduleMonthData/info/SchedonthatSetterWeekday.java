package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedonthatSetterWeekday extends InfoSetterTemplate<SchedonthatInfo> {
	
	@Override protected SchedonthatInfo setAttrHook(SchedonthatInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
