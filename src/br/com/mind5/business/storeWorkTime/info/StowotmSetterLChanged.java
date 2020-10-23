package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StowotmSetterLChanged extends InfoSetterTemplate<StowotmInfo> {
	
	@Override protected StowotmInfo setAttrHook(StowotmInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
