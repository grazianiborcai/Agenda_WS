package br.com.mind5.config.sysStorePartitioning.info;

import br.com.mind5.config.common.ConfigValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SytotinSetterEnabled extends InfoSetterTemplate<SytotinInfo> {
	
	@Override protected SytotinInfo setAttrHook(SytotinInfo recordInfo) {
		recordInfo.storePartitioning = ConfigValue.ENABLED.getConfigValue();
		return recordInfo;
	}
}
