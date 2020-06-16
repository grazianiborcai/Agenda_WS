package br.com.mind5.business.orderReserve.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.orderStatus.info.Orderatus;

public final class OrderverSetteCancelled extends InfoSetterTemplate<OrderveInfo> {
	
	@Override protected OrderveInfo setAttrHook(OrderveInfo recordInfo) {
		recordInfo.codOrderStatus = Orderatus.CANCELLED.getCodStatus();			
		return recordInfo;
	}
}
