package br.com.mind5.config.sysStoreBusinessContent.info;

import br.com.mind5.config.common.ConfigValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SytorbcSetterEnabled extends InfoSetterTemplate<SytorbcInfo> {
	
	@Override protected SytorbcInfo setAttrHook(SytorbcInfo recordInfo) {
		recordInfo.storeBusinessContent = ConfigValue.ENABLED.getConfigValue();
		return recordInfo;
	}
}
