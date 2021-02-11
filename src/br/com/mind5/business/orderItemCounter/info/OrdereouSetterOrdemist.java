package br.com.mind5.business.orderItemCounter.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdereouSetterOrdemist extends InfoSetterTemplate<OrdereouInfo> {
	
	@Override protected OrdereouInfo setAttrHook(OrdereouInfo recordInfo) {
		recordInfo.ordemarches = null;
		return recordInfo;
	}
}
