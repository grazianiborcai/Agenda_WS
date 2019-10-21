package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordSetterCreatedOn;

final class VisiPayordEnforceCreatedOn extends ActionVisitorTemplateEnforce<PayordInfo> {
	
	@Override protected PayordInfo enforceHook(PayordInfo recordInfo) {
		InfoSetter<PayordInfo> attrSetter = new PayordSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
