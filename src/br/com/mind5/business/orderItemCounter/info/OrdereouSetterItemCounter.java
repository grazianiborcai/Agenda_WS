package br.com.mind5.business.orderItemCounter.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdereouSetterItemCounter extends InfoSetterTemplate<OrdereouInfo> {
	
	@Override protected OrdereouInfo setAttrHook(OrdereouInfo recordInfo) {
		if (recordInfo.ordemarches == null)
			return setZeroItem(recordInfo);
		
		if (recordInfo.ordemarches.isEmpty())
			return setZeroItem(recordInfo);
		
		return setTotItem(recordInfo);
	}
	
	
	
	private OrdereouInfo setZeroItem(OrdereouInfo recordInfo) {
		recordInfo.itemCounter = 0;
		return recordInfo;
	}
	
	
	
	private OrdereouInfo setTotItem(OrdereouInfo recordInfo) {
		recordInfo.itemCounter = recordInfo.ordemarches.size();	
		return recordInfo;
	}
}
