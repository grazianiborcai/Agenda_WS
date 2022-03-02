package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowusiveSetterLChanged extends InfoSetterTemplate<SowusiveInfo> {
	
	@Override protected SowusiveInfo setAttrHook(SowusiveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
