package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SoweduliveSetterLChanged extends InfoSetterTemplate<SoweduliveInfo> {
	
	@Override protected SoweduliveInfo setAttrHook(SoweduliveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
