package br.com.mind5.business.storeProspect.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoprosSetterCreatedOn extends InfoSetterTemplate<StoprosInfo> {
	
	@Override protected StoprosInfo setAttrHook(StoprosInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
