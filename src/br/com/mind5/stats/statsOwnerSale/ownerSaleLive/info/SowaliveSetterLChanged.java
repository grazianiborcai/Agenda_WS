package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowaliveSetterLChanged extends InfoSetterTemplate<SowaliveInfo> {
	
	@Override protected SowaliveInfo setAttrHook(SowaliveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
