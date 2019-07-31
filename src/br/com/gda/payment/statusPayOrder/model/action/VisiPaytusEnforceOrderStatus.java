package br.com.gda.payment.statusPayOrder.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.info.PaytusSetterOrderStatus;

final class VisiPaytusEnforceOrderStatus extends ActionVisitorTemplateEnforce<PaytusInfo> {
	
	@Override protected PaytusInfo enforceHook(PaytusInfo recordInfo) {
		InfoSetter<PaytusInfo> attrSetter = new PaytusSetterOrderStatus();
		return attrSetter.setAttr(recordInfo);
	}
}
