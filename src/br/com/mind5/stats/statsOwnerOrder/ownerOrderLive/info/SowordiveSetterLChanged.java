package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowordiveSetterLChanged extends InfoSetterTemplate<SowordiveInfo> {
	
	@Override protected SowordiveInfo setAttrHook(SowordiveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
