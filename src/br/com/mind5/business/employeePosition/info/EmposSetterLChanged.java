package br.com.mind5.business.employeePosition.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmposSetterLChanged extends InfoSetterTemplate<EmposInfo> {
	
	@Override protected EmposInfo setAttrHook(EmposInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
