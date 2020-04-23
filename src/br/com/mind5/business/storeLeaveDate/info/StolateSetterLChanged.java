package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterLChanged extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
