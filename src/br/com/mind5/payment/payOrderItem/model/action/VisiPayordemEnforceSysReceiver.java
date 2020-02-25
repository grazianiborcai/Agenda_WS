package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemSetterSysReceiver_;

final class VisiPayordemEnforceSysReceiver extends ActionVisitorTemplateEnforce<PayordemInfo> {
	
	@Override protected PayordemInfo enforceHook(PayordemInfo recordInfo) {
		InfoSetter<PayordemInfo> attrSetter = new PayordemSetterSysReceiver_();
		return attrSetter.setAttr(recordInfo);
	}
}
