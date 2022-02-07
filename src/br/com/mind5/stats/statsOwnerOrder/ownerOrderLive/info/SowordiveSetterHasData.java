package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SowordiveSetterHasData extends InfoSetterTemplate<SowordiveInfo> {
	
	@Override protected SowordiveInfo setAttrHook(SowordiveInfo recordInfo) {
		recordInfo.hasData = true;
		return recordInfo;
	}
}
