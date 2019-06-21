package br.com.gda.payment.payOrder.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordSetterCreatedOn;

final class VisiPayordEnforceCreatedOn extends ActionVisitorTemplateEnforce<PayordInfo> {
	
	@Override protected PayordInfo enforceHook(PayordInfo recordInfo) {
		InfoSetter<PayordInfo> attrSetter = new PayordSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
