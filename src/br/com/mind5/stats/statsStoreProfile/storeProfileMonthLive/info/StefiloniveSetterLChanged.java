package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StefiloniveSetterLChanged extends InfoSetterTemplate<StefiloniveInfo> {
	
	@Override protected StefiloniveInfo setAttrHook(StefiloniveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
