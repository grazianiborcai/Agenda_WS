package br.com.mind5.config.sysStoreSignup.info;

import br.com.mind5.config.common.ConfigValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SysotupSetterEnabled extends InfoSetterTemplate<SysotupInfo> {
	
	@Override protected SysotupInfo setAttrHook(SysotupInfo recordInfo) {
		recordInfo.storeSignup = ConfigValue.ENABLED.getConfigValue();
		return recordInfo;
	}
}
