package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class UseraciveSetterLChanged extends InfoSetterTemplate<UseraciveInfo> {
	
	@Override protected UseraciveInfo setAttrHook(UseraciveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
