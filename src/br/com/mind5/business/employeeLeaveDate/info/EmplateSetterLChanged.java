package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmplateSetterLChanged extends InfoSetterTemplate<EmplateInfo> {
	
	@Override protected EmplateInfo setAttrHook(EmplateInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
