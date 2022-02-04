package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SuseraciveSetterLChanged extends InfoSetterTemplate<SuseraciveInfo> {
	
	@Override protected SuseraciveInfo setAttrHook(SuseraciveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
