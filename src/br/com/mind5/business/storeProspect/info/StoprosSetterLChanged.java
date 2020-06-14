package br.com.mind5.business.storeProspect.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoprosSetterLChanged extends InfoSetterTemplate<StoprosInfo> {
	
	@Override protected StoprosInfo setAttrHook(StoprosInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
