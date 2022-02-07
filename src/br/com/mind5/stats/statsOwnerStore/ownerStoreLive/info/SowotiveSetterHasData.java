package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowotiveSetterHasData extends InfoSetterTemplate<SowotiveInfo> {
	
	@Override protected SowotiveInfo setAttrHook(SowotiveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
