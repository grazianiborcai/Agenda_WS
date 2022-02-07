package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowotiveSetterLChanged extends InfoSetterTemplate<SowotiveInfo> {
	
	@Override protected SowotiveInfo setAttrHook(SowotiveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
