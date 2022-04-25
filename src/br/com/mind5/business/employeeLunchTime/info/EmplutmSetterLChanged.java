package br.com.mind5.business.employeeLunchTime.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmplutmSetterLChanged extends InfoSetterTemplate<EmplutmInfo> {
	
	@Override protected EmplutmInfo setAttrHook(EmplutmInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
