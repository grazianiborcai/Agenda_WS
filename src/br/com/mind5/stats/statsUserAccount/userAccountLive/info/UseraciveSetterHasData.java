package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class UseraciveSetterHasData extends InfoSetterTemplate<UseraciveInfo> {
	
	@Override protected UseraciveInfo setAttrHook(UseraciveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
