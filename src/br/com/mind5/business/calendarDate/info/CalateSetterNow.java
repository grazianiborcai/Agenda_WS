package br.com.mind5.business.calendarDate.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CalateSetterNow extends InfoSetterTemplate<CalateInfo> {
	
	@Override protected CalateInfo setAttrHook(CalateInfo recordInfo) {
		recordInfo.date = DefaultValue.localDateNow();
		return recordInfo;
	}
}
