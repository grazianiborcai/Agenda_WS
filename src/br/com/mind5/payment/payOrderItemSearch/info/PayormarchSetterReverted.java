package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.info.InfoSetterTemplate;

public final class PayormarchSetterReverted extends InfoSetterTemplate<PayormarchInfo> {
	
	@Override protected PayormarchInfo setAttrHook(PayormarchInfo recordInfo) {
		recordInfo.statusOrderPartner = OrderStatusMoip.REVERTED.getCodStatus();
		return recordInfo;
	}
}
