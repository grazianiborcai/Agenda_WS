package br.com.gda.payment.payOrderItem.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.info.PayordemSetterSysReceiver;

final class VisiPayordemEnforceSysReceiver extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> attrSetter = new PayordemSetterSysReceiver();
		return attrSetter.setAttr(recordInfo);
	}
}
