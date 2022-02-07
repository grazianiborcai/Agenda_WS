package br.com.mind5.stats.statsOwnerUser.userAccountLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowusiveSetterHasData extends InfoSetterTemplate<SowusiveInfo> {
	
	@Override protected SowusiveInfo setAttrHook(SowusiveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
