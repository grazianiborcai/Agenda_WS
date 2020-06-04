package br.com.mind5.business.calendarDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CalateSetterNext extends InfoSetterTemplate<CalateInfo> {
	
	@Override protected CalateInfo setAttrHook(CalateInfo recordInfo) {
		recordInfo.date = recordInfo.date.plusDays(1);
		return recordInfo;
	}
}
