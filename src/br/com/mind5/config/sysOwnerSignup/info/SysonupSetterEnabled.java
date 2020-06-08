package br.com.mind5.config.sysOwnerSignup.info;

import br.com.mind5.config.common.ConfigValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SysonupSetterEnabled extends InfoSetterTemplate<SysonupInfo> {
	
	@Override protected SysonupInfo setAttrHook(SysonupInfo recordInfo) {
		recordInfo.ownerSignup = ConfigValue.ENABLED.getConfigValue();
		return recordInfo;
	}
}
