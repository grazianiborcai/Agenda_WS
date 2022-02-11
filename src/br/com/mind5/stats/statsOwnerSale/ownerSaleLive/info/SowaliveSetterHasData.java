package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowaliveSetterHasData extends InfoSetterTemplate<SowaliveInfo> {
	
	@Override protected SowaliveInfo setAttrHook(SowaliveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
