package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StoroniveSetterLChanged extends InfoSetterTemplate<StoroniveInfo> {
	
	@Override protected StoroniveInfo setAttrHook(StoroniveInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
