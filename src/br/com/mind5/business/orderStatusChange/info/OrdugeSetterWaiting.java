package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrdugeSetterWaiting extends InfoSetterTemplate<OrdugeInfo> {
	
	@Override protected OrdugeInfo setAttrHook(OrdugeInfo recordInfo) {
		recordInfo.codOrderStatusNew = OrderStatus.WAITING.getCodStatus();
		return recordInfo;
	}
}
