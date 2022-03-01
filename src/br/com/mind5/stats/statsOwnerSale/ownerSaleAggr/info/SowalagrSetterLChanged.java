package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SowalagrSetterLChanged extends InfoSetterTemplate<SowalagrInfo> {
	
	@Override protected SowalagrInfo setAttrHook(SowalagrInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
