package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.OrderStatusMoip;

public final class PayormarchSetterReverted extends InfoSetterTemplate<PayormarchInfo> {
	
	@Override protected PayormarchInfo setAttrHook(PayormarchInfo recordInfo) {
		recordInfo.statusOrderPartner = OrderStatusMoip.REVERTED.getCodStatus();
		return recordInfo;
	}
}
