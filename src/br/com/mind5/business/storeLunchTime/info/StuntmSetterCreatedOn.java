package br.com.mind5.business.storeLunchTime.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StuntmSetterCreatedOn extends InfoSetterTemplate<StuntmInfo> {
	
	@Override protected StuntmInfo setAttrHook(StuntmInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
