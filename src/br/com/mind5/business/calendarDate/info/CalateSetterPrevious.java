package br.com.mind5.business.calendarDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CalateSetterPrevious extends InfoSetterTemplate<CalateInfo> {
	
	@Override protected CalateInfo setAttrHook(CalateInfo recordInfo) {
		recordInfo.date = recordInfo.date.minusDays(1);
		return recordInfo;
	}
}
