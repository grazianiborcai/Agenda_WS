package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SoweduliveSetterHasData extends InfoSetterTemplate<SoweduliveInfo> {
	
	@Override protected SoweduliveInfo setAttrHook(SoweduliveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
